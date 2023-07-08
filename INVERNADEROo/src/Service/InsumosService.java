/*

 */

package Service;

/*
 * INVERNADERO
 * Santiago Chiconi, Date: 25/6/2023
 */

import Entity.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.IntUnaryOperator;

public class InsumosService {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Insumos> listadoInsumos = new ArrayList<>();
    FechaYHorario fechaYHorario = new FechaYHorario();






    public void agregarInsumos(Insumos insumos) {

        String fe = fechaYHorario.fechaYhora(fechaYHorario);
        scanner.nextLine();

        System.out.println("Ingrese el nombre del insumo");
        String nom = scanner.nextLine();

        System.out.println("Ingrese el precio en pesos del aditivo");
        Double pre = scanner.nextDouble();

        System.out.println("Ingrese el peso en KG del pack");
        Double pe = scanner.nextDouble();

        System.out.println("Ingrese la altura en CM del pack");
        Double al = scanner.nextDouble();

        System.out.println("Ingrese la anchura en CM del pack");
        Double an = scanner.nextDouble();

        System.out.println("Ingrese la cantidad de unidades por pack");
        Double can = scanner.nextDouble();

        System.out.println("Ingrese el proveedor");
        String pro = scanner.nextLine();

        insumos = new Insumos(nom, pre, pe, al, an, can, pro, fe);
        listadoInsumos.add(insumos);
    }

    public void borrarInsumos(Insumos insumos) {
        Boolean m = true;
        while (m) {

            scanner.nextLine();
            System.out.print("Desea borrar un insumo?(s/n): ");
            String r = scanner.nextLine();

            if (r.equalsIgnoreCase("s")) {
                System.out.print("Ingrese el nombre del insumo a borrar: ");
                String nom = scanner.nextLine();

                for (Insumos list : listadoInsumos) {
                    if (list.getNombre().equalsIgnoreCase(nom)) {
                        System.out.println("Se borró ´´" + nom + "´´");
                        listadoInsumos.remove(list);
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

    public void menuInsumos(Insumos insumos) {
        Boolean f = true;
        while (f) {
            System.out.println("----MENU INSUMOS----");
            System.out.println("1: AGREGAR NUEVO INSUMO");
            System.out.println("2: BORRAR UN INSUMO");
            System.out.println("3: MOSTRAR LISTADO DE INSUMOS");
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
                        agregarInsumos(insumos);
                        break;
                    case 2:
                        borrarInsumos(insumos);
                        break;
                    case 3:
                        mostrarListadoInsumos(insumos);
                        break;
                    case 4:
                        guardarDatosEnArchivo(rutaArchivo(insumos), listadoInsumos);
                        break;
                    case 5:
                        cargarDatosDesdeArchivo(rutaArchivo(insumos), listadoInsumos);
                        break;
                    default:
                        System.out.println("EL NUMERO INGRESADO NO COINCIDE CON NINGUNA OPCION");
                        break;
                }
            }
        }
    }

    public InsumosService() {
        listadoInsumos = new ArrayList<Insumos>();
    }
    public String rutaArchivo(Insumos insumos){
        String f = "C:\\Users\\PC\\IdeaProjects\\INVERNADEROo\\resources\\datos_insumos.txt";
        return f;
    }
    public void mostrarListadoInsumos(Insumos insumos) {
        for (Insumos elemento : listadoInsumos) {
            System.out.println(elemento.getNombre() + "," + elemento.getPrecio() + "," +
                    elemento.getPeso() + "," + elemento.getAlturaPack() + "," +
                    elemento.getAnchuraPack() + "," + elemento.getCantidadPorPack() + "," +
                    elemento.getProveedor() + "," + elemento.getFechaHora());
        }
    }
    private static void cargarDatosDesdeArchivo(String rutaArchivo, ArrayList<Insumos> listadoElementos) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                Insumos elemento = new Insumos(datos[0], Double.parseDouble(datos[1]), Double.parseDouble(datos[2]),
                        Double.parseDouble(datos[3]), Double.parseDouble(datos[4]), Double.parseDouble(datos[5]), datos[6], datos[7]);
                listadoElementos.add(elemento);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void guardarDatosEnArchivo(String rutaArchivo, ArrayList<Insumos> listadoElementos) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(rutaArchivo)))) {
            for (Insumos elemento : listadoElementos) {
                String linea = elemento.getNombre() + "," + elemento.getPrecio() + "," +
                        elemento.getPeso() + "," + elemento.getAlturaPack() + "," +
                        elemento.getAnchuraPack() + "," + elemento.getCantidadPorPack() + "," +
                        elemento.getProveedor() + "," + elemento.getFechaHora();
                writer.println(linea);
            }
            System.out.println("LOS DATOS FUERON GUARDADOS CON EXITO");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}