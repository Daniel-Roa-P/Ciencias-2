package arbolesavl;

class Arbol {
    
    private Nodo raiz = null;
    
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
        
        int balance = calcularBalance(nodo);
        
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
    
    public Nodo retirar(Nodo nodo, int valor){
        
        if (nodo == null){
            
            return nodo;
            
        }

        if (valor < nodo.getValor()){
            
            nodo.setIzquierdo(retirar(nodo.getIzquierdo(),valor)); 
  

        } else if (valor > nodo.getValor())  {
            
            nodo.setDerecho(retirar(nodo.getDerecho(),valor)); 
   
        } else {  
 
            if ((nodo.getIzquierdo() == null) || (nodo.getDerecho() == null)){
                
                Nodo temporal = null;
                
                if (temporal == nodo.getIzquierdo()){  
                    
                    temporal = nodo.getDerecho();  
                
                } else {
                    
                    temporal = nodo.getIzquierdo();  
  
                }
                    
                if (temporal == null){

                    temporal = nodo;  
                    nodo = null; 
                    
                } else {
                    
                    nodo = temporal; 
                    
                }
                
            } else {  
   
                Nodo temp = hallarNodoMenor(nodo.getDerecho());  
   
                nodo.setValor(temp.getValor());
   
                nodo.setDerecho(retirar(nodo.getDerecho(), temp.getValor()));  
                
            }  
        }  

        if (nodo == null){
            
            return nodo;
        
        }       
  
        nodo.setPeso(pesoMaximo(obtenerPeso(nodo.getIzquierdo()), obtenerPeso(nodo.getDerecho())) + 1);  
  
        int balance = calcularBalance(nodo);  
  
        if (balance > 1 && calcularBalance(nodo.getIzquierdo()) >= 0){ 
        
            return rotarDerecha(nodo);  
   
        }
        
        if (balance > 1 && calcularBalance(nodo.getIzquierdo()) < 0){  
            nodo.setIzquierdo(rotarIzquierda(nodo.getIzquierdo()));  
            return rotarDerecha(nodo);  
            
        }  
  
        if (balance < -1 && calcularBalance(nodo.getDerecho()) <= 0){  
         
            return rotarIzquierda(nodo);
            
        }

        if (balance < -1 && calcularBalance(nodo.getDerecho()) > 0){
            
            nodo.setDerecho(rotarDerecha(nodo.getDerecho()));    
            return rotarIzquierda(nodo);  
        
        }  
        
        nodo.setBalance(calcularBalance(nodo));
        
        return nodo;  
    
    }  

    private Nodo rotarDerecha(Nodo nodo) {
    
        Nodo Hijo = nodo.getIzquierdo();
        Nodo Nieto = Hijo.getDerecho();
        
        Hijo.setDerecho(nodo);
        nodo.setIzquierdo(Nieto);
        
        nodo.setPeso(pesoMaximo(obtenerPeso(nodo.getIzquierdo()), obtenerPeso(nodo.getDerecho())) + 1); 
        Hijo.setPeso(pesoMaximo(obtenerPeso(Hijo.getIzquierdo()), obtenerPeso(Hijo.getDerecho())) + 1); 
        
        nodo.setBalance(calcularBalance(nodo));
        
        return Hijo;
        
    }
    
    private Nodo rotarIzquierda(Nodo nodo) {
        
        Nodo Hijo = nodo.getDerecho();
        Nodo Nieto = Hijo.getIzquierdo();
        
        Hijo.setIzquierdo(nodo);
        nodo.setDerecho(Nieto);
        
        nodo.setPeso(pesoMaximo(obtenerPeso(nodo.getIzquierdo()), obtenerPeso(nodo.getDerecho())) + 1); 
        Hijo.setPeso(pesoMaximo(obtenerPeso(Hijo.getIzquierdo()), obtenerPeso(Hijo.getDerecho())) + 1); 
        
        nodo.setBalance(calcularBalance(nodo));
        
        return Hijo;
        
    }
    
    int pesoMaximo(int a,int b){
            
            return (a > b) ? a : b ;
            
    }
    
    Nodo hallarNodoMenor(Nodo nodo)  {  
        
        Nodo temp = nodo;  
  
        while (temp.getIzquierdo() != null){  
        
            temp = temp.getIzquierdo();  
  
        }
        
        return temp;  
        
    }
    
    int obtenerPeso(Nodo nodo) { 
        if (nodo == null) 
            return 0; 
  
        return nodo.getPeso(); 
    } 

    int calcularBalance(Nodo nodo) {
        
        if (nodo == null){ 
        
            return 0;
            
        }
  
        return obtenerPeso(nodo.getIzquierdo()) - obtenerPeso(nodo.getDerecho()); 
        
    }

    int nivel = 0;
    int max = 0;
    
    String cadena="";
    String cadena2="";
    String cadena3="";
    
    String printInorder(Nodo nodo){
        
        if (nodo == null){ 
            return ""; 
        }
        
        nivel++;
        printInorder(nodo.getIzquierdo()); 
        nivel--;
        
        cadena = cadena + nodo.getValor() +", ";
        
        if(nivel > max){
        
            max = nivel;
            
        }
        
        nivel++;
        printInorder(nodo.getDerecho()); 
        nivel--;
        
        return cadena;
        
    } 
    
    String printPostOrder(Nodo nodo){
        
        if (nodo == null){ 
            return ""; 
        }

        printPostOrder(nodo.getIzquierdo()); 
        
        printPostOrder(nodo.getDerecho()); 
        
        cadena2 = cadena2 + nodo.getValor() +", ";
        
        return cadena2;
        
    } 
    
    String printPreOrder(Nodo nodo){
        
        if (nodo == null){ 
            return ""; 
        }
        
        cadena3 = cadena3 + nodo.getValor() +", ";
        
        printPreOrder(nodo.getIzquierdo()); 
        
        printPreOrder(nodo.getDerecho()); 
        
        return cadena3;
        
    } 
    
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
}
