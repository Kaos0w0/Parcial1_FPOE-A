package controlador;

import modelo.PronosticoModel;
import vista.PronosticoView;

/**
 * Parcial N. 1 FPOE (A). Archivo: PronosticoController.java, Autores (Grupo 01 POE): 
 * Brayan Andrés Sánchez Lozano <brayan.andres.sanchez@correounivalle.edu.co>
 * Jose Luis Hincapie Bucheli <jose.bucheli@correounivalle.edu.co>
 * Fecha creación: 04-08-2022, Fecha última modificación: 04-08-2022 
 *  Docente: Luis Romo <luis.romo@correounivalle.edu.co>
 */

public class PronosticoController {
    PronosticoModel modelo = new PronosticoModel();
    PronosticoView vista = new PronosticoView();

    public PronosticoController(PronosticoModel modelo, PronosticoView vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
}
