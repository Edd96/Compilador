package clases;

/**
 * Simbolo: almacena el nombre de la variable, si es numerico o cadena, el tipo
 * de variable, y el ambito(funcion donde se declaro la variable)
 * 
 * Es una lista doble
 */

class Simbolo {
    private String nombre;
    private int tipo;
    private int valorNumE;
    private float valorNumR;
    private String valorCad;
    private String ambito;
    private Simbolo ant;
    private Simbolo sig;

    // contructor
    public Simbolo() {
        this.nombre = "";
        this.tipo = 0;
        this.valorNumE = -1;
        this.valorNumR = -1;
        this.valorCad = "";
        this.ambito = "";
        this.ant = null;
        this.sig = null;
    }
    
    //sonbrecarga para recibir solo en nombre del simbolo sin ningun valor
    public Simbolo (String nombre, String ambito) {
        this.nombre = nombre;
        this.tipo = 0;
        this.valorNumE = -1;
        this.valorNumR = -1;
        this.valorCad = "";
        this.ambito = ambito;
        this.ant = null;
        this.sig = null;
    }
    
    //sonbrecarga con parametros para enteros
    public Simbolo (int valorNumE) {
        this.nombre = nombre;
        this.tipo = 2;
        this.valorNumE = valorNumE;
        this.valorNumR = -1;
        this.valorCad = "";
        this.ant = null;
        this.sig = null;
    }
    
    //sonbrecarga con parametros para reales
    public Simbolo (float valorNumR) {
        this.nombre = nombre;
        this.tipo = 2;
        this.valorNumR = valorNumR;
        this.valorNumE = -1;
        this.valorCad = "";
        this.ant = null;
        this.sig = null;
    }
    
    //sonbrecarga con parametros para cadenas
    public Simbolo (String valorCad) {
        this.nombre = nombre;
        this.tipo = 2;
        this.valorNumR = -1;
        this.valorNumE = -1;
        this.valorCad = valorCad;
        this.ant = null;
        this.sig = null;
    }

    // metodos para las propiedades.
    public Simbolo getAnt() {
        return ant;
    }

    public void setAnt(Simbolo ant) {
        this.ant = ant;
    }

    public void setSig(Simbolo sig) {
        this.sig = sig;
    }

    public Simbolo getSig() {
        return sig;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getValorNumE() {
        return valorNumE;
    }

    public void setValorNumE(int valorNumE) {
        this.valorNumE = valorNumE;
    }

    public float getValorNumR() {
        return valorNumR;
    }

    public void setValorNumR(int valorNumR) {
        this.valorNumR = valorNumR;
    }

    public String getValorCad() {
        return valorCad;
    }

    public void setValorCad(String valorCad) {
        this.valorCad = valorCad;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }
}