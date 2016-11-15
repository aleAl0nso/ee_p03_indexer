
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Declaracion de la clase Ventana que extiende de la clase JFrame
 * @author Jiménez Pérez Pedro, Alonso González Alejandro Javier, Azcona González José Antonio, Chávez Aquino Daniel Felipe
 * @version 14/11/2016
 */
public class Ventana extends JFrame {
    //Declaracion de atributos privados
    private JPanel arriba, centro, abajo;
    private JLabel bus;
    private JTextField dato;
    private JButton busq;
    private JTextArea res;
    private ArbolAVL arbol;
    private int caso;
    /**
     * Constructor de la clase Ventana
     * @param nombre Es un parametro de tipo String
     * @param arb Es un parametro de tipo ArbolAVL
     * @param cas Es un parametro de tipo entero
     */
    public Ventana(String nombre, ArbolAVL arb,int cas) {
        caso=cas;
        arbol = arb;
        arriba = new JPanel(new FlowLayout());
        arriba.add(bus = new JLabel(nombre));
        arriba.add(dato = new JTextField(20));
        arriba.add(busq = new JButton("Busqueda"));
        Admin a = new Admin();
        busq.addActionListener(a);
        setLayout(new BorderLayout());
        add(arriba, BorderLayout.NORTH);
        centro = new JPanel();
        centro.add(new JLabel("Resultado"));
        add(centro, BorderLayout.CENTER);
        abajo = new JPanel();
        abajo.add(res = new JTextArea(5, 25));
        add(abajo, BorderLayout.SOUTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
    }
    /**
     * Declaracion de la clase Admin que implementa los metodos de la interface ActionListener
     * @author Jiménez Pérez Pedro, Alonso González Alejandro Javier, Azcona González José Antonio, Chávez Aquino Daniel Felipe
     */
    private class Admin implements ActionListener {

        @Override
        /**
         * Metodo actionPerformed que es una implementacion de la interface ActionListener
         * @param ae Es un parametro de tipo ActionEvent
         */
        public void actionPerformed(ActionEvent ae) {
            long tiempoInicio = System.currentTimeMillis();
            String array[]=new String[caso+1];
            array[caso]=dato.getText();
            Registro r = new Registro(array);
            r.setCaso(caso);
            /*switch (caso) {
                case 0:
                    r.setId(Integer.parseInt(dato.getText()));
                    r.setCaso(0);
                    break;
                case 1:
                    r.setNombre(dato.getText());
                    r.setCaso(1);
                    break;
                case 2:
                    r.setApellido(dato.getText());
                    r.setCaso(2);
                    break;
                case 3:
                    r.setEmail(dato.getText());
                    r.setCaso(3);
                    break;
            }*/
            Registro resg=(Registro)(arbol.Buscar(r));
            if(resg!=null){
                String t= (arbol.Buscar(r)).toString();
                long totalTiempo = System.currentTimeMillis() - tiempoInicio;
                res.setText(t+"\nLo encontro en "+totalTiempo+" milisegundos");
            }else
                res.setText("no se encontro el registro");

        }

    }

}
