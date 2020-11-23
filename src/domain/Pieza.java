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


    public int getMovX() {
        return movX;
    }

    public void setMovX(int movX) {
        this.movX = movX;
    }

    public int getMovY() {
        return movY;
    }

    public void setMovY(int movY) {
        this.movY = movY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return getTipo();
    }
}
