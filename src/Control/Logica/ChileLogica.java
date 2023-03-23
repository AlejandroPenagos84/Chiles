/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.Logica;
import Modelo.ChileVO;
import Control.Conexion.*;
import Control.DAO.ChileDAO;
import Vista.Vista1;
import java.util.ArrayList;

/**
 *
 * @author Alejandro Penagos
 */
public class ChileLogica {
    
    private ChileDAO chileDao;
    private Vista1 vista;
    private ChileProperties chileProp;
    
    public ChileLogica(){
        chileProp = new ChileProperties();
        vista = new Vista1();
        //InsercionInicial(chileProp.ListaInicialChiles());
        ObtenerRegistro();
    }
    public void InsercionInicial(ArrayList<ChileVO> list){
        chileDao = new ChileDAO();
        for(int i = 0; i<list.size();i++){
            chileDao.InsertarChile(list.get(i));
        }     
    }
    
    public void ObtenerRegistro(){
        chileDao = new ChileDAO();
        String nombre = "Habanero";
        
        ChileVO aux = chileDao.ConsultarDatos(nombre);
        
        if(aux != null){
            vista.Mensanje(aux.getNombre());
            vista.Mensanje(aux.getOrigen());
            vista.Mensanje(aux.getColor());
            vista.Mensanje(aux.getCategoria());
            vista.Mensanje(String.valueOf(aux.getEscala()));
            vista.Mensanje(aux.getEspecie());
        }
    }
}
