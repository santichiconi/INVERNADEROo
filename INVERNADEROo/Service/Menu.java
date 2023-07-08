/*

 */

package Service;

/*
 * INVERNADERO
 * Santiago Chiconi, Date: 24/6/2023
 */

import Entity.*;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Aditivos aditivos = new Aditivos();
    Verduras verduras = new Verduras();
    Insumos insumos = new Insumos();
    Empleados empleados = new Empleados();
    Embalador embalador = new Embalador();
    VerdurasService verdurasService = new VerdurasService();
    AditivosService aditivosService = new AditivosService();
    InsumosService insumosService = new InsumosService();
    EmpleadosService empleadosService = new EmpleadosService();
    EmbaladorService embaladorService = new EmbaladorService();


    public void menu(Menu menu) {
        Boolean m = true;
        while (m) {
            System.out.println("----MENU PRINCIPAL----");
            System.out.println("1: MENU VERDURAS");
            System.out.println("2: MENU ADITIVOS");
            System.out.println("3: MENU INSUMOS");
            System.out.println("4: MENU EMPLEADOS");
            System.out.println("5: MENU EMBALADORES");
            System.out.println("0: SALIR");
            System.out.print("Ingrese la opcion con su teclado numerico: ");
            int e = scanner.nextInt();
            switch (e) {

                case 1:
                    verdurasService.menuVerduras(verduras);
                    break;
                case 2:
                    aditivosService.menuAditivos(aditivos);
                    break;
                case 3:
                    insumosService.menuInsumos(insumos);
                    break;
                case 4:
                   empleadosService.menuEmpleados(empleados);
                   break;
                case 5:
                    embaladorService.menuEmbalador(embalador);
                    break;
                case 0:
                    m = false;
                    break;
                default:
                    System.out.println("EL NUMERO INGRESADO NO COINCIDE CON NINGUNA OPCION, INTENTE NUEVAMENTE");
                    break;
            }

        }
    }
}