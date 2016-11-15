
/**
 * Declaracion de la clase Logical
 * @author Jiménez Pérez Pedro, Alonso González Alejandro Javier, Azcona González José Antonio, Chávez Aquino Daniel Felipe
 * @version 14/11/2016
 */
public class Logical
{
    // Declaracion de atributo
    private boolean v;
    /**
     * Constructor de la clase Logical
     * @param f Es un parametro de tipo booleano
     */
    public Logical(boolean f){v=f;}
    /**
     * Metodo set de la clase Logical
     * @param f Es un parametro de tipo booleano
     */
    public void setLogical(boolean f){v=f;}
    /**
     * Metodo que devuelve un valor booleano
     * @return Un valor booleano
     */
    public boolean booleanValue(){return v;}
}
