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
        <% 
        if(session.getAttribute("id") == null 
                || (int)session.getAttribute("id") == -1 
                || session.getAttribute("type") == null
                || !((String)session.getAttribute("type")).equals("Administrador")){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        %>
        <jsp:include page="header.jsp" />
        <header id="menuUsuario" align="center">
            <a href="<%= request.getContextPath() %>/index.jsp ">Inicio</a>
            <a href="<%= request.getContextPath() %>/myPublication.jsp ">Mis publicaciones</a>
            <a href="<%= request.getContextPath() %>/publication.jsp ">Hacer publicación</a>
             <%
                String admin =  session.getAttribute("type").toString();
                if(admin.equals("Administrador")){
            %>
            <a href="<%= request.getContextPath() %>/reports.jsp "> Reportes</a>
            <a href="<%= request.getContextPath() %>/users.jsp "> Usuarios</a>
            <% } %>
        </header>
        <% 
            GestorBD  gestor = new GestorBD();
            int id  = gestor.getIDfromUser();
            System.out.println(id);
        %>
        <div class="container">
            <form action="newUser" method="POST">
                <br><br>
            <h3> Ingresa un nuevo usuario</h3>
            <h5> ID: </h5>
             <input type="text" name="id" class="form-control" value="<%= id %>" readonly="true" /> <br>
            <h5> Nombre: </h5>
            <input type="text" name="nombre" class="form-control" required /> <br>
            
            <h5> Usuario/Nickname: </h5>
            <input type="text" name="usuario" class="form-control" required /> <br>
            <h5> Contraseña: </h5>
            <input type="text" name="pass"  class="form-control"required /> <br>
            <h5> Tipo: </h5>
            <input type="radio" name="tipo" value="Alumno" required /> Alumno
            <input type="radio" name="tipo" value="Administrador" required /> Administrador
            <h5> Correo: </h5>
            <input type="email" name="correo"  class="form-control" required /> <br>
            <br>
            <input type="submit" class="btn btn-success" value="Ingresar usuario">
        </form>
            <br>
        <form action="<%= request.getContextPath() %>/listUsers.jsp"  method="POST">
            <input type="submit" class="btn btn-primary"value="Ver usuarios">
        </form>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
    <%
        if (request.getAttribute("nameError") != null) {
            out.print("<script>alert(\"" + request.getAttribute("nameError").toString() + "\")</script>");
        }
    %>
</html>