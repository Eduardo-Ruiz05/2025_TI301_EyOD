/*
* ITESS TICS AGOSTO DICIEMBRE 2025
* ESTRUCTURAS Y ORGANIZACIÓN DE DATOS
* DOCENTE: FRANCISCO JAVIER MONTECILLO FUENTES
* INTENTO DE PROGRAMADOR: EDUARDO RUIZ AGUILAR
* EMAIL: eduardo.ruizaguilar.50@gmail.com
* DESCRIPCIÓN: 
* Ejercicios de la tarea 1
* FECHA: 19/SEPTIEMBRE/2025
*/
package U1_FUNDAMENTOS;


public class EDAlgoTP01 {
    public static void main(String [] args) {
        EDAlgoTP01.E2();
        int[] numeros = {5, 23, 8, 12, 1};
        System.out.println(EDAlgoTP01Test.E3(numeros));
    }
    
    public static void E2() {
        //Imprimir 4 patrones de triangulos (10 renglones, 10 caracteres por  
        //renglón) compuestos por "*" y " "
        
        //Primer patrón 1-10 *
        System.out.println("a)");
        for(int i = 1; i <= 10; i++) {              //Renglones
            for(int j = 0; j < i ; j++) {           //Asterizcos
                System.out.print("*");
            }
            System.out.println();                   //Salto de línea
        }
        
        //Segundo patrón 10-1 *
        System.out.println("b)");
        for(int i = 10; i >= 1; i--) {              //Renglones
            for(int j = 0; j < i ; j++) {           //Asterizcos
                System.out.print("*");
            }
            System.out.println();                   //Salto de línea
        }
        
        //Tercer patrón 10-1 _*
        System.out.println("c)");
        int asterizcos = 10;
        for(int i = 1; i <= 10; i++) {              //Renglones
            for(int j = 1; j < i;j++){              //Espacios
                System.out.print(" ");
            }
            for(int k = 0; k < asterizcos; k++){    //Asterizcos
                System.out.print("*");
            }
            asterizcos--;
            System.out.println();
        }
        
        //Cuarto Patrón 1-10 _*
        System.out.println("d)");
        int vacíos = 9;
        for(int i = 1; i <= 10; i++) {              //Renglones
            for(int j = 0; j < vacíos;j++){         //Espacios
                System.out.print(" ");
            }
            for(int k = 0; k < i; k++){             //Asterizcos
                System.out.print("*");
            }
            vacíos--;
            System.out.println();
        }
    }
    
    /**
     *
     * Programa para imprimir gráficos de barra con "*"
     * rango: 1-30, 5 gráficas
     */
    public static String E3(int[] num){
        String grafics = "";
        //Generar graficas
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < num[i] ; j++){
                grafics += "*";
            }
            grafics += "\n";
        }
        return grafics;
    }
}
