package ListasCircularesDoblementeEnlazadas;

import java.util.Scanner;


public class AplicaListaCircularDobleEnlazada {
    static Scanner entrada = new Scanner(System.in);
    static ListaCircularDoblementeEnlazada listaCircularDoble  = new ListaCircularDoblementeEnlazada();
    
    public static void main(String[] args) {
        menu();
    }
    
    
    static void menu(){
        byte opcion;
        do{
            System.out.println("\nOperaciones de la lista");
            subrayado();
            System.out.println("[1] Recorrido");
            subrayado();
            System.out.println("[2] Insertar Inicio");
            System.out.println("[3] Insertar Final");
            System.out.println("[4] Insertar por Posicion");
            subrayado();
            System.out.println("[5] Eliminar Inicio");
            System.out.println("[6] Eliminar Final");
            System.out.println("[7] Eliminar Por Posicion");
            System.out.println("[8] Eliminar Por Elemento");
            subrayado();
            System.out.println("[9] Buscar Elemento");
            System.out.println("[10] Buscar Por Posicion");
            subrayado();
            System.out.println("[11] Ordenar creciente");
            System.out.println("[12] Ordenar decreciente");
            subrayado();
            System.out.println("[13] Tamaño de la lista");
            System.out.println("[14] Mostrar Pares");
            System.out.println("[15] Mostrar Impares");
            subrayado();
            System.out.println("[0] Salir");
            subrayado();
            System.out.print("\nElige una opcion : ");
            opcion = entrada.nextByte();
            switch(opcion){
                case 1:
                    listaCircularDoble.recorrer();
                    System.out.println("\n");
                    listaCircularDoble.recorrerInverso();
                    break;
                
                case 2:
                    listaCircularDoble.ingresarInicio();
                    break;
                    
                case 3:
                    subrayado();
                    listaCircularDoble.ingresarFinal();
                    subrayado();
                    break;
                    
                case 4:
                    listaCircularDoble.insertarXPosicion(pedirPosicion(),pedirNum());
                    System.out.println("\nSe inserto Elemento...");
                    break;    
//                 
                case 5:
                    listaCircularDoble.eliminarInicio();
                    break;
                    
                case 6:
                    listaCircularDoble.eliminarFianl();
                    break;
                    
                case 7:
                    listaCircularDoble.eliminarPorPosicion(opcion);
                    break;
                    
                case 8:
                    listaCircularDoble.eliminarPorElemento(pedirNum());
                    break;
                    
                case 9:
                    if(listaCircularDoble.buscar(pedirNum()));
                    else System.out.println("No existe ese numero en la lista..");
                    break;
                    
                case 10:
                    if(listaCircularDoble.buscarPos(pedirPosicion()));
                    break;
                    
                case 11:
                    listaCircularDoble.ondenarBurbujaCreciente();
                    break;
                
                case 12:
                    listaCircularDoble.ondenarBurbujaDecreciente();
                    break;
                    
                case 13:
                    System.out.println(listaCircularDoble.getTamaño());
                    break;
                    
                case 14:
                    listaCircularDoble.mostrarPares();
                    break;
                    
                case 15:
                    listaCircularDoble.mostrarImpares();
                    break;
                    
                case 0:
                    System.exit(0);
                    break;
                
                default:System.out.println("**Ingrese opcion valida**");
            }
        }while(opcion != 0);
    }
    
    static void subrayado(){
        System.out.println("------------------------------------");
    }
    
    
    static int pedirNum(){
        int num;
        System.out.print("Ingrese la numero : ");
        num = entrada.nextInt();
        
        return num;
    }
    
    static int pedirPosicion(){
        int pos;
        do{
         System.out.print("Ingrese posicion : ");
        pos = entrada.nextInt();   
        if(pos < 0 || pos>listaCircularDoble.getTamaño()-1) System.out.println("No existe aun esa posicion");
        
        }while(pos < 0 || pos>listaCircularDoble.getTamaño()-1);
        
        return pos;
    }
}
