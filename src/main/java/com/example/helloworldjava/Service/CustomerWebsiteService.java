package com.example.helloworldjava.Service;

import com.example.helloworldjava.Entity.CustomerWebsiteEntity;
import com.example.helloworldjava.Exception.CustomerWebsiteAlreadyExistsException;
import com.example.helloworldjava.Repository.CustomerWebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CustomerWebsiteService {
    private final CustomerWebsiteRepository customerWebsiteRepository;

    @Autowired
    public CustomerWebsiteService(CustomerWebsiteRepository customerWebsiteRepository) {
        this.customerWebsiteRepository = customerWebsiteRepository;
    }

    public void addNew(CustomerWebsiteEntity customerWebsite) throws CustomerWebsiteAlreadyExistsException {
        if (this.customerWebsiteRepository.findByUrl(customerWebsite.getUrl()) != null) {
            throw new CustomerWebsiteAlreadyExistsException("Such website link already registered in database");
        }

        this.customerWebsiteRepository.save(customerWebsite);
    }

    public Iterable<CustomerWebsiteEntity> getAllWebsites() {
        return this.customerWebsiteRepository.findAll();
    }

    public void parseCustomerWebsites() {
        Iterable<CustomerWebsiteEntity> websites = this.getAllWebsites();


        for (CustomerWebsiteEntity item : websites) {

            WebClient.RequestHeadersUriSpec<?> request = (WebClient.RequestHeadersUriSpec<?>) WebClient.create(item.getUrl()).get().retrieve();

            System.out.println(request);
        }
    }
}
