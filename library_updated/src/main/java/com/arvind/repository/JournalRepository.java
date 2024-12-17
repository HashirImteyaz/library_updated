package com.arvind.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arvind.entity.journals;
public interface JournalRepository extends JpaRepository<journals, Integer> {

}
