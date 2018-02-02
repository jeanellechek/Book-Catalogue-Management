<%-- 
    Document   : index
    Created on : Nov 27, 2015, 2:08:49 PM
    Author     : 134418R
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Management System</title>
        <script src="js/validation.js" type="text/javascript"></script>
    </head>
    <body>
        <h2>Fill in the following fields to add a book to the catalogue:</h2>
        <p style="color:red"><%=session.getAttribute("error") != null ? session.getAttribute("error") : ""%></p>

        <form name="book" method="post" action="add" onsubmit="return validateForm()">
            <table>
                <tr>
                    <td>ISBN*: </td>
                    <td><input type="number" name="isbn" required/>
                    <i>Please key in the 13 digit ISBN number without dashes</i></td>
                </tr>

                <tr>
                    <td>Title*: </td>
                    <td><input type="text" name="title" maxLength="256" required/></td>
                </tr>

                <tr>
                    <td>Author(s)*:</td>
                    <td><input type="text" name="author" maxLength="256" required/></td>
                </tr>

                <tr>
                    <td>Year Published:</td>
                    <td><input type="number" name="year" maxLength="4"/></td>
                </tr>

                <tr>
                    <td>Publisher:</td>
                    <td><input type="text" name="publisher" maxLength="256"/></td>
                </tr>
                <tr>
                    <td>About:</td>
                    <td><textarea name="about" style="width:500px; height:100px;"></textarea></td>
                </tr>

                <tr>
                    <td><i>*Required</i></td>
                </tr>

                <tr>
                    <td><input type="submit" value="add"/></td>
                </tr>

            </table>
        </form>
    </body>
</html>
