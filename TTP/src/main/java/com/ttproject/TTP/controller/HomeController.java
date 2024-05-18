package com.ttproject.TTP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ttproject.TTP.dto.TicketDTO;
import com.ttproject.TTP.entity.Ticket;
import com.ttproject.TTP.service.TicketService;



@Controller
public class HomeController {
	
	//injecting service layer dependency
	TicketService ticketService;
	
	@Autowired
	public HomeController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	//http://localhost:8080/tickets
	@GetMapping("/tickets")
	public String ticketList(Model model) {
		List<TicketDTO> tickets = ticketService.findAllTickets();
		model.addAttribute("ticketAttribute" , tickets);
		return "ticketList";
	}
	
	//getting a form to enter details
	@GetMapping("/AddNewTicket")
	public String addNewTickets(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticketAttribute", ticket);
		return "AddNewTicket";
	}
	
	//saving the ticket details
	@PostMapping("/saveTicket")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.saveTicket(ticket);
		return "redirect:/tickets";
	}
	
	@GetMapping("/deleteForm/{id}")
	public String deleteTicket(@PathVariable long id) {
		ticketService.deleteTicket(id);
		return "redirect:/tickets";
	}
	
	@GetMapping("/editForm/{id}")
	public String editForm(@PathVariable long id , Model model) {
		model.addAttribute("ticketAttribute", ticketService.getTicketById(id));
		return "editForm";
	}
	
	@PostMapping("/updateTicket/{id}")
	public String updateTicket(@PathVariable long id ,@ModelAttribute("ticketAttribute") Ticket ticket) {
		Ticket existingTicket = ticketService.getTicketById(id);
		existingTicket.setId(id);
		existingTicket.setTitle(ticket.getTitle());
		existingTicket.setShortDescription(ticket.getShortDescription());
		existingTicket.setContent(ticket.getContent());
		
		ticketService.saveTicket(existingTicket);
		
		return "redirect:/tickets";
	}
	
	@GetMapping("/search")
	public String searchTickets(@RequestParam(value = "query") String query, Model model) {

		List<TicketDTO> tickets = ticketService.searchTickets(query);
		model.addAttribute("ticketAttribute", tickets);
		return "ticketList";

	}
	
	@GetMapping("/viewForm/{id}")
	public String viewForm(@PathVariable long id , Model model) {
		model.addAttribute("ticketAttribute", ticketService.getTicketById(id));
		return"viewForm";
	}
}
