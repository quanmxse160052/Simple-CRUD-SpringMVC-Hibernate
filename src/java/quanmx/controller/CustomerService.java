package quanmx.controller;

import java.util.List;
import quanmx.customer.CustomerDTO;

/**
 *
 * @author Dell
 */
public interface CustomerService {

    public List<CustomerDTO> getCustomers();

    public void addNewCustomer(CustomerDTO customer);

    public CustomerDTO getCustomer(int id);

    public void updateCustomer(CustomerDTO customer);

    public void deleteCustomer(int id);
}
