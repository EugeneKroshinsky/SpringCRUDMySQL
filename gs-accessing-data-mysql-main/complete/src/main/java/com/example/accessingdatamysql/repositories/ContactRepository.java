package com.example.accessingdatamysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.accessingdatamysql.domain.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
