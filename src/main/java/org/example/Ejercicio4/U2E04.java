package org.example.Ejercicio4;

// PRIMERA FORMA: crear una clase que implementa Runnable
class Aviso04 implements Runnable {

    // Sobrescribimos el metodo run()
    @Override
    public void run() {

        // Mostramos el nombre del hilo que ejecuta la tarea
        System.out.println(Thread.currentThread().getName());
    }
}

// Clase principal
public class U2E04 {

    public static void main(String[] args)
            throws InterruptedException {

        // 1. TAREA CON CLASE: creamos un objeto de nuestra clase Aviso04
        Runnable conClase = new Aviso04();

        // 2. TAREA CON CLASE ANONIMA: creamos Runnable directamente
        Runnable anonima = new Runnable() {

            // Implementamos el metodo run()
            @Override
            public void run() {

                // Mostramos el nombre del hilo ejecutor
                System.out.println(Thread.currentThread().getName());
            }
        };

        // 3. TAREA CON LAMBDA: forma abreviada de implementar run()
        Runnable lambda = () ->
                System.out.println(Thread.currentThread().getName());

        // Avisamos de que las tres tareas ya están preparadas
        // Todavía no se ha iniciado ningún hilo
        System.out.println("Tres tareas preparadas");

        // 4. Creamos un hilo para cada tarea y asignamos nombres
        Thread a = new Thread(conClase, "Clase");
        Thread b = new Thread(anonima, "Anonima");
        Thread c = new Thread(lambda, "Lambda");

        // 5. Iniciamos los tres hilos
        a.start();
        b.start();
        c.start();

        // 6. Esperamos a que terminen los tres hilos
        a.join();
        b.join();
        c.join();
    }
}
