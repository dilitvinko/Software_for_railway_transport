package dao;

import entity.ticket.Ticket;

public class TicketDAO extends AbstractDAODB<Ticket> {
    @Override
    protected Class getClazz() {
        return Ticket.class;
    }
    //TODO same methods findById() findAll from CarriageDao
}
