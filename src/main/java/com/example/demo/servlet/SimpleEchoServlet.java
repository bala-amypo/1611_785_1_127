
package com.example.demo.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SimpleEchoServlet extends HttpServlet {

    // must be public so the test can call it directly
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("text/plain");

        String name = req.getParameter("name");
        if (name == null || name.trim().isEmpty()) {
            name = "Guest";
        } else {
            name = name.trim();
        }

        resp.getWriter().write("Hello, " + name);
    }
}
