package domain;

public class Reina  extends Pieza{
    //Atributos
    //private String color;
    //private String tipo;
    //private int movPeon;
    //Metodo Constructor
    public Reina (int movX, int movY, String color, String tipo){
        super(movX, movY, color, tipo);
    }

    /*public String getTipo() {
        return tipo;
    }

    public Reina setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Reina setColor(String color) {
        this.color = color;
        return this;
    }*/

    public String toString(){
        return "Reina";
    }
}
