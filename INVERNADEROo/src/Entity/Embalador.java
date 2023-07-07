/*

 */

package Entity;

/*
 * INVERNADERO
 * Santiago Chiconi, Date: 27/6/2023
 */

public class Embalador extends Empleados{
    private  Double precioPorCajon;
    private String fechaHora;

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Embalador() {
    }

    public Embalador(String nombre, String apellido, Double dni, Double edad, Double altura, Double precioPorCajon, String fechaHora) {
        super(nombre, apellido, dni, edad, altura, fechaHora);
        this.precioPorCajon = precioPorCajon;
    }

    public Double getPrecioPorCajon() {
        return precioPorCajon;
    }

    public void setPrecioPorCajon(Double precioPorCajon) {
        this.precioPorCajon = precioPorCajon;
    }

    @Override
    public String toString() {
        return "Embalador{" +
                "precioPorCajon=" + precioPorCajon +
                ", fechaHora='" + fechaHora + '\'' +
                '}';
    }
}
