<%-- 
    Document   : search
    Created on : 12/05/2019, 06:17:17 PM
    Author     : Isaac Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Producto"%>
<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="header.jsp" />
        <%
            ArrayList<Producto> productos;
        %>
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <!-- section title -->
                    <div class="col-md-12">
                        <div class="section-title">
                            <% 
                            productos = (ArrayList<Producto>)request.getAttribute("productos");
                            %>
                            <% if(productos.size()>0){ %>
                            <h3 class="title">Resultados (<%= productos.size() %>):</h3>
                            <% }else{ %>
                            <h3 class="title">Sin coincidencias</h3>
                            <% } %>
                        </div>
                    </div>
                    <!-- /section title -->
                    <!-- Products tab & slick -->
                    <div class="col-md-12">
                        <div class="row">
                            <div class="products-tabs">
                                <!-- tab -->
                                <div id="tab1" class="tab-pane active">
                                    <div class="products-slick" data-nav="#slick-nav-1">
                                        <!-- product -->
                                        <%
                                            for (Producto producto : productos) {
                                        %>
                                        <div class="product">
                                            <div class="product-img">
                                                <img src="<%= producto.getImage()%>">
                                            </div>
                                            <div class="product-body">
                                                <h3 class="product-name">
                                                    <form action="ShowPublication" method="post">
                                                        <input type="hidden" name="idProducto" 
                                                               value="<%= producto.getIdProducto()%>"/>
                                                        <input type="submit" 
                                                               value="<%= producto.getNombreProd()%>"/>
                                                    </form>
                                                </h3>
                                                <h4 class="product-price">
                                                    $<%= producto.getPrecio()%>
                                                </h4>
                                                <form action="ShowPublication" method="post" class="product-btns">
                                                    <input type="hidden" name="idProducto" 
                                                           value="<%= producto.getIdProducto()%>"/>
                                                    <button class="quick-view">
                                                        <i class="fa fa-eye"></i>
                                                        <span class="tooltipp">
                                                            Ver producto
                                                        </span>
                                                    </button>
                                                </form>
                                            </div>
                                            <div  class="add-to-cart">
                                                <% if ((int) session.getAttribute("id") == producto.getIdUsuario()) {%>
                                                <form action="ShowPublication" method="post">
                                                    <input type="hidden" name="idProducto" 
                                                           value="<%= producto.getIdProducto()%>"/>
                                                    <input type="submit" 
                                                           value="Ver"
                                                           class="add-to-cart-btn"/>
                                                </form>
                                                <% } else {%>
                                                <form action="Search" method="post">
                                                    <%
                                                    String searchValue = "";
                                                    if(request.getAttribute("searchValue")!=null){
                                                        searchValue = request
                                                                .getAttribute("searchValue")
                                                                .toString();
                                                    }
                                                    %>
                                                    <input type="hidden"
                                                           name="searchValue" value="<%= searchValue %>">
                                                    <input type="hidden" name="requestURL" 
                                                           value="index.jsp" />
                                                    <input type="hidden" value="<%= producto.getIdProducto()%>" 
                                                           name="id"/>
                                                    <input type="submit"  value="Añadir al carrito" 
                                                           class="add-to-cart-btn" />
                                                </form>
                                                <% } %>
                                            </div>
                                        </div>
                                        <%
                                            }
                                        %>
                                        <!-- /product -->
                                    </div>
                                    <div id="slick-nav-1" class="products-slick-nav"></div>
                                </div>
                                <!-- /tab -->
                            </div>
                        </div>
                    </div>
                    <!-- Products tab & slick -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->

        <jsp:include page="footer.jsp"/>
        
        <jsp:include page="scripts.jsp"/>
    </body>
</html>
