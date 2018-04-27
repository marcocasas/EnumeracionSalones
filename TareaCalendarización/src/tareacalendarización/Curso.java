/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareacalendarización;

/**
 *
 * @author Pablo
 */
import java.util.ArrayList;

public class Curso {

    String nombre;
    ArrayList<String> dependencias;
    ArrayList<String> recursosProhibidos;
    String horario;
    int dependenciasEliminadas; //Atributo para ir quitando dependencias.

    public Curso(String nombre) {
        this.nombre = nombre;
        dependencias = new ArrayList<String>();
        recursosProhibidos = new ArrayList<String>();
        dependenciasEliminadas = 0; ///Se inicia en 0.
    }

    public boolean equals(Curso c) {
        return this.nombre.equals(c.nombre);
    }

    public void agregaDependencia(ArrayList<String> nombresCursos) {
        for (String n : nombresCursos) {
            if (!n.equals(this.nombre)) {
                if (!dependencias.contains(n)) {
                    dependencias.add(n);
                }
            }
        }
    }

    public void agregaRestriccionHorario(String horario) {
        if (!recursosProhibidos.contains(horario)) {
            recursosProhibidos.add(horario);
        }
    }

    public String verDependencias() {
        String dep = "";
        for (String d : dependencias) {
            dep = dep + " " + d;
        }

        return dep;
    }

    public String verHorariosRest() {
        String hor = "";
        for (String h : recursosProhibidos) {
            hor = hor + " " + h;
        }

        return hor;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public boolean checkAsignacion() {
        return horario.equals("NA");
    }

    public int cuentaDependencias() {
        return dependencias.size();
    }

    public String formato() {
        StringBuilder stb = new StringBuilder();
        stb.append("Nombre: " + nombre + "\n");
        stb.append("Dependencias: ");
        for (String s : dependencias) {
            stb.append(" " + s);
        }
        stb.append("\n");
        stb.append("Horario: " + horario + "\n");
        stb.append("Recursos prohibidos: ");
        for (String s : recursosProhibidos) {
            stb.append(" " + s);
        }

        stb.append("\n");

        return stb.toString();
    }

    public String estableceHorario(ArrayList<String> horarios, ArrayList<Boolean> saturados) {
        boolean done = false;
        int i = 0;

        while (!done) {
            if (!recursosProhibidos.contains(horarios.get(i)) && !saturados.get(i)) {
                horario = horarios.get(i);
                done = true;
            } else {
                i++;
            }

            if (i > 14) {
                done = false;
            }
        }

        return horario;
    }

    public boolean verificaRelacion(String relacionado) {
        return dependencias.contains(relacionado);
    }
}
