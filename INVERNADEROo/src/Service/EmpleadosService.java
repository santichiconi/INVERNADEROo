/*

 */

package Service;

/*
 * INVERNADERO
 * Santiago Chiconi, Date: 27/6/2023
 */

import Entity.*;

import java.io.*;
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
    }

    public void menuEmpleados(Empleados empleados) {
        Boolean f = true;
        while (f) {
            System.out.println("----MENU EMPLEADOS----");
            System.out.println("1: AGREGAR NUEVO EMPLEADO");
            System.out.println("2: BORRAR UN EMPLEADO");
            System.out.println("3: MOSTRAR LISTADO DE EMPLEADOS");
            System.out.println("4: GUARDAR DATOS");
            System.out.println("5: CARGAR DATOS");
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
                    case 4:
                        guardarDatosEnArchivo(rutaArchivo(), listadoEmpleados);
                        break;
                    case 5:
                        cargarDatosDesdeArchivo(rutaArchivo(), listadoEmpleados);
                        break;
                    default:
                        System.out.println("EL NUMERO INGRESADO NO COINCIDE CON NINGUNA OPCION");
                        break;
                }
            }
        }
    }
    public EmpleadosService() {
        listadoEmpleados = new ArrayList<Empleados>();
    }

    public String rutaArchivo(){
        String f = "C:\\Users\\PC\\IdeaProjects\\INVERNADEROo\\resources\\datos_empleados.txt";
        return f;
    }
    public void mostrarListadoEmpleados(Empleados empleados) {
        for (Empleados elemento : listadoEmpleados) {
            System.out.println(elemento.getNombre() + "," + elemento.getApellido() + "," +
                    elemento.getDni() + "," + elemento.getEdad() + "," + elemento.getAltura() + "," + elemento.getFechaHora());
        }
    }
    private static void cargarDatosDesdeArchivo(String rutaArchivo, ArrayList<Empleados> listadoElementos) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                Empleados elemento = new Empleados(datos[0], datos[1], Double.parseDouble(datos[2]),
                        Double.parseDouble(datos[3]), Double.parseDouble(datos[4]), datos[5]);
                listadoElementos.add(elemento);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //    String nombre, String apellido, Double dni, Double edad, Double altura, String fechaHora
    private static void guardarDatosEnArchivo(String rutaArchivo, ArrayList<Empleados> listadoElementos) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(rutaArchivo)))) {
            for (Empleados elemento : listadoElementos) {
                String linea = elemento.getNombre() + "," + elemento.getApellido() + "," +
                        elemento.getDni() + "," + elemento.getEdad() + "," + elemento.getAltura() + "," + elemento.getFechaHora();
                writer.println(linea);
            }
            System.out.println("LOS DATOS FUERON GUARDADOS CON EXITO");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}