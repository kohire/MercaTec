package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Carrito;
import java.util.ArrayList;
import Model.Comentario;
import Model.GestorBD;
import Model.Usuario;
import Model.Producto;

public final class showPublication_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            Producto producto;
            Usuario usuario;
            Carrito carritoValidate;
            GestorBD query = new GestorBD();
            ArrayList<Comentario> comentarios;
            boolean wasBoughtByCustomer = false;
        

            int min = 0;
            int valueU = 0;
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" \r\n");
      out.write("              href=\"");
      out.print( request.getContextPath());
      out.write("/css/showPublication.css\">\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        ");
 producto = (Producto) request.getAttribute("producto");
            usuario = query.showUsuarioProduct(producto.getIdUsuario());
            int id = (int) session.getAttribute("id");
        
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        ");

            if (producto.getUnidades() > 0) {
                valueU = 1;
                min = 1;
            } else {
                valueU = 0;
                min = 0;
            }
        
      out.write("\r\n");
      out.write("        <div id=\"ficha\">\r\n");
      out.write("            <img src=\"");
      out.print( producto.getImage());
      out.write("\" />\r\n");
      out.write("            <div align=\"center\">\r\n");
      out.write("                ");

                    String admin = session.getAttribute("type").toString();
                    if (admin.equals("Administrador")) {

                
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                <td><a href=\"deletePR?idProd=");
      out.print( producto.getIdProducto());
      out.write("\" class=\"btn btn-default\"> Eliminar</a></td>\r\n");
      out.write("\r\n");
      out.write("                ");
 }
      out.write("\r\n");
      out.write("                <br>\r\n");
      out.write("                <h2>");
      out.print( producto.getNombreProd());
      out.write("</h2>\r\n");
      out.write("                <p>10 opiniones</p>\r\n");
      out.write("\r\n");
      out.write("                <h3>Precio: $");
      out.print( producto.getPrecio());
      out.write("</h3>\r\n");
      out.write("                <br />\r\n");
      out.write("                <h4>Descripción:</h4>\r\n");
      out.write("                <h5>");
      out.print( producto.getDecripción());
      out.write("</h5>\r\n");
      out.write("\r\n");
      out.write("                <footer align=\"left\">\r\n");
      out.write("                    <p>Nombre del vendedor: ");
      out.print( usuario.getNombre());
      out.write("</p>\r\n");
      out.write("                    <p>Correo electrónico del vendedor: ");
      out.print( usuario.getCorreo());
      out.write("</p>\r\n");
      out.write("                </footer>\r\n");
      out.write("                <div>\r\n");
      out.write("                    ");
 if ((int) session.getAttribute("id") == producto.getIdUsuario()) {
      out.write("\r\n");
      out.write("                    <form action=\"MyAccount\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"idEdit\" \r\n");
      out.write("                               value=\"");
      out.print( producto.getIdProducto());
      out.write("\"/>\r\n");
      out.write("                        <input type=\"hidden\" name=\"nombre\"\r\n");
      out.write("                               value=\"");
      out.print( producto.getNombreProd());
      out.write("\" />\r\n");
      out.write("                        <input type=\"hidden\" name=\"descripcion\"\r\n");
      out.write("                               value=\"");
      out.print( producto.getDecripción());
      out.write("\"/>\r\n");
      out.write("                        <input type=\"hidden\" name=\"precio\"\r\n");
      out.write("                               value=\"");
      out.print( producto.getPrecio());
      out.write("\"/>\r\n");
      out.write("                        <input type=\"hidden\" name=\"unidades\"\r\n");
      out.write("                               value=\"");
      out.print( producto.getUnidades());
      out.write("\"/>\r\n");
      out.write("                        <input type=\"hidden\" name=\"imagen\"\r\n");
      out.write("                               value=\"");
      out.print( producto.getImage());
      out.write("\"/>\r\n");
      out.write("                        <input class=\"deleteInput\" type=\"submit\" \r\n");
      out.write("                               value=\"Modificar\"\r\n");
      out.write("                               alt=\"Modificar\"/>\r\n");
      out.write("                    </form>\r\n");
      out.write("                    ");
 } else {
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
                    
      out.write("\r\n");
      out.write("                    <form action=\"ShowPublication\" method=\"post\">\r\n");
      out.write("                    Cantidad: \r\n");
      out.write("                    <input type=\"number\" value=\"");
      out.print( valueU);
      out.write("\" \r\n");
      out.write("                           min=\"");
      out.print( min);
      out.write("\"\r\n");
      out.write("                           max=\"");
      out.print( producto.getUnidades()-contadorUnidades );
      out.write("\"\r\n");
      out.write("                           name=\"numberOfItem\">\r\n");
      out.write("                    Unidades disponibles: ");
      out.print( producto.getUnidades());
      out.write("\r\n");
      out.write("                    <br /><br /><br />\r\n");
      out.write("                        <input type=\"hidden\" name=\"addCar\" value=\"");
      out.print( producto.getIdProducto());
      out.write("\"/>\r\n");
      out.write("                        <input type=\"submit\" value=\"Agregar al carrito\">\r\n");
      out.write("                    </form>\r\n");
      out.write("                    ");
 
                      }
                    
      out.write("\r\n");
      out.write("                    <form action=\"#\" method=\"post\">\r\n");
      out.write("                        <input type=\"submit\" value=\"Comprar\">\r\n");
      out.write("                    </form>       \r\n");
      out.write("                     ");

                        }else{
                     
      out.write("\r\n");
      out.write("                        <form action=\"ShowPublication\" method=\"post\">\r\n");
      out.write("                        Cantidad: \r\n");
      out.write("                        <input type=\"number\" value=\"");
      out.print( valueU);
      out.write("\" \r\n");
      out.write("                               min=\"");
      out.print( min);
      out.write("\"\r\n");
      out.write("                               max=\"");
      out.print( producto.getUnidades());
      out.write("\"\r\n");
      out.write("                               name=\"numberOfItem\">\r\n");
      out.write("                        Unidades disponibles: ");
      out.print( producto.getUnidades());
      out.write("\r\n");
      out.write("                        <br /><br /><br />\r\n");
      out.write("                        <input type=\"hidden\" name=\"addCar\" value=\"");
      out.print( producto.getIdProducto());
      out.write("\"/>\r\n");
      out.write("                        <input type=\"submit\" value=\"Agregar al carrito\">\r\n");
      out.write("                        </form>\r\n");
      out.write("                        <form action=\"#\" method=\"post\">\r\n");
      out.write("                            <input type=\"submit\" value=\"Comprar\">\r\n");
      out.write("                        </form>\r\n");
      out.write("                    ");

                        }
                        }
                    
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div> \r\n");
      out.write("        <br><br>\r\n");
      out.write("        <div align=\"center\" id=\"reportes\">\r\n");
      out.write("            <section>\r\n");
      out.write("                <h3> ¿Deseas reportar el producto? </h3>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <input type=\"button\"  value=\"Reportar\" data-toggle=\"modal\" data-target=\"#myModal\" />\r\n");
      out.write("                </div>\r\n");
      out.write("            </section>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"modal fade\" tabindex=\"-1\" role=\"dialog\" id=\"myModal\">\r\n");
      out.write("            <div class=\"modal-dialog\">\r\n");
      out.write("                <div class=\"modal-content\">\r\n");
      out.write("                    <div class=\"modal-header\">\r\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("                        <h4 class=\"modal-title\"> Reportar Producto</h4>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-body\">\r\n");
      out.write("                        <form action=\"sendReport\" id=\"formReport\" method=\"POST\">\r\n");
      out.write("                            <input type=\"hidden\"  class=\"form-control\" name=\"idProd\"\r\n");
      out.write("                                                            value=\"");
      out.print( producto.getIdProducto());
      out.write("\" readonly/>\r\n");
      out.write("                            <input type=\"hidden\" class=\"form-control\" name=\"idUs\"\r\n");
      out.write("                                                           value=\"");
      out.print( id);
      out.write("\" readonly/>\r\n");
      out.write("                            <span>Motivo:</span> <input type=\"text\" class=\"form-control\" name=\"motivo\"\r\n");
      out.write("                                                        required />\r\n");
      out.write("                            <span>Descripción:</span> <textarea id=\"textarea\" name=\"descripcion\"\r\n");
      out.write("                                                                class=\"form-control\" ></textarea>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-footer\">\r\n");
      out.write("                        ");
 
                                if(id == -1) {
                        
      out.write("\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\r\n");
      out.write("                        ");
 }else{ 
      out.write("\r\n");
      out.write("                        <button type=\"submit\" form=\"formReport\" class=\"btn btn-primary\"> Enviar</button>\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\r\n");
      out.write("                        ");
 } 
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div><!-- /.modal-content -->\r\n");
      out.write("            </div><!-- /.modal-dialog -->\r\n");
      out.write("        </div><!-- /.modal -->\r\n");
      out.write("        <section id=\"comentarios\">\r\n");
      out.write("            <h4>Comentarios:</h4>\r\n");
      out.write("            ");
 comentarios = query.getComentarios(producto.getIdProducto()); 
      out.write("\r\n");
      out.write("            <!-- Comentario apertura -->\r\n");
      out.write("            ");
 for (Comentario comentario : comentarios) {
      out.write("\r\n");
      out.write("            <div>\r\n");
      out.write("                <header>\r\n");
      out.write("                    <h5>");
      out.print( comentario.getNombreUsuario());
      out.write("</h5>\r\n");
      out.write("                </header>\r\n");
      out.write("                <div>\r\n");
      out.write("                    ");
      out.print( comentario.getComentario());
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
 }
                comentarios.clear(); 
      out.write("\r\n");
      out.write("            <!-- Comentario cierre -->\r\n");
      out.write("            ");

                wasBoughtByCustomer = query.wasBoughtByCustomer((int) session.getAttribute("id"),
                        producto.getIdProducto());
                /*if(wasBoughtByCustomer){ */
      out.write("\r\n");
      out.write("            <form action=\"ShowPublication\" method=\"post\">\r\n");
      out.write("                <h4>Publicar comentario:</h4>\r\n");
      out.write("                <textarea id=\"makeCommentContent\" name=\"comentario\" \r\n");
      out.write("                          rows=\"10\" cols=\"40\" required=\"true\"></textarea>\r\n");
      out.write("                <br/>\r\n");
      out.write("                <input type=\"hidden\" name=\"idProducto\" value=\"");
      out.print( producto.getIdProducto());
      out.write("\"/>\r\n");
      out.write("                <input type=\"hidden\" name=\"idUsuario\" value=\"");
      out.print( (int) session.getAttribute("id"));
      out.write("\"/>\r\n");
      out.write("                <input type=\"submit\" value=\"Comentar\" />\r\n");
      out.write("            </form>\r\n");
      out.write("            ");
// } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </section>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "scripts.jsp", out, false);
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
