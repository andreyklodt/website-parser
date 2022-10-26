package com.example.helloworldjava.Repository;

import com.example.helloworldjava.Entity.CustomerWebsiteEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerWebsiteRepository extends CrudRepository<CustomerWebsiteEntity, Long> {
   CustomerWebsiteEntity findByUrl(String url);
}
