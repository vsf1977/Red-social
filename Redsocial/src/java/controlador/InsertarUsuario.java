/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author Vladimir
 */
@WebServlet(name = "InsertarUsuario", urlPatterns = {"/InsertarUsuario"})
public class InsertarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
                        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
            processRequest(request, response);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String usuario = request.getParameter("usuario"); 
            String clave = request.getParameter("clave"); 
            String ciudad = request.getParameter("ciudad"); 
            String telefono = request.getParameter("telefono"); 
            String fecha_nac = request.getParameter("fecha_nac"); 
            String nombre = request.getParameter("nombre");
            Usuario user = new Usuario();     
            user.setCiudad(ciudad);
            user.setClave(clave);
            user.setNombre(nombre);
            user.setFecha_nac(fecha_nac);
            user.setTelefono(telefono);
            user.setUsuario(usuario);
            Integer res  = user.Insertar();
            out.println(res);
            out.flush();
            HttpSession sesion = request.getSession();
            if (res == 1) 
            {
                sesion.setAttribute("usuario", usuario);
            }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
