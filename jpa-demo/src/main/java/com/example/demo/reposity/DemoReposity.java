package com.example.demo.reposity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AAA;

public interface DemoReposity extends JpaRepository<AAA, Integer> {

}
