package com.greatlearning.ticket.trackingapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.ticket.trackingapplication.model.Ticket;
import com.greatlearning.ticket.trackingapplication.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;
	
	// SERVICE CODE TO FIND ALL THE LIST OF TICKETS
	@Override
	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}
	
	// SERVICE CODE TO FIND THE TICKET BY ID
	@Override
	public Ticket findById(int theId) {
		Optional<Ticket> result = ticketRepository.findById(theId);
		Ticket ticket = null;
		if (result.isPresent())
		{
			ticket = result.get();
		}
		else
		{
			throw new RuntimeException("Ticket is not present with the given id: " + theId);
		}
		return ticket;
	}

	// SERVICE CODE TO SAVE THE TICKET
	@Override
	public void save(Ticket theTicket) {
		ticketRepository.save(theTicket);
	}

	// SERVICE CODE TO DELETE THE TICKET BY ID
	@Override
	public void deleteById(int theId) {
		ticketRepository.deleteById(theId);
	}

	// SERVICE CODE TO SEARCH THE TICKET BY KEYWORD --- (KEYWORD NEED TO BE SEARCHED IN TITLE AND SHORT DESCRIPTION)
	@Override
	public List<Ticket> searchByKeyword(String keyword) {
        return ticketRepository.findByTitleContainingOrDescriptionContaining(keyword, keyword);
    }

}
