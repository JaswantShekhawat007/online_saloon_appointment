package com.osa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osa.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>{

}
