/*

 */

package Entity;

/*
 * INVERNADERO
 * Santiago Chiconi, Date: 24/6/2023
 */

public class Verduras {
    private String nombre;
    private Double peso;
    private Double altura;
    private Double ancho;
    private Double precioSemilla;
    private String fechaHora;

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Double getPrecioSemilla() {
        return precioSemilla;
    }

    public void setPrecioSemilla(Double precioSemilla) {
        this.precioSemilla = precioSemilla;
    }

    public Verduras() {
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

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public Verduras(String nombre, Double peso, Double altura, Double ancho, Double precioSemilla, String fechaHora) {
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
        this.ancho = ancho;
        this.precioSemilla = precioSemilla;
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Verduras{" +
                "nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", ancho=" + ancho +
                ", precioSemilla=" + precioSemilla +
                '}';
    }
}