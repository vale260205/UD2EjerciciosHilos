package org.example.Ejercicio2;

//Clase que hereda de Thread
class SaludoE02 extends Thread {

    //Constructor de nuestra clase
        SaludoE02(String nombre)

        //Enviamos el nombre al constructor de Thread
        {super(nombre);}

    //Sobreescribo el metodo run()
    @Override public void run() {
         //Mostramos un saludo indicando que hilo lo ejecuta
        System.out.println("Hola desde: " + Thread.currentThread().getName());
    }
}

//Clase principal del programa
public class U2E02 {
    static void main(String[] args) throws InterruptedException {

        //Creamos el primer hilo con el nombre Ana
        Thread ana = new SaludoE02("Ana");

        //Creamos el segundo hilo con el nombre Bruno
        Thread bruno = new SaludoE02("Bruno");

        //Iniciamos el primer hilo
        ana.start();

        //Iniciamos el segundo hijo
        bruno.start();

        //Espero a que el primer hilo termine
        ana.join();

        //Espero que el segundo hilo termine
        bruno.join();

        System.out.println("Ambos terminados");

    }
}
