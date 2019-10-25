package service;

import entity.ticket.Ticket;

public interface Ticketable {
    Ticket buyTicket(Ticket ticket);
    boolean backTicket(Ticket ticket);
    Ticket replaceTicket(Ticket ticket);
}
