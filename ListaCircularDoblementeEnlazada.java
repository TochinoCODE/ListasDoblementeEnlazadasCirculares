package ListasCircularesDoblementeEnlazadas;

import java.util.Random;

public class ListaCircularDoblementeEnlazada {

    private Nodo cabeza;
    private Nodo cola;
    private int tamaño;
    final Random r = new Random();

    public ListaCircularDoblementeEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
    }

    public ListaCircularDoblementeEnlazada(int valor) {

    }

    public int getTamaño() {
        return tamaño;
    }

    public int crearAleatorio() {
        int valor = (int) r.nextInt(91) + 10;
        return valor;
    }

    public boolean estaVacio() {
        return cabeza == null;
    }

    public void ingresarInicio() {
        Nodo nuevo = new Nodo(crearAleatorio());
        if (estaVacio()) {
            cabeza = nuevo;
            cabeza.setAnterior(cabeza);
            cabeza.setAnterior(cola);
            cola = nuevo;
        } else {
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
            cabeza.setAnterior(cola);
            cola.setSiguiente(cabeza);
        }
        System.out.println("\nIngresado...");
        tamaño++;
    }

    public void ingresarFinal() {
        Nodo nuevo = new Nodo(crearAleatorio());
        if (estaVacio()) {
            cabeza = nuevo;
            cabeza.setSiguiente(cola);
            cola = cabeza;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            nuevo.setSiguiente(cabeza);
            cola = nuevo;
            cabeza.setAnterior(cola);
        }
        System.out.println("\nIngresado...");
        tamaño++;
    }

    public void recorrer() {
        int contador = 0;
        Nodo temp = cabeza;
        while (contador < tamaño) {
            System.out.print(temp.getValor() + " <-> ");
            temp = temp.getSiguiente();
            contador++;
        }

//        do {
//            System.out.print(temp.getValor()+" ->");
//            temp = temp.getSiguiente();
//            contador++;
//        }while (contador < tamaño);
    }

    public void recorrerInverso() {
        int contador = 0;
        Nodo temp = cola;
        while (contador < tamaño) {
            System.out.print(" <-> " + temp.getValor());
            temp = temp.getAnterior();
            contador++;
        }
    }

    public void insertarXPosicion(int pos, int newDato) {
        int contador = 0;
        Nodo nuevo = new Nodo(newDato);//creamos un nodo nuevo con el valor que el usuario quiere ingresar
        Nodo temp = cabeza;
        if (estaVacio()) {
            System.out.println("**Lista Vacia**");
        } else if (pos == 0) {
            ingresarInicio();
        } else if (pos == tamaño) {
            ingresarFinal();
        } else {
            while (contador < tamaño) { //Recorremos la lista
                if (contador == pos - 1) { //Cogemos una poscion antes de la mencionada por el usuario
                    //enlazamos con la siguiente posicion
                    nuevo.setSiguiente(temp.getSiguiente());
                    temp.getSiguiente().setAnterior(nuevo);

                    //Enlazamos con la anterior posicion
                    temp.setSiguiente(nuevo);
                    nuevo.setAnterior(temp);
                    tamaño++;
                }
                temp = temp.getSiguiente();
                contador++;
            }
        }
    }

    public void eliminarInicio() {
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else {
            System.out.println("Se elimino el numero : " + cabeza.getValor());
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(cola);
            cola.setSiguiente(cabeza);
            tamaño--;
        }
    }

    public void eliminarFianl() {
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else {
            System.out.println("Se elimino el numero : " + cola.getValor());
            cola.getAnterior().setSiguiente(cabeza);
            cabeza.setAnterior(cola.getAnterior());
            cola = cola.getAnterior();
            tamaño--;
        }
    }

    public void eliminarPorPosicion(int pos) {
        int contador = 0;
        Nodo temp = cabeza;
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else if (pos == 0) {
            eliminarInicio();
        } else if (pos == tamaño - 1) {
            eliminarFianl();
        } else {
            while (contador < tamaño) {
                if (contador == pos) {
                    System.out.println("Se elimino el numero : " + temp.getValor());
                    temp.getAnterior().setSiguiente(temp.getSiguiente());
                    temp.getSiguiente().setAnterior(temp.getAnterior());
                    tamaño--;
                }
                temp = temp.getSiguiente();
                contador++;
            }
        }
    }

    public void eliminarPorElemento(int num) {
        int contador = 0;
        Nodo temp = cabeza;
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else if (cabeza.getValor() == num) {
            eliminarInicio();
        } else {
            while (contador < tamaño) {
                if (temp.getValor() == num) {
                    System.out.println("Se elimino el numero : " + temp.getValor());
                    temp.getAnterior().setSiguiente(temp.getSiguiente());
                    temp.getSiguiente().setAnterior(temp.getAnterior());
                    tamaño--;
                    break;
                }
                temp = temp.getSiguiente();
                contador++;
            }
        }
    }

    public boolean buscar(int elemento) {
        int contador = 0;
        Nodo temp = cabeza;
        if (estaVacio()) {
            System.out.println("**Lista esta vacia**");
        } else {
            while (contador < tamaño) {
                if (temp.getValor() == elemento) {
                    System.out.println(temp.getValor() + " esta en la posicion " + contador);
                    return true;
                }
                temp = temp.getSiguiente();
                contador++;
            }
        }
        return false;
    }

    public boolean buscarPos(int pos) {
        int contador = 0;
        Nodo temp = cabeza;
        if (estaVacio()) {
            System.out.println("**Lista esta vacia**");
        } else {
            while (contador < tamaño) {
                if (pos == contador) {
                    System.out.println(temp.getValor() + " esta en la posicion " + contador);
                    return true;
                }
                temp = temp.getSiguiente();
                contador++;
            }
        }
        return false;
    }

    public void ondenarBurbujaCreciente() {
        Nodo temp = cabeza;
        Nodo aux = new Nodo();
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else {
            for (int i = 0; i < (tamaño - 1); i++) {
                for (int j = 0; j < (tamaño - 1); j++) {
                    if (temp.getValor() > temp.getSiguiente().getValor()) {//si numeroActual es mayor al numeroSiguiente
                        //cambio
                        //guardamos en aux el dato del snumeroSigueine
                        aux.setValor(temp.getSiguiente().getValor());

                        //a numeroSiguiente asignamos el valor del numeroActual
                        temp.getSiguiente().setValor(temp.getValor());

                        //a numeroActual asignamos el valor del numeroSiguiente
                        temp.setValor(aux.getValor());
                    }
                    temp = temp.getSiguiente();
                }
                temp = cabeza;
            }
            System.out.println("Se logro el ordenamiento...");
        }
    }

    public void ondenarBurbujaDecreciente() {
        Nodo temp = cabeza;
        Nodo aux = new Nodo();
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else {
            for (int i = 0; i < (tamaño - 1); i++) {
                for (int j = 0; j < (tamaño - 1); j++) {
                    if (temp.getValor() < temp.getSiguiente().getValor()) {//si numeroActual es mayor al numeroSiguiente
                        //cambio
                        //guardamos en aux el dato del snumeroSigueine
                        aux.setValor(temp.getSiguiente().getValor());

                        //a numeroSiguiente asignamos el valor del numeroActual
                        temp.getSiguiente().setValor(temp.getValor());

                        //a numeroActual asignamos el valor del numeroSiguiente
                        temp.setValor(aux.getValor());
                    }
                    temp = temp.getSiguiente();
                }
                temp = cabeza;
            }
            System.out.println("Se logro el ordenamiento...");
        }
    }

    public void mostrarPares() {
        int accountant = 0;
        Nodo temp = cabeza;
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else {
            System.out.println("\nElementos pares : ");
            while (accountant < tamaño) {
                if (temp.getValor() % 2 == 0) {
                    System.out.print(" <-> " + temp.getValor());
                }
                temp = temp.getAnterior();
                accountant++;
            }
        }
    }
    
    public void mostrarImpares() {
        int accountant = 0;
        Nodo temp = cabeza;
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else {
            System.out.println("\nElementos impares : ");
            while (accountant < tamaño) {
                if (temp.getValor() % 2 != 0) {
                    System.out.print(" <-> " + temp.getValor());
                }
                temp = temp.getAnterior();
                accountant++;
            }
        }
    }
}
