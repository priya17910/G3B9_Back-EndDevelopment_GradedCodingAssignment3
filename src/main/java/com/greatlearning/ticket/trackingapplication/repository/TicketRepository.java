package com.greatlearning.ticket.trackingapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.ticket.trackingapplication.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	List<Ticket> findByTitleContainingOrDescriptionContaining(String title, String description);
}
