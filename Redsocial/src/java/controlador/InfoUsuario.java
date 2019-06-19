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
import org.json.JSONObject;

@WebServlet(name = "InfoUsuario", urlPatterns = {"/InfoUsuario"})
public class InfoUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("application/json");          
        HttpSession sesion = request.getSession();
        PrintWriter out = response.getWriter();        
        String usuario = (String) sesion.getAttribute("usuario");        
        Usuario user = new Usuario();           
        user.Info(usuario);
        JSONObject UserJSON = new JSONObject();
        UserJSON.put("nombre", user.getNombre());
        UserJSON.put("ciudad", user.getCiudad());
        UserJSON.put("fecha_nac", user.getFecha_nac());
        UserJSON.put("telefono", user.getTelefono());
        out.print(UserJSON);   
        out.flush();
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
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
