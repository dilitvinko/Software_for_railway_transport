package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dto.DateCitiesDTO;
import dto.ScheduleDTO;
import entity.train.Carriage;
import entity.train.Train;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ScheduleServiceImpl;
import service.TrainServiceImpl;

@WebServlet("/Carriages")
public class CarriageController extends HttpServlet {

  private Gson gson = new GsonBuilder()
      .setDateFormat("yyyy-MM-dd").create();

  private TrainServiceImpl trainService = new TrainServiceImpl();

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    BufferedReader reader = request.getReader();
    PrintWriter writer = response.getWriter();

    Train train = gson.fromJson(reader, Train.class);

    train = (Train) trainService.findById(train.getId());

    Set<Carriage> carriages = train.getCarriages();

    //TODO DTOCarriage with Train, TypeCarriage, inCity, outCity
      String json = gson.toJson(carriages, new TypeToken<Set<Carriage>>() {
      }.getType());

      writer.println(json);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    super.doGet(request, response);
  }

  @Override
  protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    super.doGet(request, response);
  }

  @Override
  protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    super.doGet(request, response);
  }
}
