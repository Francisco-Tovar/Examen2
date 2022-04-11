package Examen2.Cenfotec.TeLoAuditoYTeCobro.domain;

import java.util.ArrayList;
import java.util.List;

public class Especialidad {

    private List<String> especialidades;

    public Especialidad() {
        especialidades = new ArrayList<String>();
        especialidades.add("ISO-Calidad");
        especialidades.add("ISO-Procesos");
        especialidades.add("ISO-Salubridad");
        especialidades.add("Seguridad Laboral");
        especialidades.add("Seguridad de IT");
    }

    public List<String> getEspecialidades() {
        return especialidades;
    }
}
