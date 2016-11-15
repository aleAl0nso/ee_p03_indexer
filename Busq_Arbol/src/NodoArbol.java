
/**
 * Declaracion de la clase generica NodoArbol que extiende de la clase Comparable 
 * @author Jim�nez P�rez Pedro, Alonso Gonz�lez Alejandro Javier, Azcona Gonz�lez Jos� Antonio, Ch�vez Aquino Daniel Felipe
 * @version 14/11/2016
 */
public class NodoArbol<T extends Comparable<T>>{
    //Declaracion de los atributos privados
    private T dato;
    private NodoArbol izq,der;
    private NodoRepetido abajo;
    private int fe;
    /**
     * Creacion del constructor
     * @param d �ste parametro es el dato del Nodo
     * @param a �ste parametro es el apuntador izquierdo del Nodo
     * @param s �ste parametro es el apuntador derecho del Nodo
     * @param ab �ste parametro nos va a se�alar un Nodo repetido
     */
    public NodoArbol(T d,NodoArbol a,NodoArbol s,NodoRepetido ab){
        fe=0;
        dato=d;
        izq=a;
        der=s;
        abajo=ab; 
    }
    /** 
     * Metodo de la frecuencia y no regresa nada
     * @param f Es un parametro de tipo entero
     */
    public void setFe(int f){fe=f;}
    /**
     * @return La frecuencia
     */
    public int getFe(){return fe;}
    /** 
     * Metodo del dato y no regresa nada
     * @param o Es un parametro de tipo T
     */
    public void setDato(T o){dato=o;}
    /**
     * @return El dato
     */
    public T getDato(){return dato;}
    /** 
     * Metodo del apuntador izquierdo y no regresa nada
     * @param ant Es un parametro de tipo NodoArbol
     */
    public void setIzq(NodoArbol ant){izq=ant;}
    /**
     * @return El apuntador izquierdo
     */
    public NodoArbol getIzq(){return izq;}
     /** 
     * Metodo del apuntador derecho y no regresa nada
     * @param s Es un parametro de tipo NodoArbol
     */
    public void setDer(NodoArbol s){der=s;}
    /**
     * @return El apuntador derecho
     */
    public NodoArbol getDer(){return der;}
    /** 
     * Metodo del NodoRepetido y no regresa nada
     * @param a Es un parametro de tipo NodoRepetido
     */
    public void setAbajo(NodoRepetido a){abajo=a;}
    /**
     * @return El nodo repetido
     */
    public NodoRepetido getAbajo(){return abajo;}
}
