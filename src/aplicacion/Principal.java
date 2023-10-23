package aplicacion;

import negocio.Coche;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Clase Principal que contiene el punto de entrada del programa.
 */
public class Principal {
    /**
     * Método principal que ejecuta el programa de gestión de coches.
     * @param args Los argumentos de línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean salir = false;

        while (!salir) {
            pausar();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("1. Ver contenido del fichero");
            System.out.println("2. Agregar un coche");
            System.out.println("3. Modificar un coche");
            System.out.println("4. Eliminar un coche");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");

            int opcion = scanner.nextInt();

            if (opcion == 1) {
                mostrarContenido();
            } else if (opcion == 2) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("fichero.txt", true))) {
                    System.out.print("Marca: ");
                    scanner.nextLine();
                    String marcaa = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ano: ");
                    int ano = scanner.nextInt();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    writer.write("Marca: " + marcaa + ", Modelo: " + modelo + ", A\u00f1o: " + ano + ", Precio: $" + precio);
                    writer.newLine();
                    System.out.println("Coche a\u00f1adido al fichero.");
                } catch (IOException e) {
                    System.err.println(e);
                    salir = true;
                }
            } else if (opcion == 3) {
                mostrarContenido();
                try {
                    System.out.print("Ingrese la marca del coche que desea modificar: ");
                    scanner.nextLine();
                    String marcaAModificar = scanner.nextLine();
                    System.out.print("Ingrese el modelo del coche que desea modificar: ");
                    String modeloAModificar = scanner.nextLine();
                    List<String> lineas = Files.readAllLines(Paths.get("fichero.txt"));
                    BufferedWriter writer = new BufferedWriter(new FileWriter("fichero.txt"));

                    for (String linea : lineas) {
                        if (linea.contains("Marca: " + marcaAModificar + ", Modelo: " + modeloAModificar)) {
                            System.out.print("Nueva marca: ");
                            String nuevaMarca = scanner.nextLine();
                            System.out.print("Nuevo modelo: ");
                            String nuevoModelo = scanner.nextLine();
                            System.out.print("Nuevo a\u00f1o:");
                            int nuevoAno = scanner.nextInt();
                            System.out.print("Nuevo precio:");
                            int nuevoPrecio = scanner.nextInt();
                            linea = "Marca: " + nuevaMarca + ", Modelo: " + nuevoModelo + ", A\u00f1o: " + nuevoAno + ", Precio: " + nuevoPrecio;
                        }
                        writer.write(linea);
                        writer.newLine();
                    }

                    writer.close();
                    System.out.println("Coche modificado en el fichero.");
                } catch (IOException e) {
                    System.err.println("Error al escribir en el archivo");
                    salir = true;
                }
            } else if (opcion == 4) {
                mostrarContenido();

                System.out.print("Ingrese la marca del coche que desea eliminar: ");
                scanner.nextLine();
                String marcaAEliminar = scanner.nextLine();
                System.out.print("Ingrese el modelo del coche que desea eliminar: ");
                String modeloAEliminar = scanner.nextLine();
                try {
                    List<String> lineas = Files.readAllLines(Paths.get("fichero.txt"));
                    BufferedWriter writer = new BufferedWriter(new FileWriter("fichero.txt"));

                    for (String linea : lineas) {
                        if (!linea.contains("Marca: " + marcaAEliminar + ", Modelo: " + modeloAEliminar)) {
                            writer.write(linea);
                            writer.newLine();
                        }
                    }
                    writer.close();
                    System.out.println("Coche eliminado del fichero.");
                } catch (IOException e) {
                    System.err.println("Error");
                }
            } else if (opcion == 5) {
                salir = true;
                System.out.println("Saliendo del programa");
            } else {
                System.out.println("Opcion invalida, saliendo del programa");
                salir = true;
            }
        }
    }

    /**
     * Método para mostrar el contenido del fichero "fichero.txt".
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public static void mostrarContenido() {
        try {
            List<String> lineas = Files.readAllLines(Paths.get("fichero.txt"));
            lineas.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    /**
     * Método para pausar la ejecución y esperar a que el usuario presione Enter.
     * @throws IOException Si ocurre un error al leer la entrada del usuario.
     */
    public static void pausar() {
        System.out.println("\n\nPresione Enter para continuar...");

        try {
            System.in.read();
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
