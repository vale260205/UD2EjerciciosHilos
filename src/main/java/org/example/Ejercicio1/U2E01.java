package org.example.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class U2E01 {
    static void main(String[] args) {
        //Obtiene el hilo que está ejecutando este código ahora mismo.
        Thread actual = Thread.currentThread();

        //Imprime el nombre de ese hilo, por ejemplo Ejecuta: main
        System.out.println("Ejecuta: " + actual.getName());

        //Crea un objeto ArrayList vacio en memoria (el heap) y guarda en lista una referencia a él,
        //es decir la dirección donde está
        List<String> lista = new ArrayList<>();

        //No crea una lista nueva. Copia la referencia, así que referenciaA apunta al mismo objeto
        //que lista
        List<String> referenciaA = lista;

        //Igual que la anterior: ahora hay tres variables(lista, referenciaA, referenciaB) apuntando a
        //un único objeto
        List<String> referenciaB = lista;

        //Añade "Ana" al objeto al que apunta referenciaA. Como es el mismo objeto para las tres variables,
        //el cambio se ve desde todas
        referenciaA.add("Ana");

        //Compueba con != si las referencias son distintas. Como apuntan al mismo objeto, la condición es
        //falsa y no se lanza nada
        if (referenciaA != referenciaB) throw new AssertionError();

        //Se comparan con el operador == se compara la referencia si son de los mismos objetos 
        System.out.println("Mismo objetivo: " + (referenciaA == referenciaB));
        System.out.println("Vista desde B: " + referenciaB);
    }
}
