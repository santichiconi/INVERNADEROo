/*

 */

package Entity;

/*
 * INVERNADERO
 * Santiago Chiconi, Date: 24/6/2023
 */

public class Insumos {
    private String nombre;
    private Double precio;
    private Double peso;
    private Double alturaPack;
    private Double anchuraPack;
    private Double cantidadPorPack;
    private String proveedor;
    private String fechaHora;

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Insumos() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAlturaPack() {
        return alturaPack;
    }

    public void setAlturaPack(Double alturaPack) {
        this.alturaPack = alturaPack;
    }

    public Double getAnchuraPack() {
        return anchuraPack;
    }

    public void setAnchuraPack(Double anchuraPack) {
        this.anchuraPack = anchuraPack;
    }

    public Double getCantidadPorPack() {
        return cantidadPorPack;
    }

    public void setCantidadPorPack(Double cantidadPorPack) {
        this.cantidadPorPack = cantidadPorPack;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Insumos(String nombre, Double precio, Double peso, Double alturaPack, Double anchuraPack, Double cantidadPorPack, String proveedor, String fechaHora) {
        this.nombre = nombre;
        this.precio = precio;
        this.peso = peso;
        this.alturaPack = alturaPack;
        this.anchuraPack = anchuraPack;
        this.cantidadPorPack = cantidadPorPack;
        this.proveedor = proveedor;
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Insumos{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", peso=" + peso +
                ", alturaPack=" + alturaPack +
                ", anchuraPack=" + anchuraPack +
                ", cantidadPorPack=" + cantidadPorPack +
                ", proveedor='" + proveedor + '\'' +
                ", fechaHora='" + fechaHora + '\'' +
                '}';
    }
}
