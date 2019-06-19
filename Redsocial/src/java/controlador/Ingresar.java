package controlador;

import modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Ingresar", urlPatterns = {"/Ingresar"})
public class Ingresar extends HttpServlet {    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("password");
        Usuario user = new Usuario();        
        Integer res  = user.Ingresar(usuario,clave);
        HttpSession sesion = request.getSession();
        if (res == 1)
        {
            sesion.setAttribute("usuario",usuario);        
        }
        out.println(res);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
