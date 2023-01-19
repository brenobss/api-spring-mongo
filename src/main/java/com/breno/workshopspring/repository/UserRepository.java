package com.breno.workshopspring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.breno.workshopspring.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
