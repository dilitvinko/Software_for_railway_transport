package service;

import dao.AbstractDAODB;
import dao.TicketDAOImpl;
import entity.ticket.Ticket;
import service.interfaces.TicketService;

public class TicketServiceImpl extends AbstractService implements TicketService {

    public TicketServiceImpl() {
        abstractDAODB = new TicketDAOImpl();
    }
}
