<%@page import="java.util.Base64"%>
<%@page import="Model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo publicación</title>
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath() %>/css/myAccount.css" />
    </head>
    <body>
        <% 
        if(session.getAttribute("id") == null 
                || (int)session.getAttribute("id") == -1
                || request.getAttribute("producto")==null){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else{
        %>
        <jsp:include page="header.jsp" />
        <%
            Producto producto = (Producto) request.getAttribute("producto");
        %>
        <form action="MyAccount" method="post" id="newPublication" 
              enctype="multipart/form-data">
            <h3>Por favor ingresa todos los datos solicitados</h3>
            <input type="hidden" name="id" value="<%= producto.getIdProducto() %>"/>
            <h5>
                Nombre del producto: 
                <input type="text" required="true" name="nombre" 
                       value="<%= producto.getNombreProd() %>"/>
            </h5>
            <h5>
                Introduce una descripción: 
                <input type="text" name="descripcion" 
                       value="<%= producto.getDecripción() %>"/>
            </h5>
            <h5>
                Indica su precio: $
                <input type="number" required="true" min="0" name="precio" 
                       value="<%= producto.getPrecio() %>"/>
            </h5>
            <h5>
                Numero de unidades disponibles: 
                <input type="number" required="true" min="0" name="unidades" 
                       value="<%= producto.getUnidades() %>"/>
            </h5>
            <h5 style="display:flex;">
                Selecciona una imagen:
                <input type="file" id="image" onChange="loadImage()" 
                       style="margin-left: 5%" name="imagen"
                       >
                <input type="hidden" name="imageActualValue" 
                       value="<%= producto.getImage() %>"/>
                <div id="imageContainer">
                    <output id="list">
                        <img src="<%= producto.getImage() %>"/>
                    </output>
                </div>
            </h5>
            <button name="edit" value="1">Modificar</button>
        </form>
        
        
        <jsp:include page="footer.jsp" />
        
        <script>
            function loadImage() {
                var archivo = document.getElementById("image");
                var imagen = archivo.files[0];
                var reader = new FileReader();
                //se solicita leer el objeto file como URL
                reader.readAsDataURL(imagen);
                reader.onloadend = function(){
                        document.getElementById("list").innerHTML = "<img class=\"photo\" src=\""+reader.result+"\" title=\""+imagen.name+"\"/>";
                }
            }	
        </script>
        <jsp:include page="scripts.jsp"/>
        <% } %>
    </body>
</html>
