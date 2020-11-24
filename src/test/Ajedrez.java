package test;

import domain.*;

import java.io.PrintStream;
import java.util.Scanner;

public class Ajedrez {

    private static Pieza piezas[][] = new Pieza[8][8];
    private static Scanner reader = new Scanner(System.in);
    private static int fichaOrigenX;
    private static int fichaOrigenY;
    private static int fichaDestinoX;
    private static int fichaDestinoY;
    private static boolean estado = false;
    private static PrintStream out = System.out;
    private static String color = "Blanco";

    public static void main(String[] args) {
        inciarTablero();
        imprimirTurno();
        while (estado == true) {
            imprimirTablero();
            preguntarDatos();
            if (validarLimites()) {
                if (validarOrigen() == true && validarDestino() == true) {
                    if (validarRecorrido() == true) {
                        moverFicha();
                        cambiarTurno();
                    } else {
                        out.println("Movimiento invalido intentelo de nuevo");
                    }
                } else {
                    out.println("Movimiento invalido intentelo de nuevo");
                }
            }else {
                out.println("No se va ha caer asi intentelo  again");
            }
        }
        imprimirTablero();
    }

    private static void imprimirTurno() {
        out.println("Color: " + color);
    }

    private static boolean validarLimites() {
        if((fichaOrigenX <0) || (fichaOrigenX>7) || (fichaDestinoX< 0) || (fichaDestinoX>7) || (fichaOrigenY <0) || (fichaOrigenY>7) || (fichaDestinoY< 0) || (fichaDestinoY>7)){
            out.println("░░░░░░░░░░░░░░▄▄▄▄▄▄▄▄▄▄▄▄░░░░░░░░░░░░░░\n" +
                    "░░░░░░░░░░░░▄████████████████▄░░░░░░░░░░\n" +
                    "░░░░░░░░░░▄██▀░░░░░░░▀▀████████▄░░░░░░░░\n" +
                    "░░░░░░░░░▄█▀░░░░░░░░░░░░░▀▀██████▄░░░░░░\n" +
                    "░░░░░░░░░███▄░░░░░░░░░░░░░░░▀██████░░░░░\n" +
                    "░░░░░░░░▄░░▀▀█░░░░░░░░░░░░░░░░██████░░░░\n" +
                    "░░░░░░░█▄██▀▄░░░░░▄███▄▄░░░░░░███████░░░\n" +
                    "░░░░░░▄▀▀▀██▀░░░░░▄▄▄░░▀█░░░░█████████░░\n" +
                    "░░░░░▄▀░░░░▄▀░▄░░█▄██▀▄░░░░░██████████░░\n" +
                    "░░░░░█░░░░▀░░░█░░░▀▀▀▀▀░░░░░██████████▄░\n" +
                    "░░░░░░░▄█▄░░░░░▄░░░░░░░░░░░░██████████▀░\n" +
                    "░░░░░░█▀░░░░▀▀░░░░░░░░░░░░░███▀███████░░\n" +
                    "░░░▄▄░▀░▄░░░░░░░░░░░░░░░░░░▀░░░██████░░░\n" +
                    "██████░░█▄█▀░▄░░██░░░░░░░░░░░█▄█████▀░░░\n" +
                    "██████░░░▀████▀░▀░░░░░░░░░░░▄▀█████████▄\n" +
                    "██████░░░░░░░░░░░░░░░░░░░░▀▄████████████\n" +
                    "██████░░▄░░░░░░░░░░░░░▄░░░██████████████\n" +
                    "██████░░░░░░░░░░░░░▄█▀░░▄███████████████\n" +
                    "███████▄▄░░░░░░░░░▀░░░▄▀▄███████████████");
            return false;
        }
        return true;
    }

    private static void moverFicha() {
        piezas[fichaDestinoX][fichaDestinoY] = piezas[fichaOrigenX][fichaOrigenY];
        PiezaVacia pv = new PiezaVacia(0, 0, "__", "__");
        piezas[fichaOrigenX][fichaOrigenY] = pv;
    }

    static void cambiarTurno() {
        if (color == "Blanco") {
            color = "Negro";
        } else {
            color = "Blanco";
        }
    }

    static boolean validarOrigen() {
        if (piezas[fichaOrigenX][fichaOrigenY] instanceof PiezaVacia || piezas[fichaOrigenX][fichaOrigenY].getColor() != color) {
            return false;
        }
        return true;
    }

    static boolean validarDestino() {
        if (piezas[fichaDestinoX][fichaDestinoY].getColor() == color) {
            return false;
        }
        return true;
    }

    static boolean validarRecorrido() {
        switch (piezas[fichaOrigenX][fichaOrigenY].getTipo()) {
            case "PN":
                return movimientoPeonNegro();
            case "PB":
                return movimientoPeonBlanco();
            case "TN":
                return movimientoTorre();
            case "TB":
                return movimientoTorre();
            case "AN":
                return movimientoAlfil();
            case "AB":
                return movimientoAlfil();
            case "CN":
                return movimientoCaballo();
            case "CB":
                return movimientoCaballo();
            case "RN":
                return movimientoRey();
            case "RB":
                return movimientoRey();
            case "DN":
                return movimientoDama();
            case "DB":
                return movimientoDama();
            default:
                out.println("A ocurrido un error impermisible");
                break;
        }
        return false;
    }

    private static boolean movimientoDama() {
        if(movimientoTorre() || movimientoAlfil()){
            return true;
        }
        return false;
    }

    private static boolean movimientoRey() {
        return true;
    }

    private static boolean movimientoCaballo() {
        //Derecha abajo y arriba
        if (fichaDestinoX == (fichaOrigenX + 2) && (fichaDestinoY == (fichaOrigenY + 1) || fichaDestinoY == (fichaOrigenY - 1))) {
            return true;
        }

        //Izquierda abajo y arriba
        if (fichaDestinoX == (fichaOrigenX - 2) && (fichaDestinoY == (fichaOrigenY + 1) || fichaDestinoY == (fichaOrigenY - 1))) {
            return true;
        }
        //Abajo derecha y izquierda
        if (fichaDestinoY == (fichaOrigenY + 2) && (fichaDestinoX == (fichaOrigenX + 1) || fichaDestinoX == (fichaOrigenX - 1))) {
            return true;
        }
        //Arriba derecha y izquierda
        if (fichaDestinoY == (fichaOrigenY - 2) && (fichaDestinoX == (fichaOrigenX + 1) || fichaDestinoX == (fichaOrigenX - 1))) {
            return true;
        }
        return false;
    }

    private static boolean movimientoAlfil() {
        //Derecha arriba
        if (fichaDestinoX > fichaOrigenX && fichaDestinoY < fichaOrigenY) {
            int i , j;
            i = fichaOrigenX + 1;
            j = fichaOrigenY -1;
            do {
                if (!(piezas[i][j] instanceof PiezaVacia )){
                    return false;
                }
                i++;
                j--;
            }while(i< fichaDestinoX && j>fichaDestinoY);
            return true;
        }
        //Derecha abajo
        if (fichaDestinoX > fichaOrigenX && fichaDestinoY > fichaOrigenY) {
            int i , j;
            i = fichaOrigenX + 1;
            j = fichaOrigenY + 1;
            do {
                if (!(piezas[i][j] instanceof PiezaVacia )){
                    return false;
                }
                i++;
                j++;
            }while((i< fichaDestinoX) && (j<fichaDestinoY));
            return true;
        }
        //Izquierda arriba
        if (fichaDestinoX < fichaOrigenX && fichaDestinoY < fichaOrigenY) {
            int i , j;
            i = fichaOrigenX -1;
            j = fichaOrigenY -1;
            do {
                if (!(piezas[i][j] instanceof PiezaVacia )){
                    return false;
                }
                i--;
                j--;
            }while(i<fichaDestinoX && j<fichaDestinoY);
            return true;
        }
        //Izquierda abajo
        if (fichaDestinoX < fichaOrigenX && fichaDestinoY > fichaOrigenY) {
            int i , j;
            i = fichaOrigenX -1;
            j = fichaOrigenY +1;
            do {
                if (!(piezas[i][j] instanceof PiezaVacia )){
                    return false;
                }
                i--;
                j++;
            }while(i< fichaDestinoX && j>fichaDestinoY);
            return true;
        }
        return false;
    }

    private static boolean movimientoTorre() {
        //para abajo
        if (fichaOrigenX == fichaDestinoX && fichaOrigenY < fichaDestinoY) {
            for (int i = (fichaOrigenY + 1); i <= (fichaDestinoY - 1); i++) {
                if (!(piezas[fichaOrigenX][i] instanceof PiezaVacia)) {
                    return false;
                }
            }
        }
        //para arriba
        if (fichaOrigenX == fichaDestinoX && fichaOrigenY > fichaDestinoY) {
            for (int i = (fichaOrigenY - 1); i > (fichaDestinoY); i--) {
                if (!(piezas[fichaOrigenX][i] instanceof PiezaVacia)) {
                    return false;
                }
            }
        }
        //para derecha
        if (fichaOrigenY == fichaDestinoY && fichaOrigenX < fichaDestinoX) {
            for (int i = (fichaOrigenX + 1); i <= (fichaDestinoX - 1); i++) {
                if (!(piezas[i][fichaOrigenY] instanceof PiezaVacia)) {
                    return false;
                }
            }
        }
        //para izquierda
        if (fichaOrigenY == fichaDestinoY && fichaOrigenX > fichaDestinoX) {
            for (int i = (fichaOrigenX - 1); i > (fichaDestinoX + 1); i--) {
                if (!(piezas[i][fichaOrigenY] instanceof PiezaVacia)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean movimientoPeonBlanco() {
        if (fichaOrigenY == 6 && fichaDestinoY == (fichaOrigenY - 2)&& fichaOrigenX == fichaDestinoX) {
            for (int i = 5; i > 4; i--) {
                if ((piezas[fichaOrigenX][i] instanceof PiezaVacia) == false) {
                    return false;
                }
            }
            return true;
        }
        if(fichaDestinoY == (fichaOrigenY - 1) && ((piezas[fichaDestinoX][fichaDestinoY] instanceof PiezaVacia)==false && (fichaDestinoX == (fichaOrigenX - 1) || fichaDestinoX == (fichaOrigenX + 1)))) {
            return true;
        }
        if (fichaDestinoY == (fichaOrigenY - 1) && (piezas[fichaDestinoX][fichaDestinoY] instanceof PiezaVacia) && fichaOrigenX == fichaDestinoX) {
            return true;
        }
        return false;
    }

    private static boolean movimientoPeonNegro() {
        if (fichaOrigenY == 1 && fichaDestinoY == (fichaOrigenY + 2)&& fichaOrigenX == fichaDestinoX) {
            for (int i = 2; i < 4; i++) {
                if ((piezas[fichaOrigenX][i] instanceof PiezaVacia) == false) {
                    return false;
                }
            }
            return true;
        }
        if (fichaDestinoY == (fichaOrigenY + 1) && (piezas[fichaDestinoX][fichaDestinoY] instanceof PiezaVacia) && fichaOrigenX == fichaDestinoX) {
            return true;
        }

        if ((fichaDestinoY == (fichaOrigenY + 1)) && (fichaDestinoX == (fichaOrigenX - 1) || fichaDestinoX == (fichaOrigenX + 1)) && (!(piezas[fichaDestinoX][fichaDestinoY] instanceof PiezaVacia))) {
            return true;
        }
        return false;
    }

    static void preguntarDatos() {
        out.println("Digite la casilla de la ficha a mover");
        out.println("X");
        fichaOrigenX = Integer.parseInt(reader.nextLine());
        out.println("Y");
        fichaOrigenY = Integer.parseInt(reader.nextLine());
        out.println("Digite la casilla destino de la ficha");
        out.println("X");
        fichaDestinoX = Integer.parseInt(reader.nextLine());
        out.println("Y");
        fichaDestinoY = Integer.parseInt(reader.nextLine());
    }

    static void inciarTablero() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                PiezaVacia pv = new PiezaVacia(0, 0, "__", "__");
                piezas[i][j] = pv;
            }
        }

        Peon peon1 = new Peon(1, 0, "Negro", "PN");
        Peon peon2 = new Peon(1, 1, "Negro", "PN");
        Peon peon3 = new Peon(1, 2, "Negro", "PN");
        Peon peon4 = new Peon(1, 3, "Negro", "PN");
        Peon peon5 = new Peon(1, 4, "Negro", "PN");
        Peon peon6 = new Peon(1, 5, "Negro", "PN");
        Peon peon7 = new Peon(1, 6, "Negro", "PN");
        Peon peon8 = new Peon(1, 7, "Negro", "PN");

        Torre torre1 = new Torre(0, 0, "Negro", "TN");
        Torre torre2 = new Torre(0, 7, "Negro", "TN");
        Alfil alfil1 = new Alfil(0, 2, "Negro", "AN");
        Alfil alfil2 = new Alfil(0, 5, "Negro", "AN");
        Caballo caballo1 = new Caballo(0, 1, "Negro", "CN");
        Caballo caballo2 = new Caballo(0, 6, "Negro", "CN");
        Reina reina1 = new Reina(0, 3, "Negro", "DN");
        Rey rey = new Rey(0, 4, "Negro", "RN");

        piezas[0][1] = peon1;
        piezas[1][1] = peon2;
        piezas[2][1] = peon3;
        piezas[3][1] = peon4;
        piezas[4][1] = peon5;
        piezas[5][1] = peon6;
        piezas[6][1] = peon7;
        piezas[7][1] = peon8;

        piezas[0][0] = torre1;
        piezas[7][0] = torre2;
        piezas[2][0] = alfil1;
        piezas[5][0] = alfil2;
        piezas[1][0] = caballo1;
        piezas[6][0] = caballo2;
        piezas[3][0] = reina1;
        piezas[4][0] = rey;
        Peon peon9 = new Peon(1, 0, "Blanco", "PB");
        Peon peon10 = new Peon(1, 1, "Blanco", "PB");
        Peon peon11 = new Peon(1, 2, "Blanco", "PB");
        Peon peon12 = new Peon(1, 3, "Blanco", "PB");
        Peon peon13 = new Peon(1, 4, "Blanco", "PB");
        Peon peon14 = new Peon(1, 5, "Blanco", "PB");
        Peon peon15 = new Peon(1, 6, "Blanco", "PB");
        Peon peon16 = new Peon(1, 7, "Blanco", "PB");

        Torre torre3 = new Torre(0, 0, "Blanco", "TB");
        Torre torre4 = new Torre(0, 7, "Blanco", "TB");
        Alfil alfil3 = new Alfil(0, 2, "Blanco", "AB");
        Alfil alfil4 = new Alfil(0, 5, "Blanco", "AB");
        Caballo caballo3 = new Caballo(0, 1, "Blanco", "CB");
        Caballo caballo4 = new Caballo(0, 6, "Blanco", "CB");
        Reina reina2 = new Reina(0, 3, "Blanco", "DB");
        Rey rey2 = new Rey(0, 4, "Blanco", "RB");

        piezas[0][6] = peon9;
        piezas[1][6] = peon10;
        piezas[2][6] = peon11;
        piezas[3][6] = peon12;
        piezas[4][6] = peon13;
        piezas[5][6] = peon14;
        piezas[6][6] = peon15;
        piezas[7][6] = peon16;

        piezas[0][7] = torre3;
        piezas[7][7] = torre4;
        piezas[2][7] = alfil3;
        piezas[5][7] = alfil4;
        piezas[1][7] = caballo3;
        piezas[6][7] = caballo4;
        piezas[3][7] = reina2;
        piezas[4][7] = rey2;

        estado = true;
    }

    static void imprimirTablero() {
        System.out.println("****************************Tablero****************************\n" +
                "Y\t\t" + "0 \t" + "1 \t" + "2 \t" + "3 \t" + "4 \t" + "5 \t" + "6 \t" + "7 \t" + " X \n" +
                "0\t\t" + piezas[0][0].toString() + "\t" + piezas[1][0].toString() + "\t" + piezas[2][0].toString() + "\t" + piezas[3][0].toString() + "\t" + piezas[4][0].toString() + "\t" + piezas[5][0].toString() + "\t" + piezas[6][0].toString() + "\t" + piezas[7][0].toString() + "\n" +
                "1\t\t" + piezas[0][1].toString() + "\t" + piezas[1][1].toString() + "\t" + piezas[2][1].toString() + "\t" + piezas[3][1].toString() + "\t" + piezas[4][1].toString() + "\t" + piezas[5][1].toString() + "\t" + piezas[6][1].toString() + "\t" + piezas[7][1].toString() + "\n" +
                "2\t\t" + piezas[0][2].toString() + "\t" + piezas[1][2].toString() + "\t" + piezas[2][2].toString() + "\t" + piezas[3][2].toString() + "\t" + piezas[4][2].toString() + "\t" + piezas[5][2].toString() + "\t" + piezas[6][2].toString() + "\t" + piezas[7][2].toString() + "\n" +
                "3\t\t" + piezas[0][3].toString() + "\t" + piezas[1][3].toString() + "\t" + piezas[2][3].toString() + "\t" + piezas[3][3].toString() + "\t" + piezas[4][3].toString() + "\t" + piezas[5][3].toString() + "\t" + piezas[6][3].toString() + "\t" + piezas[7][3].toString() + "\n" +
                "4\t\t" + piezas[0][4].toString() + "\t" + piezas[1][4].toString() + "\t" + piezas[2][4].toString() + "\t" + piezas[3][4].toString() + "\t" + piezas[4][4].toString() + "\t" + piezas[5][4].toString() + "\t" + piezas[6][4].toString() + "\t" + piezas[7][4].toString() + "\n" +
                "5\t\t" + piezas[0][5].toString() + "\t" + piezas[1][5].toString() + "\t" + piezas[2][5].toString() + "\t" + piezas[3][5].toString() + "\t" + piezas[4][5].toString() + "\t" + piezas[5][5].toString() + "\t" + piezas[6][5].toString() + "\t" + piezas[7][5].toString() + "\n" +
                "6\t\t" + piezas[0][6].toString() + "\t" + piezas[1][6].toString() + "\t" + piezas[2][6].toString() + "\t" + piezas[3][6].toString() + "\t" + piezas[4][6].toString() + "\t" + piezas[5][6].toString() + "\t" + piezas[6][6].toString() + "\t" + piezas[7][6].toString() + "\n" +
                "7\t\t" + piezas[0][7].toString() + "\t" + piezas[1][7].toString() + "\t" + piezas[2][7].toString() + "\t" + piezas[3][7].toString() + "\t" + piezas[4][7].toString() + "\t" + piezas[5][7].toString() + "\t" + piezas[6][7].toString() + "\t" + piezas[7][7].toString() + "\n");
    }

}


