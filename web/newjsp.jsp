<%-- 
    Document   : newjsp
    Created on : 11/05/2019, 09:42:26 PM
    Author     : Aideé Alvarez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <% int id = (int) session.getAttribute("id");
           String type = (String) session.getAttribute("type");
            out.print("Hello, ID: " + id + ", Bienvenido al sistema <br>");
            out.print("Okay, this is your type: " + type);
        %>
    </body>
</html>
