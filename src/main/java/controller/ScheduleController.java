package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dto.DateCitiesDTO;
import dto.ScheduleDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ScheduleServiceImpl;

@WebServlet("/Schedule")
public class ScheduleController extends HttpServlet {

    private Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd").create();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        PrintWriter writer = response.getWriter();

        DateCitiesDTO dateCitiesDTO = gson.fromJson(reader, DateCitiesDTO.class);
        ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
        List<ScheduleDTO> pairs = scheduleService.findAllTrainAtDateByCities(dateCitiesDTO);
        String json = gson.toJson(pairs, new TypeToken<List<ScheduleDTO>>() {
        }.getType());
        writer.println(json);
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
