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

import java.util.List;


public class ContainsDuplicate {
    public static void main(String[] args) {
        // 1. Datos
        // 2. Algoritmo a resolver
        
    }
    
    public static boolean containsDuplicate(List <Integer> nums) {
        for(int i = 0; i < nums.size()-1; i++) 
            for(int j = i+1; j < nums.size(); j++) 
                if(nums.get(i) == nums.get(j))
                    return true;
        
        return false;
    }
}
