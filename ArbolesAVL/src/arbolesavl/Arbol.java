package arbolesavl;

class Arbol {
    
    Nodo raiz;
    
    public Nodo insertar(Nodo nodo, int valor){
        
        if(nodo == null){
        
            return(new Nodo(valor));
            
        }
        
        int valorRaiz = nodo.getValor();
        Nodo nodoIzq  = nodo.getIzquierdo();
        Nodo nodoDer  = nodo.getDerecho();
        
        if(valor < valorRaiz){
            
            nodo.setIzquierdo(insertar(nodoIzq, valor));
            
        } else if(valor > valorRaiz){
        
            nodo.setDerecho(insertar(nodoDer, valor));
            
        } else {
        
            return nodo;
        
        }
        
        nodo.setPeso( 1 + pesoMaximo( nodoIzq.getPeso(), nodoDer.getPeso() ) );
        
        int balance = calcularBalance(nodo, nodoIzq, nodoDer);
        
        if( balance > 1 && valor < nodoIzq.getValor() ){
        
        } else if ( balance < -1 && valor > nodoDer.getValor() ){
        
        } else if ( balance > 1 && valor > nodoIzq.getValor() ){
        
        } else if ( balance < -1 && valor < nodoDer.getValor() ){
        
        }
        
        return nodo;
        
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
}
