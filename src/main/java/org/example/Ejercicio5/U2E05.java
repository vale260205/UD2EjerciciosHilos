package org.example.Ejercicio5;

//Creamos una clase que hereda de Thread
class IdentidadE05 extends Thread {

    //Constructor: asignamos el nombre A al hilo
    IdentidadE05() {
        super("A");
    }
    //Sobreescribimos el metodo run()
    @Override
    public void run() {

        //Mostramos el nombre Thread y el nombre del hilo que ejecuta
        //realmente el código
        System.out.println("Objeto: " + getName() + "; ejecuta: "
                            + Thread.currentThread().getName());
    }
}

//Clase principal
public class U2E05 {
    static void main(String[] args) throws InterruptedException {

        //1. Creamos un hilo, pero todavía no lo iniciamos
        Thread hilo = new IdentidadE05();

        //2. Consultamos su estado inicial
        System.out.println(hilo.getState());

        //3. Esto no inicia un nuevo
        hilo.run();

        //4. Comprobamos que sigue en estado NEW
        if (hilo.getState() != Thread.State.NEW) throw new AssertionError();

        //5. Mostramos el estado despues de llamar a run()
        System.out.println("Tras run directo: " + hilo.getState());

        //6. Ahora si iniciamos un nuevo hilo
        hilo.start();

        //7. Esperamos a que termine
        hilo.join();

        //8. Comprobamos que el hilo ha terminado
        if (hilo.getState() != Thread.State.TERMINATED) throw new AssertionError();

        //9. Mostramos el estado final
        System.out.println(hilo.getState());
    }
}
