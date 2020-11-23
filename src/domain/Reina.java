package domain;

public class Reina  extends Pieza{

    public Reina (int movX, int movY, String color, String tipo){
        super(movX, movY, color, tipo);
    }

    public String toString(){
        return getTipo();
    }
}
