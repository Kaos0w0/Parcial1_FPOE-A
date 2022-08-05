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
                        modelo.ingresoVentas(ventas, año, false);
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
                    int selectedAux = vista.getSelectedRow();
                    vista.añadirFilas(modelo.eliminarFila(vista.getTabla(), vista.getModelo(), selectedAux));
                    try{
                        if(vista.getRowCount() == 1){
                            vista.nuevo();
                            modelo.nuevo();
                        } else {
                            
                            
                            /*vista.quitarFila(selectedAux);
                            if(selectedAux <= vista.getTabla().getRowCount()-1){
                               vista.cambiarFila(modelo.getFilaForVista(), selectedAux);
                            }
                            vista.setTotal(modelo.getTotalForVista());
                            vista.resetIndex();*/
                        }
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Seleccione una fila primero", "Advertencia",
                        JOptionPane.WARNING_MESSAGE); 
                    }
                } case "btnModificar" -> {
                    try{
                        int selectedAux = vista.getSelectedRow();
                        if(selectedAux != -1){
                            String cambio = JOptionPane.showInputDialog(null, "Nuevo numero de ventas para el año " + (vista.getSelectedRow() + 1) + ":", "Cambio de ventas", JOptionPane.QUESTION_MESSAGE);
                            if(cambio != null){
                                try{
                                    ventas = Integer.valueOf(cambio);
                                } catch(NumberFormatException e) {
                                    throw new RuntimeException("Valor inválido");
                                }
                                modelo.eliminarFila(vista.getTabla(), vista.getModelo(), selectedAux);
                                try{
                                    año = Integer.valueOf(vista.getAños());
                                } catch(NumberFormatException e) {
                                    año = 0;
                                }
                                modelo.ingresoVentas(ventas, año, true);
                                vista.cambiarFila(modelo.getFilaForVista(), selectedAux);
                                vista.setTotal(modelo.getTotalForVista());
                            }
                        } else {
                            throw new RuntimeException("Seleccione una fila primero");
                        }
                    } catch(RuntimeException E){
                        JOptionPane.showMessageDialog(null, E.getMessage(), "Advertencia",
                        JOptionPane.WARNING_MESSAGE); 
                    }
                } default -> System.out.println("Este boton no existe");
            }

        }
    }
}
