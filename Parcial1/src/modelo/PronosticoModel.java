package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Parcial N. 1 FPOE (A). Archivo: PronosticoModel.java, Autores (Grupo 01 POE): 
 * Brayan Andrés Sánchez Lozano <brayan.andres.sanchez@correounivalle.edu.co>
 * Jose Luis Hincapie Bucheli <jose.bucheli@correounivalle.edu.co>
 * Fecha creación: 04-08-2022, Fecha última modificación: 04-08-2022 
 *  Docente: Luis Romo <luis.romo@correounivalle.edu.co>
 */

public class PronosticoModel {
    //Datos para las columnas de la tabla
    private int añosPronostico;
    private int cantidadVentas;
    private int añoCuadrado;
    private int ventasCuadradas;
    private int ventasPorAño;
    private int totalAños;

    //Datos para la ultima fila de la tabla
    private int totalSumaAños;
    private int totalVentas;
    private int totalAñosCuadrados;
    private int totalVentasCuadradas;
    private int totalVentasPorAños;

    //Datos relativos al crecimiento y el pronóstico
    private int crecimientoPromedio;
    private int pronosticoParaAño;
    private int añoAPronosticar;
    private float a, b, numerador, denominador;

    //Arreglo para llevar los datos a la vista
    String arrayForVista[];

    //Inicializar valores
    public PronosticoModel() {
        totalAños = 0;
        totalVentas = 0;
        totalAñosCuadrados = 0;
        totalVentasCuadradas = 0;
        totalVentasPorAños = 0;
        totalSumaAños = 0;
        arrayForVista = new String[5];
    }

    //Ingreso de los datos del usuario
    public void ingresoVentas(int cantidadVentas, int añosPronostico, boolean existente){
        this.cantidadVentas = cantidadVentas;
        this.añosPronostico = añosPronostico;
        añoAñadido(existente);
        arrayForVista = new String[5];
    }

    //Getter para cada variable
    public int getAñoPronostico() {
        return añosPronostico;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public int getAñoCuadrado() {
        return añoCuadrado;
    }

    public int getVentasCuadradas() {
        return ventasCuadradas;
    }

    public int getVentasPorAño() {
        return ventasPorAño;
    }

    public int getTotalAños() {
        return totalAños;
    }

    public int getTotalVentas() {
        return totalVentas;
    }

    public int getTotalAñosCuadrados() {
        return totalAñosCuadrados;
    }

    public int getTotalVentasCuadradas() {
        return totalVentasCuadradas;
    }

    public int getTotalVentasPorAños() {
        return totalVentasPorAños;
    }

    public int getCrecimientoPromedio() {
        return crecimientoPromedio;
    }

    public int getPronosticoParaAño() {
        return pronosticoParaAño;
    }

    public int getAñoAPronosticar() {
        return añoAPronosticar;
    }

    //Setters para las variables ajustables por el usuario
    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public void setAñosPronostico(int añosPronostico) {
        this.añosPronostico = añosPronostico;
    }

    //Metodos propios de los cálculos requeridos
    public int valorAlCuadrado(int valor){
        return (int) Math.pow(valor, 2);
    }

    public int getXCuadrado(){
        return valorAlCuadrado(totalAños);
    }

    public int getYCuadrada(){
        return valorAlCuadrado(cantidadVentas);
    }

    public int getXPorY(){
        return (totalAños * cantidadVentas);
    }

    public void añoAñadido(boolean existente){
        if(existente == false){
            totalAños += 1;
            totalSumaAños += totalAños;
        } else {
            totalSumaAños += totalAños + 1;
        }
        totalVentas += cantidadVentas;
        totalAñosCuadrados += getXCuadrado();
        totalVentasCuadradas += getYCuadrada();
        totalVentasPorAños += getXPorY();
    }
    
    public void añoEliminado(int año, int ventas, int index){
        totalAños -= 1;
        totalSumaAños -= año;
        totalVentas -= ventas;
        totalAñosCuadrados -=  valorAlCuadrado(index);
        totalVentasCuadradas -= valorAlCuadrado(ventas);
        totalVentasPorAños -= (index * ventas);
    }

    public void calcularB(){
        numerador = (totalAños * totalVentasPorAños) - (totalSumaAños * totalVentas);
        denominador = (totalAños * totalAñosCuadrados) - (valorAlCuadrado(totalAños));
        b = numerador / denominador;
    }

    public void calcularA(){
        numerador = (totalVentas) - (b * totalSumaAños);
        denominador = totalAños;
        a = numerador / denominador;
    }

    public float pronosticoXAño(int año){
        calcularB();
        calcularA();
        return (a + (b * año));
    }

    public float crecimientoXAños(){
        calcularB();
        numerador = (b * añosPronostico);
        denominador = totalVentas;
        return (numerador / denominador);
    }

    public boolean isCalculable(){
        return totalAños >= 3 && añosPronostico != 0;
    }

    public String[] getFilaForVista(){
        arrayForVista[0] = String.valueOf(totalAños);
        arrayForVista[1] = String.valueOf(cantidadVentas);
        arrayForVista[2] = String.valueOf(getXCuadrado());
        arrayForVista[3] = String.valueOf(getYCuadrada());
        arrayForVista[4] = String.valueOf(getXPorY());
        return arrayForVista;
    }

    public String[] getTotalForVista(){
        arrayForVista[0] = String.valueOf(totalSumaAños);
        arrayForVista[1] = String.valueOf(totalVentas);
        arrayForVista[2] = String.valueOf(totalAñosCuadrados);
        arrayForVista[3] = String.valueOf(totalVentasCuadradas);
        arrayForVista[4] = String.valueOf(totalVentasPorAños);
        return arrayForVista;
    }

    public void nuevo(){
        totalAños = 0;
        totalVentas = 0;
        totalAñosCuadrados = 0;
        totalVentasCuadradas = 0;
        totalVentasPorAños = 0;
        totalSumaAños = 0;
        arrayForVista = new String[5];
    }

    public List<String[]> eliminarFila(JTable tabla, DefaultTableModel modelo, int fila){
        int aux = tabla.getRowCount();
        List<String> datosReinicio = new ArrayList<>();
        List<String[]> listas = new ArrayList<>();
        for(int l = 0; l < aux; l++){
            datosReinicio.add((String) modelo.getValueAt(fila, 1));
        }

        while(fila != tabla.getRowCount()){
            modelo.removeRow(fila);
        }

        datosReinicio.remove(fila);
        
        nuevo();
        for(int j=0; j<datosReinicio.size(); j++){
            ingresoVentas(Integer.valueOf(datosReinicio.get(j)), añosPronostico, false);
            listas.add(getFilaForVista());
        }
        return listas;
    }
}
