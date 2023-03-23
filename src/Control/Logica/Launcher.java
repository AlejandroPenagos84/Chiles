/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.Logica;
import Control.Conexion.*;
/**
 *
 * @author Alejandro Penagos
 */
public class Launcher {
    public static void main(String[]args){
        ChileProperties cn = new ChileProperties();
        cn.ListaInicialChiles();
        new ChileLogica();
        
    }
}
