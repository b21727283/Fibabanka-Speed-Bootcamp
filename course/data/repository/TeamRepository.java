package com.example.springbootfirst.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springbootfirst.data.entity.Team;

public interface TeamRepository extends CrudRepository<Team, Long>{

}
