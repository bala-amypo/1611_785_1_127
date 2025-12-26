package com.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleEchoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setStatus(HttpServletResponse.SC_OK);
        
        String name = req.getParameter("name");
        if (name != null && !name.trim().isEmpty()) {
            name = name.trim();
        } else {
            name = "Guest";
        }
        
        try (PrintWriter out = resp.getWriter()) {
            out.print("Hello, " + name);
        }
    }
}
