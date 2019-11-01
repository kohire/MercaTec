<%@page import="Model.Carrito"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Producto"%>
<%@page import="Model.GestorBD" %> 
<!DOCTYPE html>
<!-- Contenido de index (articulos) -->
<%! 
            GestorBD queries = new GestorBD();
            ArrayList<Producto> productos;
            int newsProducts = 0;
            Carrito carritoValidate;
%>
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <!-- section title -->
            <div class="col-md-12">
                <div class="section-title">
                    <h3 class="title">Publicaciones recientes</h3>
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
                                    
                                    productos =  queries.selectProducts(-1);
                                    newsProducts = 0;
                                    if(productos.size()>=10){
                                        newsProducts = (productos.size()-10);
                                    }
                                    for(int i = newsProducts; i<productos.size();i++){
                                %>
                                <div class="product">
                                    <div class="product-img">
                                        <img src="<%= productos.get(i).getImage()%>">
                                    </div>
                                    <div class="product-body">
                                        <h3 class="product-name">
                                            <form action="ShowPublication" method="post">
                                                <input type="hidden" name="idProducto" 
                                                       value="<%= productos.get(i).getIdProducto() %>"/>
                                                <input type="submit" 
                                                       value="<%= productos.get(i).getNombreProd() %>"/>
                                            </form>
                                        </h3>
                                        <h4 class="product-price">
                                            $<%= productos.get(i).getPrecio() %>
                                        </h4>
                                        <form action="ShowPublication" method="post" class="product-btns">
                                            <input type="hidden" name="idProducto" 
                                                   value="<%= productos.get(i).getIdProducto() %>"/>
                                            <button class="quick-view">
                                                <i class="fa fa-eye"></i>
                                                <span class="tooltipp">
                                                    Ver producto
                                                </span>
                                            </button>
                                        </form>
                                    </div>
                                    <div  class="add-to-cart">
                                        <% if((int)session.getAttribute("id") == productos.get(i).getIdUsuario()){ %>
                                            <form action="ShowPublication" method="post">
                                                <input type="hidden" name="idProducto" 
                                                       value="<%= productos.get(i).getIdProducto() %>"/>
                                                <input type="submit" 
                                                       value="Ver"
                                                       class="add-to-cart-btn"/>
                                            </form>
                                        <% }else{
                                            if((int)session.getAttribute("id")!=-1){
                                                carritoValidate = queries.selectCarrito(
                                                        Integer.parseInt(
                                                                session.getAttribute("id").toString()
                                                        ));
                                                int contadorUnidades = 0;
                                                for(int u=0;u<carritoValidate.getProductos().size();u++){
                                                    if(carritoValidate.getProductos().get(u).getIdProducto() == productos.get(i).getIdProducto()){
                                                        contadorUnidades+=1;
                                                    }
                                                }
                                                if(contadorUnidades<productos.get(i).getUnidades()){
                                        %>
                                        <form action="carrito" method="post">
                                            <input type="hidden" name="requestURL" 
                                                value="<%= request.getRequestURI() %>" />
                                            <input type="hidden" value="<%= productos.get(i).getIdProducto() %>" 
                                                   name="id"/>
                                            <input type="submit"  value="Añadir al carrito" 
                                                   class="add-to-cart-btn" />
                                        </form>
                                        <% }}else{
                                        %>    
                                         <form action="carrito" method="post">
                                            <input type="hidden" name="requestURL" 
                                                value="<%= request.getRequestURI() %>" />
                                            <input type="hidden" value="<%= productos.get(i).getIdProducto() %>" 
                                                   name="id"/>
                                            <input type="submit"  value="Añadir al carrito" 
                                                   class="add-to-cart-btn" />
                                        </form>       
                                        <%
                                        } }%>
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
<hr style="color:black;" />
<!-- Articulos en general -->
<div class="section">
    <!-- container -->
    <div id="productsTable">
        <!-- products -->
        <%
            for (Producto producto : productos) {
        %>
        <div id="item">
            <div class="product">
                <div class="product-img">
                    <img src="<%= producto.getImage()%>">
                </div>
                <div class="product-body">
                    <h3 class="product-name">
                        <form action="ShowPublication" method="post">
                            <input type="hidden" name="idProducto" 
                               value="<%= producto.getIdProducto() %>"/>
                            <input type="submit" 
                                   value="<%= producto.getNombreProd()%>"/>
                        </form>
                    </h3>
                    <h4 class="product-price">$<%= producto.getPrecio()%></h4>
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
                   <div class="add-to-cart">
                       <% if ((int) session.getAttribute("id") == producto.getIdUsuario()) {%>
                       <form action="ShowPublication" method="post">
                           <input type="hidden" name="idProducto" 
                                  value="<%= producto.getIdProducto()%>"/>
                           <input type="submit" 
                                  value="Ver"
                                  class="add-to-cart-btn"/>
                       </form>
                       <% } else{
                                            if((int)session.getAttribute("id")!=-1){
                                                carritoValidate = queries.selectCarrito(
                                                        Integer.parseInt(
                                                                session.getAttribute("id").toString()
                                                        ));
                                                int contadorUnidades = 0;
                                                for(int u=0;u<carritoValidate.getProductos().size();u++){
                                                    if(carritoValidate.getProductos().get(u).getIdProducto() == producto.getIdProducto()){
                                                        contadorUnidades+=1;
                                                    }
                                                }
                                                if(contadorUnidades<producto.getUnidades()){
                                        %>
                                        <form action="carrito" method="post">
                                            <input type="hidden" name="requestURL" 
                                                value="<%= request.getRequestURI() %>" />
                                            <input type="hidden" value="<%= producto.getIdProducto() %>" 
                                                   name="id"/>
                                            <input type="submit"  value="Añadir al carrito" 
                                                   class="add-to-cart-btn" />
                                        </form>
                                        <% }}else{
                                        %>    
                                         <form action="carrito" method="post">
                                            <input type="hidden" name="requestURL" 
                                                value="<%= request.getRequestURI() %>" />
                                            <input type="hidden" value="<%= producto.getIdProducto() %>" 
                                                   name="id"/>
                                            <input type="submit"  value="Añadir al carrito" 
                                                   class="add-to-cart-btn" />
                                        </form>       
                                        <%
                                        } }%>
                   </div>
            </div>
        </div>
        <%
            }
            productos.clear();
        %>
        <!-- /product -->
    </div>
</div>  