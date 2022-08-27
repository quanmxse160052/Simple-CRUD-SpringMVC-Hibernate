package quanmx.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quanmx.customer.CustomerDAO;
import quanmx.customer.CustomerDTO;

/**
 *
 * @author Dell
 */
@Service("customerServiceImp")
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public List<CustomerDTO> getCustomers() {
        //get customers from DAO
        List<CustomerDTO> customers = customerDAO.getCustomers();
        return customers;

    }

    @Override
    public void addNewCustomer(CustomerDTO customer) {
        customerDAO.addNewCustomer(customer);
    }

    @Override
    public CustomerDTO getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    public void updateCustomer(CustomerDTO customer) {
        customerDAO.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

}
