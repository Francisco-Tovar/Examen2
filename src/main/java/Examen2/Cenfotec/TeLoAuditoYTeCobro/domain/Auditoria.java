package Examen2.Cenfotec.TeLoAuditoYTeCobro.domain;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

@Entity
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    private Date fecha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CONSULTOR_ID", referencedColumnName = "ID")
    private Consultor consultor;

    private String especialidad;

    public Auditoria() {
        this.fecha = new java.sql.Date(System.currentTimeMillis());
    }

    public Auditoria(Long id, Date fecha, Cliente cliente, Consultor consultor, String especialidad) throws ParseException {
        this.id = id;
        this.fecha = fecha;
        ;
        this.cliente = cliente;
        this.consultor = consultor;
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Consultor getConsultor() {
        return consultor;
    }

    public void setConsultor(Consultor consultor) {
        this.consultor = consultor;
    }

    public String getDateString() {
        return format.format(fecha);
    }

    @Override
    public String toString() {
        return "Auditoria{" +
                "id=" + id + '\n' +
                ", fecha=" + getDateString() + '\n' +
                ", cliente=" + cliente.toString() + '\n' +
                ", consultor=" + consultor.toString() + '\n' +
                '}';
    }
}
