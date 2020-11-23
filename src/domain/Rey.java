package domain;

public class Rey extends Pieza{
    //Atributos
    //private String color;
    //private String tipo;
    //private int movPeon;
    //Metodo Constructor
    public Rey (int movX, int movY, String color, String tipo){
        super(movX, movY, color, tipo);
    }

    /*public String getTipo() {
        return tipo;
    }

    public Rey setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Rey setColor(String color) {
        this.color = color;
        return this;
    }*/

    public String toString(){
        return "Rey   ";
    }
}
