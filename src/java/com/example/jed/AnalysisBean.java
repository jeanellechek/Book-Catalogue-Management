package com.example.jed;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jeanelle Chek
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
public class AnalysisBean {

    public String setZeroIfNull(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        } else {
            return str;
        }
    }

    public String addBooks(String isbn, String title, String author, String year, String publisher, String about) {

        //prepare to make the JDBC connection
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DataSource dsBookCatalogue = null;

        try {
            connection = dsBookCatalogue.getConnection();

            String sqlInsert = "INSERT INTO book " + "(isbn,title,author,year,publisher,about) " + "VALUES " + "(?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, isbn);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, author);
            preparedStatement.setInt(4, Integer.parseInt(year));
            preparedStatement.setString(5, publisher);
            preparedStatement.setString(6, about);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        if (preparedStatement != null) {
            String message = "Successful";
            return message;
        } else {
            String message = "failed";
            return message;

        }
    }
}
