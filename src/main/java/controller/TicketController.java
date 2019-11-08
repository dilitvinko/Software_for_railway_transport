package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dto.FreeTicketDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.TicketServiceImpl;


@WebServlet("/Ticket")
public class TicketController extends HttpServlet {

  private Gson gson = new GsonBuilder()
      .setDateFormat("yyyy-MM-dd").create();


  private TicketServiceImpl ticketService = new TicketServiceImpl();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    super.doGet(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    BufferedReader reader = request.getReader();
    PrintWriter writer = response.getWriter();

    FreeTicketDTO freeTicketDTO = gson.fromJson(reader, FreeTicketDTO.class);

    Set<Integer> seats = ticketService
        .freeSeatsInCarriage(freeTicketDTO.getIdCarriage(), freeTicketDTO.getIdTrain(),
            freeTicketDTO.getIdOutCity(), freeTicketDTO.getIdOutCity(), freeTicketDTO.getDate());
    String json = gson.toJson(seats, new TypeToken<Set<Integer>>() {
    }.getType());
    writer.println(json);
  }

  @Override
  protected void doPut(HttpServletRequest request, HttpServletResponse response) {

    //BUY ticket
  }

  @Override
  protected void doDelete(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    super.doGet(request, response);
  }
}
