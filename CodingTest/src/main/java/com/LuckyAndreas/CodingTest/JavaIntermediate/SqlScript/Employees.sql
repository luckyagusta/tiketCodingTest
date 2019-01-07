-- Table: public."Employees"

-- DROP TABLE public."Employees";

CREATE TABLE public."Employees"
(
    "EmployeeID" numeric NOT NULL,
    "FirstName" character varying(50) COLLATE pg_catalog."default",
    "LastName" character varying(50) COLLATE pg_catalog."default",
    "Title" character varying(50) COLLATE pg_catalog."default",
    "WorkPhone" character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT "Employees_pkey" PRIMARY KEY ("EmployeeID")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Employees"
    OWNER to postgres;