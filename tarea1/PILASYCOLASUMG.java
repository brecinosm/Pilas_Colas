import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PILASYCOLASUMG {
    private static final int NUMERO_DE_NUMEROS = 10000000;
    private static final int RANGO_MINIMO = -50000000;
    private static final int RANGO_MAXIMO = 50000000;

    public static void main(String[] args) {
        generarNumerosAleatorios();
        leerYOrdenarNumeros();
        procesarPila();
        procesarCola();
    }

    public static void generarNumerosAleatorios() {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter("numeros_aleatorios.txt"));

            Random generador = new Random();

            for (int i = 0; i < NUMERO_DE_NUMEROS; i++) {
                int numeroAleatorio = generador.nextInt(RANGO_MAXIMO - RANGO_MINIMO + 1) + RANGO_MINIMO;
                escritor.write(Integer.toString(numeroAleatorio));
                escritor.newLine();
            }

            escritor.close();

            System.out.println("Se han generado y almacenado " + NUMERO_DE_NUMEROS + " números aleatorios en el archivo.");

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void leerYOrdenarNumeros() {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("numeros_aleatorios.txt"));

            ArrayList<Integer> numeros = new ArrayList<>();
            String linea;

            // Leer números del archivo
            while ((linea = lector.readLine()) != null) {
                numeros.add(Integer.parseInt(linea));
            }

            // Ordenar los números
            Collections.sort(numeros);

            BufferedWriter escritorOrdenado = new BufferedWriter(new FileWriter("numeros_aleatorios_ordenados.txt"));

            // Escribir los números ordenados en un nuevo archivo
            for (int numero : numeros) {
                escritorOrdenado.write(Integer.toString(numero));
                escritorOrdenado.newLine();
            }

            lector.close();
            escritorOrdenado.close();

            System.out.println("Se han ordenado y almacenado los números en el archivo 'numeros_aleatorios_ordenados.txt'.");

        } catch (IOException e) {
            System.out.println("Error al leer o escribir en el archivo: " + e.getMessage());
        }
    }

    public static void procesarPila() {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("numeros_aleatorios_ordenados.txt"));

            Stack<Integer> pila = new Stack<>();
            String linea;

            // Leer números del archivo y agregarlos a la pila
            while ((linea = lector.readLine()) != null) {
                pila.push(Integer.parseInt(linea));
            }

            lector.close();

            BufferedWriter escritorPila = new BufferedWriter(new FileWriter("numeros_procesados_pila.txt"));

            // Extraer números de la pila y escribirlos en un nuevo archivo
            while (!pila.isEmpty()) {
                escritorPila.write(Integer.toString(pila.pop()));
                escritorPila.newLine();
            }

            escritorPila.close();

            System.out.println("Se han procesado y almacenado los números de la pila en el archivo 'numeros_procesados_pila.txt'.");

        } catch (IOException e) {
            System.out.println("Error al leer o escribir en el archivo: " + e.getMessage());
        }
    }

    public static void procesarCola() {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("numeros_aleatorios_ordenados.txt"));

            Queue<Integer> cola = new LinkedList<>();
            String linea;

            // Leer números del archivo y agregarlos a la cola
            while ((linea = lector.readLine()) != null) {
                cola.offer(Integer.parseInt(linea));
            }

            lector.close();

            BufferedWriter escritorCola = new BufferedWriter(new FileWriter("numeros_procesados_cola.txt"));

            // Extraer números de la cola y escribirlos en un nuevo archivo
            while (!cola.isEmpty()) {
                escritorCola.write(Integer.toString(cola.poll()));
                escritorCola.newLine();
            }

            escritorCola.close();

            System.out.println("Se han procesado y almacenado los números de la cola en el archivo 'numeros_procesados_cola.txt'.");

        } catch (IOException e) {
            System.out.println("Error al leer o escribir en el archivo: " + e.getMessage());
        }
    }
}
