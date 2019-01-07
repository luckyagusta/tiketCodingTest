-- Table: public."Products"

-- DROP TABLE public."Products";

CREATE TABLE public."Products"
(
    "ProductID" numeric NOT NULL,
    "ProductName" character varying(50) COLLATE pg_catalog."default",
    "UnitPrice" numeric,
    "InStock" "char",
    CONSTRAINT "Products_pkey" PRIMARY KEY ("ProductID")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Products"
    OWNER to postgres;