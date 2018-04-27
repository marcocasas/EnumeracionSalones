/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalendarMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Pablo
 */
public class Curso {
    
    String nombre;
    public Set<String> conexiones;         //dependencias
    public Set<String> restricciones;      // >=# o x <---> y 
    public Set<String> recursosProhibidos; //recursos prohibidos
    boolean cancelado;                     //el curso ya se rest'o de las otras dependencias 
    
    public Curso(){
        conexiones           = new HashSet<>();
        restricciones        = new HashSet<>();
        recursosProhibidos   = new HashSet<>();
    }
    
    public void armaDependencias(Set<String> nombresCursos){ //set solo agrega objetos que no existan ya en la coleccion
        for (String s : nombresCursos) {
            this.conexiones.add(s);
        }
    }
    
    public void agregaRestriccionHorario(String horario) {
        this.recursosProhibidos.add(horario);
    }
    
    
    
}
