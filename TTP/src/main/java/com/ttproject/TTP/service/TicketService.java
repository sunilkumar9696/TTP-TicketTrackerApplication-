package com.ttproject.TTP.service;

import java.util.List;

import com.ttproject.TTP.dto.TicketDTO;
import com.ttproject.TTP.entity.Ticket;

public interface TicketService {

	List<TicketDTO> findAllTickets();
	
	void saveTicket(Ticket ticket);
	
	void deleteTicket(long id);
	
	Ticket getTicketById(long id);
	
	List<TicketDTO> searchTickets(String query);
}
