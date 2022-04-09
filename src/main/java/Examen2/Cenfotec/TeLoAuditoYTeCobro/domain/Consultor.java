package Examen2.Cenfotec.TeLoAuditoYTeCobro.domain;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Consultor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private String telefono;
    private Date dob;
    private String telPersonal;
    private String email;
    private Boolean disponibilidad;
    private String especialidad;
    private boolean estatus;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    public Consultor() {
        this.estatus = true;
    }

    public Consultor(String nombre, String apellido1, String apellido2, String direccion, String telefono,
                     String dob, String telPersonal, String email, boolean disponibilidad, String especialidad) throws ParseException {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dob = format.parse(dob);
        this.telPersonal = telPersonal;
        this.email = email;
        this.disponibilidad = disponibilidad;
        this.especialidad = especialidad;
        this.estatus = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getDateString(){
        return format.format(dob);
    }

    public String getTelPersonal() {
        return telPersonal;
    }

    public void setTelPersonal(String telPersonal) {
        this.telPersonal = telPersonal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isEstatus() {
        return estatus;
    }
    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Consultor{" +
                "nombre='" + nombre + + '\n'+
                ", apellido1='" + apellido1 +  '\n'+
                ", apellido2='" + apellido2 +  '\n'+
                ", direccion='" + direccion +  '\n'+
                ", telefono='" + telefono +  '\n'+
                ", fecha de nacimiento=" + getDateString() +  '\n'+
                ", telefono Personal='" + telPersonal +  '\n'+
                ", email='" + email +  '\n'+
                ", disponibilidad='" + disponibilidad.toString() +  '\n'+
                ", especialidad='" + especialidad +  '\n'+
                '}';
    }
}
