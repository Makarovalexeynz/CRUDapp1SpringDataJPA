package ru.makarov.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.makarov.springcourse.models.*;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

}
