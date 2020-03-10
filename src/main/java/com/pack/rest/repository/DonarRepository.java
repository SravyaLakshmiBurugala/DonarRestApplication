package com.pack.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.rest.entiry.Donar;

@Repository
public interface DonarRepository extends JpaRepository<Donar, String> {

}
