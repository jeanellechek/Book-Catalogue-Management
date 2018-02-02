/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jed;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.validator.routines.ISBNValidator;

/**
 *
 * @author 134418R
 */
@WebServlet("/add")
public class ValidationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get all the parameters that needs to be validated out
        String isbn = request.getParameter("isbn");

        //using the ISBNValidator from the commos.validator library
        ISBNValidator isbnValidator = ISBNValidator.getInstance();

        if (isbnValidator.isValidISBN13(isbn)) {
            RequestDispatcher rd = request.getRequestDispatcher("/add2");
            rd.forward(request, response);
        } else {
            //set at message of the isbn cannot be verified
            request.getSession().setAttribute("error", "The ISBN supplied is invalid");
            response.sendRedirect(this.getServletContext().getContextPath());
        }

    }
}
