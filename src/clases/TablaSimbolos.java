package clases;

import java.lang.reflect.Constructor;

/**
 *
 * esta clase permite generar una trabla de simbolos qeu se utilizara en el analisis semantico
 * es la parte principal de la traduccion orientada por la sintaxis
 */


/**
 * TablaSimbolos: esta clase genera objetos de tipo tabla de simbolos, contiene
 * los metodos para llenar la tabla, eliminar simbolos y buscar simbolos
 */
class TablaSimbolos {
    private Simbolo prSimbolo, ulSimbolo, acSimbolo;// para llevar control del primer, ultimo y actual simbolo
    int totalSimbolos;// conteo de simbolos

    // Metodos get y set de las variables

    public Simbolo getPrSimbolo() {
        return prSimbolo;
    }

    public Simbolo getUlSimbolo() {
        return ulSimbolo;
    }

    public Simbolo getAcToken() {
        return acSimbolo;
    }

    public TablaSimbolos() {
        this.prSimbolo = null;
        this.ulSimbolo = null;
        this.acSimbolo = null;
        this.totalSimbolos = 0;
    }

    boolean esListaVacia() {
        return (prSimbolo == null);
    }
    
    boolean simboloExist(String nombre){
        if(esListaVacia()){
            return false;
        }else{
            Simbolo aux = prSimbolo;
            while(aux != null & aux.getNombre() != nombre){
                aux = aux.getSig();
            }
            
            if(aux.getNombre() == nombre){
                return true;
            }
            
            return false;
        }
    }

    //sobrecarga para agregar simbolos a la tabla 
    public boolean addSimbol(String nombre, String ambito) {
        if(simboloExist(nombre)){
            return false;
        }else{
            Simbolo simboloNuevo = new Simbolo(nombre, ambito);
            if (esListaVacia()) {
                prSimbolo = simboloNuevo;
            } else {
                simboloNuevo.setAnt(ulSimbolo);
                ulSimbolo.setSig(simboloNuevo);
            }
            ulSimbolo = simboloNuevo;
            acSimbolo = simboloNuevo;
            totalSimbolos++;
            return true;
        }
   
    }
    
    public void addTipo(int tipo){
        acSimbolo.setTipo(tipo);
    }
    
    //metodo para agregar valores a los simbolos de tipo entero de la tabla
    public int addValorEnt(String nombre, int valor) {
        if (simboloExist(nombre)) {
            
        } else {
        }
        
        return 0;
    }
    
    //metodo para recorer la lista
    public void recore(){
        
    }
    
    //metodo para buscar simbolo dentro de la lista
    public void buscar(){
        
    }
    
    //metodo para validar si existe el simbolo dentro de la lista
    public boolean validarSim(){
        return true;
    }
    
    //metodo para validar si el simbolo tiene o no valor
    public boolean simboloVacio(){
     return true;   
    }
}