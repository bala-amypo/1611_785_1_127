package com.example.demo.servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;

public class SimpleEchoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setStatus(200);
        resp.setContentType("text/plain");

        String name = req.getParameter("name");
        if (name == null || name.trim().isEmpty()) {
            resp.getWriter().write("Hello, Guest");
        } else {
            resp.getWriter().write("Hello, " + name.trim());
        }
    }
}
