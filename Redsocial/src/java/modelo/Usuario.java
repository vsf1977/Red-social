package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;  

public class Usuario 
{
    private String usuario;
    private String nombre;
    private String fecha_nac;
    private String telefono;
    private String clave;
    private String ciudad;
    

    private PreparedStatement pr = null;
    private Connection conn = null;
    public Integer rs;
    private ResultSet rst;

   
    public Usuario()
    {
        usuario = "";
        nombre = "";
        telefono = "";
        clave = "";
        ciudad = "";        
    }

    /**
     *
     * @param usuario
     * @param clave
     * @return
     */
    
    public Integer Ingresar(String usuario, String clave) 
    {
        Integer res =0;
        try 
        {
            String sql = "select * from usuarios where usuario = ? and clave = ?";            
            conn = modelo.DAO.Enlace(conn);
            pr = conn.prepareStatement(sql);
            pr.setString(1, usuario);
            pr.setString(2, clave);
            rst = pr.executeQuery();            
            if (rst.first()) 
            {
                res = 1;
            }
            pr.close();
            conn.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }    
    
    
    public Integer Insertar() 
    {
        Integer res =0;
        try 
        {
            String sql = "INSERT INTO usuarios ("
                + " usuario,"
                + " clave,"
                + " nombre,"
                + " fecha_nac,"
                + " ciudad,"
                + " telefono ) VALUES ("
                + "?, ?, ?, ?, ?, ?)";
            Date date;
            date = Date.valueOf(fecha_nac);
            conn = modelo.DAO.Enlace(conn);
            pr = conn.prepareStatement(sql);
            pr.setString(1, usuario);            
            pr.setString(2, clave);
            pr.setString(3, nombre);
            pr.setDate(4, date); 
            pr.setString(5, ciudad);
            pr.setString(6, telefono);
            pr.executeUpdate(); 
            res = 1;
            pr.close();
            conn.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }    
    
    public void Info(String user) 
    {
        try 
        {
            String sql = "select * from usuarios where usuario = ?";            
            conn = modelo.DAO.Enlace(conn);
            pr = conn.prepareStatement(sql);
            pr.setString(1, user);
            rst = pr.executeQuery();
            if (rst.first())
            {
                this.nombre = rst.getString("nombre");
                this.telefono = rst.getString("telefono");
                this.ciudad = rst.getString("ciudad");         
                this.fecha_nac = rst.getString("fecha_nac");
            }
            pr.close();
            conn.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }       
     
    public Integer Borrar(String user) 
    {
        Integer res = 0;
        try 
        {
            String sql = "delete from usuarios where usuario = ?";            
            conn = modelo.DAO.Enlace(conn);
            pr = conn.prepareStatement(sql);
            pr.setString(1, user);
            pr.executeUpdate();
            res = 1;
            pr.close();
            conn.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }        
    
     
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

     public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
}
