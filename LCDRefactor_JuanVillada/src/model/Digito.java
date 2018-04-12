package model;

import java.util.HashMap;

/**
 * Representa un digito en formato de 7 segmentos.
 * Un digito cuenta con una altura = (tamañoSegmento) * 2 + 3
 * y anchura = (tamañoSegmento) + 2
 */

public class Digito {

    /**
     *
     */
    private static HashMap<Integer, char[]> segmentos = new HashMap<Integer, char[]>(10);

    {
        segmentos.put(0, new char[]{Segmento.A, Segmento.B, Segmento.C, Segmento.D, Segmento.E, Segmento.F});
        segmentos.put(1, new char[]{Segmento.B, Segmento.C});
        segmentos.put(2, new char[]{Segmento.A, Segmento.B, Segmento.D, Segmento.E, Segmento.G});
        segmentos.put(3, new char[]{Segmento.A, Segmento.B, Segmento.C, Segmento.D, Segmento.G});
        segmentos.put(4, new char[]{Segmento.B, Segmento.C, Segmento.F, Segmento.G});
        segmentos.put(5, new char[]{Segmento.A, Segmento.C, Segmento.D, Segmento.F, Segmento.G});
        segmentos.put(6, new char[]{Segmento.A, Segmento.C, Segmento.D, Segmento.E, Segmento.F, Segmento.G});
        segmentos.put(7, new char[]{Segmento.A, Segmento.B, Segmento.C});
        segmentos.put(8, new char[]{Segmento.A, Segmento.B, Segmento.C, Segmento.D, Segmento.E, Segmento.F, Segmento.G});
        segmentos.put(9, new char[]{Segmento.A, Segmento.B, Segmento.C, Segmento.F, Segmento.G});
    }

    //Tamaño de cada segmento del digito
    private int tamañoSegmento;

    //Altura del digito = tamañoSegmento * 2 + 3
    private int altura;

    //Anchura del digito = tamañoSegmento + 2
    private int anchura;

    //Lista de caracteres que corresponden a los segmentos que se mostraran en el display
    private char[] segmentosDisplay;

    //Matriz de caracteres que representa el digito
    private char[][] matrizDigitos;

    /**
     * Constructor para la clase Digito
     *
     * @param digito   Numero entero entre 0 y 9
     * @param tamañoSegmento Numero entero entre 0 y 9 que indica el tamaño de los segmentos de digitos
     */
    public Digito(int digito, int tamañoSegmento) {
        this.tamañoSegmento = tamañoSegmento;
        altura = 2 * tamañoSegmento + 3;
        anchura = tamañoSegmento + 2;
        segmentosDisplay = segmentos.get(digito);
    }


    public int getTamañoSegmento() {

        return tamañoSegmento;
    }

    public char[] getSegmentosDisplay() {

        return segmentosDisplay;
    }

    public char[][] getMatrizDigitos() {

        return matrizDigitos;
    }

    public void setMatrizDigitos(char[][] matrizDigitos) {

        this.matrizDigitos = matrizDigitos;
    }

    public int getAltura() {

        return altura;
    }

    public int getAnchura() {

        return anchura;
    }

}
