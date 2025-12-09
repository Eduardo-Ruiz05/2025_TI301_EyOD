/*
* ITESS TICS AGOSTO DICIEMBRE 2025
* ESTRUCTURAS Y ORGANIZACIÓN DE DATOS
* DOCENTE: FRANCISCO JAVIER MONTECILLO PUENTE
* INTENTO DE PROGRAMADOR: EDUARDO RUIZ AGUILAR
* EMAIL: eduardo.ruizaguilar.50@gmail.com
* DESCRIPCIÓN: 
* -- Tema 3: árboles --
* 
* FECHA: 26/NOVIEMBRE/2025
*/
package tema3.estructurasNoLineales;


public class GraphAdjacencyListTest {
    
    public static void main (String args []) {
        GraphAdjacencyList tree = new GraphAdjacencyList(7);
        
        tree.addEdge(0, 1);
        tree.addEdge(0, 2);
        tree.addEdge(1, 3);
        tree.addEdge(1, 4);
        tree.addEdge(2, 5);
        tree.addEdge(2, 6);
        
        tree.print();
        tree.hasChildren();
        
        System.out.println("Depth: " + tree.depth(5));
    }
}
