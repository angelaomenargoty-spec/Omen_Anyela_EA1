import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vector = new int[15];

        // 1. Llenar el vector con números entre 10 y 100
        System.out.println("--- 1. Ingreso de datos (15 números entre 10 y 100) ---");
        for (int i = 0; i < vector.length; i++) {
            int numero;
            do {
                System.out.print("Ingrese el valor para la posición [" + i + "]: ");
                numero = scanner.nextInt();
                if (numero < 10 || numero > 100) {
                    System.out.println("-> Número fuera del rango (10 a 100). Intente de nuevo.");
                }
            } while (numero < 10 || numero > 100);
            vector[i] = numero;
        }

        // Mostrar valores ingresados
        System.out.print("\nVector ingresado: [ ");
        for (int num : vector) {
            System.out.print(num + " ");
        }
        System.out.println("]");

        // 2 y 3. Buscar valor, y encontrar Mayor y Menor en un solo ciclo
        System.out.println("\n--- 2 y 3. Búsqueda y valores Mayor/Menor ---");
        System.out.print("Ingrese un número para buscar en el vector: ");
        int numeroBuscar = scanner.nextInt();

        boolean encontrado = false;
        int posEncontrada = -1;
        int mayor = vector[0];
        int menor = vector[0];

        for (int i = 0; i < vector.length; i++) {
            // Evaluación de búsqueda
            if (vector[i] == numeroBuscar && !encontrado) {
                encontrado = true;
                posEncontrada = i;
            }
            // Evaluación de mayor y menor
            if (vector[i] > mayor) {
                mayor = vector[i];
            }
            if (vector[i] < menor) {
                menor = vector[i];
            }
        }

        // Resultados de búsqueda
        if (encontrado) {
            System.out.println("-> El número " + numeroBuscar + " se encuentra en la posición: " + posEncontrada);
        } else {
            System.out.println("-> El número " + numeroBuscar + " NO se encuentra en el vector.");
        }

        // Resultados de Mayor y Menor
        System.out.println("-> El número mayor es: " + mayor);
        System.out.println("-> El número menor es: " + menor);

        // 4. Identificar Múltiplos de un Número X
        System.out.println("\n--- 4. Múltiplos de un número X ---");
        System.out.print("Ingrese el número X para buscar sus múltiplos: ");
        int x = scanner.nextInt();

        boolean hayMultiplos = false;
        System.out.print("Múltiplos de " + x + " en el vector: ");
        for (int num : vector) {
            if (num % x == 0) {
                System.out.print(num + " ");
                hayMultiplos = true;
            }
        }
        if (!hayMultiplos) {
            System.out.println("No hay múltiplos de " + x + " en el vector.");
        } else {
            System.out.println();
        }

        // 5. Calcular la Suma de Todos los Valores
        System.out.println("\n--- 5. Suma Total ---");
        int suma = 0;
        for (int num : vector) {
            suma += num;
        }
        System.out.println("-> La suma de todos los elementos es: " + suma);

        // 6. Nuevo Vector con Valores por Encima del Promedio
        System.out.println("\n--- 6. Números por Encima del Promedio ---");
        double promedio = (double) suma / vector.length;
        System.out.println("-> El promedio es: " + promedio);

        ArrayList<Integer> mayoresPromedio = new ArrayList<>();
        for (int num : vector) {
            if (num > promedio) {
                mayoresPromedio.add(num);
            }
        }

        if (mayoresPromedio.isEmpty()) {
            System.out.println("-> No hay números mayores que el promedio.");
        } else {
            System.out.println("-> Valores por encima del promedio: " + mayoresPromedio);
            System.out.println("-> Cantidad de números por encima del promedio: " + mayoresPromedio.size());
        }

        scanner.close();
    }
}

