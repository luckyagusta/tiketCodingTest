-- Table: public."Orders"

-- DROP TABLE public."Orders";

CREATE TABLE public."Orders"
(
    "OrderID" numeric NOT NULL,
    "CustomerID" numeric,
    "EmployeeID" numeric,
    "OrderDate" date,
    "PurchaseOrderNumber" character varying(30) COLLATE pg_catalog."default",
    "ShipDate" date,
    "ShippingMethodID" numeric,
    "FreightCharge" numeric,
    "Taxes" numeric,
    "PaymentReceived" character(1) COLLATE pg_catalog."default",
    "Comment" character varying(150) COLLATE pg_catalog."default",
    CONSTRAINT "Orders_pkey" PRIMARY KEY ("OrderID"),
    CONSTRAINT "Orders_CustomerID_fkey" FOREIGN KEY ("CustomerID")
        REFERENCES public."Customers" ("CustomerID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "Orders_EmployeeID_fkey" FOREIGN KEY ("EmployeeID")
        REFERENCES public."Employees" ("EmployeeID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "Orders_ShippingMethodID_fkey" FOREIGN KEY ("ShippingMethodID")
        REFERENCES public."Shipping_Methods" ("ShippingMethodID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Orders"
    OWNER to postgres;