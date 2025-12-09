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

import java.util.ArrayList;
import java.util.List;


public class GraphAdjacencyList {
    private List<List<Integer>> graph;
    private int n;  //num de vértices

    public GraphAdjacencyList(int n) {
        this.n = n;
        
        graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
        graph.add(new ArrayList<>());
    }
    
    public void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
        
    }
    
    public void print() {
        int node = 0;
        for(var al:graph){
            System.out.print(node + ":");
            for(var i:al){
                System.out.print(i + ",");
                
            }
            node++;
            System.out.println("");
        }
        
    }
    
    public int depth(int p) { 
        //is root
        if(p == 0)
            return 0;
        return 1 + depth( graph.get(p).get(0) );
    }
    
    public void hasChildren() {
        int node = 0;
        for(var al:graph){
            System.out.print(node + ":");
            for(var i:al){
                if(i != 0 && i == node-1){
                    System.out.print(i + " ");
                    System.out.print(": True");
                }
            }
            node++;
            System.out.println("");
        }
    }
}
