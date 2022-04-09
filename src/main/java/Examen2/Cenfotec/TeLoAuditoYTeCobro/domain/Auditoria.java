package Examen2.Cenfotec.TeLoAuditoYTeCobro.domain;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    private Date fecha;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "consultor_id")
    private Consultor consultor;

    public Auditoria() {    }

    public Auditoria(Long id, String fecha, Cliente cliente, Consultor consultor) throws ParseException {
        this.id = id;
        this.fecha = format.parse(fecha);;
        this.cliente = cliente;
        this.consultor = consultor;
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
    public String getDateString(){
        return format.format(fecha);
    }
    @Override
    public String toString() {
        return "Auditoria{" +
                "id=" + id +  '\n'+
                ", fecha=" + getDateString() + '\n'+
                ", cliente=" + cliente.toString() +'\n'+
                ", consultor=" + consultor.toString() +'\n'+
                '}';
    }
}
