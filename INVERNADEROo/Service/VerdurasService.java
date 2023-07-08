/*

 */

package Service;

/*
 * INVERNADERO
 * Santiago Chiconi, Date: 24/6/2023
 */

import Entity.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class VerdurasService {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Verduras> listadoVerduras = new ArrayList<>();
    FechaYHorario fechaYHorario = new FechaYHorario();




    public void agregarVerduras(Verduras verduras) {
        String fe = fechaYHorario.fechaYhora(fechaYHorario);
        scanner.nextLine();
        System.out.println("Ingrese el nombre de la verdura");
        String nom = scanner.nextLine();

        System.out.println("Ingrese el peso promedio de ´´" + nom + "´´ al punto de cosecha");
        Double pe = scanner.nextDouble();

        System.out.println("Ingrese la altura promedio de ´´" + nom + "´´ al punto de cosecha");
        Double al = scanner.nextDouble();

        System.out.println("Ingrese la anchura promedio de ´´" + nom + "´´ al punto de cosecha");
        Double an = scanner.nextDouble();

        System.out.println("Ingrese el precio unitario de semilla o plantin de ´´" + nom + "´´");
        Double pr = scanner.nextDouble();

        /*String nombre, Double peso, Double altura, Double ancho*/

        Verduras ve = new Verduras(nom, pe, al, an, pr, fe);
        listadoVerduras.add(ve);
        guardarDatos();
    }

    public void borrarVerduras(Verduras verduras) {
        boolean r = true;
        while (r) {
            System.out.println("Desea borrar una verdura? (s/n)");
            String re = scanner.nextLine();
            if (re.equalsIgnoreCase("s")) {
                System.out.println("Ingrese el nombre de la verdura a borrar");
                String ver = scanner.nextLine();
                for (Verduras list : listadoVerduras) {
                    if (ver.equalsIgnoreCase(verduras.getNombre())) {
                        listadoVerduras.remove(list);
                    } else {
                        System.out.println("El nombre ingresado no coincide");
                    }
                }
            }
            if (re.equalsIgnoreCase("n")) {
                r = false;
            }
        }
        guardarDatos();
    }

    public void mostrarListadoVerduras(Verduras verduras) {
        for (Verduras re : listadoVerduras) {
            System.out.println(re);
        }
    }

    public void menuVerduras(Verduras verduras) {
        boolean f = true;
        while (f) {
            System.out.println("----MENU VERDURAS----");
            System.out.println("1: Agregar nueva verdura");
            System.out.println("2: Borrar verdura/s");
            System.out.println("3: Mostrar listado de verduras");
            System.out.println("0: Salir al Menu Principal");
            int e = scanner.nextInt();
            if (e == 0) {
                f = false;
            } else {
                switch (e) {
                    case 1:
                        agregarVerduras(verduras);
                        break;
                    case 2:
                        borrarVerduras(verduras);
                        break;
                    case 3:
                        mostrarListadoVerduras(verduras);
                        break;
                    default:
                        System.out.println("El numero ingresado es incorrecto");
                        break;
                }
            }
        }
    }

    public String obtenerDatosVerduras() {
        StringBuilder datos = new StringBuilder();
        for (Verduras d : listadoVerduras) {
            datos.append(d.toString());
            datos.append(System.lineSeparator());
        }
        return datos.toString();
    }

    public VerdurasService() {
        listadoVerduras = new ArrayList<Verduras>();
    }

    private boolean verificarDirectorio(String rutaArchivo) {
        File directorio = new File(rutaArchivo);
        return directorio.exists() && directorio.isDirectory();
    }

    public void guardarDatos() {
        String rutaArchivo = "C:\\Users\\chuPac\\IdeaProjects\\INVERNADEROo\\META-INF\\datos_verduras.txt";
        ArrayList<String> datos = new ArrayList<>();
        datos.add(obtenerDatosVerduras());

        if (verificarDirectorio(rutaArchivo)) {
            GuardarDatos.guardarDatos(rutaArchivo, datos);
        } else {
            System.out.println("La ruta de guardado no es válida.");
        }
    }
    public void cargarDatos() {
        ArrayList<String> datos = GuardarDatos.cargarDatos("datos_verduras.txt");
    }
}