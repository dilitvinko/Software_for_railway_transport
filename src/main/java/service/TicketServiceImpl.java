package service;

import dao.TicketDAOImpl;
import entity.ticket.Ticket;
import service.interfaces.TicketService;

import java.sql.Date;
import java.util.List;

public class TicketServiceImpl extends AbstractService implements TicketService {

    public TicketServiceImpl() {
        abstractDAODB = new TicketDAOImpl();
    }



    //TODO Костыльный метод будет переписан нормально через JPA
    //МОЖЕТ ВОЗРАЩАТЬ seats ?? только
    public List<Ticket> freeSeatsInCarriage(long idTrain, long idCarriage, Date date, long idOutCity, long idInCity){
        TicketDAOImpl ticketDAO = new TicketDAOImpl();
        List<Ticket> reservedTickets = ticketDAO.findByTrainCarriageDate(idTrain, idCarriage, date);

        return null;
    }
}
