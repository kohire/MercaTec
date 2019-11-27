<%-- 
    Document   : userGmail
    Created on : 26/11/2019, 08:57:49 PM
    Author     : Sandra Luz Godinez G
--%>

<%@page import="Model.GestorBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Usuarios </title>
        <meta name="viewport" content="width=device=width, initial-scale=1">
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath() %>/css/myAccount.css" />
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath() %>/css/car.css" />
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath()%>/css/bootstrap.min.css"/>
    </head>
    <body>

        <jsp:include page="header.jsp" />

        <% 
            GestorBD  gestor = new GestorBD();
            int id  = gestor.getIDfromUser();
            System.out.println(id);
        %>
         <%
            String name=(String)request.getParameter("name");
            String email=(String)request.getParameter("email");
         %>
        <div class="container">
            <form action="newUser" method="POST">
                <br><br>
            <h3> Ingresa un nuevo usuario</h3>
            <h5> ID: </h5>
             <input type="text" name="id" class="form-control" value="<%= id %>" readonly="true" /> <br>
            <h5> Nombre: </h5>
            <input type="text" name="nombre" class="form-control" value="<%=name%>" required /> <br>
            
            <h5> Usuario/Nickname: </h5>
            <input type="text" name="usuario" class="form-control" value="<%=name %>" required /> <br>
            <h5> Contraseña: </h5>
            <input type="text" name="pass"  class="form-control"required /> <br>
            <h5> Tipo: </h5>
            <input type="radio" name="tipo" value="Alumno" required /> Alumno
            <input type="radio" name="tipo" value="Administrador" required /> Administrador
            <h5> Correo: </h5>
            <input type="email" name="correo"  class="form-control" value="<%=email %>" required /> <br>
            <br>
            <input type="submit" class="btn btn-success" value="Ingresar usuario">
        </form>
            <br>

        </div>
        <jsp:include page="footer.jsp"/>
    </body>
    <%
        if (request.getAttribute("nameError") != null) {
            out.print("<script>alert(\"" + request.getAttribute("nameError").toString() + "\")</script>");
        }
    %>
</html>