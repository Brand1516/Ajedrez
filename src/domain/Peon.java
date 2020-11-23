package domain;

public class Peon extends Pieza {
    //Atributos
    //private String color;
    //private String tipo;
    //private int movPeon;
    //Metodo Constructor
    public Peon (int movX, int movY, String color, String tipo){
        super(movX, movY, color, tipo);
    }
    //Metodos


    /*public String getTipo() {
        return tipo;
    }

    public Peon setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Peon setColor(String color) {
        this.color = color;
        return this;
    }*/

    public String toString(){
        return "Peon";
    }

}
