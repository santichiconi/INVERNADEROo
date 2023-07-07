/*

 */

package Service;

/*
 * INVERNADERO
 * Santiago Chiconi, Date: 24/6/2023
 */

import Entity.Aditivos;
import Entity.FechaYHorario;
import Entity.GuardarDatos;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AditivosService {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Aditivos> listadoAditivos = new ArrayList<>();

    public void setListadoAditivos(ArrayList<Aditivos> listadoAditivos) {
        this.listadoAditivos = listadoAditivos;
    }

    FechaYHorario fechaYHorario = new FechaYHorario();


    public void agregarAditivo(Aditivos aditivos1) {
        String fe = fechaYHorario.fechaYhora(fechaYHorario);
        scanner.nextLine();
        System.out.print("Ingrese el nombre del aditivo: ");
        String nom = scanner.next();

        System.out.print("Ingrese el peso unitario en KG de ´´" + nom + "´´: ");
        Double pe = scanner.nextDouble();

        System.out.print("Ingrese el precio unitario de ´´" + nom + "´´: ");
        Double pr = scanner.nextDouble();

        System.out.print("Ingrese la altura en CM de ´´" + nom + "´´: ");
        Double al = scanner.nextDouble();

        System.out.print("Ingrese la anchura en CM de ´´" + nom + "´´: ");
        Double an = scanner.nextDouble();

        ArrayList<String> aditivosList = new ArrayList<>();
        Boolean m = true;
        while (m) {
            scanner.nextLine();
            System.out.print("¿Desea agregar un aditivo con sus contenidos quimicos?(s/n): ");
            String r = scanner.nextLine();
            if (r.equalsIgnoreCase("n")) {
                m = false;
            } else {
                System.out.print("Ingrese el/los contenidos del ´´" + nom + "´´: ");
                String re = scanner.next();
                aditivosList.add(re);
            }
        }

        System.out.print("Ingrese el proveedor de ´´" + nom + "´´: ");
        String pro = scanner.nextLine();

        aditivos1 = new Aditivos(nom, pe, pr, al, an, aditivosList, pro, fe);
        listadoAditivos.add(aditivos1);

    }

    public void borrarAditivos(Aditivos aditivos1) {
        Boolean m = true;
        while (m) {

            scanner.nextLine();
            System.out.print("Desea borrar un aditivo?(s/n): ");
            String r = scanner.nextLine();

            if (r.equalsIgnoreCase("s")) {
                System.out.print("Ingrese el nombre del aditivo a borrar: ");
                String nom = scanner.nextLine();

                for (Aditivos list : listadoAditivos) {
                    if (list.getNombre().equalsIgnoreCase(nom)) {
                        System.out.println("Se borró ´´" + nom + "´´");
                        listadoAditivos.remove(list);
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

    public void mostrarListadoAditivos(Aditivos aditivos1) {
        for (Aditivos ls : listadoAditivos) {
            System.out.println(ls);
        }
    }

    public void menuAditivos(Aditivos aditivos1) {
        String rutaArchivo = "C:\\Users\\PC\\IdeaProjects\\INVERNADEROo\\resources\\datos_aditivos.txt";

        Boolean f = true;
        while (f) {
            System.out.println("----MENU ADITIVOS----");
            System.out.println("1: AGREGAR NUEVO ADITIVO");
            System.out.println("2: BORRAR UN ADITIVO");
            System.out.println("3: MOSTRAR LISTADO DE ADITIVOS");
            System.out.println("4: CARGAR DATOS");
            System.out.println("5: GUARDAR DATOS EN ARCHIVO");
            System.out.println("0: SALIR AL MENU PRINCIPAL");
            System.out.print("Ingrese la opcion con su teclado numerico: ");
            int r = scanner.nextInt();
            if (r == 0) {
                f = false;
            } else {
                switch (r) {
                    case 1:
                        agregarAditivo(aditivos1);
                        break;
                    case 2:
                        borrarAditivos(aditivos1);
                        break;
                    case 3:
                        mostrarListadoAditivos(aditivos1);
                        break;
                    case 4:
                        cargarDatosDesdeArchivo(rutaArchivo, listadoAditivos);
                        break;
                    case 5:
                        guardarDatosEnArchivo(rutaArchivo, listadoAditivos);
                        break;
                    default:
                        System.out.println("EL NUMERO INGRESADO NO COINCIDE CON NINGUNA OPCION");
                        break;
                }
            }
        }
    }

    public ArrayList<Aditivos> getListadoAditivos() {
        return listadoAditivos;
    }

    public AditivosService() {
        listadoAditivos = new ArrayList<Aditivos>();
    }


    public void obtenerRutaArchivo() {
        // Ruta del archivo datos_aditivos.txt
        String nombreArchivo = "datos_aditivos.txt";
        String rutaDirectorio = System.getProperty("user.dir");
        String rutaArchivo = rutaDirectorio + "/" + nombreArchivo;

        System.out.println(rutaArchivo);
    }



    public void fer() {
        String rutaArchivo = "C:\\Users\\PC\\IdeaProjects\\INVERNADEROo\\resources\\datos_aditivos.txt";

        // Cargar datos desde el archivo al ArrayList
        cargarDatosDesdeArchivo(rutaArchivo, listadoAditivos);


        // Guardar los cambios en el archivo
        guardarDatosEnArchivo(rutaArchivo, listadoAditivos);
    }

    private static void cargarDatosDesdeArchivo(String rutaArchivo, ArrayList<Aditivos> listadoElementos) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Dividir la línea en los datos individuales utilizando algún formato (por ejemplo, CSV)
                String[] datos = linea.split(",");

                // Crear una instancia de Elemento con los datos y agregarla al ArrayList
                Aditivos elemento = new Aditivos(datos[0], Double.parseDouble(datos[1]), Double.parseDouble(datos[2]),
                        Double.parseDouble(datos[3]), Double.parseDouble(datos[4]), new ArrayList<>(), datos[6], datos[7]);
                listadoElementos.add(elemento);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void guardarDatosEnArchivo(String rutaArchivo, ArrayList<Aditivos> listadoElementos) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(rutaArchivo)))) {
            // Recorre el ArrayList y escribe cada elemento en una línea del archivo
            for (Aditivos elemento : listadoElementos) {
                String linea = elemento.getNombre() + "," + elemento.getPeso() + "," + elemento.getPrecio() + "," +
                        elemento.getAltura() + "," + elemento.getAnchura() + ",," + elemento.getProveedor() + "," +
                        elemento.getFechaHora();
                writer.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}