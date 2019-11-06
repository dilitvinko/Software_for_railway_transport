package controller;

import com.google.gson.Gson;
import dao.TrainDAOImpl;
import entity.train.Train;
import service.TrainServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/testRailway")
public class TestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        TrainServiceImpl trainService = new TrainServiceImpl();

        List<Train> trains = trainService.findAll();
        String JSON  = gson.toJson(trains);


        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println("Hello");
        out.println(JSON);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPut(request, response);
    }
}
