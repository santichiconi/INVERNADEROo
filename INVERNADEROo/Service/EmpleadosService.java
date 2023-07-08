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

public class EmpleadosService {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Empleados> listadoEmpleados;
    FechaYHorario fechaYHorario = new FechaYHorario();


    public void agregarEmpleado(Empleados empleados) {
        String fe = fechaYHorario.fechaYhora(fechaYHorario);
        scanner.nextLine();
        System.out.println("Ingrese el nombre del empleado");
        String nom = scanner.nextLine();

        System.out.println("Ingrese el apellido de ´´" + nom + "´´");
        String ap = scanner.nextLine();

        System.out.println("Ingrese el DNI de ´´" + nom + "´´");
        Double dni = scanner.nextDouble();

        System.out.println("Ingrese la edad de ´´ " + nom + "´´");
        Double ed = scanner.nextDouble();

        System.out.println("Ingrese la altura en CM del empleado");
        Double al = scanner.nextDouble();


        Empleados empleados1 = new Empleados(nom, ap, dni, ed, al, fe);
        listadoEmpleados.add(empleados1);
        guardarDatos();
    }

    public void borrarEmpleado(Empleados empleados) {
        Boolean m = true;
        while (m) {

            scanner.nextLine();
            System.out.print("Desea borrar un empleado?(s/n): ");
            String r = scanner.nextLine();

            if (r.equalsIgnoreCase("s")) {
                System.out.print("Ingrese el nombre del empleado a borrar: ");
                String nom = scanner.nextLine();

                for (Empleados list : listadoEmpleados) {
                    if (list.getNombre().equalsIgnoreCase(nom)) {
                        System.out.println("Se borró ´´" + nom + "´´");
                        listadoEmpleados.remove(list);
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

    public void mostrarListadoEmpleados(Empleados empleados) {
        for (Empleados ls : listadoEmpleados) {
            System.out.println(ls);
        }
    }

    public void menuEmpleados(Empleados empleados) {
        Boolean f = true;
        while (f) {
            System.out.println("----MENU EMPLEADOS----");
            System.out.println("1: AGREGAR NUEVO EMPLEADO");
            System.out.println("2: BORRAR UN EMPLEADO");
            System.out.println("3: MOSTRAR LISTADO DE EMPLEADOS");
            System.out.println("0: SALIR AL MENU PRINCIPAL");
            System.out.print("Ingrese la opcion con su teclado numerico: ");
            int r = scanner.nextInt();
            if (r == 0) {
                f = false;
            } else {
                switch (r) {
                    case 1:
                        agregarEmpleado(empleados);
                        break;
                    case 2:
                        borrarEmpleado(empleados);
                        break;
                    case 3:
                        mostrarListadoEmpleados(empleados);
                        break;
                    default:
                        System.out.println("EL NUMERO INGRESADO NO COINCIDE CON NINGUNA OPCION");
                        break;
                }
            }
        }
    }

    public String obtenerDatosEmpleados() {
        StringBuilder datos = new StringBuilder();
        for (Empleados d : listadoEmpleados) {
            datos.append(d.toString());
            datos.append(System.lineSeparator());
        }
        return datos.toString();
    }

    public EmpleadosService() {
        listadoEmpleados = new ArrayList<Empleados>();
    }

    private boolean verificarDirectorio(String rutaArchivo) {
        File directorio = new File(rutaArchivo);
        return directorio.exists() && directorio.isDirectory();
    }

    public void guardarDatos() {
        String rutaArchivo = "C:\\Users\\chuPac\\IdeaProjects\\INVERNADEROo\\META-INF\\datos_empleados.txt";
        ArrayList<String> datos = new ArrayList<>();
        datos.add(obtenerDatosEmpleados());

        if (verificarDirectorio(rutaArchivo)) {
            GuardarDatos.guardarDatos(rutaArchivo, datos);
        } else {
            System.out.println("La ruta de guardado no es válida.");
        }
    }

    public void cargarDatos() {
        ArrayList<String> datos = GuardarDatos.cargarDatos("datos_empleados.txt");
    }
}