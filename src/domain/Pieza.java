package domain;

public class Pieza {
    //Atributos

    private int movX;
    private int movY;
    private String color;
    private String tipo;
    //Metodo constructor
    public Pieza (){
    }
    public Pieza (int movX, int movY, String color, String tipo){
        this.movX = movX;
        this.movY = movY;
        this.color = color;
        this.tipo = tipo;
    }
    //Metodos
    public int getMovX() {
        return movX;
    }

    public Pieza setMovX(int movX) {
        this.movX = movX;
        return this;
    }

    public int getMovY() {
        return movY;
    }

    public Pieza setMovY(int movY) {
        this.movY = movY;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Pieza setColor(String color) {
        this.color = color;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public Pieza setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    @Override
    public String toString() {
        return "Pieza{" +
                "movX=" + movX +
                ", movY=" + movY +
                ", color='" + color + '\'' +
                '}';
    }
}
