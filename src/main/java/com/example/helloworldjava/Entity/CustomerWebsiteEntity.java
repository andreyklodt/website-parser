package com.example.helloworldjava.Entity;

import org.springframework.http.HttpStatus;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerWebsiteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;

    private CustomerWebsiteStatus status = CustomerWebsiteStatus.New;

    private HttpStatus http_code;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getUrl(){
        return this.url;
    }

    public void setUrl(String url){
        this.url = url;
    }

     public CustomerWebsiteStatus getStatus(){
        return this.status;
    }

    public void setStatus(CustomerWebsiteStatus status){
        this.status = status;
    }

    public HttpStatus getHttp_code() {
        return http_code;
    }

    public void setHttp_code(HttpStatus http_code) {
        this.http_code = http_code;
    }
}
