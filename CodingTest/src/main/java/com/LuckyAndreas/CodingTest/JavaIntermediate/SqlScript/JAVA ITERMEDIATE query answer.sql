1.Query Customer di kota Irvine:
select cust.* from "Customers" cust inner join "Orders" o on o."CustomerID" = cust."CustomerID"
where cust."City" = 'Irvine';

2.Daftar semua pelanggan yang pesanannya ditangani karyawan bernama Adam Barr :
select cust.* from "Customers" cust 
inner join "Orders" o on o."CustomerID" = cust."CustomerID"
inner join "Employees" e on e."EmployeeID" = o."EmployeeID"
where e."FirstName" = 'Adam' and e."LastName" = 'Barr';

3.Daftar produk yang dipesan oleh pelanggan Contoso, Ltd
select prod.* from "Products" prod
inner join "Order_Details" od on od."ProductID" = prod."ProductID"
inner join "Orders" o on o."OrderID" = od."OrderID"
inner join "Customers" cs on cs."CustomerID" = o."CustomerID"
where cs."CompanyName" like 'Contoso%'

4.Daftar transaksi pemesanan yang dikirimkan melalui UPS Ground
select o.* from "Orders" o 
inner join "Shipping_Methods" sm on sm."ShippingMethodID" = o."ShippingMethodID"
where sm."ShippingMethod" = 'UPS Ground'

5.Daftar biaya total pemesanan (termasuk pajak dan biaya pengiriman) setiap transaksi diurut berdasarkan tanggal transaksi :
select 
sum( (od."UnitPrice" * od."Quantity") - ((od."UnitPrice" * od."Quantity" * od."Discount")/100 )) - o."Taxes" -
(CASE 
	WHEN o."FreightCharge" != null 
	THEN o."FreightCharge"
		ELSE 0
END )
as BiayaTotalPemesanan,
o."OrderID",
o."OrderDate"
from "Orders" o 
inner join "Order_Details" od on od."OrderID" = o."OrderID"
group by o."OrderID"
order by o."OrderDate" desc