package com.example.helloworldjava.Controller;

import com.example.helloworldjava.Entity.CustomerWebsiteEntity;
import com.example.helloworldjava.Exception.CustomerWebsiteAlreadyExistsException;
import com.example.helloworldjava.Service.CustomerWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/service-website")
public class CustomerWebsiteController {

    private final CustomerWebsiteService customerWebsiteService;

    @Autowired
    public CustomerWebsiteController(CustomerWebsiteService customerWebsiteService) {
        this.customerWebsiteService = customerWebsiteService;
    }

    // TODO переписать ошибку под гайд https://stackoverflow.com/questions/38117717/what-is-the-best-way-to-return-different-types-of-responseentity-in-spring-mvc-o
    @PostMapping
    public ResponseEntity<String> addNewCustomerWebsite(@RequestBody CustomerWebsiteEntity website) {
        try {
            this.customerWebsiteService.addNew(website);

            return ResponseEntity.ok("Success");
        } catch (CustomerWebsiteAlreadyExistsException error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<CustomerWebsiteEntity>> getAllCustomerWebsites() {
        try {
            return ResponseEntity.ok().body(this.customerWebsiteService.getAllWebsites());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/parse")
    public ResponseEntity<String> parseCustomerWebsites() {
        try {
            this.customerWebsiteService.parseCustomerWebsites();

            return ResponseEntity.ok("Ok boi");
        } catch (Exception error) {

            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
}