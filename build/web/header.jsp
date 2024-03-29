<%@page import="java.util.ArrayList"%>
<%@page import="Model.Carrito"%>
<%@page import="Model.Producto"%>
<%@page import="Model.GestorBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" pageEncoding="EUC-KR">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <meta name="google-signin-client_id" content="1003778353887-d1ooo7vu2vgv43700n9pcqlgrk4d6b6k.apps.googleusercontent.com">
    <link rel="shortcut icon" href="<%= request.getContextPath()%>/img/gorro.ico" />
    <title>MercaTec</title>
    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="<%= request.getContextPath()%>/css/bootstrap.min.css"/>

    <!-- Slick -->
    <link type="text/css" rel="stylesheet" href="<%= request.getContextPath()%>/css/slick.css"/>
    <link type="text/css" rel="stylesheet" href="<%= request.getContextPath()%>/css/slick-theme.css"/>

    <!-- nouislider -->
    <link type="text/css" rel="stylesheet" href="<%= request.getContextPath()%>/css/nouislider.min.css"/>

    <!-- Font Awesome Icon -->
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/font-awesome.min.css">

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" 
          href="<%= request.getContextPath()%>/css/style.css"/>
    <link type="text/css" rel="stylesheet" 
          href="<%= request.getContextPath()%>/css/car.css"/>

</head>
<header>
    <%!
        double total,supertotal;
        GestorBD queryCarrito = new GestorBD();
        Carrito carrito;
    %> 
    <!-- MAIN HEADER -->
    <div id="header">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <!-- LOGO -->
                <div class="col-md-3">
                    <div class="header-logo">
                        <a href="<%= request.getContextPath()%>/index.jsp" class="logo">
                            <img src="<%= request.getContextPath()%>/img/logo.png" alt="">
                        </a>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH BAR -->
                <div class="col-md-6">
                    <div class="header-search">
                        <form action="Search" method="post">
                            <%
                                String searchValue = "";
                                int idProductRequest = 0;
                                if (request.getAttribute("searchValue") != null) {
                                    searchValue = request
                                            .getAttribute("searchValue")
                                            .toString();
                                } else if (request.getAttribute("idProductRequest") != null) {
                                    idProductRequest = (int) request.getAttribute("idProductRequest");
                                }
                            %>
                            <input class="input" placeholder="¡Encuentra lo que buscas!"
                                   name="searchValue" value="<%= searchValue%>">
                            <button type="submit" class="search-btn">Buscar</button>
                        </form>
                    </div>
                </div>
                <!-- /SEARCH BAR -->

                <!-- ACCOUNT -->
                <div class="col-md-3 clearfix">
                    <div class="header-ctn">
                        <div class="dropdown">
                            <%
                                if ((int) session.getAttribute("id") == -1) {
                            %>
                            <form action="login.jsp">
                                <input type="submit" value="Iniciar sesión"/>
                            </form>
                    <div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>
                    <img id="myImg"><br>
                    <p id="name"></p>
                    <div id="status">
                 </div>
                 <script type="text/javascript">
                    function onSignIn(googleUser) {
                    // window.location.href='success.jsp';
                    var profile = googleUser.getBasicProfile();
                    var imagurl=profile.getImageUrl();
                    var name=profile.getName();
                    var email=profile.getEmail();
                    //document.getElementById("myImg").src = imagurl;
                    document.getElementById("name").innerHTML = name;
                    document.getElementById("myP").style.visibility = "hidden";
                    //myFunction();
                    document.getElementById("status").innerHTML = '<a href=userGmail.jsp?email='+email+'&name='+name+'/> Registrarte</a></p>';
                 //myFunction();
            }
                 </script>
                   <!--<button onclick="signOut();">Sign out</button>-->
           <script>
             function signOut() {
               var auth2 = gapi.auth2.getAuthInstance();
               auth2.signOut().then(function () {
                 console.log('User signed out.');
               });
             }
           </script>
                            <%
                                } else {%>
                            <form action="myAccount.jsp">
                                <input type="submit" value="Mi cuenta"/>
                            </form>
                            <form action="Logout">
                                <input type="submit" value="Cerrar sesión"/>
                            </form>
                            <% }
                            %>
                        </div>
                    </div>
                    <div class="header-ctn">
                        <!-- Cart -->
                        <div class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                <i class="fa fa-shopping-cart"></i>
                                <span>Carrito</span>
                                <!-- Icono que representa el numero de articulos en el carrito -->
                                <%
                                    if ((int) session.getAttribute("id") != -1) {
                                        carrito = queryCarrito.selectCarrito(
                                                Integer.parseInt(
                                                        session.getAttribute("id").toString()
                                                ));
                                %>

                                <div class="qty"><%= carrito.getProductos().size()%></div>

                                <%   }
                                %>
                            </a>
                            <div class="cart-dropdown">
                                <div class="cart-list">
                                    <%
                                        total = 0;
                                        if (carrito != null) {
                                            for (Producto productoH : carrito.getProductos()) {
                                                total = total + productoH.getPrecio();
                                    %>
                                    <!-- Productos en carrito -->
                                    <div class="product-widget">
                                        <div class="product-img">
                                            <img src="<%= productoH.getImage()%>">
                                        </div>
                                        <div class="product-body">
                                            <h3 class="product-name"><a href="#"><%= productoH.getNombreProd()%></a></h3>
                                            <h4 class="product-price"><span class="qty">1x</span>$<%= productoH.getPrecio()%></h4>
                                        </div>
                                        <form action="carrito" method="post">
                                            <input type="hidden" name="requestURL" 
                                                   value="<%= request.getRequestURI()%>" />
                                            <input type="hidden" name="idDelete" 
                                                   value="<%= productoH.getIdPc()%>"/>
                                            <input type="hidden"
                                                   name="searchValue" value="<%= searchValue%>"/>
                                            <input type="hidden"
                                                   name="idProductRequest" 
                                                   value="<%= idProductRequest%>"/>
                                            <input type="submit" class="delete" value="x"/>
                                        </form>
                                    </div>      
                                    <%  }
                                    %>
                                    <!-- Contador de productos en carro -->
                                    <!--  -->
                                </div>
                                <small><%= carrito.getProductos().size()%> producto(s)</small>
                                <% carrito.getProductos().clear();
                                        }%>
                                <h5 id="total">SUBTOTAL: $<%= total%></h5>
                                <div class="cart-btns">
                                    <form action="carrito">
                                        <button value="show" name="show">
                                            Ver carrito
                                        </button>
                                    </form>
                                    <!--<form action="carrito">
                                        <button value="buy" name="buy">
                                            Comprar
                                        </button>
                                    </form>-->
                                    <!--DOLAR 19.92-->
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
                                        <button type="submit">Comprar</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!-- /Cart -->
                    </div>
                </div>
                <!-- /ACCOUNT -->
            </div>
            <!-- row -->
        </div>
        <!-- container -->
    </div>
    <!-- /MAIN HEADER -->
</header>
