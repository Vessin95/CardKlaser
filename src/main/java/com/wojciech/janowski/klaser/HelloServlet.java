package com.wojciech.janowski.klaser;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    private String message;
    private ServletOutputStream out;

    public void init() throws ServletException {
        message = "4Head!!!!";
    }

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        out = resp.getOutputStream();
        
        out.println("<h3>" + message + "</h3>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.println("Hello z posta xDDDD");
    }

    public void destroy() {
        super.destroy();
        System.out.println("Moj destroy");
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
