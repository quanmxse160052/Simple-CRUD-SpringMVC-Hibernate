/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanmx.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import quanmx.customer.CustomerDTO;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    @Qualifier("customerServiceImp")
    private CustomerService customerService;

    @RequestMapping("/list")
    public String listCustomers(Model model) {
        //get customers from DAO
        List<CustomerDTO> customers = customerService.getCustomers();
        //add result to model
        model.addAttribute("CUSTOMERS", customers);
        return "list-customer";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd() {
        return "AddCustomerForm";
    }

    @PostMapping("/addNewCustomer")
    public String addNewCustomer(HttpServletRequest request) {

        String firstName = request.getParameter("txtFirstName");
        String lastName = request.getParameter("txtLastName");
        String email = request.getParameter("txtEmail");
        CustomerDTO customer = new CustomerDTO(firstName, lastName, email);
        customerService.addNewCustomer(customer);

        return "redirect:/customer/list";

    }

    @GetMapping("/updateForm")
    public String updateForm(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        CustomerDTO updatedCustomer = customerService.getCustomer(id);
        model.addAttribute("CUSTOMER", updatedCustomer);
        return "updateForm";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("txtFirstName");
        String lastName = request.getParameter("txtLastName");
        String email = request.getParameter("txtEmail");
        CustomerDTO customer = new CustomerDTO(firstName, lastName, email);
        customer.setId(id);
        customerService.updateCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("id") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

}
