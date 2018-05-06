package clases;

import java.util.Set;

/**
 * Token: En este tipo de objeto se almacena el número(identificador
 * de que tipo de token es) y el lexema asociado al token.
 * 
 */
public class Token {

    private int id;//Numero de id del token
    
    private String lex;//lexema
    
    private Token ant;//enlace al token anterior
    private Token sig;//enlace al token siguiente

    /*
    * Metodos get y set para acceder a los datos
    */
    public Token getAnt() {
        return ant;
    }
    
    public void setAnt(Token ant){
        this.ant = ant;
    }
    
    public void setSig(Token sig){
        this.sig = sig;
    }
    
    public Token getSig() {
        return sig;
    }

    public void setLex(String lex) {
        this.lex = lex;
    }

    public String getLex(){
        return lex;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    /*
    * Contructor para recibir datos
    */
    public Token(int id, String lex) {
        this.id = id;
        this.lex = lex;
        ant = null;
        sig = null;
    }
    
}