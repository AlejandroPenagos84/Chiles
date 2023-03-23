/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import Modelo.ChileVO;
import Control.Conexion.ChileConexionBD;
/**
 *
 * @author Alejandro Penagos
 */
public class ChileDAO {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public ChileDAO() {
        con = null;
        st = null;
        rs = null;
    }
    
    public void InsertarChile(ChileVO chile){
        try{
            con = ChileConexionBD.getConexion();
            st = con.createStatement();
            String insercion = "INSERT INTO APP.CHILES VALUES('" +chile.getNombre() + "','" + chile.getOrigen()+ "','"+ chile.getColor() + "','"+ chile.getCategoria() + "',"+ chile.getEscala() + ",'"+ chile.getEspecie() + "')";
            st.executeUpdate(insercion);
            st.close();
            ChileConexionBD.desconectar();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public ChileVO ConsultarDatos(String nombre){
        ChileVO chile = null;
        String consulta = "SELECT * FROM App.CHILES where nombre='" + nombre + "'";
        try{
            con = (Connection) ChileConexionBD.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            
            if(rs.next()){
                chile = new ChileVO();
                chile.setNombre(rs.getString("nombre"));
                chile.setOrigen(rs.getString("origen"));
                chile.setColor(rs.getString("color"));
                chile.setCategoria(rs.getString("categoria"));
                chile.setEscala(rs.getInt("escala"));
                chile.setEspecie(rs.getString("especie"));
                
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return chile;
    }
    
    
}
