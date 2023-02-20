import java.util.ArrayList;

import model.Customer;

public class Tester {
    public static void main(String[] args) throws Exception {
        Customer customer = new Customer("first", "second", "j@domain.com");
        Customer customer2 = new Customer("first2", "secon2d", "hhh@153.com");

        ArrayList<Customer> sites = new ArrayList<>();
       
        sites.add(customer);
        sites.add(customer2);

        System.out.println(sites);
    }
}
