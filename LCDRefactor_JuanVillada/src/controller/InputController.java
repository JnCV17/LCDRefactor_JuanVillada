package controller;

import java.util.ArrayList;

public class InputController {

    /**
     * Metodo encargado de procesar la entrada que contiene el size del segmento
     * de los digitos y los digitos a imprimir
     *
     * @param comando    Entrada que contiene el size del segmento de los digito
     *                   y el numero a imprimir
     * @param espacioDig Espacio Entre digitos
     */
    public ArrayList<Object> procesar(String comando) {

        String[] parametros;

        int tam;

        if (!comando.contains(",")) {
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene caracter ,");
        }

        //Se hace el split de la cadena
        parametros = comando.split(",");

        //Valida la cantidad de parametros
        if (parametros.length > 2) {
            throw new IllegalArgumentException("Cadena " + comando
                    + " contiene mas caracter ,");
        }

        //Valida la cantidad de parametros
        if (parametros.length < 2) {
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene los parametros requeridos");
        }

        //Valida que el parametro size sea un numerico
        if (isNumeric(parametros[0])) {
            tam = Integer.parseInt(parametros[0]);

            // se valida que el size este entre 1 y 10
            if (tam < 1 || tam > 10) {
                throw new IllegalArgumentException("El parametro size [" + tam
                        + "] debe estar entre 1 y 10");
            }
        } else {
            throw new IllegalArgumentException("Parametro Size [" + parametros[0]
                    + "] no es un numero");
        }
        
        ArrayList<Object> retorno = new ArrayList<Object>();
        
        retorno.add(tam);
        retorno.add(parametros[1]);
        
        return retorno;

    }

    /**
     * Metodo encargado de validar si una cadena es numerica
     *
     * @param cadena Cadena
     */
    static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}