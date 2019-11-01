<%-- 
    Document   : publication
    Created on : 12/05/2019, 08:47:51 PM
    Author     : Isaac Perez
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva publicación</title>
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath() %>/css/myAccount.css" />
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath() %>/css/publicar.css" />
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
        
        <form action="Publication" method="post" id="newPublication" 
              enctype="multipart/form-data">
            <h3>Por favor ingresa todos los datos solicitados</h3>
            <h5>
                Nombre del producto: 
                <input type="text" required="true" name="nombre"/>
            </h5>
            <h5>
                Introduce una descripción: 
                <input type="text" name="descripcion" value=""/>
            </h5>
            <h5>
                Indica su precio: $
                <input type="number" required="true" min="0" name="precio" 
                       value="0"/>
            </h5>
            <h5>
                Numero de unidades disponibles: 
                <input type="number" required="true" min="0" name="unidades" 
                       value="1"/>
            </h5>
            <h5 style="display:flex;">
                Selecciona una imagen:
                <div id="contenedorInputFile">
                <input type="file" id="image" onChange="loadImage()" 
                     required="true" name="imagen">
                    <div id="imageContainer">
                        <output id="list"></output>
                    </div>
                </div>
            </h5>
            <input id="publicar" type="submit" value="Publicar" />
            <input id="cancelar" type="button" value="Cancelar" onClick="location.href='<%= request.getContextPath() %>/index.jsp'"/>
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
    </body>
</html>
