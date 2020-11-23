package domain;

public class PiezaVacia extends Pieza{
    public PiezaVacia() {
    }

    public PiezaVacia(int movX, int movY, String color, String tipo) {
        super(movX, movY, color, tipo);
    }

    @Override
    public String toString() {
        return getTipo();
    }
}
