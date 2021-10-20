package br.com.ozzybr.personapi.dto.response;

//Aula DIO com prof. Rodrigo Peleias

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {

	private String message;
}
