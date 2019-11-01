<%-- 
    Document   : showPublication
    Created on : 13/05/2019, 07:43:25 PM
    Author     : Isaac Perez
--%>

<%@page import="Model.Carrito"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Comentario"%>
<%@page import="Model.GestorBD"%>
<%@page import="Model.Usuario"%>
<%@page import="Model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath()%>/css/showPublication.css">

    </head>
    <body>
        <jsp:include page="header.jsp" />
        <%!
            Producto producto;
            Usuario usuario;
            Carrito carritoValidate;
            GestorBD query = new GestorBD();
            ArrayList<Comentario> comentarios;
            boolean wasBoughtByCustomer = false;
        %>
        <% producto = (Producto) request.getAttribute("producto");
            usuario = query.showUsuarioProduct(producto.getIdUsuario());
            int id = (int) session.getAttribute("id");
        %>
        <%!
            int min = 0;
            int valueU = 0;
        %>
        <%
            if (producto.getUnidades() > 0) {
                valueU = 1;
                min = 1;
            } else {
                valueU = 0;
                min = 0;
            }
        %>
        <div id="ficha">
            <img src="<%= producto.getImage()%>" />
            <div align="center">
                <%
                    String admin = session.getAttribute("type").toString();
                    if (admin.equals("Administrador")) {

                %>
                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                <td><a href="deletePR?idProd=<%= producto.getIdProducto()%>" class="btn btn-default"> Eliminar</a></td>

                <% }%>
                <br>
                <h2><%= producto.getNombreProd()%></h2>
                <p>10 opiniones</p>

                <h3>Precio: $<%= producto.getPrecio()%></h3>
                <br />
                <h4>Descripción:</h4>
                <h5><%= producto.getDecripción()%></h5>

                <footer align="left">
                    <p>Nombre del vendedor: <%= usuario.getNombre()%></p>
                    <p>Correo electrónico del vendedor: <%= usuario.getCorreo()%></p>
                </footer>
                <div>
                    <% if ((int) session.getAttribute("id") == producto.getIdUsuario()) {%>
                    <form action="MyAccount" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="idEdit" 
                               value="<%= producto.getIdProducto()%>"/>
                        <input type="hidden" name="nombre"
                               value="<%= producto.getNombreProd()%>" />
                        <input type="hidden" name="descripcion"
                               value="<%= producto.getDecripción()%>"/>
                        <input type="hidden" name="precio"
                               value="<%= producto.getPrecio()%>"/>
                        <input type="hidden" name="unidades"
                               value="<%= producto.getUnidades()%>"/>
                        <input type="hidden" name="imagen"
                               value="<%= producto.getImage()%>"/>
                        <input class="deleteInput" type="submit" 
                               value="Modificar"
                               alt="Modificar"/>
                    </form>
                    <% } else {
                        if((int)session.getAttribute("id")!=-1){
                            carritoValidate = query.selectCarrito(
                                    Integer.parseInt(
                                            session.getAttribute("id").toString()
                                    ));
                            int contadorUnidades = 0;
                            for(int i=0;i<carritoValidate.getProductos().size();i++){
                                if(carritoValidate.getProductos().get(i).getIdProducto() == producto.getIdProducto()){
                                    contadorUnidades+=1;
                                }
                            }
                     if(contadorUnidades<producto.getUnidades()){
                    %>
                    <form action="ShowPublication" method="post">
                    Cantidad: 
                    <input type="number" value="<%= valueU%>" 
                           min="<%= min%>"
                           max="<%= producto.getUnidades()-contadorUnidades %>"
                           name="numberOfItem">
                    Unidades disponibles: <%= producto.getUnidades()%>
                    <br /><br /><br />
                        <input type="hidden" name="addCar" value="<%= producto.getIdProducto()%>"/>
                        <input type="submit" value="Agregar al carrito">
                    </form>
                    <% 
                      }
                    %>
                    <form action="#" method="post">
                        <input type="submit" value="Comprar">
                    </form>       
                     <%
                        }else{
                     %>
                        <form action="ShowPublication" method="post">
                        Cantidad: 
                        <input type="number" value="<%= valueU%>" 
                               min="<%= min%>"
                               max="<%= producto.getUnidades()%>"
                               name="numberOfItem">
                        Unidades disponibles: <%= producto.getUnidades()%>
                        <br /><br /><br />
                        <input type="hidden" name="addCar" value="<%= producto.getIdProducto()%>"/>
                        <input type="submit" value="Agregar al carrito">
                        </form>
                        <form action="#" method="post">
                            <input type="submit" value="Comprar">
                        </form>
                    <%
                        }
                        }
                    %>
                </div>
            </div>
        </div> 
        <br><br>
        <div align="center" id="reportes">
            <section>
                <h3> ¿Deseas reportar el producto? </h3>
                <div>
                    <input type="button"  value="Reportar" data-toggle="modal" data-target="#myModal" />
                </div>
            </section>
        </div>

        <div class="modal fade" tabindex="-1" role="dialog" id="myModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title"> Reportar Producto</h4>
                    </div>
                    <div class="modal-body">
                        <form action="sendReport" id="formReport" method="POST">
                            <span>ID Producto:</span><input type="text" class="form-control" name="idProd"
                                                            value="<%= producto.getIdProducto()%>" readonly/>
                            <span>ID Usuario:</span><input type="text" class="form-control" name="idUs"
                                                           value="<%= id%>" readonly/>
                            <span>Motivo:</span> <input type="text" class="form-control" name="motivo"
                                                        required />
                            <span>Descripción:</span> <textarea id="textarea" name="descripcion"
                                                                class="form-control" ></textarea>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <% 
                                if(id == -1) {
                        %>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <% }else{ %>
                        <button type="submit" form="formReport" class="btn btn-primary"> Enviar</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <% } %>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <section id="comentarios">
            <h4>Comentarios:</h4>
            <% comentarios = query.getComentarios(producto.getIdProducto()); %>
            <!-- Comentario apertura -->
            <% for (Comentario comentario : comentarios) {%>
            <div>
                <header>
                    <h5><%= comentario.getNombreUsuario()%></h5>
                </header>
                <div>
                    <%= comentario.getComentario()%>
                </div>
            </div>
            <% }
                comentarios.clear(); %>
            <!-- Comentario cierre -->
            <%
                wasBoughtByCustomer = query.wasBoughtByCustomer((int) session.getAttribute("id"),
                        producto.getIdProducto());
                /*if(wasBoughtByCustomer){ */%>
            <form action="ShowPublication" method="post">
                <h4>Publicar comentario:</h4>
                <textarea id="makeCommentContent" name="comentario" 
                          rows="10" cols="40" required="true"></textarea>
                <br/>
                <input type="hidden" name="idProducto" value="<%= producto.getIdProducto()%>"/>
                <input type="hidden" name="idUsuario" value="<%= (int) session.getAttribute("id")%>"/>
                <input type="submit" value="Comentar" />
            </form>
            <%// } %>

        </section>
        <jsp:include page="footer.jsp" />
        <jsp:include page="scripts.jsp" />
    </body>
</html>
