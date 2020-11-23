package domain;

public class Caballo extends Pieza{

    public Caballo (int movX, int movY, String color, String tipo){
        super(movX, movY, color, tipo);
    }



    public String toString(){
        return getTipo();
    }
}
