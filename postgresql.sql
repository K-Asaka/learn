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

