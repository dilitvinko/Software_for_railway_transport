package dao;

import dao.interfece.TicketDAO;
import entity.ticket.Ticket;
import entity.train.Carriage;

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
        CityDAOImpl cityDAO = new CityDAOImpl();
        List<Ticket> tickets = super.findAll();
        for (Ticket ticket :
                tickets) {
            ticket.setTrain(trainDAO.findById(ticket.getId_train()));
            ticket.setCarriage(CarriageDAO.findById(ticket.getId_carriage()));
            ticket.setOutCity(cityDAO.findById(ticket.getId_out_city()));
            ticket.setInCity(cityDAO.findById(ticket.getId_in_city()));
        }
        return tickets;
    }

    @Override
    public Ticket findById(long id) {
        Ticket ticket = new Ticket();
        ticket = super.findById(id);
        TrainDAOImpl trainDAO = new TrainDAOImpl();
        CarriageDAOImpl CarriageDAO = new CarriageDAOImpl();
        CityDAOImpl cityDAO = new CityDAOImpl();
        ticket.setTrain(trainDAO.findById(ticket.getId_train()));
        ticket.setCarriage(CarriageDAO.findById(ticket.getId_carriage()));
        ticket.setOutCity(cityDAO.findById(ticket.getId_out_city()));
        ticket.setInCity(cityDAO.findById(ticket.getId_in_city()));
        return ticket;
    }
}
