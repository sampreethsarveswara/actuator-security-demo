package com.example.actuatordemo.repository;

import com.example.actuatordemo.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends ReactiveCrudRepository<User, Integer> {
}
