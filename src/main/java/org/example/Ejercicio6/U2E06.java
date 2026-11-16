
package org.example.Ejercicio6;

// Clase principal
public class U2E06 {

    public static void main(String[] args)
            throws InterruptedException {

        // 1. Creamos un array de 4 posiciones
        // Cada posicion guardara las iteraciones de un hilo
        int[] iteraciones = new int[4];

        // 2. Creamos un array para guardar los 4 hilos
        Thread[] hilos = new Thread[4];

        // 3. Bucle que crea los cuatro hilos
        for (int i = 0; i < hilos.length; i++) {

            // Guardamos el identificador del hilo
            // final permite utilizarlo dentro de la lambda
            final int id = i;

            // 4. Creamos un nuevo hilo con una tarea lambda
            hilos[i] = new Thread(() -> {

                // Cada hilo realiza 5 iteraciones
                for (int n = 1; n <= 5; n++) {

                    // Aumentamos el contador de su posicion
                    iteraciones[id]++;

                    // Mostramos el identificador y la iteracion
                    System.out.println("Hilo-" + id + ": " + n);
                }

            }, "Hilo-" + id);

            // 5. Iniciamos el hilo
            hilos[i].start();
        }

        // 6. Esperamos a que terminen los cuatro hilos
        for (Thread hilo : hilos) {
            hilo.join();
        }

        // 7. Creamos una variable para acumular el total
        int total = 0;

        // 8. Recorremos el array y sumamos sus valores
        for (int n : iteraciones) {
            total += n;
        }

        // 9. Comprobamos que se han realizado 20 iteraciones
        if (total != 20) {
            throw new AssertionError(total);
        }

        // 10. Mostramos el resultado final
        System.out.println("Total: " + total);
    }
}

