package domain;

public class Alfil extends  Pieza{
    //Atributos
    //private String color;
    //private String tipo;
    //private int movPeon;
    //Metodo Constructor
    public Alfil (int movX, int movY, String color, String tipo){
        super(movX, movY, color, tipo);
    }

    /*public String getTipo() {
        return tipo;
    }

    public Alfil setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Alfil setColor(String color) {
        this.color = color;
        return this;
    }*/

    public String toString(){
        return "Alfil";
    }
}
