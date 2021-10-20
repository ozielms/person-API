package br.com.ozzybr.personapi.dto.mapper;

//Aula DIO com prof. Rodrigo Peleias

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.ozzybr.personapi.dto.request.PersonDTO;
import br.com.ozzybr.personapi.entities.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
	Person toModel(PersonDTO dto);

	PersonDTO toDTO(Person dto);
}
