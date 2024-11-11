package com.marketingApp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingApp1.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
