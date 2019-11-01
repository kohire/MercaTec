<%-- 
    Document   : login
    Created on : 11/05/2019, 06:33:58 PM
    Author     : Aideé Alvarez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login MercaTec</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="<%= request.getContextPath()%>/img/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/util.css">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
                            <!-- MÉTODO POST PARA INGRESAR AL INDEX -->
				<form class="login100-form validate-form" action="validacionUsuario" method="POST">
					<span class="login100-form-title p-b-33">
						Account Login
					</span>

					<div class="wrap-input100 validate-input" data-validate = "El usuario es requerido">
						<input class="input100" type="text" name="user" placeholder="Usuario" required>
						<span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>

					<div class="wrap-input100 rs1 validate-input" data-validate="La contraseña es requerida">
						<input class="input100" type="password" name="password" placeholder="Contraseña" required>
						<span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>

					<div class="container-login100-form-btn m-t-20">
						<button class="login100-form-btn">
							Sign in
						</button>
					</div>

					<div class="text-center p-t-45 p-b-4">
						<span class="txt1">
							Olvidaste
						</span>

						<a href="#" class="txt2 hov1">
							Usuario / Contraseña?
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<%
        if (request.getAttribute("LogError") != null) {
            out.print("<script>alert(\"" + request.getAttribute("LogError").toString() + "\")</script>");
        }
    %>
</html>