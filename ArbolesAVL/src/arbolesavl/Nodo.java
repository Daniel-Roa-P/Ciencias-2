
package arbolesavl;

public class Nodo {
  
    int valor;
    int factorBalance;
    
    Nodo izquierdo;
    Nodo derecho;
    
    Nodo(int n){
        
        this.valor = n;
        this.factorBalance = 0;
        this.izquierdo = null;
        this.derecho   = null;
        
    }
    
}
