package br.com.ozzybr.personapi.repositories;

//Aula DIO com prof. Rodrigo Peleias

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ozzybr.personapi.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
