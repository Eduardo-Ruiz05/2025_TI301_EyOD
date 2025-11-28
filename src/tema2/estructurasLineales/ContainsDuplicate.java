/*
* ITESS TICS AGOSTO DICIEMBRE 2025
* ESTRUCTURAS Y ORGANIZACIÓN DE DATOS
* DOCENTE: FRANCISCO JAVIER MONTECILLO PUENTE
* INTENTO DE PROGRAMADOR: EDUARDO RUIZ AGUILAR
* EMAIL: eduardo.ruizaguilar.50@gmail.com
* DESCRIPCIÓN PROBLEMA: 
* 
* FECHA: 17/OCTUBRE/2025
*/
package tema2.estructurasLineales;

import java.util.ArrayList;
import java.util.List;


public class ContainsDuplicate {
    public static void main(String[] args) {
        // 1. Datos
        int n = 10;     //Cantidad de números
        int m = 10;     //Rango
        List<Integer> nums = generateNums(n,m);
        print(nums);
        System.out.println("Contains Duplicate:\n" + containsDuplicate(nums));
    }
    
    // 2. Algoritmo a resolver (Fuerza Bruta)
    public static void print(List<Integer> nums) {
        System.out.println(nums.toString());
    }
    
    public static List<Integer> generateNums(int n, int m) {
        List<Integer> nums = new ArrayList<>();
        
        for(int i = 0; i < n; i++) 
            nums.add((int) (Math.random()*m));
            
        return nums;
    }
    
    public static boolean containsDuplicate(List <Integer> nums) {
        for(int i = 0; i < nums.size()-1; i++) 
            for(int j = i+1; j < nums.size(); j++) 
                if(nums.get(i) == nums.get(j))
                    return true;
        
        return false;
    }
}
