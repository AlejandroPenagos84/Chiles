/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.Conexion;

/**
 *
 * @author Alejandro Penagos
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import Vista.Vista1;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import Modelo.ChileVO;

public class ChileProperties {

    private Vista1 vista1;
    private ArrayList<ChileVO> listaChiles;

    public ChileProperties() {
        vista1 = new Vista1();
        listaChiles = new ArrayList();
        ListaInicialChiles();
    }

    Properties propiedades = new Properties();
    InputStream entrada = null;

    public ArrayList<ChileVO> ListaInicialChiles() {
        try {
            entrada = new FileInputStream("docs/chile.properties");
            propiedades.load(entrada);

            int numChile = propiedades.size() / 6;

            for (int i = 1; i <= numChile; i++) {
                ChileVO chile = new ChileVO();
                chile.setNombre(propiedades.getProperty("chile" + i + ".nombre"));
                chile.setColor(propiedades.getProperty("chile" + i + ".color"));
                chile.setOrigen(propiedades.getProperty("chile" + i + ".origen"));
                chile.setCategoria(propiedades.getProperty("chile" + i + ".categoria"));
                chile.setEspecie(propiedades.getProperty("chile" + i + ".especie"));
                chile.setEscala(Integer.parseInt(propiedades.getProperty("chile" + i + ".escala")));
                listaChiles.add(chile);
            }

        } catch (IOException e) {
            vista1.Mensanje("No existe el archivo");
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    vista1.Mensanje("El archivo esta vacio");
                }
            }

        }
        return listaChiles;
    }
}
