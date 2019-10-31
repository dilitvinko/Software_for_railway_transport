package dao;

import dao.interfaces.TicketDAO;
import entity.ticket.Ticket;

import java.util.List;

public class TicketDAOImpl extends AbstractDAODB<Ticket> implements TicketDAO {
    @Override
    protected Class getClazz() {
        return Ticket.class;
    }
    //TODO same methods findById() findAll from CarriageDao

    @Override
    public List<Ticket> findAll() {
        TrainDAOImpl trainDAO = new TrainDAOImpl();
        CarriageDAOImpl CarriageDAO = new CarriageDAOImpl();
        ScheduleDAOImpl scheduleDAO = new ScheduleDAOImpl();
        List<Ticket> tickets = super.findAll();
        for (Ticket ticket :
                tickets) {
            setTicket(ticket, trainDAO, CarriageDAO, scheduleDAO);
        }
        return tickets;
    }

    @Override
    public Ticket findById(long id) {
        Ticket ticket = new Ticket();
        ticket = super.findById(id);
        TrainDAOImpl trainDAO = new TrainDAOImpl();
        CarriageDAOImpl CarriageDAO = new CarriageDAOImpl();
        ScheduleDAOImpl scheduleDAO = new ScheduleDAOImpl();
        setTicket(ticket, trainDAO, CarriageDAO, scheduleDAO);
        return ticket;
    }

    private void setTicket(Ticket ticket, TrainDAOImpl trainDAO, CarriageDAOImpl carriageDAO, ScheduleDAOImpl scheduleDAO) {
        ticket.setTrain(trainDAO.findById(ticket.getId_train()));
        ticket.setCarriage(carriageDAO.findById(ticket.getId_carriage()));
        ticket.setOutSchedule(scheduleDAO.findById(ticket.getId_outSchedule()));
        ticket.setInSchedule(scheduleDAO.findById(ticket.getId_inSchedule()));
    }
}
