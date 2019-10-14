package com.example.demo.reposity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Haved;

public interface HavedReposity extends JpaRepository<Haved, Integer> {

}
