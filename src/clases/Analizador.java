package clases;

import java.util.Set;

//Esta clase permite identificar los tokens


public class Analizador {

    /**
     * Token, de dato
     */
    public class Token {
        
        protected int id;
        protected String lex;
        protected Token ant;
        protected Token sig;

        public Token(int id, String lex){
            this.id = id;
            this.lex = lex;
            ant = null;
            sig = null;
        }
    }

    /**
     * ListaTokens
     */
    public class ListaTokens {
    
        Token prToken, ulToken, acToken;//para llevar control del primer, ultimo y actual token
        int totalTokens;//conteo de tokens
        
        public ListaTokens(){
            this.prToken = null;
            this.ulToken = null;
            this.acToken = null;
            this.totalTokens = 0;
        }

        boolean esListaVacia(){
            return(prToken == null);
        }

        void addToken(int id, String lexema){
            Token tokenNuevo = new Token(id,lexema);
            if(esListaVacia()){
                prToken = tokenNuevo;
            }
            else{
                tokenNuevo.ant = ulToken;
                ulToken.sig = tokenNuevo;
            }
            ulToken = tokenNuevo;
            acToken = tokenNuevo;
            totalTokens++;
        }
    }
    int estado = 0, auxtoken = 0, cont = 0;
    int error= 0, errLinea= 1, errCol;// errores y posicion de estos
    char c = 0;
    public String cadena = "", lexema = "";//variables para lexema
    ListaTokens objLista;//lista donde se almacena los lexemas
    public Analizador(String cadena){
        this.cadena = cadena;
        objLista = new ListaTokens(); 
    }

    int obtenerToken(){
        lexema = "";
        auxtoken=0;
        error=0;
        estado = 0;
        while(error==0 && auxtoken==0){
            if(cont<cadena.length()){
                errCol++;
                c = cadena.charAt(cont);
            }
            else{
                c=0;
            }
            cont++;
            switch(estado){
                case 0:
                    if(Character.isLetter(c) == true){
                        lexema = lexema + c;
                        estado = 1;
                    }
                    else{
                        if(Character.isDigit(c) == true){
                            estado= 2;
                            lexema = lexema + c;
                        }
                        else{
                            switch(c){
                                case '"': estado = 3; lexema = lexema + c;
                                break;
                                case ':': estado = 4; lexema = lexema + c;
                                break;
                                case ';': estado = 5; lexema = lexema + c;
                                break;
                                case '=': estado = 6; lexema = lexema + c;
                                break;
                                case '+': estado = 7; lexema = lexema + c;
                                break;
                                case '-': estado = 8; lexema = lexema + c;
                                break;
                                case '*': estado = 9; lexema = lexema + c;
                                break;
                                case '/': estado = 10; lexema = lexema + c;
                                break;
                                case ',': estado = 11; lexema = lexema + c;
                                break;
                                case '(': estado = 12; lexema = lexema + c;
                                break;
                                case ')': estado = 13; lexema = lexema + c;
                                break;
                                case '{': estado = 14; lexema = lexema + c;
                                break;
                                case '}': estado = 15; lexema = lexema + c;
                                break;
                                case '>': estado = 16; lexema = lexema + c;
                                break;
                                case '<': estado = 17; lexema = lexema + c;
                                break;
                                case ' ': estado = 0;
                                break;
                                case '\n': estado = 0;
                                    errLinea++;
                                    errCol = 0;
                                break;
                                case '\t': estado = 0;
                                break;
                                case '#': estado = 25;
                                break;
                                default: error = 1;
                                break;
                            }
                        }
                    }
                break;
                case 1:
                    if (Character.isLetterOrDigit(c) == true) {
                        estado = 1; lexema = lexema + c;
                    } else {
                        auxtoken = 1;
                    }
                break;
                case 2:
                    if (Character.isDigit(c) == true) {
                        estado = 2; lexema = lexema + c;
                    } else {
                        if (c == '.') {
                            estado = 18; lexema = lexema + c;
                        } else {
                            auxtoken = 2;
                        }
                    }
                break;
                case 3: estado = 19; lexema = lexema + c;
                break;
                case 4: auxtoken = 5;
                break;
                case 5: auxtoken = 6;
                break;
                case 6: auxtoken = 7;
                break;
                case 7: auxtoken = 8;
                break;
                case 8: auxtoken = 9;
                break;
                case 9: auxtoken = 10;
                break;
                case 10: auxtoken = 11;
                break;
                case 11: auxtoken = 12;
                break;
                case 12: auxtoken = 13;
                break;
                case 13: auxtoken = 14;
                break;
                case 14: auxtoken = 15;
                break;
                case 15: auxtoken = 16;
                break;
                case 16: if (c == '=') {estado = 20; lexema = lexema + c;}
                    else auxtoken = 17;
                break;
                case 17: if (c == '=') {estado = 21; lexema = lexema + c;}
                    else{
                        if (c == '>') {estado = 22; lexema = lexema + c;}
                        else auxtoken = 18;
                    }
                break;
                case 18:
                    if (Character.isDigit(c) == true) {estado = 23; lexema = lexema + c;}
                    else error= 1;
                break;
                case 19:
                    if (c=='"'){estado = 24; lexema = lexema + c;}
                    else {estado = 19; lexema = lexema + c;}
                break;
                case 20: auxtoken = 19;
                break;
                case 21: auxtoken = 20;
                break;
                case 22: auxtoken = 21;
                break;
                case 23:
                    if (Character.isDigit(c)) {estado = 23; lexema = lexema + c;}
                    else auxtoken= 3;
                break;
                case 24: auxtoken = 4;
                break;
                case 25:
                    if(c=='\n') estado = 26;
                    else estado = 25;
                break;
                case 26: auxtoken = 34;
                break;
            }
        }
        cont--;
        //if(c!=0)eliminarUltimo();
        if(error > 0) {}
        else{
            switch(lexema){
                case "void": auxtoken = 22;
                break;
                case "entero": auxtoken = 23;
                break;
                case "real": auxtoken = 24;
                break;
                case "cadena": auxtoken = 25;
                break;
                case "Salida": auxtoken = 26;
                break;
                case "Entrada": auxtoken = 27;
                break;
                case "Si": auxtoken = 28;
                break;
                case "Entonces": auxtoken = 29; 
                break;
                case "Sino": auxtoken = 30;
                break;
                case "Finsi": auxtoken = 31;
                break;
                case "Principal": auxtoken = 32;
                break;
                case "Llamar": auxtoken = 33;
                break;
            }
        }
        return auxtoken;
    }

    public void encontrarTokens(){
        while(cont<cadena.length()){
            objLista.addToken(obtenerToken(), lexema);
        }
    }
}
