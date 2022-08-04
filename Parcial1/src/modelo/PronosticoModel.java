package modelo;

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

    public PronosticoModel() {
        totalAños = 0;
        totalVentas = 0;
        totalAñosCuadrados = 0;
        totalVentasCuadradas = 0;
        totalVentasPorAños = 0;
        totalSumaAños = 0;
    }

    //Inicializar valores
    public void ingresoAño(int añosPronostico, int cantidadVentas){
        this.añosPronostico = añosPronostico;
        this.cantidadVentas = cantidadVentas;
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

    public void añoAñadido(){
        totalAños += 1;
        totalSumaAños += totalAños;
        totalVentas += cantidadVentas;
        totalAñosCuadrados += getXCuadrado();
        totalVentasCuadradas += getYCuadrada();
        totalVentasPorAños += getXPorY();
    }


}
