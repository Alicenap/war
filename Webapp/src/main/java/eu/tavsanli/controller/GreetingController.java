package eu.tavsanli.controller;


import eu.tavsanli.ejb.GreetingBean;
import eu.tavsanli.localejbapi.UnitConverter;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class GreetingController extends HttpServlet {

    @EJB
    private GreetingBean greetingBean;

    @EJB
    UnitConverter unitConverter;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String greeting = greetingBean.getGreeting();
        request.setAttribute("greeting", greeting);
        final Double temperatureInCelsius = unitConverter.fahrenheitToCelsius(95.0);
        request.setAttribute("temperatureInCelsius", temperatureInCelsius);
        final RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }
}
