package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.dao.CountryRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import com.example.demo.entities.Country;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootstrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (customerRepository.count() > 1) {
            return;
        }

        Customer a = new Customer();
        a.setFirstName("Smith");
        a.setLastName("Wings");
        a.setAddress("734 cops");
        a.setPostal_code("45678");
        a.setPhone("456978231");
        a.setDivision(divisionRepository.getReferenceById(2L));

        Customer b = new Customer();
        b.setFirstName("Alice");
        b.setLastName("Johnson");
        b.setAddress("456 Oak Ave");
        b.setPostal_code("67890");
        b.setPhone("9876543210");
        b.setDivision(divisionRepository.getReferenceById(3L));

        Customer c = new Customer();
        c.setFirstName("Bob");
        c.setLastName("Williams");
        c.setAddress("789 Elm Blvd");
        c.setPostal_code("54321");
        c.setPhone("5551234567");
        c.setDivision(divisionRepository.getReferenceById(4L));

        Customer d = new Customer();
        d.setFirstName("Eva");
        d.setLastName("Brown");
        d.setAddress("101 Pine Ln");
        d.setPostal_code("98765");
        d.setPhone("7890123456");
        d.setDivision(divisionRepository.getReferenceById(5L));

        Customer e = new Customer();
        e.setFirstName("Michael");
        e.setLastName("Phelps");
        e.setAddress("202 Cedar Rd");
        e.setPostal_code("13579");
        e.setPhone("4567890123");
        e.setDivision(divisionRepository.getReferenceById(6L));

        customerRepository.save(a);
        customerRepository.save(b);
        customerRepository.save(c);
        customerRepository.save(d);
        customerRepository.save(e);

        customerRepository.findAll();

    }
}
