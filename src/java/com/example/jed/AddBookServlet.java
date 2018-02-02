/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jed;

import java.io.IOException;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author 134418R
 */
@WebServlet("/add2")
public class AddBookServlet extends HttpServlet {

    //Inject the database resource into the class using a datasource object
    @Resource(name = "jdbc/jed")
    private DataSource dsBookCatalogue;
    @EJB
    private AnalysisBean analysisBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get all parameters that is required for the book
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String year = request.getParameter("year");
        String publisher = request.getParameter("publisher");
        String about = request.getParameter("about");

        String message = analysisBean.addBooks(isbn, title, author, year, publisher, about);
        
        request.getSession().setAttribute("message", message);

        //redirect to a result page
        response.sendRedirect(this.getServletContext().getContextPath() + "/results.jsp");
    }
}
