package com.greatlearning.ticket.trackingapplication.service;

import java.util.List;

import com.greatlearning.ticket.trackingapplication.model.Ticket;

// SERVICE LAYER INTERFACE
public interface TicketService {
	public List<Ticket> findAll();
	public Ticket findById(int theId);
	public void save(Ticket theTicket);
	public void deleteById(int theId);
	public List<Ticket> searchByKeyword(String keyword);
}
