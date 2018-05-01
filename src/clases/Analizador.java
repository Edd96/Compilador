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
                if (c != ' ' && c != '\n') lexema=lexema+c;
            }
            else{
                c=0;
            }
            cont++;
            switch(estado){
                case 0:
                    if(Character.isLetterOrDigit(c)){
                        if(Character.isLetter(c)) estado = 1;
                        else estado = 2;
                    }
                    else{
                        switch(c){
                            case '"': estado = 3;
                            break;
                            case ':': estado = 4;
                            break;
                            case ';': estado = 5;
                            break;
                            case '=': estado = 6;
                            break;
                            case '+': estado = 7;
                            break;
                            case '-': estado = 8;
                            break;
                            case '*': estado = 9;
                            break;
                            case '/': estado = 10;
                            break;
                            case ',': estado = 11;
                            break;
                            case '(': estado = 12;
                            break;
                            case ')': estado = 13;
                            break;
                            case '{': estado = 14;
                            break;
                            case '}': estado = 15;
                            break;
                            case '>': estado = 16;
                            break;
                            case '<': estado = 17;
                            break;
                            default: if ( c != ' ' && c!= '\n') error = 1;
                        }
                    }
                break;
                case 1: 
                    if(Character.isLetterOrDigit(c)) estado = 1;
                    else token = 1;
                break;
                case 2: 
                    if(Character.isDigit(c)) estado = 2;
                    else{ 
                        if(c == '.') estado = 18;
                        else token = 2;
                    };
                break;
                case 3: estado = 19;
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
                case 16: if (c == '=') estado = 20;
                    else token = 17;
                break;
                case 17: if (c == '=') estado = 21;
                    else{
                        if (c == '>') estado = 22;
                        else token = 18;
                    }
                break;
                case 18:
                    if (Character.isDigit(c)) estado = 23;
                    else error= 1;
                break;
                case 19:
                    if (c=='"')estado = 24;
                    else estado = 19;
                break;
                case 20: token = 19;
                break;
                case 21: token = 20;
                break;
                case 22: token = 21;
                break;
                case 23: 
                    if (Character.isDigit(c)) estado = 23;
                    else token= 3;
                break;
                case 24: token = 4;
                break;
            }
        }
        if(c!=0)eliminarUltimo();
        switch(lexema){
                case "void": token = 22; cont++;
                break;
                case "entero": token = 23; cont++;
                break;
                case "real": token = 24; cont++;
                break;
                case "cadena": token = 25; cont++;
                break;
                case "salida": token = 26; cont++;
                break;
                case "entrada": token = 27; cont++;
                break;
                case "si": token = 28; cont++;
                break;
                case "entonces": token = 29; cont++;
                break;
                case "sino": token = 30; cont++;
                break;
                case "finsi": token = 31; cont++;
                break;
                case "principal": token = 32; cont++;
                break;
                case "llamar": token = 33; cont++;
                break;
            }
        cont--;
        if(error != 0){errores++; cont++; return token;}
        return token;
    }
    
    public void encontrarTokens(){
        while(cont<cadena.length() && error == 0){
            
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
