package Examen2.Cenfotec.TeLoAuditoYTeCobro.domain;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String razonSocial;
    private String cedulaJuridica;
    private String direccion;
    private String telefono;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTACTO_ID", referencedColumnName = "ID")
    private List<Contacto> contactos;

    public Cliente() {
        this.contactos = new ArrayList<Contacto>();
    }

    public Cliente(Long id, String razonSocial, String cedulaJuridica,
                   String direccion, String telefono, List<Contacto> contactos) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.cedulaJuridica = cedulaJuridica;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contactos = contactos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
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

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public void addContacto(Contacto contacto){
        this.contactos.add(contacto);
    }

    public String getAllContacts(){
        String valor = "";
        for (Contacto i : contactos) {
            valor.concat( i.toString() + '\n' );
        }
        return valor;
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", razonSocial='" + razonSocial + '\'' +
                ", cedulaJuridica='" + cedulaJuridica + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", contactos=" + getAllContacts() +
                '}';
    }
}
