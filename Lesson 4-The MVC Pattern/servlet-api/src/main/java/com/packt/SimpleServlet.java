package net.javatutorial.tutorials;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest reqest, HttpServletResponse response) 
            throws ServletException, IOException {
        response.getWriter().println("<html><head></head><body>Greetings!</body>");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " initialized");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " destroyed");
    }

}