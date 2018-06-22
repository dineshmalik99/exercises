package com.sapient.lloyds.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.lloyds.entity.Card;

@Repository
public interface CardDAO extends JpaRepository<Card, String>{

}
