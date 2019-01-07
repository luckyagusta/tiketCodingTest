package com.LuckyAndreas.CodingTest.JavaIntermediate;

import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Customers;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Employees;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.OrderDetails;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Orders;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Products;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.ShippingMethods;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Repository.OrderRepository.ProductDetail;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Service.CustomerService;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Service.EmployeeService;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Service.OrderDetailService;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Service.OrderService;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Service.ProductService;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Service.ShippingMethodService;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Util.CsvDataLoader;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Util.CsvPath;

@RestController
@RequestMapping("/rest")
public class MainController {
	@Autowired
	private CsvDataLoader loader;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private ProductService prodService;
	
	@Autowired
	private ShippingMethodService smService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDetailService odService;
	
	@GetMapping("/dataPemesan")
	public Page<Customers> getAllCustomer(@PageableDefault(size = 5) Pageable pageable){
		List<Customers> obj = customerService.findCustomers();
		int start = (int) pageable.getOffset();
		int end = (start + pageable.getPageSize()) > obj.size() ? obj.size()
				: (start + pageable.getPageSize());
		return new PageImpl<Customers>(obj.subList(start, end), pageable, obj.size());
	}
	
	@GetMapping("/dataKaryawanByOrder")
	public PageImpl<Object> getEmployeeByOrder(@PageableDefault(size = 5) Pageable pageable){
		List<Object> obj = empService.findEmployeeByOrder();
		int start = (int) pageable.getOffset();
		int end = (start + pageable.getPageSize()) > obj.size() ? obj.size()
				: (start + pageable.getPageSize());
		return new PageImpl<Object>(obj.subList(start, end), pageable, obj.size());
	}
	
	@GetMapping("/shippingMethodByOrder")
	public PageImpl<Object> getSmInUsed(@PageableDefault(size = 5) Pageable pageable){
		List<Object> obj = smService.findShippingMethodByOrder();
		int start = (int) pageable.getOffset();
		int end = (start + pageable.getPageSize()) > obj.size() ? obj.size()
				: (start + pageable.getPageSize());
		return new PageImpl<Object>(obj.subList(start, end), pageable, obj.size());
	}
	
	@RequestMapping(value = "/getProductDetail/{orderId}", method = RequestMethod.GET)
	public Page<ProductDetail> getProductDetail(@PathVariable("orderId") long orderID,
			@PageableDefault(size = 5) Pageable pageable) {
		List<ProductDetail> prodDetail = orderService.findProductDetail(orderID);
		int start = (int) pageable.getOffset();
		int end = (start + pageable.getPageSize()) > prodDetail.size() ? prodDetail.size()
				: (start + pageable.getPageSize());
		return new PageImpl<ProductDetail>(prodDetail.subList(start, end), pageable, prodDetail.size());
	}
	
	@RequestMapping(value = "/getPaymentDetail/{orderId}", method = RequestMethod.GET)
	public List<Object> payDetail(@PathVariable("orderId") long orderID){
		return orderService.payDetail(orderID);
	}
	
	
	@GetMapping("/uploadEmployeeCSV")
	public void uploadEmployeeCSV(){
		List<Employees> emp = loader.readCsvEmployees(CsvPath.EMPLOYEES);
		empService.uploadEmployee(emp);
	}
	
	@GetMapping("/uploadProductCSV")
	public void uploadProductCSV(){
		List<Products> prod = loader.readCsvProducts(CsvPath.PRODUCTS);
		prodService.uploadProducts(prod);
	}
	
	@GetMapping("/uploadShippingMethodCSV")
	public void uploadShippingMethodCSV(){
		List<ShippingMethods> sm = loader.readCsvShippingMethods(CsvPath.ShippingMethods);
		smService.uploadShippingMethod(sm);
	}
	
	@GetMapping("/uploadCustomerCSV")
	public void uploadCustomerCSV() {
		List<Customers> customers = loader.readCsvCustomerMethods(CsvPath.CUSTOMERS);
		customerService.uploadCustomer(customers);
	}
	
	@GetMapping("/uploadOrderCSV")
	public void uploadOrderCSV() throws ParseException {
		List<Orders> order = loader.readCsvOrder(CsvPath.ORDERS);
		orderService.uploadOrder(order);
	}
	
	@GetMapping("/uploadOrderDetailCSV")
	public void uploadOrderDetailCSV() {
		List<OrderDetails> od = loader.readCsvOrderDetail(CsvPath.ORDERDETAILS);
		odService.uploadOrderDetail(od);
	}
	
	
}
