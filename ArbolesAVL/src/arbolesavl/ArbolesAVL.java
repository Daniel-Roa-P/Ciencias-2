

package arbolesavl;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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
    private final List <Nodo> listaArbol = new ArrayList();
    
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
        botonCrear.addActionListener(this);
        
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
    
    Arbol tree = new Arbol(); 
    
    private boolean todoNull(List list) {
        
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
    
    public void listarArbol(List<Nodo> nodos, int nivel, int profundidad){
        
        if (nodos.isEmpty() || todoNull(nodos)){
        
            return;

        }
       
        int ubicacion = profundidad - nivel;
        List<Nodo> newNodes = new ArrayList<>();
        
        for (Nodo node : nodos) {
            if (node != null) {
                
                newNodes.add(node.getIzquierdo());
                newNodes.add(node.getDerecho());
                listaArbol.add(node.getIzquierdo());
                listaArbol.add(node.getDerecho());
                
                
            } else {
                
                newNodes.add(null);
                newNodes.add(null);
                listaArbol.add(null);
                listaArbol.add(null);
            
            }
        }
            
            listarArbol(newNodes, nivel + 1, profundidad);
            
    
    }
    
    void pintarArbol(){
        
        int exponente = 0;
        int i=0;
        int j=0;
        
        while(exponente <= tree.max){
        
            if(j >= Math.pow(2, exponente)){           
                
                exponente=exponente+1;
                j=0;
                System.out.println(" ");
                
            }
            
            if(listaArbol.get(i) != null){
            
            System.out.print(listaArbol.get(i).getValor() + " ");
            
            } else {
            
            System.out.print("  ");
            
            }
            
            i++;
            j++;
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == botonCrear){            

        tree.raiz = tree.insertar(tree.raiz, 5);
        tree.raiz = tree.insertar(tree.raiz, 124);
        tree.raiz = tree.insertar(tree.raiz, 24);
        tree.raiz = tree.insertar(tree.raiz, 10);
        tree.raiz = tree.insertar(tree.raiz, 100);
        tree.raiz = tree.insertar(tree.raiz, 150);
        tree.raiz = tree.insertar(tree.raiz, 7);
        tree.raiz = tree.insertar(tree.raiz, 2);
        tree.raiz = tree.insertar(tree.raiz, 64);
        tree.raiz = tree.insertar(tree.raiz, 14);
        tree.raiz = tree.insertar(tree.raiz, 91);
        tree.raiz = tree.insertar(tree.raiz, 10);
        tree.raiz = tree.insertar(tree.raiz, 71);
        tree.raiz = tree.insertar(tree.raiz, 37);
        tree.raiz = tree.insertar(tree.raiz, 12);
        tree.raiz = tree.insertar(tree.raiz, 97);
        tree.raiz = tree.insertar(tree.raiz, 66);
        tree.raiz = tree.insertar(tree.raiz, 23);
        tree.raiz = tree.insertar(tree.raiz, 55);
        tree.raiz = tree.insertar(tree.raiz, 87);
        tree.raiz = tree.insertar(tree.raiz, 47);
        
        } else if (e.getSource() == botonInsertar){
        
            
            
        } else if (e.getSource() == botonRetirar){
            
            
            
        } else if (e.getSource() == botonDibujar){ 
            
            tree.printInorder(tree.raiz);
            System.out.println(" ");
            
            List <Nodo> lista = new ArrayList();
            lista.add(tree.raiz);
            listaArbol.add(tree.raiz);
            listarArbol(lista, 0, tree.max);
            
            pintarArbol();
            
        }
        
    }
    
}