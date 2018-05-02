package clases;


//Esta clase permite identificar los tokens


public class Analizador {

    int estado = 0, error = 0, token = 0, cont = 0;
    public int tokens[] = new int[33], errores= 0;
    char c = 0;
    public String cadena = "", lexema = "", lexValidos="", lexNoValidos ="";

    public Analizador(String cadena){
        this.cadena = cadena; //.replaceAll("\\s", "");
    }

    int obtenerToken(){
        lexema = "";
        token=0;
        error=0;
        estado = 0;
        while(error==0 && token==0){
            if(cont<cadena.length()){
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
                        token = 1;
                    }
                break;
                case 2:
                    if (Character.isDigit(c) == true) {
                        estado = 2; lexema = lexema + c;
                    } else {
                        if (c == '.') {
                            estado = 18; lexema = lexema + c;
                        } else {
                            token = 2;
                        }
                    }
                break;
                case 3: estado = 19; lexema = lexema + c;
                break;
                case 4: token = 5; 
                break;
                case 5: token = 6; 
                break;
                case 6: token = 7; 
                break;
                case 7: token = 8; 
                break;
                case 8: token = 9; 
                break;
                case 9: token = 10; 
                break;
                case 10: token = 11; 
                break;
                case 11: token = 12; 
                break;
                case 12: token = 13; 
                break;
                case 13: token = 14; 
                break;
                case 14: token = 15; 
                break;
                case 15: token = 16; 
                break;
                case 16: if (c == '=') {estado = 20; lexema = lexema + c;}
                    else token = 17;
                break;
                case 17: if (c == '=') {estado = 21; lexema = lexema + c;}
                    else{
                        if (c == '>') {estado = 22; lexema = lexema + c;}
                        else token = 18;
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
                case 20: token = 19;
                break;
                case 21: token = 20;
                break;
                case 22: token = 21;
                break;
                case 23:
                    if (Character.isDigit(c)) {estado = 23; lexema = lexema + c;}
                    else token= 3;
                break;
                case 24: token = 4;
                break;
                case 25: 
                    if(c=='\n') estado = 26;
                    else estado = 25;
                break;
                case 26: token = 34;
                break;
            }
        }
        cont--;
        //if(c!=0)eliminarUltimo();
        if(error > 0) {lexNoValidos = lexema; token = 0;}
        else{
            switch(lexema){
                case "void": token = 22; 
                break;
                case "entero": token = 23; 
                break;
                case "real": token = 24; 
                break;
                case "cadena": token = 25; 
                break;
                case "Salida": token = 26; 
                break;
                case "Entrada": token = 27; 
                break;
                case "Si": token = 28;
                break;
                case "Sntonces": token = 29; 
                break;
                case "Sino": token = 30; 
                break;
                case "Finsi": token = 31; 
                break;
                case "Principal": token = 32; 
                break;
                case "Llamar": token = 33;
                break;
            }
        }
        if(error != 0){errores++;  return token;}
        return token;
    }

    public void encontrarTokens(){
        while(cont<cadena.length()){

            switch(obtenerToken()){
                case 1: tokens[0]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 2: tokens[1]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 3: tokens[2]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 4: tokens[3]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 5: tokens[4]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 6: tokens[5]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 7: tokens[6]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 8: tokens[7]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 9: tokens[8]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 10: tokens[9]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 11: tokens[10]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 12: tokens[11]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 13: tokens[12]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 14: tokens[13]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 15: tokens[14]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 16: tokens[15]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 17: tokens[16]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 18: tokens[17]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 19: tokens[18]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 20: tokens[19]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 21: tokens[20]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 22: tokens[21]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 23: tokens[22]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 24: tokens[23]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 25: tokens[24]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 26: tokens[25]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 27: tokens[26]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 28: tokens[27]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 29: tokens[28]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 30: tokens[29]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 31: tokens[30]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 32: tokens[31]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                case 33: tokens[32]++; lexValidos = lexValidos + this.lexema + '\n';
                break;
                default: lexNoValidos = lexNoValidos + this.lexema + '\n';
                break;
            }
        }
    }

    void eliminarUltimo(){
        String auxLexema = "";
        if (lexema.length() > 1){
        for (int i = 0; i < lexema.length(); i++) {
            if (i!=lexema.length()-1) {
                auxLexema= auxLexema + lexema.charAt(i);
            }
        }
        lexema = auxLexema;
        }
    }
}
