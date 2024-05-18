package com.ttproject.TTP.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ttproject.TTP.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

	@Query("SELECT p from Ticket p WHERE " +
            " p.title LIKE CONCAT('%', :query, '%') OR " +
            " p.shortDescription LIKE CONCAT('%', :query, '%')")
	
	List<Ticket> searchTickets(String query);
}
