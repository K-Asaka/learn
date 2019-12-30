CREATE TABLE "売上" (
    id serial NOT NULL,
    "売上日時" timestamp without time zone NOT NULL DEFAULT now(),
    "商品名" character varying(64) NOT NULL,
    "価格" numeric NOT NULL DEFAULT 0,
    "ジャンル" text NOT NULL,
    CONSTRAINT "売上_pkey" PRIMARY KEY (id)
);

INSERT INTO "売上" ("売上日時", "商品名", "価格", "ジャンル")
VALUES(
    now() - ((random() * 10000) ::int % 365) * interval '1 day'
    , 'SoftwareDesign 2月号'
    , 1220
    , '紙'
)
, (
    now() - ((random() * 10000) ::int % 365) * interval '1 day'
    , 'SoftwareDesign 2月号'
    , 1220
    , '電子書籍'
)
, (
    now() - ((random() * 10000) ::int % 365) * interval '1 day'
    , 'SoftwareDesign 10月号'
    , 1220
    , '紙'
)
, (
    now() - ((random() * 10000) ::int % 365) * interval '1 day'
    , 'SoftwareDesign 10月号'
    , 1220
    , '電子書籍'
);

SELECT * FROM "売上" ORDER BY random() LIMIT 5;


-- ランキングデータ集計
SELECT "売上日時" ::date AS "売上日"
    , "商品名"
    , count(*) AS "件数"
FROM
    "売上"
GROUP BY
    "売上日"
    , "商品名"
ORDER BY
    "件数" DESC
LIMIT
    5;

-- window関数を使ったランキングデータ集計
SELECT
    *,
    rank() OVER (PARTITION BY "商品名" ORDER BY "件数" DESC) AS "順位"
FROM
(
    SELECT
        "売上日時" ::date AS "売上日"
        , "商品名"
        , count(*) AS "件数"
    FROM
        "売上"
    GROUP BY
        "売上日"
        , "商品名"
) AS "集計"


-- JSONB型を使ったデータ登録の例
CREATE TABLE public.users
(
    id serial NOT NULL,
    name character varying(128) NOT NULL,
    properties jsonb NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

-- 閉じカッコのない不正なJSONを指定
--INSERT INTO users (name, properties) VALUES ('hoge', '{"age": 18, "nickname": "hoge"');
-- 修正してINSERT
INSERT INTO users (name, properties) VALUES ('test', '{}');
INSERT INTO users (name, properties) VALUES ('test', '{}');
INSERT INTO users (name, properties) VALUES ('test', '{"age": 18, "nickname": "test"}');
INSERT INTO users (name, properties) VALUES ('hoge', '{"age": 18, "nickname": "hoge"}');
INSERT INTO users (name, properties) VALUES ('fuga', '{"age": 20, "nickname": "fuga"}');
INSERT INTO users (name, properties) VALUES ('bar',  '{"age": 40, "gender": "man", "nickname": "foo"}');

SELECT * FROM users;
-- JSONのkeyと値を指定した検索
SELECT * FROM users WHERE properties->>'nickname' = 'hoge';
-- JSONのkeyと値の組を指定した検索
SELECT * FROM users WHERE properties @> '{"age":18}'::jsonb;
-- 指定したkeyがJSONの中に存在するかの検索
SELECT * FROM users WHERE properties ? 'gender';

-- 1000万件以上のテストデータがある想定
-- psqlの実行結果と一緒に実行時間を出力する
\timing
SELECT * FROM users WHERE properties->>'nickname' = 'hogefuga';
-- 検索対象で式INDEXを作成する
CREATE INDEX demo_json_index
ON public.users
USING btree
((properties->>'nickname'::text));

SELECT * FROM users WHERE properties->>'nickname' = 'hogefuga';


-- 拡張機能
-- PGXN
-- http://pgxn.org/
-- postgresql.confに追記
-- shared_preload_libraries = 'pg_stat_statements'

-- スーパーユーザー権限でExtensionのインストール
CREATE EXTENSION pg_stat_statements;
-- 利用可能なcontribの一覧表示
SELECT * FROM pg_available_extensions;

\x
SELECT * FROM users WHERE properties->>'nickname' = 'hoge';
SELECT pg_stat_statements_reset();
SELECT * FROM pg_stat_statements ORDER BY total_time LIMIT 4;

-- クエリを実行してから確認する
SELECT query, calls, total_time FROM pg_stat_statements ORDER BY total_time DESC LIMIT 4;


-- 追記型アーキテクチャの確認
-- データベースページの内容を調べるためpageinspectを追加
CREATE EXTENSION pageinspect;

CREATE TABLE hoge(
      id   SERIAL PRIMARY KEY
    , name VARCHAR(100)
);
-- データの更新操作
INSERT INTO hoge(name) VALUES('insert 1');
SELECT * FROM hoge;
-- lp:ブロック内のアイテムのオフセットID
-- t_xmin:そのレコードを作成したトランザクションのトランザクションID
-- t_xmax:そのレコードを削除したトランザクションのトランザクションID
SELECT lp, t_xmin, t_xmax FROM heap_page_items(get_raw_page('hoge', 0));
-- INSERTした行が見えなくなる
UPDATE hoge SET name = 'update 1' WHERE id = 1;
SELECT lp, lp_off, lp_flags, lp_len, t_xmin, t_xmax FROM heap_page_items(get_raw_page('hoge', 0));
-- UPDATEで追記された行が見えなくなる
UPDATE hoge SET name = 'update 2' WHERE id = 1;
SELECT lp, t_xmin, t_xmax FROM heap_page_items(get_raw_page('hoge', 0));
-- DELETEで最後のUPDATEで追記された行が見えなくなる
DELETE FROM hoge WHERE id = 1;
SELECT lp, t_xmin, t_xmax FROM heap_page_items(get_raw_page('hoge', 0));
-- INSERTで行の追加
INSERT INTO hoge(name) VALUES('insert 1');
SELECT lp, t_xmin, t_xmax FROM heap_page_items(get_raw_page('hoge', 0));
-- VACUUMにより参照されていなかった行が削除される
VACUUM;
SELECT lp, t_xmin, t_xmax FROM heap_page_items(get_raw_page('hoge', 0));
DELETE FROM hoge WHERE id = 2;
VACUUM;
-- 対象が1件もないためエラーになる
SELECT lp, t_xmin, t_xmax FROM heap_page_items(get_raw_page('hoge', 0));
