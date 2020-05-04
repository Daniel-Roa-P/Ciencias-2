package arbolesavl;

class Arbol {
    
    Nodo raiz = null;
    
    public Nodo insertar(Nodo nodo, int valor){
        
        if(nodo == null){
        
            return(new Nodo(valor));
            
        }
        
        int valorRaiz = nodo.getValor();
        
        if(valor < valorRaiz){
            
            nodo.setIzquierdo(insertar(nodo.getIzquierdo(), valor));
            
        } else if(valor > valorRaiz){
        
            nodo.setDerecho(insertar(nodo.getDerecho(), valor));
            
        } else {
        
            return nodo;
        
        }
        
        nodo.setPeso(1 + pesoMaximo(obtenerPeso(nodo.getIzquierdo()), obtenerPeso(nodo.getDerecho())));
        
        int balance = calcularBalance(nodo, nodo.getIzquierdo(), nodo.getDerecho());
        
        nodo.setBalance(balance);

        
        if( balance > 1 && valor < nodo.getIzquierdo().getValor() ){
        
            return rotarDerecha(nodo);
            
        } else if ( balance < -1 && valor > nodo.getDerecho().getValor() ){
            
            return rotarIzquierda(nodo);
            
        } else if ( balance > 1 && valor > nodo.getIzquierdo().getValor() ){
        
            nodo.setIzquierdo(rotarIzquierda(nodo.getIzquierdo()));
            return rotarDerecha(nodo);
            
        } else if ( balance < -1 && valor < nodo.getDerecho().getValor() ){
        
            nodo.setDerecho(rotarDerecha(nodo.getDerecho()));
            return rotarIzquierda(nodo);
            
        }
        
        return nodo;
        
    }

    private Nodo rotarDerecha(Nodo nodo) {
    
        Nodo Hijo = nodo.getIzquierdo();
        Nodo Nieto = Hijo.getDerecho();
        
        Hijo.setDerecho(nodo);
        nodo.setIzquierdo(Nieto);
        
        nodo.setPeso(pesoMaximo(obtenerPeso(nodo.getIzquierdo()), obtenerPeso(nodo.getDerecho())) + 1); 
        Hijo.setPeso(pesoMaximo(obtenerPeso(Hijo.getIzquierdo()), obtenerPeso(Hijo.getDerecho())) + 1); 
        
        nodo.setBalance(calcularBalance(nodo, nodo.getIzquierdo(), nodo.getDerecho()));
        
        return Hijo;
        
    }
    
    private Nodo rotarIzquierda(Nodo nodo) {
        
        Nodo Hijo = nodo.getDerecho();
        Nodo Nieto = Hijo.getIzquierdo();
        
        Hijo.setIzquierdo(nodo);
        nodo.setDerecho(Nieto);
        
        nodo.setPeso(pesoMaximo(obtenerPeso(nodo.getIzquierdo()), obtenerPeso(nodo.getDerecho())) + 1); 
        Hijo.setPeso(pesoMaximo(obtenerPeso(Hijo.getIzquierdo()), obtenerPeso(Hijo.getDerecho())) + 1); 
        
        nodo.setBalance(calcularBalance(nodo, nodo.getIzquierdo(), nodo.getDerecho()));
        
        return Hijo;
        
    }
    
    int pesoMaximo(int a,int b){
            
            return (a > b) ? a : b ;
            
    }
    
    int obtenerPeso(Nodo nodo) { 
        if (nodo == null) 
            return 0; 
  
        return nodo.getPeso(); 
    } 

    int calcularBalance(Nodo nodo, Nodo izq, Nodo der) {
        
        if (nodo == null){ 
        
            return 0;
            
        }
  
        return obtenerPeso(izq) - obtenerPeso(der); 
        
    }

    int nivel = 0;
    int max = 0;
    
    void printInorder(Nodo nodo) 
    { 
        if (nodo == null){ 
            return; 
        }
        
        nivel++;
        printInorder(nodo.getIzquierdo()); 
        nivel--;
  
        if(nivel > max){
        
            max = nivel;
            
        }
        
        nivel++;
        printInorder(nodo.getDerecho()); 
        nivel--;

    } 
    
}
