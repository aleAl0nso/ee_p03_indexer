
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Declaracion de la clase Principal que extiende de la clase JFrame
 * @author Jiménez Pérez Pedro, Alonso González Alejandro Javier, Azcona González José Antonio, Chávez Aquino Daniel Felipe
 * @version 14/11/2016
 */
public class Principal extends JFrame {
    //Declaracion de los atributos
    private JPanel centro, arriba;
    private JTable menu;
    private JTextField dir;
    private JButton acept;
    private ButtonGroup grupo;
    private JRadioButton bot[];
    private String [] id;
    Object matriz[][] ;
    
                File archivoE;
    /**
     * Constructor de la clase Principal 
     * donde se hacen las instancias del clases para los graficos
     * @param a Es un parametro de la clase addActionListener
     */
    public Principal() {
        grupo = new ButtonGroup();
        /*bot = new JRadioButton[4];
        matriz[0][0] = new JLabel("id");
        grupo.add(bot[0] = new JRadioButton("", true));
        matriz[0][1] = bot[0];
        matriz[1][0] = new JLabel("nombre");
        grupo.add(bot[1] = new JRadioButton(""));
        matriz[1][1] = bot[1];
        matriz[2][0] = new JLabel("apellido");
        grupo.add(bot[2] = new JRadioButton(""));
        matriz[2][1] = bot[2];
        matriz[3][0] = new JLabel("email");
        grupo.add(bot[3] = new JRadioButton(""));
        matriz[3][1] = bot[3];*/
        String tit[] = {"datos", "indexar"};
        centro = new JPanel(new GridLayout(0, 2));
        centro.add(new JLabel(tit[0]));
        centro.add(new JLabel(tit[1]));
        /*for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (j > 0) {
                    centro.add((JRadioButton) matriz[i][j]);
                } else {
                    centro.add((JLabel) matriz[i][j]);
                }
            }
        }*/
        arriba = new JPanel(new FlowLayout());
        arriba.add(new JLabel("Abrir archivo"));
        arriba.add(dir = new JTextField(15));
        arriba.add(acept = new JButton("Abrir"));
        Admin a = new Admin();
        acept.addActionListener(a);
        setLayout(new BorderLayout());
        add(centro, BorderLayout.CENTER);
        add(arriba, BorderLayout.NORTH);
        JButton acp;
        add(acp=new JButton("Aceptar"),BorderLayout.SOUTH);
        acp.addActionListener(a);
        setSize(350, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * @Metodo del tamaño que no regresa nada
     */
    public void pintar(){
        setSize(351, 301);
    }
    /**
     * Declaracion de la clase interna Admin que implementa los metodos de la interface ActionListener
     * @author Jiménez Pérez Pedro, Alonso González Alejandro Javier, Azcona González José Antonio, Chávez Aquino Daniel Felipe
     */
    private class Admin implements ActionListener {

        @Override
        /**
         * Metodo actionPerdormed que es una implementacion de la interface ActionListener
         * @param ae Es un parametro de tipo ActionEvent
         */
        public void actionPerformed(ActionEvent ae) {
            Archivo archivo = new Archivo();
            ArbolAVL arb = new ArbolAVL();
            
            Ventana ventana;
            if ((JButton) ae.getSource() == acept) {
                
                String actual = System.getProperty("User.dir");
                JFileChooser selector = new JFileChooser(actual);
                int estado = selector.showOpenDialog(null);
                if (estado == JFileChooser.APPROVE_OPTION) {
                    archivoE = selector.getSelectedFile();
                    dir.setText(archivoE.getName());
                }
                String aux="";
                try {
                    BufferedReader bf=new BufferedReader(new FileReader(archivoE));
                    aux=bf.readLine();
                    bf.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                id=aux.split("[|]");
                bot=new JRadioButton[id.length];
                for(int i=0;i<id.length;i++){
                    centro.add(new JLabel(id[i]));
                    bot[i]=new JRadioButton("",true);
                    grupo.add(bot[i]);
                    centro.add(bot[i]);
                }
                pintar();
            }else{
                ArrayList<Registro> regis = new ArrayList<Registro>();
                    try {
                        regis=archivo.datos(archivoE);
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    int caso = 0;
                    for (int i = 0; i < bot.length; i++)
                        if(bot[i].isSelected())
                            caso=i;
                    System.out.println("caso   "+caso);
                    for (int i = 0; i < regis.size(); i++) {
                        regis.get(i).setCaso(caso);
                    try {
                        arb.Insertar(regis.get(i));
                    } catch (Exception ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    ventana = new Ventana(id[caso], arb,caso);
                
            }
        }

    }
    
    /**
     * Metodo main para ejecutar el programa
     * @param args Es un parametro por default
     */
    public static void main(String[] args) {
        Principal p = new Principal();
    }
    

}
