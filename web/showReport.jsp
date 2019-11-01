<%-- 
    Document   : showReport
    Created on : 24/05/2019, 12:12:25 PM
    Author     : Aideé Alvarez
--%>

<%@page import="Model.Reportes"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title> Ver Reporte</title>

        <link rel="stylesheet" href="css/estilos.css">
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath()%>/css/myAccount.css" />
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath()%>/css/bootstrap.min.css"/>
         <script>
            function atras() {
                history.back();
            };
        </script>
    </head>
    <body>
        <%
        if(session.getAttribute("id") == null 
                || (int)session.getAttribute("id") == -1
                || request.getAttribute("reportUnique")==null){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else{
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
        <%
            Collection<Reportes> show = null;
            show = (Collection<Reportes>) request.getAttribute("reportUnique");
            String user = (String) request.getAttribute("idUsuario");
            for (Reportes rep : show) {
        %>
        <div class="container"> 
            <br>
            <h2> Información del Reporte:</h2>
            <br>
            <div class="row">
                <div class="col-md-4">
                    ID Reporte: <input type="text" class="form-control" 
                                       value="<%=rep.getIdReporte()%>"
                                       readonly="true"/>
                </div>
                <div class="col-md-4">
                    ID Usuario:  <input type="text" class="form-control"
                                        value="<%=rep.getIdUsuario()%>" 
                                        readonly="true"/>
                </div>
                <div class="col-md-4">
                    ID Producto:  <input type="text" class="form-control" 
                                         value="<%=rep.getIdProducto()%>" 
                                         readonly="true"/>
                </div>
                <div class="col-md-6">
                    Motivo:  <input type="text" class="form-control"
                                    value="<%=rep.getMotivo()%>" 
                                    readonly="true"/>
                </div>
                <div class="col-md-6">
                    Usuario que reporta:  <input type="text" class="form-control"
                                                 value="<%= user%>" 
                                                 readonly="true"/>
                </div>
                 <div class="col-lg-12">
                        Descripción:
                        <textarea class="form-control" rows="4" style="resize:none;" 
                                  readonly="true"><%=rep.getDescripcion()%></textarea>
                    </div>
                </div>
                <br>
              <td><a href="ShowPublication?idProducto=<%= rep.getIdProducto()%>" class="btn btn-danger"> Ver Producto</a></td>
              <br><br>
                <% }%>
                <input type="submit" class="btn btn-primary" value="Regresar" onclick="atras();"/>
            </div>
            <jsp:include page="footer.jsp" />
            <% } %>
    </body>
</html>

