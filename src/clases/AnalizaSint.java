
package clases;

/**
 *
 * Con esta clase se pueden crear objetos de tipo Analizador Sintactico y
 * contiene todos los metodos necesarios para saber si el orden de los token es
 * el acptado por las gramatica del lenguaje
 */
public class AnalizaSint {
    ListaTokens lista = new ListaTokens();
    Token token;
    public String errores = "";
    boolean band = false;//si es true se valido el estado correctamente

    public AnalizaSint(ListaTokens lista) {
        this.token = lista.getPrToken();
    }

    private void addError(String tokEsperado, int l, int c) {
        errores = errores + "Error en linea: " + String.valueOf(l) + "       Columna: " + String.valueOf(c)
                + "      Se esperaba: " + tokEsperado + '\n';
    }

    public void analizar() {
        S();
        
    }

    private void S() {      
        if(token == null){
            
        }else{ 
            if(token.getId() == 22){
                FUN();
                S();
            }
        }
    }

    private void FUN() {
        if (token.getId() == 22) {
            token = token.getSig();
            if(token.getId() == 1){
                token = token.getSig();
                if (token.getId() == 13) {
                token = token.getSig();
                PAR();
                if (token.getId() == 14) {
                    token = token.getSig();
                    if (token.getId() == 15) {
                        token = token.getSig();
                        BLOQ();
                        if (token.getId() == 16) {
                            token = token.getSig();
                            // se termino correctamente una funcion
                        } else {
                            addError("}", token.getnLinea(), token.getnCol());
                        }
                    } else {
                        addError("{", token.getnLinea(), token.getnCol());
                    }
                } else {
                    addError(")", token.getnLinea(), token.getnCol());
                }
            } else {
                addError("(", token.getnLinea(), token.getnCol());
            }
            }
            
        } else {
            addError("void2", token.getnLinea(), token.getnCol());
        }
    }

    private void BLOQ() {
        if (token.getId() == 1) {
            CAB();
            BLOQ();
        } else {
            if (token.getId() == 26 | token.getId() == 27 | token.getId() == 33) {
                CALL();
                BLOQ();
            } else {
                if (token.getId() == 28) {
                    SI();
                    BLOQ();
                } else {
                    if (token.getId() == 30 | token.getId() == 31 | token.getId() == 16) {
                        // se valida
                    } else {
                        if (token == null)
                            ; // fin de bloque;
                        else {
                            // aqui no estoy seguro
                            addError("variable/funcion o Finsi/Sino", token.getnLinea(), token.getnCol());
                        }
                    }
                }
            }
        }
    }

    private void PAR() {
        if (token.getId() == 1) {
            token = token.getSig();
            if (token.getId() == 5) {
                token = token.getSig();
                TIPO();
            } else {
                addError(":", token.getnLinea(), token.getnCol());
            }
        } else {
            if(token.getId() == 14){
              band = true;  
            } else {
                addError("variable | )", token.getnLinea(), token.getnCol());
            }
        }
    }

    private void TIPO() {
        if (token.getId() == 23 | token.getId() == 24 | token.getId() == 25) {
            token = token.getSig();
        } else {
            addError("tipo de dato", token.getnLinea(), token.getnCol());
        }
    }

    private void CAB() {
        if (token.getId() == 1) {
            token = token.getSig();
            CAB1();
        } else {
            addError("variable", token.getnLinea(), token.getnCol());
        }
    }

    private void CAB1() {
        if (token.getId() == 5) {
            DEC();
        } else {
            if (token.getId() == 7) {
                ASIG();
            } else {
                addError(":/=", token.getnLinea(), token.getnCol());
            }
        }
    }

    private void DEC() {
        if (token.getId() == 5) {
            token = token.getSig();
            TIPO();
            DEC1();
            if (token.getId() == 6) {
                token = token.getSig();
            } else {
                addError(";", token.getnLinea(), token.getnCol());
            }
        } else {
            addError(":", token.getnLinea(), token.getnCol());
        }
    }

    private void DEC1() {
        if (token.getId() == 7) {
            token = token.getSig();
            DEC2();
        } else {
            if (token.getId() == 6) {
                // se valida
            } else {
                addError(";", token.getnLinea(), token.getnCol());
            }
        }
    }

    private void DEC2() {
        if (token.getId() == 1 | token.getId() == 2 | token.getId() == 3) {
            OP();
        } else {
            if (token.getId() == 4) {
                DATO();
            } else {
                addError("valor", token.getnLinea(), token.getnCol());
            }
        }
    }

    private void ASIG() {
        if (token.getId() == 7) {
            token = token.getSig();
            ASIG1();
            if (token.getId() == 6) {
                token = token.getSig();
            } else {
                addError(";", token.getnLinea(), token.getnCol());
            }
        } else {
            addError("=", token.getnLinea(), token.getnCol());
        }
    }

    private void ASIG1() {
        if (token.getId() == 1 | token.getId() == 2 | token.getId() == 3) {
            OP();
        } else {
            if (token.getId() == 4) {
                DATO();
            } else {
                addError("valor", token.getnLinea(), token.getnCol());
            }
        }
    }

    private void DATO() {
        if (token.getId() == 2 | token.getId() == 3 | token.getId() == 4) {
            token = token.getSig();
        } else {
            addError("valor", token.getnLinea(), token.getnCol());
        }
    }

    private void OP() {
        if (token.getId() == 1 | token.getId() == 2 | token.getId() == 3) {
            T();
            OP1();
        } else {
            addError("número/variable", token.getnLinea(), token.getnCol());
        }
    }

    private void OP1() {
        if (token.getId() == 8) {
            token = token.getSig();
            T();
            OP1();
        } else {
            if (token.getId() == 9) {
                token = token.getSig();
                T();
                OP1();
            } else {
                if (token.getId() == 6 | token.getId() == 14) {
                    // se llego
                } else {
                    if (token == null) {
                        // valido
                    } else {
                        addError("+/- o nombre", token.getnLinea(), token.getnCol());
                    }
                }
            }
        }
    }

    private void T() {
        if (token.getId() == 1 | token.getId() == 2 | token.getId() == 3) {
            F();
            T1();
        } else {
            addError("número/variable", token.getnLinea(), token.getnCol());
        }
    }

    private void T1() {
        if (token.getId() == 6 | token.getId() == 8 | token.getId() == 9) {
            // valido
        } else {
            if (token.getId() == 10) {
                token = token.getSig();
                F();
                T1();
            } else {
                if (token.getId() == 11) {
                    token = token.getSig();
                    F();
                    T1();
                } else {
                    if (token.getId() == 6 | token.getId() == 8 | token.getId() == 9 | token.getId() == 14) {
                    // se llego
                } else {
                    if (token == null) {
                        // valido
                    } else {
                        addError("* | / o nombre", token.getnLinea(), token.getnCol());
                    }
                }
                }
            }
        }
    }

    private void F() {
        if (token.getId() == 1 | token.getId() == 2 | token.getId() == 3) {
            token = token.getSig();
        } else {
            addError("número/variable", token.getnLinea(), token.getnCol());
        }
    }

    private void CALL() {
        if (token.getId() == 26) {
            token = token.getSig();
            if (token.getId() == 13) {
                token = token.getSig();
                SALE();
                if (token.getId() == 14) {
                    token = token.getSig();
                    if (token.getId() == 6) {
                        token = token.getSig();
                        // valido
                    } else {
                        addError(";", token.getnLinea(), token.getnCol());
                    }
                } else {
                    addError(")", token.getnLinea(), token.getnCol());
                }
            } else {
                addError("(", token.getnLinea(), token.getnCol());
            }
        } else {
            if (token.getId() == 27) {
                token = token.getSig();
                if (token.getId() == 13) {
                    token = token.getSig();
                    if (token.getId() == 1) {
                        token = token.getSig();
                        if (token.getId() == 14) {
                            token = token.getSig();
                            if (token.getId() == 6) {
                                token = token.getSig();
                                // valido
                            } else {
                                addError(";", token.getnLinea(), token.getnCol());
                            }
                        } else {
                            addError(")", token.getnLinea(), token.getnCol());
                        }
                    } else {
                        addError("variable", token.getnLinea(), token.getnCol());
                    }
                } else {
                    addError("(", token.getnLinea(), token.getnCol());
                }
            } else {
                if(token.getId() == 33){
                    token = token.getSig();
                    LL();
                    if (token.getId() == 14) {
                            token = token.getSig();
                            if (token.getId() == 6) {
                                token = token.getSig();
                                // valido
                            } else {
                                addError(";", token.getnLinea(), token.getnCol());
                            }
                        } else {
                            addError(")", token.getnLinea(), token.getnCol());
                        }
                }
                else{
                    addError("Nombre funcion", token.getnLinea(), token.getnCol());
                }
            }
        }
    }

    private void LL() {
        if (token.getId() == 1) {
            token = token.getSig();
            if (token.getId() == 13) {
                token = token.getSig();
                A();
                if (token.getId() == 14) {
                    token = token.getSig();
                } else {
                    addError(")", token.getnLinea(), token.getnCol());
                }
            } else {
                addError("(", token.getnLinea(), token.getnCol());
            }
        } else {
            addError("variable", token.getnLinea(), token.getnCol());
        }
    }

    private void A() {
        if (token.getId() == 1) {
            token = token.getSig();
        } else {
            if (token.getId() == 2 | token.getId() == 3 | token.getId() == 4) {
                DATO();
            } else {
                if (token.getId() == 11) {
                    // valido
                } else {
                    if (token == null) {
                        // valido
                    } else {
                        addError("variable/dato/(", token.getnLinea(), token.getnCol());
                    }
                }
            }
        }
    }

    private void SALE() {
        if (token.getId() == 1 | token.getId() == 2 | token.getId() == 3 | token.getId() == 4) {
            SALE1();
            SALE2();
        } else {
            addError("variable/dato", token.getnLinea(), token.getnCol());
        }
    }

    private void SALE1() {
        if (token.getId() == 1) {
            token = token.getSig();
        } else {
            if (token.getId() == 2 | token.getId() == 3) {
                OP();
            } else {
                if (token.getId() == 4) {
                    DATO();
                } else {
                    addError("variable/dato", token.getnLinea(), token.getnCol());
                }
            }
        }
    }

    private void SALE2() {
        if (token.getId() == 12) {
            token = token.getSig();
            SALE1();
            SALE2();
        } else {
            if (token.getId() == 14) {
                // validar
            } else {
                if (token == null) {
                    // validar
                } else {
                    addError(",/)", token.getnLinea(), token.getnCol());
                }
            }
        }
    }

    private void SI() {
        if(token.getId() == 28){
            token = token.getSig();
            if(token.getId() == 13){
                token = token.getSig();
                CON();
                if(token.getId() == 14){
                    token = token.getSig();
                    if(token.getId() == 29){
                        token = token.getSig();
                        BLOQ();
                        SI1();
                    } else {
                        addError("Entonces", token.getnLinea(), token.getnCol());
                    }
                } else {
                    addError(")", token.getnLinea(), token.getnCol());
                }
            } else {
                addError("(", token.getnLinea(), token.getnCol());
            }
        } else {
            addError("Si", token.getnLinea(), token.getnCol());
        }
    }

    private void SI1() {
        if(token.getId()==30){
            token = token.getSig();
            BLOQ();
            if(token.getId() == 31){
                token = token.getSig();
            } else {
                addError("Finsi", token.getnLinea(), token.getnCol());
            }
        } else {
            if(token.getId() == 31){
                token = token.getSig();
            } else {
                addError("Sino/Finsi", token.getnLinea(), token.getnCol());
            }
        }
    }

    private void CON() {
        if (token.getId() == 1 | token.getId() == 2 | token.getId() == 3 | token.getId() == 4) {
            B();
            COMP();
            C();
        } else {
            addError("variable/dato", token.getnLinea(), token.getnCol());
        }
    }

    private void B() {
        if (token.getId() == 1 | token.getId() == 2 | token.getId() == 3 | token.getId() == 4) {
            C();
        } else {
            addError("variable/dato", token.getnLinea(), token.getnCol());
        }
    }

    private void C() {
        if (token.getId() == 1 | token.getId() == 2 | token.getId() == 3 | token.getId() == 4) {
            token = token.getSig();
        } else {
            addError("variable/dato", token.getnLinea(), token.getnCol());
        }
    }

    private void COMP() {
        if (token.getId() == 7) {
            token = token.getSig();
        } else {
            if(token.getId() == 17){
                token = token.getSig();
                COMP1();
            } else {
                if(token.getId() == 18){
                    token = token.getSig();
                    COMP2();
                } else {
                    addError("> | < | =", token.getnLinea(), token.getnCol());
                }     
            }
        }
    }

    private void COMP1() {
        if (token.getId() == 1 | token.getId() == 2 | token.getId() == 3 | token.getId() == 4) {
            //valido
        } else {
            if(token.getId() == 7){
                token = token.getSig();
            } else{
                addError("variable | dato | =", token.getnLinea(), token.getnCol());
            }
        }
    }

    private void COMP2() {
        if (token.getId() == 1 | token.getId() == 2 | token.getId() == 3 | token.getId() == 4) {
            //valido
        } else {
            if(token.getId() == 7){
                token = token.getSig();
            } else{
                if(token.getId() == 17){
                    token = token.getSig();
                } else {
                    addError("variable | dato | = | >", token.getnLinea(), token.getnCol());
                }
            }
        }
    }
}
