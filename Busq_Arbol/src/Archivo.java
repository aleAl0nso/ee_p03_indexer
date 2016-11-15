
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Declaracion de la clase Archivo
 * @author Jiménez Pérez Pedro, Alonso González Alejandro Javier, Azcona González José Antonio, Chávez Aquino Daniel Felipe
 * @version 14/11/2016
 */
public class Archivo {
    /**
     * Metodo llamado datos que devuelve un ArrayList de registros
     * @param are Es un parametro que define un archivo
     */
    public ArrayList<Registro> datos(File are) throws IOException{
        File ar=are;
        if(!ar.exists())
            do
                JOptionPane.showMessageDialog(null,"El archivo "
                        +" no fue encontrado"
                            +"\nFavor de verificar el archivo antes de dar click en aceptar");
            while(!ar.exists());
        return list(ar);
    }
    /**
     * Metodo llamado list que lee un archivo y devuelve un ArrayList de registros
     * @param ar Es un parametro que define un archivo
     */
    private ArrayList<Registro> list(File ar) throws FileNotFoundException, IOException{
        ArrayList<Registro> dat=new ArrayList<Registro>();
        String aux;
        BufferedReader bf=new BufferedReader(new FileReader(ar));
        bf.readLine();
        
        while((aux=bf.readLine())!=null){
            String array[];
            array=aux.split("[|]");
            dat.add(new Registro(array));
        }
        bf.close();
        return dat;
    }
}
