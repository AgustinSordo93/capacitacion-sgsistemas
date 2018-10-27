package com.clase1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clase1.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
