package parcial1;

import modelo.PronosticoModel;
import vista.PronosticoView;
import controlador.PronosticoController;

/**
 * Parcial N. 1 FPOE (A). Archivo: Parcial1.java, Autores (Grupo 01 POE): 
 * Brayan Andrés Sánchez Lozano <brayan.andres.sanchez@correounivalle.edu.co>
 * Jose Luis Hincapie Bucheli <jose.bucheli@correounivalle.edu.co>
 * Fecha creación: 04-08-2022, Fecha última modificación: 04-08-2022 
 *  Docente: Luis Romo <luis.romo@correounivalle.edu.co>
 */

public class Parcial1 {

    public static void main(String[] args) {
        PronosticoModel modelo = new PronosticoModel();
        PronosticoView vista = new PronosticoView();
        PronosticoController controlador = new PronosticoController(modelo, vista);
    }
    
}
