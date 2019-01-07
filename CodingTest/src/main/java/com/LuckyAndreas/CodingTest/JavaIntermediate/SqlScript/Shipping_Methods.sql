-- Table: public."Shipping_Methods"

-- DROP TABLE public."Shipping_Methods";

CREATE TABLE public."Shipping_Methods"
(
    "ShippingMethodID" numeric NOT NULL,
    "ShippingMethod" character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT "Shipping_methods_pkey" PRIMARY KEY ("ShippingMethodID")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Shipping_Methods"
    OWNER to postgres;