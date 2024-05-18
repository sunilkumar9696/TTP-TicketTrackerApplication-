package com.ttproject.TTP.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttproject.TTP.dto.TicketDTO;
import com.ttproject.TTP.entity.Ticket;
import com.ttproject.TTP.mapper.TicketMapper;
import com.ttproject.TTP.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{

	//we are injecting repository dependency through construction injection
	
	private TicketRepository ticketRepository;
	
	@Autowired
	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}
	@Override
	public List<TicketDTO> findAllTickets() {
		List<Ticket> tickets = ticketRepository.findAll();
		
		//type 1 java feature 8
//		return tickets.stream().map((ticket) -> TicketMapper.mapToTicketDto(ticket))
//				.collect(Collectors.toList());
		
		//type 2 java feature 8
		//we are converting the list of tickets to ticketdto
		return tickets.stream().map(TicketMapper :: mapToTicketDto).collect(Collectors.toList());
	}
	@Override
	public void saveTicket(Ticket ticket) {
		ticketRepository.save(ticket);
	}
	@Override
	public void deleteTicket(long id) {
		ticketRepository.deleteById(id);
	}
	@Override
	public Ticket getTicketById(long id) {
		Ticket tickets = ticketRepository.findById(id).get();
		
		return tickets;
	}
	
	@Override
	public List<TicketDTO> searchTickets(String query) {
		List<Ticket> tickets = ticketRepository.searchTickets(query);
		return tickets.stream().map(TicketMapper::mapToTicketDto).collect(Collectors.toList());
	}

}
