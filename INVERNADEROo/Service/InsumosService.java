/*

 */

package Service;

/*
 * INVERNADERO
 * Santiago Chiconi, Date: 25/6/2023
 */

import Entity.*;

import java.io.File;
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

        Insumos insumos1 = new Insumos(nom, pre, pe, al, an, can, pro, fe);
        listadoInsumos.add(insumos);
        guardarDatos();
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
        guardarDatos();
    }

    public void mostrarListadoInsumos(Insumos insumos) {
        for (Insumos ls : listadoInsumos) {
            System.out.println(ls);
        }
    }

    public void menuInsumos(Insumos insumos) {
        Boolean f = true;
        while (f) {
            System.out.println("----MENU INSUMOS----");
            System.out.println("1: AGREGAR NUEVO INSUMO");
            System.out.println("2: BORRAR UN INSUMO");
            System.out.println("3: MOSTRAR LISTADO DE INSUMOS");
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
                    default:
                        System.out.println("EL NUMERO INGRESADO NO COINCIDE CON NINGUNA OPCION");
                        break;
                }
            }
        }
    }

    public String obtenerDatosInsumos() {
        StringBuilder datos = new StringBuilder();
        for (Insumos d : listadoInsumos) {
            datos.append(d.toString());
            datos.append(System.lineSeparator());
        }
        return datos.toString();
    }

    public InsumosService() {
        listadoInsumos = new ArrayList<Insumos>();
    }
    private boolean verificarDirectorio(String rutaArchivo) {
        File directorio = new File(rutaArchivo);
        return directorio.exists() && directorio.isDirectory();
    }
    public void guardarDatos() {
        String rutaArchivo = "C:\\Users\\chuPac\\IdeaProjects\\INVERNADEROo\\META-INF\\datos_insumos.txt";
        ArrayList<String> datos = new ArrayList<>();
        datos.add(obtenerDatosInsumos());

        if (verificarDirectorio(rutaArchivo)) {
            GuardarDatos.guardarDatos(rutaArchivo, datos);
        } else {
            System.out.println("La ruta de guardado no es válida.");
        }
    }
    public void cargarDatos() {
        ArrayList<String> datos = GuardarDatos.cargarDatos("datos_insumos.txt");
    }
}