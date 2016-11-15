
/**
 * Declaracion de la clase generica NodoRepetido que extiende de la clase Comparable 
 * @author Jiménez Pérez Pedro, Alonso González Alejandro Javier, Azcona González José Antonio, Chávez Aquino Daniel Felipe
 * @version 14/11/2016
 */
public class NodoRepetido<T extends Comparable<T>>{
    //Declaracion de atributos 
    T dato;
    private NodoRepetido abajo;
    /**
     * Constructor de la clase NodoRepetido
     * @param per Es un parametro de tipo T que es un dato
     * @param nodo Es un parametro de tipo NodoRepetido
     */
    public NodoRepetido(T per,NodoRepetido nodo){
        dato=per;
        abajo=nodo;
    }
    /**
     * Metodo del dato y no devuelve nada
     */
    public void setDato(T p){dato=p;}
    /**
     * Metodo que devuelve el dato
     * @return Un dato
     */
    public T getDato(){return dato;}
    /**
     * Metodo del NodoRepetido y no devuelve nada
     */
    public void setAbajo(NodoRepetido nodo){abajo=nodo;}
    /**
     * Metodo que devuelve el NodoRepetido
     * @return Un nodo repetido llamado abajo
     */
    public NodoRepetido getAbajo(){return abajo;}
}
