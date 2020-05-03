
package arbolesavl;

public class Nodo {
  
    private int valor;
    private int peso;
    private int balance;
    
    private Nodo izquierdo;
    private Nodo derecho;
    
    Nodo(int n){
        
        this.valor = n;
        this.peso = 1;
        this.izquierdo = null;
        this.derecho   = null;
        
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
    
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
}
