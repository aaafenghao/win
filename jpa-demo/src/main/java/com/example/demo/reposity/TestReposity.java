package com.example.demo.reposity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Test;

public interface TestReposity extends JpaRepository<Test, Integer> {

}
