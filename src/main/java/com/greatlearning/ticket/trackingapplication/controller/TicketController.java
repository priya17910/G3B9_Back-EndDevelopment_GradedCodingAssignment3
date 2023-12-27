package com.greatlearning.ticket.trackingapplication.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.ticket.trackingapplication.model.Ticket;
import com.greatlearning.ticket.trackingapplication.service.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	TicketService ticketService;
	
	// CONTROLLER CODE TO GET THE LIST OF TICKETS
	@GetMapping("/list")
	public String findAll(Model model)
	{
		List<Ticket> tickets = ticketService.findAll();
		model.addAttribute("tickets", tickets);
		return "ticket/list-of-tickets";
	}
	
	// CONTROLLER CODE TO GET THE LIST OF TICKETS SEARCHED ACCORDING TO THE KEYWORD ENTERED
	@PostMapping("/searchTickets")
	public String listSearchedTickets(Model model, @RequestParam("keyword") String keyword)
	{
		List<Ticket> tickets = ticketService.searchByKeyword(keyword);
		model.addAttribute("tickets", tickets);
		model.addAttribute("keyword", keyword);
		System.out.println(keyword);
		return "ticket/list-of-tickets";
	}
	
	// CONTROLLER CODE TO SHOW THE FORM FOR CREATING NEW TICKET
	@GetMapping("/showTicketFormForAdd")
	public String showTicketFormForAdd(Model model)
	{
		Ticket theTicket = new Ticket();
		model.addAttribute("ticket", theTicket);
		model.addAttribute("add", true);
		return "ticket/ticket-form";
	}
	
	// CONTROLLER CODE TO SAVE THE CREATED OR UPDATED TICKET
	@PostMapping("/saveTicket")
	public String saveBook(Model model, @ModelAttribute("ticket") Ticket ticket)
	{
		ticket.setCreatedOn(new Date());
		ticketService.save(ticket);
		return "redirect:/tickets/list?ed";
	}
	
	// CONTROLLER CODE TO DELETE TICKET
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id)
	{
		ticketService.deleteById(id);
		return "redirect:/tickets/list?del";
	}
	
	// CONTROLLER CODE TO SHOW THE FORM FOR UPDATING THE TICKET
	@GetMapping("/showTicketFormForEdit/{id}")
	public String showTicketFormForEdit(Model model, @PathVariable int id)
	{
		Ticket theTicket = ticketService.findById(id);
		model.addAttribute("ticket", theTicket);
		model.addAttribute("edit", true);
		return "ticket/ticket-form";
	}
	
	// CONTROLLER CODE TO SHOW THE TICKET TO VIEW
	@GetMapping("/showTicketFormToView/{id}")
	public String showTicketFormToView(Model model, @PathVariable int id)
	{
		Ticket theTicket = ticketService.findById(id);
		model.addAttribute("ticket", theTicket);
		model.addAttribute("readOnly", true);
		model.addAttribute("view", true);
		return "ticket/ticket-form";
	}
}
