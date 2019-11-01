<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.GestorBD"%>
<%@page import="Model.Producto"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publicaciones</title>
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath() %>/css/myAccount.css" />
         <link rel="icon" type="image/png" href="<%= request.getContextPath()%>/img/logo.png" />
    </head>
    <body>
        <% 
        if(session.getAttribute("id") == null 
                || (int)session.getAttribute("id") == -1){
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
                    System.out.println("Administrador entró aquí");
            %>
            <a href="<%= request.getContextPath() %>/reports.jsp "> Reportes</a>
            <a href="<%= request.getContextPath() %>/users.jsp "> Usuarios</a>
            <% } %>
        </header>
        <%!
            GestorBD query = new GestorBD();
            ArrayList<Producto> productos;
            int iduser = -1;
        %>
        <%
            iduser = Integer.parseInt(session.getAttribute("id").toString());

             productos = query.selectProducts(iduser);
        %>
        <%
            if (productos.size() < 1) {%>
        <h2 style="margin-left: 20%; margin-top: 8%;">No haz realizado alguna publicación</h2>
        <%} else { %>
        <h2 style="margin-left: 20%; margin-top: 8%;">Tus publicaciones</h2>
        <%} %>
        <table id="productsList">
            <%    for (Producto producto : productos) {
            %>
            <tr>
                <td>
                    <img src="<%= producto.getImage()%>" />
                </td>
                <td>
                    <form action="ShowPublication" method="post">
                        <input type="hidden" name="idProducto" 
                               value="<%= producto.getIdProducto()%>"/>
                        <input type="submit" 
                               value="<%= producto.getNombreProd()%>"/>
                    </form>
                </td>
                <td>
                    <h4>Precio: $<%= producto.getPrecio()%></h4>
                </td>
                <td>
                    <form action="MyAccount" method="post">
                        <input type="hidden" name="idDelete" 
                               value="<%= producto.getIdProducto() %>"/>
                        <input class="deleteInput" type="image" 
                               src="<%= request.getContextPath()%>/img/deleteIcon.png"
                               alt="Eliminar"/>
                    </form>
                </td>
                <td>
                    <form action="MyAccount" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="idEdit" 
                               value="<%= producto.getIdProducto() %>"/>
                        <input type="hidden" name="nombre"
                               value="<%= producto.getNombreProd() %>" />
                        <input type="hidden" name="descripcion"
                               value="<%= producto.getDecripción() %>"/>
                        <input type="hidden" name="precio"
                               value="<%= producto.getPrecio() %>"/>
                        <input type="hidden" name="unidades"
                               value="<%= producto.getUnidades() %>"/>
                        <input type="hidden" name="imagen"
                               value="<%= producto.getImage() %>"/>
                        <input class="deleteInput" type="image" 
                               src="<%= request.getContextPath()%>/img/editIcon.png"
                               alt="Modificar"/>
                    </form>
                </td>
            </tr>
            <%    }
            %>
        </table>
        <div id="actions">      
            <div>
                <%
                    if (productos.size() < 1) {%>
                <form action="publication.jsp" method="post">
                    <input type="submit" value="Realizar publicación" />
                </form>
                <%}
                    productos.clear();
                %>
            </div>
        </div>
        <jsp:include page="footer.jsp" />
        
        <jsp:include page="scripts.jsp" />
    </body>
</html>
