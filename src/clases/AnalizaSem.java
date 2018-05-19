package clases;

/**
 *
 * esta clase permite generar una trabla de simbolos qeu se utilizara en el analisis semantico
 * es la parte principal de la traduccion orientada por la sintaxis
 */

/**
 * Simbolo: almacena el lexema asociado al token(Nombre del token) y el valor
 * que se le da porteriormente si es de tipo numerico o cadena.
 * 
 * Es una lista doble
 */
public class Simbolo {
    private String id;
    private int tipo;
    private int valorNum;
    private String valorCad;
    private Simbolo ant;
    private Simbolo sig;

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

    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getTipo(){
        return tipo;
    }

    public void setTipo(int tipo){
        this.tipo = tipo;
    }

    public int getValorNum(){
        return valorNum;
    }

    public void setValorNum(int valorNum){
        this.valorNum = valorNum;
    }

    public String getValorCad() {
        return valorCad;
    }

    public void setValorCad(String valorCad) {
        this.valorCad = valorCad;
    }
}