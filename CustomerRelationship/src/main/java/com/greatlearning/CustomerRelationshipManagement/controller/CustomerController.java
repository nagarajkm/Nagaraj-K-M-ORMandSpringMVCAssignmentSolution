package com.greatlearning.CustomerRelationshipManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.CustomerRelationshipManagement.Customer;
import com.greatlearning.CustomerRelationshipManagement.service.CustomerService;

@Controller
@RequestMapping("/Customer")
public class CustomerController {

	@Autowired
	private CustomerService customerservice;

	@RequestMapping("/list")
	public String listcustomer(Model theModel) {
		List<Customer> customer = customerservice.findAll();
		theModel.addAttribute("Customers", customer);
		return "list-customer";

	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("Customer", theCustomer);

		return "Customer-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model theModel) {

		
		Customer thecustomer = customerservice.findById(id);

		
		theModel.addAttribute("Customer", thecustomer);

		
		return "Customer-form";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") int theid) {

		
		customerservice.deleteById(theid);

		
		return "redirect:/Customer/list";

	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		System.out.println(id);
		Customer thecustomer;
		if (id != 0) {
			thecustomer = customerservice.findById(id);
			thecustomer.setFirstName(firstName);
			thecustomer.setLastName(lastName);
			thecustomer.setEmail(email);
		} else
			thecustomer = new Customer(firstName, lastName, email);
		
		customerservice.save(thecustomer);
		// use a redirect to prevent duplicate submissions
		return "redirect:/Customer/list";
	}

}
