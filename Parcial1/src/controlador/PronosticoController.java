package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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
    private int año, ventas;

    public PronosticoController(PronosticoModel modelo, PronosticoView vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        vista.addBtnAgregarA(new AccionesBotones());
        vista.addBtnNuevo(new AccionesBotones());
        vista.addBtnBorrarA(new AccionesBotones());
        vista.addBtnModificar(new AccionesBotones());
    }

    private class AccionesBotones implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent b) {

            switch (b.getActionCommand()) {
                case "btnAgregar" -> {
                    try{
                        año = Integer.valueOf(vista.getAños());
                    } catch(NumberFormatException e) {
                        año = 0;
                    }
                    try{
                        ventas = Integer.valueOf(vista.getVentas());
                        modelo.ingresoVentas(ventas, año);
                        vista.setFila(modelo.getFilaForVista());
                        vista.setTotal(modelo.getTotalForVista());                        
                    } catch(NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Ingrese un valor de ventas valido", "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                    }
                } case "btnNuevo" -> {
                    vista.nuevo();
                    modelo.nuevo();
                } case "btnBorrar" -> {
                    try{
                        modelo.eliminarFila(vista.getTabla(), vista.getModelo(), vista.getSelectedRow());
                        if(vista.getRowCount() == 1){
                            vista.nuevo();
                            modelo.nuevo();
                        } else {
                            modelo.eliminarFila(vista.getTabla(), vista.getModelo(), vista.getSelectedRow());
                            vista.quitarFila(vista.getSelectedRow());
                        }
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Seleccione una fila primero", "Advertencia",
                        JOptionPane.WARNING_MESSAGE); 
                    }
                } case "btnModificar" -> {
                    
                } default -> System.out.println("Este boton no existe");
            }

        }
    }
}
