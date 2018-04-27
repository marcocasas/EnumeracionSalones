/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalendarMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Pablo
 */
public class Calendarizar {
    Map tablaDependencias = new HashMap(); //modela propiamente la tabla para restar el valor mayor
    //el primer param es el nombre y el segundo la cantidad de conexiones
    private Set<Curso> cursosPorOrganizar; //Conjunto de objetos "Curso", para tener todos los datos
                                           //se ocupa para crear el map
    ArrayList<Integer> recursosProhibidos;
    int recursoProhibido;
    
    public Map armaTabla(){//mapeo de nombre de curso y cantidad de conexiones que tiene
        
        for(Curso c:cursosPorOrganizar){
            if(!tablaDependencias.containsKey(c)){
                tablaDependencias.put(c.nombre, c.conexiones.size());
            }
        }
        return tablaDependencias;
    }
    
    
    public Curso getCurso(String nombre){
        for(Curso c: cursosPorOrganizar){
            if(c.nombre.equals(nombre)){
                return c;
            }
        }
        return null;
    }
    
    
    public void solve(){
        Map<String, Integer> treeMap = new TreeMap<String, Integer>(tablaDependencias);//esto ordena el hasmap
                                                                                       //de mayor a menor con base
                                                                                       //en el num de conexiones
        recursosProhibidos =  new ArrayList<>();
        Set<String> auxConexiones;                                  //guarda conexiones de curso actual
        Curso temp=null,conectado=null;                             //Curso aux para iterar y conectado para decrementar las conexiones
        int conexiones = 0;                                         //num de conexiones
        
        for(Map.Entry<String,Integer> entry : treeMap.entrySet()) { //iterar sobre el map ordenado 
            String key = entry.getKey();                            // clave, nombre, del curso actual          
            temp = getCurso(key);
            auxConexiones = temp.conexiones;                        //conexiones del curso actual
            ArrayList<String> list = new ArrayList<>(auxConexiones);//Convierto SET a ArrayList para eliminar dependencias
            conexiones = auxConexiones.size();                      //numero de conexiones del curso actual
            for(int i = 0; i<conexiones;i++){                       //para cada conexion, borrar el nodo actual de su lista
                Curso x = getCurso(list.get(i));                    //extraigo el elemento de la lista de conexiones
                Set<String> auxConexiones2 = x.conexiones;          //obtengo su lista de conexiones y elimino al nodo con las siguientes dos lineas
                ArrayList<String> list2 = new ArrayList<>(auxConexiones2);
                list2.remove(i);                                    //FALTA INTRODUCIR CRITERIO PARA DETERMINAR QU'E RECURSO SE LE DEBE PROHIBIR
            }
            temp.cancelado=true;                                    //Bandera para marcar al curso como "expandido "
       
        }                                                 
    }
    
}
