/*
* ITESS TICS AGOSTO DICIEMBRE 2025
* ESTRUCTURAS Y ORGANIZACIÓN DE DATOS
* DOCENTE: FRANCISCO JAVIER MONTECILLO FUENTES
* INTENTO DE PROGRAMADOR: EDUARDO RUIZ AGUILAR
* EMAIL: eduardo.ruizaguilar.50@gmail.com
* DESCRIPCIÓN: 
* Dado un archivo con nombres, encontrar cuantos "Juan" hay, no importasi está
* escrito con con mayús o minúsculas-
* La primera línea de archivo contiene el número de nombres (el nombre es una sola
* palabra)
* FECHA: 03/SEPTIEMBRE/2025
*/

package U1_FUNDAMENTOS;
import java.util.*;
import java.io.*;
/*
*Dado un archivo con nombres, encontrar cuantos "Juan" hay, no importasi está
*escrito con con mayús o minúsculas-
*La primera línea de archivo contiene el número de nombres (el nombre es una sola
*palabra por linea)
 */
public class Arreglos {
    
    
    public static int problemaJuan(String [] args)throws java.io.IOException{
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        
        int num = Integer.parseInt(in.readLine());
        //System.out.println(num);
        
        int juanes = 0;
        String nombre = "";
        for(int i = 0; i <= num-1; i++){
            nombre = in.readLine();
            nombre = nombre.toLowerCase();
            if("juan".equals(nombre))
                juanes++;
        }
        
        return juanes;
    }
    public static void main(String [] args)throws java.io.IOException{
        System.out.println(Arreglos.problemaJuan(args));
    } 
}
