package com.nanda.laundry.repository;

import com.nanda.laundry.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findFirstByMobilePhone(String number);
}
