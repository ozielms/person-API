package one.digitalinnovation.personapi.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.ozzybr.personapi.dto.mapper.PersonMapper;
import br.com.ozzybr.personapi.dto.request.PersonDTO;
import br.com.ozzybr.personapi.dto.response.MessageResponseDTO;
import br.com.ozzybr.personapi.entities.Person;
import br.com.ozzybr.personapi.repositories.PersonRepository;
import br.com.ozzybr.personapi.services.PersonService;

import static one.digitalinnovation.personapi.utils.PersonUtils.createFakeDTO;
import static one.digitalinnovation.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
        MessageResponseDTO successMessage = personService.create(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponseDTO.builder()
                .message("Person successfully created with ID " + savedPersonId)
                .build();
    }

}
