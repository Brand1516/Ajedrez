package test;

import domain.*;

import java.io.PrintStream;
import java.util.Scanner;

public class Ajedrez {

    private static Pieza piezas [][] = new Pieza[8][8];
    private static Scanner reader = new Scanner(System.in);
    private static int fichaOrigenX;
    private static int fichaOrigenY;
    private static int fichaDestinoX;
    private static int fichaDestinoY;
    private static boolean estado = false;
    private static PrintStream out = System.out;

    public static void main(String[] args) {

        inciarTablero();
        while (estado == true){
            imprimirTablero();

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


            if(piezas[fichaOrigenX][fichaOrigenY] == null){
                System.out.println("No hay niguna ficha para mover ");
            }else {
                if (piezas[fichaDestinoX][fichaDestinoY] != null) {
                    String colorOrigen;
                    String colorDestino;
                    boolean verificarColor;
                    colorOrigen = piezas[fichaOrigenX][fichaOrigenY].getColor();
                    System.out.println("Color de la pieza Origen" + piezas[fichaOrigenX][fichaOrigenY].getColor());
                    colorDestino = piezas[fichaDestinoX][fichaDestinoY].getColor();
                    System.out.println("Color de la pieza Destino" + piezas[fichaDestinoX][fichaDestinoY].getColor());
                    verificarColor = colorOrigen == colorDestino;
                    if (verificarColor) {
                        System.out.println("No puede mover, hay una ficha de su equipo");
                    }

                    if (colorOrigen == "Negro") {
                        if (verificarColor == false) {
                            String tipoOrigen;
                            tipoOrigen = piezas[fichaOrigenX][fichaOrigenY].getTipo();
                            switch (tipoOrigen) {
                                case "Peon":
                                    System.out.println("Es peon");
                                    if (fichaOrigenX == fichaDestinoX) {
                                        if (fichaOrigenX == fichaDestinoX) {
                                            for (int i = fichaOrigenY; i < 2; i++) {
                                                if (piezas[fichaOrigenX][i] != null){
                                                }
                                            }
                                            Pieza piezaOrigenPeon;
                                            piezaOrigenPeon = piezas[fichaOrigenX][fichaOrigenY];
                                            piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenPeon;
                                            piezas[fichaOrigenX][fichaOrigenY] = null;
                                        }
                                    }
                                    break;
                                case "Torre":
                                    System.out.println("Es Torre");
                                    if (fichaOrigenX == fichaDestinoX || fichaOrigenY == fichaDestinoY) {
                                        if (fichaOrigenX == fichaDestinoX) {
                                            for (int i = fichaOrigenY; i < fichaDestinoY; i++) {
                                                if (piezas[fichaOrigenX][i] != null) {
                                                }
                                            }
                                            Pieza piezaOrigenTorre;
                                            piezaOrigenTorre = piezas[fichaOrigenX][fichaOrigenY];
                                            piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenTorre;
                                            piezas[fichaOrigenX][fichaOrigenY] = null;
                                        }
                                        if (fichaOrigenY == fichaDestinoY) {
                                            for (int i = fichaOrigenX; i < fichaDestinoX; i++) {
                                                if (piezas[i][fichaOrigenY] != null) ;
                                            }
                                            Pieza piezaOrigenTorre;
                                            piezaOrigenTorre = piezas[fichaOrigenX][fichaOrigenY];
                                            piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenTorre;
                                            piezas[fichaOrigenX][fichaOrigenY] = null;
                                        }
                                    } else {
                                        System.out.println("Movimiento invalido");
                                    }
                                    break;
                                case "Caballo":
                                    System.out.println("Es Caballo");


                                    Pieza piezaOrigenCaballo;
                                    piezaOrigenCaballo = piezas[fichaOrigenX][fichaOrigenY];
                                    piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenCaballo;
                                    piezas[fichaOrigenX][fichaOrigenY] = null;
                                    break;
                                case "Alfil":
                                    System.out.println("Es Alfil");
                                    Pieza piezaOrigenAlfil;
                                    piezaOrigenAlfil = piezas[fichaOrigenX][fichaOrigenY];
                                    piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenAlfil;
                                    piezas[fichaOrigenX][fichaOrigenY] = null;
                                    break;
                                case "Reina":
                                    System.out.println("Es Reina");
                                    Pieza piezaOrigenReina;
                                    piezaOrigenReina = piezas[fichaOrigenX][fichaOrigenY];
                                    piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenReina;
                                    piezas[fichaOrigenX][fichaOrigenY] = null;
                                    break;
                                case "Rey":
                                    System.out.println("Es Rey");
                                    Pieza piezaOrigenRey;
                                    piezaOrigenRey = piezas[fichaOrigenX][fichaOrigenY];
                                    piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenRey;
                                    piezas[fichaOrigenX][fichaOrigenY] = null;
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    if (colorOrigen == "Blanco") {
                        if (verificarColor == false) {
                            String tipoOrigen;
                            tipoOrigen = piezas[fichaOrigenX][fichaOrigenY].getTipo();
                            switch (tipoOrigen) {
                                case "Peon":
                                    System.out.println("Es peon");

                                    if (fichaOrigenX == fichaDestinoX) {
                                        if (fichaOrigenX == fichaDestinoX) {
                                            for (int i = fichaOrigenY; i < fichaDestinoY; i++) {
                                                if (piezas[fichaOrigenX][i] != null) ;
                                            }

                                            Pieza piezaOrigenPeon;
                                            piezaOrigenPeon = piezas[fichaOrigenX][fichaOrigenY];
                                            piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenPeon;
                                            piezas[fichaOrigenX][fichaOrigenY] = null;
                                        }
                                    }
                                    break;
                                case "Torre":
                                    System.out.println("Es Torre");
                                    if (fichaOrigenX == fichaDestinoX || fichaOrigenY == fichaDestinoY) {
                                        if (fichaOrigenX == fichaDestinoX) {
                                            for (int i = fichaOrigenY; i < fichaDestinoY; i++) {
                                                if (piezas[fichaOrigenX][i] != null) {
                                                }
                                            }
                                            Pieza piezaOrigenTorre;
                                            piezaOrigenTorre = piezas[fichaOrigenX][fichaOrigenY];
                                            piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenTorre;
                                            piezas[fichaOrigenX][fichaOrigenY] = null;
                                        }
                                        if (fichaOrigenY == fichaDestinoY) {
                                            for (int i = fichaOrigenX; i < fichaDestinoX; i++) {
                                                if (piezas[i][fichaOrigenY] != null) ;
                                            }
                                            Pieza piezaOrigenTorre;
                                            piezaOrigenTorre = piezas[fichaOrigenX][fichaOrigenY];
                                            piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenTorre;
                                            piezas[fichaOrigenX][fichaOrigenY] = null;
                                        }
                                    } else {
                                        System.out.println("Movimiento invalido");
                                    }
                                    break;
                                case "Caballo":
                                    System.out.println("Es Caballo");


                                    Pieza piezaOrigenCaballo;
                                    piezaOrigenCaballo = piezas[fichaOrigenX][fichaOrigenY];
                                    piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenCaballo;
                                    piezas[fichaOrigenX][fichaOrigenY] = null;
                                    break;
                                case "Alfil":
                                    System.out.println("Es Alfil");
                                    Pieza piezaOrigenAlfil;
                                    piezaOrigenAlfil = piezas[fichaOrigenX][fichaOrigenY];
                                    piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenAlfil;
                                    piezas[fichaOrigenX][fichaOrigenY] = null;
                                    break;
                                case "Reina":
                                    System.out.println("Es Reina");
                                    Pieza piezaOrigenReina;
                                    piezaOrigenReina = piezas[fichaOrigenX][fichaOrigenY];
                                    piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenReina;
                                    piezas[fichaOrigenX][fichaOrigenY] = null;
                                    break;
                                case "Rey":
                                    System.out.println("Es Rey");
                                    Pieza piezaOrigenRey;
                                    piezaOrigenRey = piezas[fichaOrigenX][fichaOrigenY];
                                    piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenRey;
                                    piezas[fichaOrigenX][fichaOrigenY] = null;
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }else{
                    String colorOrigen;
                    String colorDestino;
                    boolean verificarColor;
                    colorOrigen = piezas[fichaOrigenX][fichaOrigenY].getColor();
                    System.out.println("Color de la pieza Origen" + piezas[fichaOrigenX][fichaOrigenY].getColor());
                    //colorDestino = piezas[fichaDestinoX][fichaDestinoY].getColor();
                    //System.out.println("Color de la pieza Destino" + piezas[fichaDestinoX][fichaDestinoY].getColor());
                    //verificarColor = colorOrigen == colorDestino;
                    /*if (verificarColor) {
                        System.out.println("No puede mover, hay una ficha de su equipo");
                    }*/

                    if (colorOrigen == "Negro") {
                            String tipoOrigen;
                            tipoOrigen = piezas[fichaOrigenX][fichaOrigenY].getTipo();
                            switch (tipoOrigen) {
                                case "Peon":
                                    System.out.println("Es peon");
                                    if (fichaOrigenX == fichaDestinoX) {
                                        if (fichaOrigenX == fichaDestinoX) {
                                            for (int i = fichaOrigenY; i < fichaDestinoY; i++) {
                                                if (piezas[fichaOrigenX][i] != null){
                                                }
                                            }
                                            Pieza piezaOrigenPeon;
                                            piezaOrigenPeon = piezas[fichaOrigenX][fichaOrigenY];
                                            piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenPeon;
                                            piezas[fichaOrigenX][fichaOrigenY] = null;
                                        }
                                    }
                                    if (fichaOrigenX == fichaDestinoX) {
                                        if (fichaOrigenX == fichaDestinoX) {
                                            for (int i = fichaOrigenY; i < fichaDestinoY; i++) {
                                                if (piezas[fichaOrigenX][i] != null){

                                                }
                                            }
                                            Pieza piezaOrigenPeon;
                                            piezaOrigenPeon = piezas[fichaOrigenX][fichaOrigenY];
                                            piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenPeon;
                                            piezas[fichaOrigenX][fichaOrigenY] = null;
                                        }
                                    }
                                    break;
                                case "Torre":
                                    System.out.println("Es Torre");
                                    if (fichaOrigenX == fichaDestinoX || fichaOrigenY == fichaDestinoY) {
                                        if (fichaOrigenX == fichaDestinoX) {
                                            for (int i = fichaOrigenY; i < fichaDestinoY; i++) {
                                                if (piezas[fichaOrigenX][i] != null) {
                                                }
                                            }
                                            Pieza piezaOrigenTorre;
                                            piezaOrigenTorre = piezas[fichaOrigenX][fichaOrigenY];
                                            piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenTorre;
                                            piezas[fichaOrigenX][fichaOrigenY] = null;
                                        }
                                        if (fichaOrigenY == fichaDestinoY) {
                                            for (int i = fichaOrigenX; i < fichaDestinoX; i++) {
                                                if (piezas[i][fichaOrigenY] != null) ;
                                            }
                                            Pieza piezaOrigenTorre;
                                            piezaOrigenTorre = piezas[fichaOrigenX][fichaOrigenY];
                                            piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenTorre;
                                            piezas[fichaOrigenX][fichaOrigenY] = null;
                                        }
                                    } else {
                                        System.out.println("Movimiento invalido");
                                    }
                                    break;
                                case "Caballo":
                                    System.out.println("Es Caballo");


                                    Pieza piezaOrigenCaballo;
                                    piezaOrigenCaballo = piezas[fichaOrigenX][fichaOrigenY];
                                    piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenCaballo;
                                    piezas[fichaOrigenX][fichaOrigenY] = null;
                                    break;
                                case "Alfil":
                                    System.out.println("Es Alfil");
                                    Pieza piezaOrigenAlfil;
                                    piezaOrigenAlfil = piezas[fichaOrigenX][fichaOrigenY];
                                    piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenAlfil;
                                    piezas[fichaOrigenX][fichaOrigenY] = null;
                                    break;
                                case "Reina":
                                    System.out.println("Es Reina");
                                    Pieza piezaOrigenReina;
                                    piezaOrigenReina = piezas[fichaOrigenX][fichaOrigenY];
                                    piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenReina;
                                    piezas[fichaOrigenX][fichaOrigenY] = null;
                                    break;
                                case "Rey":
                                    System.out.println("Es Rey");
                                    Pieza piezaOrigenRey;
                                    piezaOrigenRey = piezas[fichaOrigenX][fichaOrigenY];
                                    piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenRey;
                                    piezas[fichaOrigenX][fichaOrigenY] = null;
                                    break;
                                default:
                                    break;
                            }
                    }
                    if (colorOrigen == "Blanco") {
                            String tipoOrigen;
                            tipoOrigen = piezas[fichaOrigenX][fichaOrigenY].getTipo();
                            switch (tipoOrigen) {
                                case "Peon":
                                    System.out.println("Es peon");

                                    if (fichaOrigenX == fichaDestinoX) {
                                        if (fichaOrigenX == fichaDestinoX) {
                                            for (int i = fichaOrigenY; i < fichaDestinoY; i++) {
                                                if (piezas[fichaOrigenX][i] != null) ;
                                            }

                                            Pieza piezaOrigenPeon;
                                            piezaOrigenPeon = piezas[fichaOrigenX][fichaOrigenY];
                                            piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenPeon;
                                            piezas[fichaOrigenX][fichaOrigenY] = null;
                                        }
                                    }
                                    break;
                                case "Torre":
                                    System.out.println("Es Torre");
                                    if (fichaOrigenX == fichaDestinoX || fichaOrigenY == fichaDestinoY) {
                                        if (fichaOrigenX == fichaDestinoX) {
                                            for (int i = fichaOrigenY; i < fichaDestinoY; i++) {
                                                if (piezas[fichaOrigenX][i] != null) {
                                                }
                                            }
                                            Pieza piezaOrigenTorre;
                                            piezaOrigenTorre = piezas[fichaOrigenX][fichaOrigenY];
                                            piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenTorre;
                                            piezas[fichaOrigenX][fichaOrigenY] = null;
                                        }
                                        if (fichaOrigenY == fichaDestinoY) {
                                            for (int i = fichaOrigenX; i < fichaDestinoX; i++) {
                                                if (piezas[i][fichaOrigenY] != null) ;
                                            }
                                            Pieza piezaOrigenTorre;
                                            piezaOrigenTorre = piezas[fichaOrigenX][fichaOrigenY];
                                            piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenTorre;
                                            piezas[fichaOrigenX][fichaOrigenY] = null;
                                        }
                                    } else {
                                        System.out.println("Movimiento invalido");
                                    }
                                    break;
                                case "Caballo":
                                    System.out.println("Es Caballo");


                                    Pieza piezaOrigenCaballo;
                                    piezaOrigenCaballo = piezas[fichaOrigenX][fichaOrigenY];
                                    piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenCaballo;
                                    piezas[fichaOrigenX][fichaOrigenY] = null;
                                    break;
                                case "Alfil":
                                    System.out.println("Es Alfil");
                                    Pieza piezaOrigenAlfil;
                                    piezaOrigenAlfil = piezas[fichaOrigenX][fichaOrigenY];
                                    piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenAlfil;
                                    piezas[fichaOrigenX][fichaOrigenY] = null;
                                    break;
                                case "Reina":
                                    System.out.println("Es Reina");
                                    Pieza piezaOrigenReina;
                                    piezaOrigenReina = piezas[fichaOrigenX][fichaOrigenY];
                                    piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenReina;
                                    piezas[fichaOrigenX][fichaOrigenY] = null;
                                    break;
                                case "Rey":
                                    System.out.println("Es Rey");
                                    Pieza piezaOrigenRey;
                                    piezaOrigenRey = piezas[fichaOrigenX][fichaOrigenY];
                                    piezas[fichaDestinoX][fichaDestinoY] = piezaOrigenRey;
                                    piezas[fichaOrigenX][fichaOrigenY] = null;
                                    break;
                                default:
                                    break;
                            }
                    }
                }
            }
        }
    }

    static void inciarTablero(){
        Peon peon1 = new Peon(1,0, "Negro", "Peon");
        Peon peon2 = new Peon(1,1, "Negro", "Peon");
        Peon peon3 = new Peon(1,2, "Negro", "Peon");
        Peon peon4 = new Peon(1,3, "Negro", "Peon");
        Peon peon5 = new Peon(1,4, "Negro", "Peon");
        Peon peon6 = new Peon(1,5, "Negro", "Peon");
        Peon peon7 = new Peon(1,6, "Negro", "Peon");
        Peon peon8 = new Peon(1,7, "Negro", "Peon");

        Torre torre1 = new Torre(0,0, "Negro", "Torre");
        Torre torre2 = new Torre(0,7, "Negro", "Torre");
        Alfil alfil1 = new Alfil(0,2, "Negro", "Alfil");
        Alfil alfil2 = new Alfil(0,5, "Negro", "Alfil");
        Caballo caballo1 = new Caballo(0,1, "Negro", "Caballo");
        Caballo caballo2 = new Caballo(0,6, "Negro", "Caballo");
        Reina reina1 = new Reina(0,3, "Negro", "Reina");
        Rey rey = new Rey(0,4, "Negro", "Rey");

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
        Peon peon9 = new Peon(1,0, "Blanco", "Peon");
        Peon peon10 = new Peon(1,1, "Blanco", "Peon");
        Peon peon11 = new Peon(1,2, "Blanco", "Peon");
        Peon peon12 = new Peon(1,3, "Blanco", "Peon");
        Peon peon13 = new Peon(1,4, "Blanco", "Peon");
        Peon peon14 = new Peon(1,5, "Blanco", "Peon");
        Peon peon15 = new Peon(1,6, "Blanco", "Peon");
        Peon peon16 = new Peon(1,7, "Blanco", "Peon");

        Torre torre3 = new Torre(0,0, "Blanco", "Torre");
        Torre torre4 = new Torre(0,7, "Blanco", "Torre");
        Alfil alfil3 = new Alfil(0,2, "Blanco", "Alfil");
        Alfil alfil4 = new Alfil(0,5, "Blanco", "Alfil");
        Caballo caballo3 = new Caballo(0,1, "Blanco", "Caballo");
        Caballo caballo4 = new Caballo(0,6, "Blanco", "Caballo");
        Reina reina2 = new Reina(0,3, "Blanco", "Reina");
        Rey rey2 = new Rey(0,4, "Blanco", "Rey");

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

    static void imprimirTablero(){
        System.out.println("****************************Tablero****************************\n" +
                "Y\t\t" + "0 \t\t" + "1 \t\t" + "2 \t\t" + "3 \t\t" + "4 \t\t" + "5 \t\t" + "6 \t\t" + "7 \t\t" + " X \n" +
                "0\t\t" + piezas[0][0] + "\t" + piezas[1][0] + "\t" + piezas[2][0] + "\t" + piezas[3][0] + "\t" + piezas[4][0] + "\t" + piezas[5][0] + "\t" + piezas[6][0] + "\t" + piezas[7][0] + "\n" +
                "1\t\t" + piezas[0][1] + "\t" + piezas[1][1] + "\t" + piezas[2][1] + "\t" + piezas[3][1] + "\t" + piezas[4][1] + "\t" + piezas[5][1] + "\t" + piezas[6][1] + "\t" + piezas[7][1] + "\n" +
                "2\t\t" + piezas[0][2] + "\t" + piezas[1][2] + "\t" + piezas[2][2] + "\t" + piezas[3][2] + "\t" + piezas[4][2] + "\t" + piezas[5][2] + "\t" + piezas[6][2] + "\t" + piezas[7][2] + "\n" +
                "3\t\t" + piezas[0][3] + "\t" + piezas[1][3] + "\t" + piezas[2][3] + "\t" + piezas[3][3] + "\t" + piezas[4][3] + "\t" + piezas[5][3] + "\t" + piezas[6][3] + "\t" + piezas[7][3] + "\n" +
                "4\t\t" + piezas[0][4] + "\t" + piezas[1][4] + "\t" + piezas[2][4] + "\t" + piezas[3][4] + "\t" + piezas[4][4] + "\t" + piezas[5][4] + "\t" + piezas[6][4] + "\t" + piezas[7][4] + "\n" +
                "5\t\t" + piezas[0][5] + "\t" + piezas[1][5] + "\t" + piezas[2][5] + "\t" + piezas[3][5] + "\t" + piezas[4][5] + "\t" + piezas[5][5] + "\t" + piezas[6][5] + "\t" + piezas[7][5] + "\n" +
                "6\t\t" + piezas[0][6] + "\t" + piezas[1][6] + "\t" + piezas[2][6] + "\t" + piezas[3][6] + "\t" + piezas[4][6] + "\t" + piezas[5][6] + "\t" + piezas[6][6] + "\t" + piezas[7][6] + "\n" +
                "7\t\t" + piezas[0][7] + "\t" + piezas[1][7] + "\t" + piezas[2][7] + "\t" + piezas[3][7] + "\t" + piezas[4][7] + "\t" + piezas[5][7] + "\t" + piezas[6][7] + "\t" + piezas[7][7] + "\n");
    }

}

