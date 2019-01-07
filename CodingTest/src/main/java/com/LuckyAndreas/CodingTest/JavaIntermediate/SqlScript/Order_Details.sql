-- Table: public."Order_Details"

-- DROP TABLE public."Order_Details";

CREATE TABLE public."Order_Details"
(
    "OrderDetailID" numeric NOT NULL,
    "OrderID" numeric,
    "ProductID" numeric,
    "Quantity" numeric,
    "UnitPrice" numeric,
    "Discount" numeric,
    CONSTRAINT "Order_Details_pkey" PRIMARY KEY ("OrderDetailID"),
    CONSTRAINT "Order_Details_OrderID_fkey" FOREIGN KEY ("OrderID")
        REFERENCES public."Orders" ("OrderID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "Order_Details_ProductID_fkey" FOREIGN KEY ("ProductID")
        REFERENCES public."Products" ("ProductID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Order_Details"
    OWNER to postgres;