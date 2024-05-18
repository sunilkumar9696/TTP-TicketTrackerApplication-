package com.ttproject.TTP.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDTO {

	
	private long id;
	
	private String title;
	
	private String shortDescription;
	
	private String content;
	
	private LocalDate ticketCreatedOn;
	
	
}
