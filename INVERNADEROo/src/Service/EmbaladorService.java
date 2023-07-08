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

        embalador = new Embalador(nom, ap, dni, ed, al, su, fe);
        listadoEmbalador.add(embalador);
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
                        scanner.nextLine();
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
    //    String nombre, String apellido, Double dni, Double edad, Double altura, Double precioPorCajon, String fechaHora
    public void mostrarListadoEmbalador(Embalador embalador) {
        for (Embalador elemento : listadoEmbalador) {
            System.out.println(elemento.getNombre() + "," + elemento.getApellido() + "," +
                    elemento.getDni() + "," + elemento.getEdad() + "," + elemento.getAltura() + "," + elemento.getPrecioPorCajon() + "," +
                    elemento.getFechaHora());

        }
    }

    public void menuEmbalador(Embalador embalador) {
        Boolean f = true;
        while (f) {
            System.out.println("----MENU EMBALADOR----");
            System.out.println("1: AGREGAR NUEVO EMBALADOR");
            System.out.println("2: BORRAR UN EMBALADOR");
            System.out.println("3: MOSTRAR LISTADO DE EMBALADORES");
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
                        agregarEmbalador(embalador);
                        break;
                    case 2:
                        borrarEmbalador(embalador);
                        break;
                    case 3:
                        mostrarListadoEmbalador(embalador);
                        break;
                    case 4:
                        guardarDatosEnArchivo(rutaArchivo(), listadoEmbalador);
                        break;
                    case 5:
                        cargarDatosDesdeArchivo(rutaArchivo(), listadoEmbalador);
                        break;
                    default:
                        System.out.println("EL NUMERO INGRESADO NO COINCIDE CON NINGUNA OPCION");
                        break;
                }
            }
        }
    }

    public EmbaladorService() {
        listadoEmbalador = new ArrayList<Embalador>();
    }


    public String rutaArchivo(){
        String f = "C:\\Users\\PC\\IdeaProjects\\INVERNADEROo\\resources\\datos_embalador.txt";
        return f;
    }

    private static void cargarDatosDesdeArchivo(String rutaArchivo, ArrayList<Embalador> listadoElementos) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                Embalador elemento = new Embalador(datos[0], datos[1], Double.parseDouble(datos[2]),
                        Double.parseDouble(datos[3]), Double.parseDouble(datos[4]), Double.parseDouble(datos[5]), datos[6]);
                listadoElementos.add(elemento);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //    String nombre, String apellido, Double dni, Double edad, Double altura, Double precioPorCajon, String fechaHora
    private static void guardarDatosEnArchivo(String rutaArchivo, ArrayList<Embalador> listadoElementos) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(rutaArchivo)))) {
            for (Embalador elemento : listadoElementos) {
                String linea = elemento.getNombre() + "," + elemento.getApellido() + "," +
                        elemento.getDni() + "," + elemento.getEdad() + "," + elemento.getAltura() + "," + elemento.getPrecioPorCajon() + "," +
                        elemento.getFechaHora();
                writer.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}