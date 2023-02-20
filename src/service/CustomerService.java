package service;

import java.util.Collection;
import java.util.LinkedList;
import model.Customer;

public class CustomerService {
    private CustomerService(){} // singleton pattern (单例模式) ：私有构造函数，不允许外部创建实例
    private static CustomerService customerServiceInstance = new CustomerService(); // singleton pattern (单例模式)  只提供一个实例 
    public static CustomerService getInstance(){ // singleton pattern (单例模式) 只提供一个实例
        return customerServiceInstance;
    }

    private Collection<Customer> customers = new LinkedList<Customer>();

    public void addCustomer(String email, String firstName, String lastName){
        customers.add(new Customer(email, firstName, lastName));
    }

    public Customer getCustomer(String email){
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                return customer;
        }
        }
        return null;
    }

    public Collection<Customer> getAllCustomers(){
        return customers;
    }


}
