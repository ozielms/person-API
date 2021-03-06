package br.com.ozzybr.personapi.controllers;

//	Aula DIO com prof. Rodrigo Peleias

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ozzybr.personapi.dto.request.PersonDTO;
import br.com.ozzybr.personapi.dto.response.MessageResponseDTO;
import br.com.ozzybr.personapi.exception.PersonNotFoundException;
import br.com.ozzybr.personapi.services.PersonService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

	private final PersonService personService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody @Valid PersonDTO personDTO) {
		return personService.create(personDTO);
	}

	// ------ FIND -------
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
		return personService.findById(id);
	}

	// ------ LISTA ALL -------
	@GetMapping
	public List<PersonDTO> listAll() {
		return personService.listAll();
	}

	// ------ UPDATE -------
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO)
			throws PersonNotFoundException {
		return personService.update(id, personDTO);
	}

// ------ DELETE -------
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws PersonNotFoundException {
		personService.delete(id);
	}
}
