<%-- 
    Document   : index
    Created on : 9/05/2019, 07:41:09 PM
    Author     : Isaac Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="icon" type="image/png" href="<%= request.getContextPath()%>/img/logo.png" />
    </head>
    <body>
        <% if(session.getAttribute("id")== null){
            session.setAttribute("id", -1);
            session.setAttribute("type", "normal");
        } %>
        <jsp:include page="header.jsp" />
        
        <jsp:include page="products.jsp" />
        
        <jsp:include page="footer.jsp"/>
        
        <jsp:include page="scripts.jsp"/>
    </body>
</html>
