

package arbolesavl;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ArbolesAVL extends JFrame implements ActionListener {

    public JButton botonCrear  = new JButton("Crear arbol");
    public JButton botonInsertar = new JButton("Insertar en el arbol");
    public JButton botonRetirar  = new JButton("Retirar del arbol");
    public JButton botonDibujar  = new JButton("Dibujar Arbol");
    
    public JLabel label  = new JLabel("Indicador de balances (Colores)");
    public JLabel label2 = new JLabel(" 0 = Negro");
    public JLabel label3 = new JLabel("-1 = Azul");
    public JLabel label4 = new JLabel(" 1 = Rojo");
    public JLabel label5 = new JLabel("Ingresar numero(s) que desea añadir");
    
    public JTextField tfIngreso = new JTextField();
    public JTextField tfRetiro = new JTextField();
    
    private Arbol arbol;
    
    public static void main(String[] args) {
     
        ArbolesAVL arbolesAvl = new ArbolesAVL();
        arbolesAvl.setSize(700, 700);
        arbolesAvl.setTitle("Arboles AVL");
        arbolesAvl.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        arbolesAvl.setVisible(true);
        
    }

    public ArbolesAVL(){
        
        Container c=getContentPane();
        c.setLayout(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        c.add(label);
        c.add(label2);
        c.add(label3);
        c.add(label4);
        c.add(label5);
    
        c.add(tfIngreso);
        c.add(tfRetiro);
        
        c.add(botonInsertar);
        c.add(botonRetirar);
        c.add(botonDibujar);
        c.add(botonCrear);
        
        botonInsertar.addActionListener(this);
        botonRetirar.addActionListener(this);
        botonDibujar.addActionListener(this);
        
        label.setBounds(20, 25, 200, 20);
        label2.setBounds(20, 50, 200, 20);
        label3.setBounds(20, 75, 200, 20);
        label3.setForeground(Color.BLUE);
        label4.setBounds(20, 100, 200, 20);
        label4.setForeground(Color.RED);
        label5.setBounds(300, 25, 300, 20);
        
        tfIngreso.setBounds(300, 50, 210, 20);
        tfRetiro.setBounds(300, 75, 210, 20);
        
        botonInsertar.setBounds(525, 50, 145, 20);
        botonInsertar.setBackground(Color.green);
        botonRetirar.setBounds(525, 75, 145, 20);
        botonRetirar.setBackground(Color.red);
        botonDibujar.setBounds(300,100,370,20);
        botonDibujar.setBackground(Color.yellow);
        botonCrear.setBounds(525, 25, 145, 20);
        botonCrear.setBackground(Color.blue);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == botonCrear){
        
            
    
        } else if (e.getSource() == botonInsertar){
        
            
            
        } else if (e.getSource() == botonRetirar){
            
            
            
        } else if (e.getSource() == botonDibujar){
        
        
            
        }
        
    }
    
}
