
package org.example.Ejercicio7;

// Clase principal
public class U2E07 {

    public static void main(String[] args)
            throws InterruptedException {

        // 1. Creamos un hilo con una tarea lambda
        Thread hilo = new Thread(() -> {

            try {
                // 2. Simulamos un trabajo que dura 120 milisegundos
                Thread.sleep(120);

            } catch (InterruptedException e) {

                // Recuperamos la señal de interrupcion
                Thread.currentThread().interrupt();
            }
        });

        // 3. Guardamos el tiempo inicial antes de iniciar el hilo
        long inicio = System.nanoTime();

        // 4. Iniciamos el hilo
        hilo.start();

        // 5. Esperamos a que el hilo termine
        hilo.join();

        // 6. Guardamos el tiempo final
        long fin = System.nanoTime();

        // 7. Calculamos el tiempo transcurrido en nanosegundos
        long nanosegundos = fin - inicio;

        // 8. Convertimos los nanosegundos a milisegundos
        double milisegundos = nanosegundos / 1000000.0;

        // 9. Mostramos el resultado
        System.out.println("Duracion en ms: " + milisegundos);

        // 10. Comprobamos que el hilo ya no está ejecutandose
        if (hilo.isAlive()) {
            throw new AssertionError();
        }
    }
}

