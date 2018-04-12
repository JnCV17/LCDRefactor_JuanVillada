package model;

public class Segmento {

    //Constantes que indican el segmento de  el segmento
    public static final char A = 'A';
    public static final char B = 'B';
    public static final char C = 'C';
    public static final char D = 'D';
    public static final char E = 'E';
    public static final char F = 'F';
    public static final char G = 'G';

    //Constantes de orientacion del Segmento
    public static final String HORIZONTAL = "-";
    public static final String VERTICAL = "|";
    
    public static final String POSICION_X = "X";
    public static final String POSICION_Y = "Y";

    //Representa la orientacion del segmento
    private int orientacion;

    public int getOrientacion() {

        return orientacion;
    }

    public void setOrientacion(int orientacion) {

        this.orientacion = orientacion;
    }
}
