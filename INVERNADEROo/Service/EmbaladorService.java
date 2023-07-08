/*

 */

package Service;

/*
 * INVERNADERO
 * Santiago Chiconi, Date: 27/6/2023
 */


import Entity.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class EmbaladorService {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Embalador> listadoEmbalador = new ArrayList<>();
    FechaYHorario fechaYHorario = new FechaYHorario();








    public void agregarEmbalador(Embalador embalador) {
        String fe = fechaYHorario.fechaYhora(fechaYHorario);
        scanner.nextLine();
        System.out.println("Ingrese el nombre del embalador");
        String nom = scanner.nextLine();
        System.out.println("Ingrese el apellido de ´´" + nom + "´´");
        String ap = scanner.nextLine();
        System.out.println("Ingrese el DNI de ´´" + nom + "´´");
        Double dni = scanner.nextDouble();
        System.out.println("Ingrese la edad de ´´ " + nom + "´´");
        Double ed = scanner.nextDouble();
        System.out.println("Ingrese la altura en CM del empleado");
        Double al = scanner.nextDouble();
        System.out.println("Ingrese el sueldo por cajon de ´´" + nom + "´´");
        Double su = scanner.nextDouble();

        Embalador embalador1 = new Embalador(nom, ap, dni, ed, al, su, fe);
        listadoEmbalador.add(embalador1);
        guardarDatos();
    }

    public void borrarEmbalador(Embalador embalador) {
        Boolean m = true;
        while (m) {

            scanner.nextLine();
            System.out.print("Desea borrar un embalador?(s/n): ");
            String r = scanner.nextLine();

            if (r.equalsIgnoreCase("s")) {
                System.out.print("Ingrese el nombre del empleado a borrar: ");
                String nom = scanner.nextLine();

                for (Embalador list : listadoEmbalador) {
                    if (list.getNombre().equalsIgnoreCase(nom)) {
                        System.out.println("Se borró ´´" + nom + "´´");
                        listadoEmbalador.remove(list);
                        break;
                    } else {
                        System.out.println("´´" + nom + "´´ no se encontro en la lista");
                    }
                }
            }

            if (r.equalsIgnoreCase("n")) {
                m = false;
            }
        }
        guardarDatos();
    }

    public void mostrarListadoEmbalador(Embalador embalador) {
        for (Embalador ls : listadoEmbalador) {
            System.out.println(ls);
        }
    }

    public void menuEmbalador(Embalador embalador) {
        Boolean f = true;
        while (f) {
            System.out.println("----MENU EMBALADOR----");
            System.out.println("1: AGREGAR NUEVO EMBALADOR");
            System.out.println("2: BORRAR UN EMBALADOR");
            System.out.println("3: MOSTRAR LISTADO DE EMBALADORES");
            System.out.println("0: SALIR AL MENU PRINCIPAL");
            System.out.print("Ingrese la opcion con su teclado numerico: ");
            int r = scanner.nextInt();
            if (r == 0) {
                f = false;
            } else {
                switch (r) {
                    case 1:
                        agregarEmbalador(embalador);
                        break;
                    case 2:
                        borrarEmbalador(embalador);
                        break;
                    case 3:
                        mostrarListadoEmbalador(embalador);
                        break;
                    default:
                        System.out.println("EL NUMERO INGRESADO NO COINCIDE CON NINGUNA OPCION");
                        break;
                }
            }
        }
    }

    public String obtenerDatosEmbalador() {
        StringBuilder datos = new StringBuilder();
        for (Embalador d : listadoEmbalador) {
            datos.append(d.toString());
            datos.append(System.lineSeparator());
        }
        return datos.toString();
    }

    public EmbaladorService() {
        listadoEmbalador = new ArrayList<Embalador>();
    }
    private boolean verificarDirectorio(String rutaArchivo) {
        File directorio = new File(rutaArchivo);
        return directorio.exists() && directorio.isDirectory();
    }
    public void guardarDatos() {
        String rutaArchivo = "C:\\Users\\chuPac\\IdeaProjects\\INVERNADEROo\\META-INF\\datos_embalador.txt";
        ArrayList<String> datos = new ArrayList<>();
        datos.add(obtenerDatosEmbalador());

        if (verificarDirectorio(rutaArchivo)) {
            GuardarDatos.guardarDatos(rutaArchivo, datos);
        } else {
            System.out.println("La ruta de guardado no es válida.");
        }
    }
    public void cargarDatos() {
        ArrayList<String> datos = GuardarDatos.cargarDatos("datos_embalador.txt");
    }
}