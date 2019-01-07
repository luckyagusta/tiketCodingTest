package com.LuckyAndreas.CodingTest.JavaIntermediate.Util;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Customers;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Employees;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.OrderDetails;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Orders;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Products;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.ShippingMethods;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Service.CustomerService;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Service.EmployeeService;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Service.OrderService;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Service.ProductService;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Service.ShippingMethodService;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Service
public class CsvDataLoader {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ShippingMethodService smService;
	@Autowired
	private ProductService prodService;
	@Autowired
	private OrderService orderService;

	public CSVReader readData(String fileName, int skipLine) throws IOException {

		Reader reader = Files.newBufferedReader(Paths.get(fileName));
		CSVParser parser = new CSVParserBuilder().withSeparator(';').withIgnoreQuotations(true).build();
		CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).withSkipLines(skipLine).build();
		return csvReader;
	}

	public List<Products> readCsvProducts(String fileName) {
		List<Products> listProd = new ArrayList<>();
		int skipLine = 1;
		try {
			CSVReader csvReader = readData(fileName, skipLine);
			String[] nextLine;
			while ((nextLine = csvReader.readNext()) != null) {
				Products prod = new Products();
				prod.setProductID(Long.valueOf(nextLine[0]));
				prod.setProductName(nextLine[1]);
				if (nextLine[2].indexOf(",") != -1) {
					prod.setUnitPrice(Double.parseDouble(nextLine[2].replaceAll("[,]+", "")));
				}
				else{
					prod.setUnitPrice(Double.parseDouble(nextLine[2]));
				}
				prod.setInStock(nextLine[3].charAt(0));
				listProd.add(prod);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return listProd;
	}

	public List<Employees> readCsvEmployees(String fileName) {
		List<Employees> listEmp = new ArrayList<>();
		int skipLine = 1;
		try {
			CSVReader csvReader = readData(fileName, skipLine);
			String[] nextLine;
			while ((nextLine = csvReader.readNext()) != null) {
				Employees emp = new Employees();
				emp.setEmployeeID(Long.valueOf(nextLine[0]));
				emp.setFirstName(nextLine[1]);
				emp.setLastName(nextLine[2]);
				emp.setTitle(nextLine[3]);
				emp.setWorkPhone(nextLine[4]);
				listEmp.add(emp);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return listEmp;
	}

	public List<ShippingMethods> readCsvShippingMethods(String fileName) {
		List<ShippingMethods> listShipping = new ArrayList<>();
		int skipLine = 1;
		try {
			CSVReader csvReader = readData(fileName, skipLine);
			String[] nextLine;
			while ((nextLine = csvReader.readNext()) != null) {
				ShippingMethods sm = new ShippingMethods();
				sm.setShippingMethodID(Long.valueOf(nextLine[0]));
				sm.setShippingMethod(nextLine[1]);
				listShipping.add(sm);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return listShipping;
	}

	public List<Customers> readCsvCustomerMethods(String fileName) {
		List<Customers> listCustomer = new ArrayList<>();
		int skipLine = 1;
		int temp = 1;
		try {
			CSVReader csvReader = readData(fileName, skipLine);
			String[] nextLine;
			Customers customerSpecial = new Customers();
			while ((nextLine = csvReader.readNext()) != null) {
				Customers customer = new Customers();
				if (temp == 1) {

					customerSpecial.setCustomerID(Long.valueOf(nextLine[0]));
					customerSpecial.setCompanyName(nextLine[1]);
					customerSpecial.setFirstName(nextLine[2]);
					customerSpecial.setLastName(nextLine[3]);
					customerSpecial.setBillingAddress(nextLine[4]);
					customerSpecial.setCity(nextLine[5]);
					customerSpecial.setStateOrProvince(nextLine[6]);
					customerSpecial.setZIPCode(nextLine[7]);
					customerSpecial.setEmail(nextLine[8]);
					customerSpecial.setCompanyWebSite(nextLine[9]);

				}
				if (temp == 2) {
					customerSpecial.setPhoneNumber(nextLine[1]);
					customerSpecial.setFaxNumber(nextLine[2]);
					customerSpecial.setShipAddress(nextLine[3]);
					customerSpecial.setShipCity(nextLine[4]);
					customerSpecial.setShipStateOrProvince(nextLine[5]);
					customerSpecial.setShipZIPCode(nextLine[6]);
					customerSpecial.setShipPhoneNumber(nextLine[7]);
					System.out.println(customerSpecial.getShipPhoneNumber());
					listCustomer.add(customerSpecial);
				}

				if (temp == 4) {
					customer.setCustomerID(Long.valueOf(nextLine[0]));
					customer.setCompanyName(nextLine[1]);
					customer.setFirstName(nextLine[2]);
					customer.setLastName(nextLine[3]);
					customer.setBillingAddress(nextLine[4]);
					customer.setCity(nextLine[5]);
					customer.setStateOrProvince(nextLine[6]);
					customer.setZIPCode(nextLine[7]);
					customer.setEmail(nextLine[8]);
					customer.setCompanyWebSite(nextLine[9]);
					customer.setPhoneNumber(nextLine[10]);
					customer.setFaxNumber(nextLine[11]);
					customer.setShipAddress(nextLine[12]);
					customer.setShipCity(nextLine[13]);
					customer.setShipStateOrProvince(nextLine[14]);
					customer.setShipZIPCode(nextLine[15]);
					customer.setShipPhoneNumber(nextLine[16]);
					listCustomer.add(customer);

				} else if (temp == 3 || temp == 5) {
					if (nextLine[1].indexOf(",") != -1) {
						customer.setCompanyName(nextLine[1].replaceAll("[,]+", ""));
					}
					customer.setCustomerID(Long.valueOf(nextLine[0]));
					customer.setFirstName(nextLine[2]);
					customer.setLastName(nextLine[3]);
					customer.setBillingAddress(nextLine[4]);
					customer.setCity(nextLine[5]);
					customer.setStateOrProvince(nextLine[6]);
					customer.setZIPCode(nextLine[7]);
					customer.setEmail(nextLine[8]);
					customer.setCompanyWebSite(nextLine[9]);
					customer.setPhoneNumber(nextLine[10]);
					customer.setFaxNumber(nextLine[11]);
					customer.setShipAddress(nextLine[12]);
					customer.setShipCity(nextLine[13]);
					customer.setShipStateOrProvince(nextLine[14]);
					customer.setShipZIPCode(nextLine[15]);
					customer.setShipPhoneNumber(nextLine[16]);
					listCustomer.add(customer);
				}
				temp++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return listCustomer;
	}

	public List<Orders> readCsvOrder(String fileName) throws ParseException {
		List<Orders> listOrder = new ArrayList<>();
		int skipLine = 1;
		long temp = 1;

		try {
			CSVReader csvReader = readData(fileName, skipLine);
			String[] nextLine;
			while ((nextLine = csvReader.readNext()) != null) {
				Orders order = new Orders();
				if (temp == 6) {
					order.setOrderID(Long.valueOf(nextLine[0]));
					Customers customer = customerService.findCustomer(Long.valueOf(nextLine[1]));
					order.setCustomer(customer);
					Employees employee = employeeService.findEmployee(Long.valueOf(nextLine[2]));
					order.setEmployee(employee);
					order.setOrderDate(nextLine[3]);
					order.setPurchaseOrderNumber(nextLine[4]);
					ShippingMethods sm = smService.findSM(Long.valueOf(nextLine[6]));
					order.setShippingMethods(sm);
					order.setFreightCharge(Long.valueOf(nextLine[7]));
					order.setTaxes(Long.valueOf(nextLine[8]));
					order.setPaymentReceived(nextLine[9].charAt(0));
					order.setComment(nextLine[10]);
					listOrder.add(order);
				} else {
					order.setOrderID(Long.valueOf(nextLine[0]));
					Customers customer = customerService.findCustomer(Long.valueOf(nextLine[1]));
					order.setCustomer(customer);
					Employees employee = employeeService.findEmployee(Long.valueOf(nextLine[2]));
					order.setEmployee(employee);
					order.setOrderDate(nextLine[3]);
					order.setPurchaseOrderNumber(nextLine[4]);
					order.setShipDate(nextLine[5]);
					ShippingMethods sm = smService.findSM(Long.valueOf(nextLine[6]));
					order.setShippingMethods(sm);
					if (nextLine[7].isEmpty()) {
					} else {
						order.setFreightCharge(Long.valueOf(nextLine[7]));
					}
					order.setTaxes(Long.valueOf(nextLine[8]));
					order.setPaymentReceived(nextLine[9].charAt(0));
					order.setComment(nextLine[10]);
					listOrder.add(order);
				}
				temp++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return listOrder;
	}
	
	public List<OrderDetails> readCsvOrderDetail(String fileName) {
		List<OrderDetails> listOD = new ArrayList<>();
		int skipLine = 1;
		try {
			CSVReader csvReader = readData(fileName, skipLine);
			String[] nextLine;
			while ((nextLine = csvReader.readNext()) != null) {
				OrderDetails od = new OrderDetails();
				od.setOrderDetailID(Long.valueOf(nextLine[0]));
				Orders order = orderService.findOrder(Long.valueOf(nextLine[1]));
				od.setOrder(order);
				Products prod = prodService.findProduct(Long.valueOf(nextLine[2]));
				od.setProduct(prod);
				od.setQuantity(Long.valueOf(nextLine[3]));
				if (nextLine[4].indexOf(",") != -1) {
					od.setUnitPrice(Double.parseDouble(nextLine[4].replaceAll("[,]+", "")));
				}
				else {
					od.setUnitPrice(Double.parseDouble(nextLine[4]));
				}
				if (nextLine[5].indexOf("%") != -1) {
					od.setDiscount(Long.valueOf(nextLine[5].replaceAll("[%]+", "")));
				}
				else {
					od.setDiscount(Long.valueOf(nextLine[5]));
				}
				listOD.add(od);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return listOD;
	}

}
