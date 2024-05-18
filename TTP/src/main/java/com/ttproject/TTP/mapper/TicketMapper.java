package com.ttproject.TTP.mapper;

import com.ttproject.TTP.dto.TicketDTO;
import com.ttproject.TTP.entity.Ticket;

public class TicketMapper {

	//mapping Ticket entity to TicketDTO
	public static TicketDTO mapToTicketDto(Ticket ticket) {
		TicketDTO ticketDto = TicketDTO.builder()
				.id(ticket.getId())
				.title(ticket.getTitle())
				.shortDescription(ticket.getShortDescription())
				.content(ticket.getContent())
				.ticketCreatedOn(ticket.getTicketCreatedOn())
				.build();
		return ticketDto;
	}
	
	//mapping TicketDTO to Ticket
	
	public static Ticket mapToTicket(TicketDTO ticketdto) {
		Ticket ticket = Ticket.builder()
				.id(ticketdto.getId())
				.title(ticketdto.getTitle())
				.shortDescription(ticketdto.getShortDescription())
				.content(ticketdto.getContent())
				.ticketCreatedOn(ticketdto.getTicketCreatedOn())
				.build();
		return ticket;
	}
}
