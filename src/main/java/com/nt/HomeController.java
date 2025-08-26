package com.nt;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.Customer.Customer;
import com.nt.Repository.CustomerRepository;
import com.nt.service.CustomerService;

@Controller
public class HomeController {

	@Autowired
	private CustomerService service;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/insert-form")
	public String insert() {
		return "insert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute Customer c, Model model) {
		boolean isAdded = service.insert(c);
		if (isAdded) {
			model.addAttribute("msg", "Account Created Successfully");
			return "success";
		} else {
			model.addAttribute("errorMsg", "Account creation Failed");
			return "error";
		}
	}

	@RequestMapping(value = "/update-form")
	public String update(@RequestParam int id, Model model) {
		Customer c = service.select(id);
		model.addAttribute("cust", c);
		return "update";
	}

	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String update(@ModelAttribute Customer c, Model model) {

		boolean isUpdated = service.update(c);
		if(isUpdated) {
		model.addAttribute("msg", "Account Updated Successfully");
		return "success";
		}else {
			model.addAttribute("errorMsg", "Account Updation Failed");
			return "error";
		}
	}

	@RequestMapping(value = "/delete-form")
	public String delete() {
		return "delete";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam int id, Model model) {

		boolean isDeleted = service.delete(id);
		if(isDeleted) {
		model.addAttribute("msg", "Account Deleted Successfully");
		return "success";
		}else {
			model.addAttribute("errorMsg", "Account Deletion Failed");
			return "error";
		}
	}

	@RequestMapping(value = "/select-form")
	public String select() {
		return "select";
	}

	@RequestMapping("/select")
	public String select(@RequestParam int id, Model model) {

		Customer c = service.select(id);
		if(c!=null) {
		model.addAttribute("c", c);
		return "display";
		}else {
			model.addAttribute("errorMsg", "Account Selection Failed");
			return "error";
		}
	}

	@RequestMapping("/selectall")
	public String selectall(@ModelAttribute Customer c, Model model) {

		List<Customer> list = service.selectall(c);
		if(list!=null) {
		model.addAttribute("custlist", list);
		return "displayall";
		}else {
			model.addAttribute("errorMsg", "All Account Selection Failed");
			return "error";
		}
	}

	@RequestMapping(value = "/type-form")
	public String type() {
		return "1-type";
	}

	@RequestMapping(value = "/type", method = RequestMethod.POST)
	public String type(@RequestParam String type, Model model) {

		List<Customer> list = service.type(type);
		if(list!=null&& !list.isEmpty()) {
		model.addAttribute("customer", list);
		return "1-type-1";
		}else {
			model.addAttribute("errorMsg", "Selection By Account Type Failed");
			return "error";
		}
	}

	@RequestMapping(value = "/area-form")
	public String area() {
		return "2-area";
	}

	@RequestMapping(value = "/area", method = RequestMethod.POST)
	public String area(@RequestParam String address, Model model) {

		List<Customer> list = service.area(address);
		if(list!=null&& !list.isEmpty()) {
		model.addAttribute("customer", list);
		return "2-area-2";
		}else {
			model.addAttribute("errorMsg", "Selection By Account Area Failed");
			return "error";
		}
	}

	@RequestMapping(value = "/status-form")
	public String status() {
		return "3-status";
	}

	@RequestMapping(value = "/status", method = RequestMethod.POST)
	public String status(@RequestParam String status, Model model) {

		List<Customer> list = service.status(status);
		if(list!=null&& !list.isEmpty()) {
		model.addAttribute("customer", list);
		return "3-status-3";
		}else {
			model.addAttribute("errorMsg", "Selection By Account Status Failed");
			return "error";
		}
	}

	@RequestMapping("/balance")
	public String bal(@ModelAttribute Customer c, Model model) {
		int a = service.bal(c);
		if(a==1) {
		model.addAttribute("msg","Account Balance Updated Successfully");
		return "success";
		}else {
			model.addAttribute("errorMsg", "Account Balance Updation Failed");
			return "error";
		}
	}
}
