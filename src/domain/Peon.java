package domain;

public class Peon extends Pieza {

    public Peon (int movX, int movY, String color, String tipo){
        super(movX, movY, color, tipo);
    }


    public String toString(){
        return getTipo();
    }

}
