<%@page import="Model.GestorBD"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device=width, initial-scale=1">
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath()%>/css/myAccount.css" />
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath()%>/css/bootstrap.min.css"/>
        <title> Mostrar Usuarios</title>
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
            <a href="<%= request.getContextPath()%>/index.jsp ">Inicio</a>
            <a href="<%= request.getContextPath()%>/myPublication.jsp ">Mis publicaciones</a>
            <a href="<%= request.getContextPath()%>/publication.jsp ">Hacer publicación</a>
            <%
                String admin = session.getAttribute("type").toString();
                if (admin.equals("Administrador")) {
            %>
            <a href="<%= request.getContextPath()%>/reports.jsp "> Reportes</a>
            <a href="<%= request.getContextPath()%>/users.jsp "> Usuarios</a>
            <% } %>
        </header>
        <%@ page import= "Model.Usuario,java.util.Collection" %>
        
        
        <div class="container">
            <%
                Collection<Usuario> users = new ArrayList<>();
                GestorBD gestor = new GestorBD();
                Collection<Usuario> usuario = null;
                
            %> 
            <br>
            <h2> Los usuarios registrados son: </h2>
            <table>
                <div class="row">
                    <form>
                        <div class="col-md-4"> 
                            <input type="text" class="form-control" name="txtBuscar" placeholder="Buscar..."/>
                        </div>
                        <div class="col-md-1" align="center"> 
                            <input type="submit" class="form-control" value="buscar"/>
                        </div>
                    </form>
                </div>
            </table>
            <br>
            <%
                String aux = request.getParameter("txtBuscar");
                users = gestor.getUsuarios(aux);
                if (aux != null) { //Aquí valida si es diferente de nulo.
                   usuario = users;
                } else {
                   usuario = users;
                }
            %>
            <p> Número de Usuarios registrados: <b> <%= usuario.size()%> </b></p>
            <div class="table-responsive">
                <table cellpadding="5" class="table table-striped table-hover">
                    <tr>
                        <th> ID   </th>
                        <th> Nombre </th>
                        <th> Usuario </th>
                        <th> Contraseña </th>
                        <th> Tipo </th>
                        <th> Correo </th>
                        <th> Acciones </th>
                    </tr>
                    <%
                        if (usuario.size() == 0) {
                    %>
                    <tr>
                        <td colspan="7" align="center"> Por el momento no hay usuarios registrados.</td>
                    </tr>
                    <%
                    } else {
                        for (Usuario us : usuario) {
                    %>
                    <tr>
                        <td><%=us.getIdUsuario()%> </td>
                        <td><%=us.getNombre()%> </td>
                        <td><%=us.getUsuario()%> </td>
                        <td><%=us.getContraseña()%> </td>
                        <td><%=us.getTipo()%> </td>
                        <td><%=us.getCorreo()%> </td>
                        <td> <a href="deleteUser?id=<%= us.getIdUsuario()%>"> Eliminar </a></td>
                    </tr>
                    <% }
                        }%>
                </table>
            </div>
            <% usuario.clear();%>
            <br>
            <a href="users.jsp" class="btn btn-default"> Regresar</a>
        </div>
        <br> <br>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
