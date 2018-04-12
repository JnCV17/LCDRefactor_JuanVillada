package controller;

import java.util.ArrayList;

import model.Punto;
import model.Digito;
import model.Segmento;

public class LCDDisplayController {
	
	private String[][] matrizImpr;
	private Punto puntoFijo1;
	private Punto puntoFijo2;
	private Punto puntoFijo3;
	private Punto puntoFijo4;
	private Punto puntoFijo5;
	
	public LCDDisplayController() {
		puntoFijo1 = new Punto();
		puntoFijo2 = new Punto();
		puntoFijo3 = new Punto();
		puntoFijo4 = new Punto();
		puntoFijo5 = new Punto();
	}

    /**
     * Metodo encargado de un segmento a la matriz de Impresion
     *
     * @param segmento Segmento a adicionar
     */
    private void adicionarSegmento(char segmento, int size) {

        switch (segmento) {
        		case 'A':
                    adicionarLinea(this.matrizImpr, puntoFijo1, Segmento.POSICION_X,
                            size, Segmento.HORIZONTAL);
                    break;
        		case 'B':
                    adicionarLinea(this.matrizImpr, puntoFijo5, Segmento.POSICION_Y,
                            size, Segmento.VERTICAL);
                    break;
        		case 'C':
                    adicionarLinea(this.matrizImpr, puntoFijo4, Segmento.POSICION_Y,
                            size, Segmento.VERTICAL);
                    break;
        		case 'D':
                    adicionarLinea(this.matrizImpr, puntoFijo3, Segmento.POSICION_X,
                            size, Segmento.HORIZONTAL);
                    break;
        		case 'E':
                    adicionarLinea(this.matrizImpr, puntoFijo2, Segmento.POSICION_Y,
                            size, Segmento.VERTICAL);
                    break;
        		case 'F':
                    adicionarLinea(this.matrizImpr, puntoFijo1 , Segmento.POSICION_Y,
                            size, Segmento.VERTICAL);
                    break;
            case 'G':
                adicionarLinea(this.matrizImpr, puntoFijo2, Segmento.POSICION_X,
                        size, Segmento.HORIZONTAL);
                break;
            default:
                break;
        }
    }

    /**
     *
     * Metodo encargado de imprimir un numero
     *
     * @param size Tamaño Segmento Digitos
     * @param numeroImp Numero a Imprimir
     * @param espacio Espacio Entre digitos
     */
    public void imprimirNumero(int size, String numeroImp, int espacio)
    {
        int pivotX = 0;

        // Crea el arreglo de caracteres que contiene los digitos a imprimir
        char[] digitosEntrada = numeroImp.toCharArray();

        ArrayList<Digito> digitos = new ArrayList<Digito>();

        for (char digito : digitosEntrada) {

            //Valida que el caracter sea un digito
            if (!Character.isDigit(digito)) {
                throw new IllegalArgumentException("Caracter " + digito
                        + " no es un digito");
            }
            
            int numero = Integer.parseInt(String.valueOf(digito));
            
            Digito nuevoDigito = new Digito(numero, size);

            digitos.add(nuevoDigito);
        }

        // Calcula el numero de filas cada digito
        int filasDig = (2 * size) + 3;

        // Calcula el numero de columna de cada digito
        int columDig = size + 2;

        // Calcula el total de filas de la matriz en la que se almacenaran los digitos
        int totalFilas = filasDig;

        // Calcula el total de columnas de la matriz en la que se almacenaran los digitos
        int totalColum = (columDig * numeroImp.length())
                + (espacio * numeroImp.length());

        // crea matriz para almacenar los numero a imprimir
        this.matrizImpr = new String[totalFilas][totalColum];

        // Inicializa matriz
        for (int i = 0; i < totalFilas; i++) {
            for (int j = 0; j < totalColum; j++) {
                this.matrizImpr[i][j] = " ";
            }
        }

        for (Digito digito : digitos) {

            //Calcula puntos fijos
            this.puntoFijo1.setI(0);
            this.puntoFijo1.setJ(0 + pivotX);
            
            this.puntoFijo2.setI(filasDig / 2);
            this.puntoFijo2.setJ(0 + pivotX); 
            
            this.puntoFijo3.setI(filasDig - 1);
            this.puntoFijo3.setJ(0 + pivotX); 

            this.puntoFijo4.setI(columDig - 1);
            this.puntoFijo4.setJ((filasDig / 2) + pivotX); 
            
            this.puntoFijo5.setI(0);
            this.puntoFijo5.setJ((columDig - 1) + pivotX); 

            pivotX = pivotX + columDig + espacio;
            
            char[] segmentosDigito = digito.getSegmentosDisplay();
            
            for (char c : segmentosDigito) {
            		adicionarSegmento(c, size);
			}
        }

        // Imprime matriz
        for (int i = 0; i < totalFilas; i++) {
            for (int j = 0; j < totalColum; j++) {
                System.out.print(this.matrizImpr[i][j]);
            }
            System.out.println();
        }
    }
    
    /**
    *
    * Metodo encargado de añadir una linea a la matriz de Impresion
    *
    * @param matriz Matriz Impresion
    * @param punto Punto Pivote
    * @param posFija Posicion Fija
    * @param size Tamaño Segmento
    * @param caracter Caracter Segmento
    */    
   private void adicionarLinea(String[][] matriz, Punto punto, String posFija,
           int size, String caracter) {

       if (posFija.equalsIgnoreCase(Segmento.POSICION_X)) 
       {
           for (int y = 1; y <= size; y++) 
           {
               int valor = punto.getJ() + y;
               matriz[punto.getI()][valor] = caracter;
           }
       } 
       else 
       {
           for (int i = 1; i <= size; i++) 
           {
               int valor = punto.getI() + i;
               matriz[valor][punto.getJ()] = caracter;
           }
       }
   }

}