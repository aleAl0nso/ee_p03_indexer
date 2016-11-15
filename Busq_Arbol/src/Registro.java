
/**
 * Declaracion de la clase Registro que implementa el metodo de la clase Comparable
 * @author Jiménez Pérez Pedro, Alonso González Alejandro Javier, Azcona González José Antonio, Chávez Aquino Daniel Felipe
 * @version 14/11/2016
 */
public class Registro implements Comparable<Registro>{
    //Declaracion de los atributos privados
    private String array [];
    private int caso;
    /**
     * Metodo del caso que no devuelve nada
     * @param cas Es un parametro de tipo entero
     */
    public void setCaso(int cas){
        caso=cas;
    }
    /**
     * Metodo del Registro
     * @param a Es un parametro de un arreglo de String
     */
    public Registro(String a[]){
        array=a;
    }
    /**
     * Metodo que devuelve un arreglo de tipo String
     * @return Un arreglo de String
     */
    public String[] getArray(){
        return array;
    }
    @Override
    /**
     * Metodo que implementado de la clase Comparable
     * @param t Es un parametro de tipo Registro
     * @return Regresa un numero entero
     */
    public int compareTo(Registro t) {
        return array[caso].compareTo((t.getArray())[caso]);
    }
    /**
     * Metodo que regresa la descripcion del registro
     * @return Un String con los datos del registro
     */
    public String toString(){
        String g="";
        for(int i=0;i<array.length;i++)
            g+=array[i]+"|";
        return g;
    }
}
