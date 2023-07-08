/*

 */

package Service;

/*
 * INVERNADERO
 * Santiago Chiconi, Date: 24/6/2023
 */

import Entity.*;

import java.io.*;
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
        String nom = scanner.nextLine().toLowerCase();

        System.out.println("Ingrese el peso promedio de ´´" + nom + "´´ al punto de cosecha");
        Double pe = scanner.nextDouble();

        System.out.println("Ingrese la altura promedio de ´´" + nom + "´´ al punto de cosecha");
        Double al = scanner.nextDouble();

        System.out.println("Ingrese la anchura promedio de ´´" + nom + "´´ al punto de cosecha");
        Double an = scanner.nextDouble();

        System.out.println("Ingrese el precio unitario de semilla o plantin de ´´" + nom + "´´");
        Double pr = scanner.nextDouble();

        /*String nombre, Double peso, Double altura, Double ancho*/

        verduras = new Verduras(nom, pe, al, an, pr, fe);
        listadoVerduras.add(verduras);
    }

    public void borrarVerduras(Verduras verduras) {
        boolean r = true;
        while (r) {

            scanner.nextLine();
            System.out.println("Desea borrar una verdura? (s/n)");
            String re = scanner.nextLine();

            if (re.equalsIgnoreCase("s")) {
                System.out.println("Ingrese el nombre de la verdura a borrar");
                String ver = scanner.nextLine().toLowerCase();

                for (Verduras list : listadoVerduras) {
                    if (list.getNombre().equalsIgnoreCase(ver)) {
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
            System.out.println("1: AGREGAR NUEVA VERDURA");
            System.out.println("2: BORRAR VERDURA/S");
            System.out.println("3: MOSTRAR LISTADO");
            System.out.println("4: GUARDAR DATOS");
            System.out.println("5: CARGAR DATOS");
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
                    case 4:
                        guardarDatosEnArchivo(rutaArchivo(), listadoVerduras);
                        break;
                    case 5:
                        cargarDatosDesdeArchivo(rutaArchivo(), listadoVerduras);
                        break;
                    case 0:
                        e = 0;
                        break;
                    default:
                        System.out.println("El numero ingresado es incorrecto");
                        break;
                }
            }
        }
    }

    public VerdurasService() {
        listadoVerduras = new ArrayList<Verduras>();
    }
    public String rutaArchivo(){
        String f = "C:\\Users\\PC\\IdeaProjects\\INVERNADEROo\\resources\\datos_verduras.txt";
        return f;
    }
    public void mostrarListadoInsumos(Verduras verduras) {
        for (Verduras elemento : listadoVerduras) {
            System.out.println(elemento.getNombre() + "," + elemento.getPeso() + "," +
                    elemento.getAltura() + "," + elemento.getAncho() + "," +
                    elemento.getPrecioSemilla() + "," + elemento.getFechaHora());
        }
    }
    private static void cargarDatosDesdeArchivo(String rutaArchivo, ArrayList<Verduras> listadoElementos) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
//                String nombre, Double peso, Double altura, Double ancho, Double precioSemilla, String fechaHora
                Verduras elemento = new Verduras(datos[0], Double.parseDouble(datos[1]), Double.parseDouble(datos[2]),
                        Double.parseDouble(datos[3]), Double.parseDouble(datos[4]), datos[5]);
                listadoElementos.add(elemento);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void guardarDatosEnArchivo(String rutaArchivo, ArrayList<Verduras> listadoElementos) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(rutaArchivo)))) {
            for (Verduras elemento : listadoElementos) {

                String linea = elemento.getNombre() + "," + elemento.getPeso() + "," +
                        elemento.getAltura() + "," + elemento.getAncho() + "," +
                        elemento.getPrecioSemilla() + "," + elemento.getFechaHora();
                writer.println(linea);
            }
            System.out.println("LOS DATOS FUERON GUARDADOS CON EXITO");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}