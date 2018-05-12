package clases;

import java.util.Set;

/**
 * ListaTokens: Lista doblemente enlazada donde se colocan los tokens 
 * identificados como válidos
 */
public class ListaTokens {

    private Token prToken, ulToken, acToken;// para llevar control del primer, ultimo y actual token
    int totalTokens;// conteo de tokens
    
    //Metodos get y set de las variables
    
    public Token getPrToken(){
        return prToken;
    }
    
    public Token getUlToken(){
        return ulToken;
    }
    
    public Token getAcToken(){
        return acToken;
    }

    public ListaTokens() {
        this.prToken = null;
        this.ulToken = null;
        this.acToken = null;
        this.totalTokens = 0;
    }

    boolean esListaVacia() {
        return (prToken == null);
    }

    void addToken(int id, String lexema, int nLinea, int nCol) {
        Token tokenNuevo = new Token(id, lexema, nLinea, nCol);
        if (esListaVacia()) {
            prToken = tokenNuevo;
        } else {
            tokenNuevo.setAnt(ulToken);
            ulToken.setSig(tokenNuevo);
        }
        ulToken = tokenNuevo;
        acToken = tokenNuevo;
        totalTokens++;
    }
}
