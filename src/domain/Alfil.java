package domain;

public class Alfil extends  Pieza{
    public Alfil (int movX, int movY, String color, String tipo){
        super(movX, movY, color, tipo);
    }


    public String toString(){
        return getTipo();
    }
}
