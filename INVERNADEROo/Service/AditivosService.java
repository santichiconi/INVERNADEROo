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

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AditivosService {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Aditivos> listadoAditivos;
    FechaYHorario fechaYHorario = new FechaYHorario();


    public void agregarAditivo(Aditivos aditivos) {
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

        Aditivos aditivos1 = new Aditivos(nom, pe, pr, al, an, aditivosList, pro, fe);
        listadoAditivos.add(aditivos1);
        guardarDatos();

    }

    public void borrarAditivos(Aditivos aditivos) {
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
        guardarDatos();
    }

    public void mostrarListadoAditivos(Aditivos aditivos) {
        for (Aditivos ls : listadoAditivos) {
            System.out.println(ls);
        }
    }

    public void menuAditivos(Aditivos aditivos) {
        /*String rutaArchivo = new File("datos_aditivos.txt").getAbsolutePath();
        System.out.println("Ruta absoluta del archivo: " + rutaArchivo);*/

        Boolean f = true;
        while (f) {
            System.out.println("----MENU ADITIVOS----");
            System.out.println("1: AGREGAR NUEVO ADITIVO");
            System.out.println("2: BORRAR UN ADITIVO");
            System.out.println("3: MOSTRAR LISTADO DE ADITIVOS");
            System.out.println("4: CARGAR DATOS");
            System.out.println("5: OBTENER LA RUTA DEL ARCHIVO DATOS_ADITIVOS.TXT");
            System.out.println("0: SALIR AL MENU PRINCIPAL");
            System.out.print("Ingrese la opcion con su teclado numerico: ");
            int r = scanner.nextInt();
            if (r == 0) {
                f = false;
            } else {
                switch (r) {
                    case 1:
                        agregarAditivo(aditivos);
                        break;
                    case 2:
                        borrarAditivos(aditivos);
                        break;
                    case 3:
                        mostrarListadoAditivos(aditivos);
                        break;
                    case 4:
                        cardarDatosManualmente();
                        break;
                    case 5:
                        obtenerRutaArchivo();
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

    public String obtenerDatosAditivos() {
        StringBuilder datos = new StringBuilder();
        for (Aditivos d : listadoAditivos) {
            datos.append(d.toString());
            datos.append(System.lineSeparator());
        }
        return datos.toString();
    }

    public AditivosService() {
        listadoAditivos = new ArrayList<Aditivos>();
    }

    private boolean verificarDirectorio(String rutaArchivo) {
        File directorio = new File(rutaArchivo);
        return directorio.exists() && directorio.isDirectory();
    }

    public void guardarDatos() {
        String rutaArchivo = "C:\\Users\\PC\\Desktop\\invernadero-main\\INVERNADEROo\\out\\artifact\\datos_aditivos.txt";
        ArrayList<String> datos = new ArrayList<>();
        datos.add(obtenerDatosAditivos());

        if (verificarDirectorio(rutaArchivo)) {
            System.out.println("La ruta de guardado SI ES VALIDA");
            GuardarDatos.guardarDatos(rutaArchivo, datos);
        } else {
            System.out.println("La ruta de guardado no es válida.");
        }
    }


    public void cardarDatosManualmente() {
        cargarDatos();
    }

    public void cargarDatos() {
        String rutaArchivo = "C:\\Users\\PC\\Desktop\\invernadero-main\\INVERNADEROo\\out\\artifact\\datos_aditivos.txt";

        ArrayList<String> datos = GuardarDatos.cargarDatos(rutaArchivo);
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("datos.txt").getFile());

        for (String dato : datos) {
            // Separar los datos en campos utilizando un delimitador (por ejemplo, coma)
            String[] campos = dato.split(",");

            // Obtener los valores de los campos
            String nombre = campos[0];
            Double peso = Double.parseDouble(campos[1].substring(campos[1].indexOf("=") + 1));
            Double precio = Double.parseDouble(campos[2].substring(campos[2].indexOf("=") + 1));
            Double altura = Double.parseDouble(campos[3].substring(campos[3].indexOf("=") + 1));
            Double anchura = Double.parseDouble(campos[4].substring(campos[4].indexOf("=") + 1));
            ArrayList<String> aditivos = new ArrayList<>(Arrays.asList(campos[5].split(";")));
            String proveedor = campos[6];
            String fechaHora = campos[7];

            // Crear un nuevo objeto Aditivo con los campos correspondientes
            Aditivos aditivo = new Aditivos(nombre, peso, precio, altura, anchura, aditivos, proveedor, fechaHora);

            // Agregar el objeto Aditivo al listadoAditivos
            listadoAditivos.add(aditivo);
        }
    }

    public void obtenerRutaArchivo() {
        // Ruta del archivo datos_aditivos.txt
        String nombreArchivo = "datos_aditivos.txt";
        String rutaDirectorio = System.getProperty("user.dir");
        String rutaArchivo = rutaDirectorio + "/" + nombreArchivo;

        System.out.println(rutaArchivo);
    }



}