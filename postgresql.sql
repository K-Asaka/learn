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
