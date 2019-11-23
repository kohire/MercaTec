<%@page import="java.util.ArrayList"%>
<%@page import="Model.Carrito"%>
<%@page import="Model.Producto"%>
<%@page import="Model.GestorBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <% 
        if(session.getAttribute("id") == null 
                || (int)session.getAttribute("id") == -1){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        %>
        <jsp:include page="header.jsp" />
        
        <%!
            double total, supertotal;
            GestorBD queryCarrito = new GestorBD();
            Carrito carrito;
            int idUser = -1;
        %> 
        <%
            idUser = Integer.parseInt(session.getAttribute("id").toString());
            
            carrito = queryCarrito.selectCarrito(idUser);
            total = 0;
        %>
        <%
          if(carrito.getProductos().size()<1){%>
            <h2 style="margin-left: 20%; margin-top: 8%;">No hay articulos en tu carrito</h2>
        <%}else{ %>
            <h2 style="margin-left: 20%; margin-top: 8%;">Articulos</h2>
        <%} %>
        <table id="productsList">
        <%    for(Producto producto:carrito.getProductos()){
                total = total + producto.getPrecio();
        %>
            <tr>
                <td>
                    <img src="<%= producto.getImage() %>" />
                </td>
                <td>
                    <h1><%= producto.getNombreProd() %></h1>
                </td>
                <td>
                    <h4>Precio: $<%= producto.getPrecio() %></h4>
                </td>
                <td>
                    <form action="carrito" method="post">
                        <input type="hidden" name="requestURL" 
                               value="<%= request.getRequestURI() %>" />
                        <input type="hidden" name="idDeleteT" 
                               value="<%= producto.getIdPc()%>"/>
                        <input class="deleteInput" type="image" 
                               src="<%= request.getContextPath() %>/img/deleteIcon.png"
                               alt="Eliminar"/>
                    </form>
                </td>
            </tr>
        <%    }
        %>
        </table>
        <div id="actions">      
            <h3>
                Total: $<%= total%>
            </h3>
            <div>
                <form action="carrito" method="post">
                    <input type="hidden" name="stillShopping" value="yes"/>
                    <input type="submit" value="Seguir comprando" />
                </form>
                <%
                    if(carrito.getProductos().size()>0){%>
                        <% 
                                        supertotal = total / 19.9238;
                                    %>
                                    <form action="${initParam['posturl']}" method="POST">
                                        <input type="hidden" name="upload" value="1">
                                        <input type="hidden" name="return" value="${initParam['returnurl']}">
                                        <input type="hidden" name="cmd" value="_cart">
                                        <input type="hidden" name="business" value="${initParam['business']}">

                                        <input type="hidden" name="item_name_1" value="Compra en MercaTec">
                                        <input type="hidden" name="amount_1" value="<%= supertotal%>">
                                        <input type="hidden" name="quantity_1" value="1">
                                        <input type="submit" value="Finalizar Compra">
                                    </form>
                    <%}
                    carrito.getProductos().clear();
                %>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
        
        <jsp:include page="scripts.jsp"/>
    </body>
</html>
