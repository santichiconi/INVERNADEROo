package Entity;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class GuardarDatos {

    public static void guardarDatos(String rutaArchivo, ArrayList<String> datos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (String dato : datos) {
                writer.write(dato);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static ArrayList<String> cargarDatos(String rutaArchivo) {
            ArrayList<String> datos = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    datos.add(linea);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return datos;
        }
}


