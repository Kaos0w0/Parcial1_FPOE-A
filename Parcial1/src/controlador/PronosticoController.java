package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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
                    int añoAux = modelo.getAñoPronostico();
                    try{
                        año = Integer.valueOf(vista.getAños());
                    } catch(NumberFormatException e) {
                        año = añoAux;
                    }
                    try{
                        modelo.setAño(año);
                        ventas = Integer.valueOf(vista.getVentas());
                        modelo.ingresoVentas(ventas, false);
                        vista.setFila(modelo.getFilaForVista());
                        vista.setTotal(modelo.getTotalForVista());                        
                        if(modelo.isCalculable()){
                            vista.setCrecimiento(modelo.crecimientoXAños());
                            vista.tablaPronostico(modelo.tablaPronostico());
                        }
                    } catch(NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Ingrese un valor de ventas valido", "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                    }
                } case "btnNuevo" -> {
                    vista.nuevo();
                    modelo.nuevo();
                } case "btnBorrar" -> {
                    try{
                        int añoAux = modelo.getAñoPronostico();
                        try{
                            año = Integer.valueOf(vista.getAños());
                        } catch(NumberFormatException e) {
                            año = añoAux;
                        }
                        modelo.setAño(año);
                        if(vista.getRowCount() == 1){
                            vista.nuevo();
                            modelo.nuevo();
                        } else {
                            int selectedAux = vista.getSelectedRow();
                            List<String[]> listasAux = modelo.eliminarFila(vista.getTabla(), vista.getModelo(), selectedAux, false, 0);
                            vista.nuevo();
                            vista.añadirFilas(listasAux);
                            vista.setTotal(modelo.getTotalForVista());
                            if(modelo.isCalculable()){
                                vista.setCrecimiento(modelo.crecimientoXAños());
                                vista.tablaPronostico(modelo.tablaPronostico());
                            }
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
                                int añoAux = modelo.getAñoPronostico();
                                try{
                                    año = Integer.valueOf(vista.getAños());
                                } catch(NumberFormatException e) {
                                    año = añoAux;
                                }
                                modelo.setAño(año);
                                List<String[]> listasAux = modelo.eliminarFila(vista.getTabla(), vista.getModelo(), selectedAux, true, ventas);
                                vista.nuevo();
                                vista.añadirFilas(listasAux);
                                vista.setTotal(modelo.getTotalForVista());
                                if(modelo.isCalculable()){
                                    vista.setCrecimiento(modelo.crecimientoXAños());
                                    vista.tablaPronostico(modelo.tablaPronostico());
                                }
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
