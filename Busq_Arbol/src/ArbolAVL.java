

/**
 * Declaracion de la clase generica ArbolAVL que extiende de la clase Comparable 
 * @author Jiménez Pérez Pedro, Alonso González Alejandro Javier, Azcona González José Antonio, Chávez Aquino Daniel Felipe
 * @version 14/11/2016
 */
public class ArbolAVL<T extends Comparable<T>>{
    //Declaración de los atributos privados
    private NodoArbol<T> raiz;
    public ArbolAVL(){raiz=null;}
    private NodoArbol raizArbol(){return raiz;}
    /**
     * Metodo para insertar y no regresa nada
     * @param p Éste parametro es de tipo T
     */
    public void Insertar(T p)throws Exception{
        Logical h=new Logical(false);
        raiz=InsertarAVL(raiz,p,h);
    }
    /**
     * Metodo para insertar un NodoArbol
     * @return Un NodoArbol llamado raiz
     * @param p Éste parametro define el dato
     */
    private NodoArbol InsertarAVL(NodoArbol<T> raiz,T p,Logical h)throws Exception{
        NodoArbol n1;
        if(raiz==null){
            raiz=new NodoArbol(p,null,null,null);
            h.setLogical(true);
        }else
            if(p.compareTo(raiz.getDato())<0){
                NodoArbol iz;
                iz=InsertarAVL(raiz.getIzq(),p,h);
                raiz.setIzq(iz);
                if(h.booleanValue()){
                    switch(raiz.getFe()){
                        case 1:
                        raiz.setFe(0);
                        h.setLogical(false);
                        break;
                        case 0:
                        raiz.setFe(-1);
                        break;
                        case -1:
                        n1=raiz.getIzq();
                        if(n1.getFe()==-1)
                            raiz=RotacionII(raiz,n1);
                        else
                            raiz=RotacionID(raiz,n1);
                        h.setLogical(false);
                    }
                }
            }else
                if(p.compareTo(raiz.getDato())>0){
                    NodoArbol dr;
                    dr=InsertarAVL(raiz.getDer(),p,h);
                    raiz.setDer(dr);
                    if(h.booleanValue()){
                        switch(raiz.getFe()){
                            case 1:
                            n1=raiz.getDer();
                            if(n1.getFe()==1)
                                raiz=RotacionDD(raiz,n1);
                            else
                                raiz=RotacionDI(raiz,n1);
                            h.setLogical(false);
                            break;
                            case 0:
                            raiz.setFe(1);
                            break;
                            case -1:
                            raiz.setFe(0);
                            h.setLogical(false);
                        }
                    }
                }else
                    if(p.compareTo(raiz.getDato())==0)
                        InsertarRepetido(raiz, p);
                    else
                    throw new Exception("No puede haber claves repetidas");
        return raiz;
    }
    /**
     * Metodo que hace la Rotacion Izquierda Izquierda en el Arbol
     * @param n Es un parametro de tipo NodoArbol
     * @param n1 Es un parametro de tipo NodoArbol
     * @return Un NodoArbol
     */
    private NodoArbol RotacionII(NodoArbol n,NodoArbol n1){
        n.setIzq(n1.getDer());
        n1.setDer(n);
        if(n1.getFe()==-1){
            n.setFe(0);
            n1.setFe(0);
        }else{
            n.setFe(-1);
            n1.setFe(1);
        }
        return n1;
    }
    /**
     * Metodo que hace la Rotacion Derecha Derecha en el Arbol
     * @param n Es un parametro de tipo NodoArbol
     * @param n1 Es un parametro de tipo NodoArbol
     * @return Un NodoArbol
     */
    private NodoArbol RotacionDD(NodoArbol n, NodoArbol n1){
        n.setDer(n1.getIzq());
        n1.setIzq(n);
        if(n1.getFe()==1){
            n.setFe(0);
            n1.setFe(0);
        }else{
            n.setFe(1);
            n1.setFe(-1);
        }
        return n1;
    }
    /**
     * Metodo que hace la Rotacion Izquierda Derecha en el Arbol
     * @param n Es un parametro de tipo NodoArbol
     * @param n1 Es un parametro de tipo NodoArbol
     * @return Un NodoArbol
     */
    private NodoArbol RotacionID(NodoArbol n,NodoArbol n1){
        NodoArbol n2;
        n2=n1.getDer();
        n.setIzq(n2.getDer());
        n2.setDer(n);
        n1.setDer(n2.getIzq());
        n2.setIzq(n1);
        if(n2.getFe()==1)
            n1.setFe(-1);
        else
            n1.setFe(0);
        if(n2.getFe()==-1)
            n.setFe(1);
        else
            n.setFe(0);
        n2.setFe(0);
        return n2;
    }
    /**
     * Metodo que hace la Rotacion Derecha Izquierda en el Arbol
     * @param n Es un parametro de tipo NodoArbol
     * @param n1 Es un parametro de tipo NodoArbol
     * @return Un NodoArbol
     */
    private NodoArbol RotacionDI(NodoArbol n,NodoArbol n1){
        NodoArbol n2;
        n2=n1.getIzq();
        n.setDer(n2.getIzq());
        n2.setIzq(n);
        n1.setIzq(n2.getDer());
        n2.setDer(n1);
        if(n2.getFe()==1)
            n.setFe(-1);
        else
            n.setFe(0);
        if(n2.getFe()==-1)
            n1.setFe(1);
        else
            n1.setFe(0);
        n2.setFe(0);
        return n2;
    }
    /**
     * Metodo que utiliza el metodo Busqueda para buscar un dato
     * @param p Es un parametro de tipo T
     * @return Un dato de tipo T
     */
    public T Buscar(T p){
        return Busqueda(raiz,p);
    }
    /**
     * Metodo busca un NodoArbol a traves de comparaciones
     * @param raiz Es un parametro de tipo NodoArbol
     * @param p Es un parametro de tipo T
     */
    private T Busqueda(NodoArbol<T> raiz,T p){
        if(raiz!=null){
            if(raiz.getDato().compareTo(p)==0){return raiz.getDato();}
            if(raiz.getDato().compareTo(p)>0)return (T) Busqueda(raiz.getIzq(),p);
            if(raiz.getDato().compareTo(p)<0)return (T) Busqueda(raiz.getDer(),p);
        }
        return null;
    }
    
    /**
     * Metodo que inserta un NodoArbol repetido
     * @param raiz Es un parametro de tipo NodoArbol
     * @param p Es un parametro de tipo T
     */
    private void InsertarRepetido(NodoArbol raiz,T p){
        NodoRepetido ab=raiz.getAbajo(),n=new NodoRepetido(p,null);
        if(n!=null){
            if(ab!=null){
                while(ab.getAbajo()!=null){
                    ab=ab.getAbajo();
                }
                ab.setAbajo(n);
            }else raiz.setAbajo(n);
        }
    }
}
