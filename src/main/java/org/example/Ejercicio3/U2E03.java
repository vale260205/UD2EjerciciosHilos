package org.example.Ejercicio3;

//Runnable representa un trabajo y exige un único metodo abstracto
class SaludoE03 implements Runnable {

    //Sobreescribo el metodo de run
    @Override public void run() {

        //Mostramos el nombre del hilo que se esta ejecutando
        System.out.println("Trabaja " + Thread.currentThread().getName());
    }
}

public class U2E03 {
    static void main(String[] args) throws InterruptedException {
        //1. Creamos la tarea
        Runnable tarea = new SaludoE03();

        //2. Creamos un hilo y le entregamos la tarea
        //El hilo tendrá el nombre Ana
       Thread hilo = new Thread(tarea,"Ana");

       //3.Iniciamos el hilo
       hilo.start();

       //Esperamos a que el hilo termine
       hilo.join();

       //Muestro el mensaje final
        System.out.println("Fin corfirmado");
    }
}
