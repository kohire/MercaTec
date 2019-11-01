<%-- 
    Document   : reports
    Created on : 15/05/2019, 04:13:56 PM
    Author     : Aideé Alvarez
--%>

<%@page import="Model.GestorBD"%>
<%@page import="Model.Reportes"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device=width, initial-scale=1">
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath()%>/css/myAccount.css" />
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath()%>/css/buttons.css" />
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath()%>/css/bootstrap.min.css"/>
        <title> Reportes</title>
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
        <br>


        <div class="container">
            <h3> Reportes publicados: </h3>

            <%
                Collection<Reportes> reports = new ArrayList<>();
                GestorBD gestor = new GestorBD();
                Collection<Reportes> rep = null;
            %>

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
                reports = gestor.getReports(aux);
                if (aux != null) {
                    rep = reports;
                } else {
                    rep = reports;
                }
            %>

            <p> Número de reportes registrados: <b> <%= rep.size()%> </b></p>
            <div class="table-responsive">
                <table  cellpadding="5" class="table table-striped table-hover">
                    <tr>
                        <td> ID </td>
                        <td> ID Usuario</td>
                        <td> ID Producto</td>
                        <td> Motivo</td>
                        <td colspan="2"> Acciones</td>
                    </tr>
                    <%
                        if (rep.size() == 0) {
                    %>
                    <tr>
                        <td colspan="7" align="center"> Por el momento no hay reportes registrados.</td>
                    </tr>
                    <%
                    } else {
                        for (Reportes r : rep) {
                    %>
                    <tr>
                        <td><%=r.getIdReporte()%></td>
                        <td><%=r.getIdUsuario()%></td>
                        <td><%=r.getIdProducto()%></td>
                        <td><%=r.getMotivo()%></td>
                        <td><a href="showRep?idR=<%= r.getIdReporte()%>&idU=<%= r.getIdUsuario()%>"> Ver Reporte</a></td>
                        <td><a href="deleteReport?id=<%= r.getIdReporte()%>"> Eliminar Reporte</a></td>
                    </tr>
                    <%}
                        }%>
                </table>
            </div>
            <% rep.clear();%>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
