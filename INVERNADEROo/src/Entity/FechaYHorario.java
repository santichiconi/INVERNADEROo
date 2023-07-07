/*

 */

package Entity;

/*
 * INVERNADERO
 * Santiago Chiconi, Date: 27/6/2023
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FechaYHorario {

    public String fechaYhora(FechaYHorario fechaYHorario){

        LocalDateTime fechaHoraActual = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy /// HH:mm:ss");

        String fechaHoraFormateada = fechaHoraActual.format(formatter);

        return  fechaHoraFormateada;
    }
}
