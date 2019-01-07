-- Table: public."Customers"

-- DROP TABLE public."Customers";

CREATE TABLE public."Customers"
(
    "CustomerID" numeric NOT NULL,
    "FirstName" character varying(50) COLLATE pg_catalog."default",
    "LastName" character varying(30) COLLATE pg_catalog."default",
    "BillingAddress" character varying(50) COLLATE pg_catalog."default",
    "City" character varying(255) COLLATE pg_catalog."default",
    "StateOrProvince" character varying(50) COLLATE pg_catalog."default",
    "ZIPCode" character varying(20) COLLATE pg_catalog."default",
    "Email" character varying(20) COLLATE pg_catalog."default",
    "CompanyWebsite" character varying(75) COLLATE pg_catalog."default",
    "PhoneNumber" character varying(200) COLLATE pg_catalog."default",
    "FaxNumber" character varying(30) COLLATE pg_catalog."default",
    "ShipAddress" character varying(30) COLLATE pg_catalog."default",
    "ShipCity" character varying(255) COLLATE pg_catalog."default",
    "ShipStateOrProvince" character varying(50) COLLATE pg_catalog."default",
    "ShipZIPCode" character varying(20) COLLATE pg_catalog."default",
    "ShipPhoneNumber" character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT "Customers_pkey" PRIMARY KEY ("CustomerID")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Customers"
    OWNER to postgres;