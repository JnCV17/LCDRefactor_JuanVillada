import java.io.*;
import java.util.ArrayList;
import controller.*;

public class Main {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
    	
    	mostrarMensaje();

    	LCDDisplayController lcdController = new LCDDisplayController();
    	InputController inputController = new InputController();
    	
        String inputLine;

        while (true) {

            inputLine = bufferedReader.readLine();
            
            ArrayList<Object> parametros = inputController.procesar(inputLine);
            
            lcdController.imprimirNumero((int)parametros.get(0), (String)parametros.get(1), 1);
            
            if (inputLine.equals("0,0")) {
                break;
            } else {
            	bufferedWriter.write("\n");
                continue;
            }
        }

        bufferedWriter.close();
        bufferedReader.close();

    }
    
    private static void mostrarMensaje() throws IOException {

        bufferedWriter.write("****************************************************\n");
        bufferedWriter.write("*Display LCD 7 segmentos*\n");
        bufferedWriter.write("****************************************************\n");
        bufferedWriter.write("\n");
        bufferedWriter.write("Introduzca el tamaño del segmento y el numero que desea ver en formato de 7 Segmentos.\n");
        bufferedWriter.write("Para finalizar la entrada de datos, introduzca el valor\"0,0\".\n");
        bufferedWriter.flush();

    }




}