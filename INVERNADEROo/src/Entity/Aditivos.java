/*

 */

package Entity;

/*
 * INVERNADERO
 * Santiago Chiconi, Date: 24/6/2023
 */

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Aditivos {
    private String nombre;
    private Double peso;
    private Double precio;
    private Double altura;
    private Double anchura;
    private ArrayList<String> aditivos;
    private String proveedor;
    private String fechaHora;
    public Aditivos() {
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public ArrayList<String> getAditivos() {
        return aditivos;
    }

    public void setAditivos(ArrayList<String> aditivos) {
        this.aditivos = aditivos;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getAnchura() {
        return anchura;
    }

    public void setAnchura(Double anchura) {
        this.anchura = anchura;
    }

    public Aditivos(String nombre, Double peso, Double precio, Double altura, Double anchura, ArrayList<String> aditivos, String proveedor, String fechaHora) {
        this.nombre = nombre;
        this.peso = peso;
        this.precio = precio;
        this.altura = altura;
        this.anchura = anchura;
        this.aditivos = aditivos;
        this.proveedor = proveedor;
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Aditivos{" +
                "nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", precio=" + precio +
                ", altura=" + altura +
                ", anchura=" + anchura +
                ", aditivos=" + aditivos +
                ", proveedor='" + proveedor + '\'' +
                ", fechaHora='" + fechaHora + '\'' +
                '}';
    }
}