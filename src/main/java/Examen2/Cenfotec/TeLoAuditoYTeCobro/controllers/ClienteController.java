package Examen2.Cenfotec.TeLoAuditoYTeCobro.controllers;

import Examen2.Cenfotec.TeLoAuditoYTeCobro.domain.Cliente;
import Examen2.Cenfotec.TeLoAuditoYTeCobro.domain.Contacto;
import Examen2.Cenfotec.TeLoAuditoYTeCobro.services.ClienteService;
import Examen2.Cenfotec.TeLoAuditoYTeCobro.services.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    @Autowired
    ContactoService contactoService;

    @RequestMapping(value = "/registrarCliente", method = RequestMethod.GET)
    public String navegarRegistroCliente(Model model){
        model.addAttribute(new Cliente());
        return "registrarCliente";
    }

    @RequestMapping(value = "/registrarCliente", method = RequestMethod.POST)
    public String accionRegistrarCliente(Cliente cliente, BindingResult result, Model model){
        clienteService.save(cliente);
        return "exito";
    }

    @RequestMapping("/listarClientes")
    public String listadoClientes(Model model) {
        model.addAttribute("clientes", clienteService.getAll());
        return "listarClientes";
    }

    @RequestMapping(value = "/editarCliente/{id}")
    public String irAEditarCliente(Model model, @PathVariable int id) {
        Optional<Cliente> clienteToEdit = clienteService.getById(id);
        if (clienteToEdit.isPresent()){
            model.addAttribute("cliente", clienteToEdit);
            return "editarCliente";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/editarCliente/{id}", method = RequestMethod.POST)
    public String guardarCambios(Cliente cliente, BindingResult result,Model model, @PathVariable int id) {
        clienteService.update(cliente);
        return "exito";
    }

    @RequestMapping(value = "/registrarContacto/{id}")
    public String irRegistrarContacto(Model model, @PathVariable int id) {
        Optional<Cliente> clienteToEdit = clienteService.getById(id);
        if (clienteToEdit.isPresent()){
            model.addAttribute("cliente", clienteToEdit);
            model.addAttribute( new Contacto());
            return "registrarContacto";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/registrarContacto/{id}", method = RequestMethod.POST)
    public String guardarContacto(Cliente cliente, Contacto contacto, BindingResult result,Model model, @PathVariable int id) {
        Optional<Cliente> clienteToEdit = clienteService.getById(id);
        if (clienteToEdit.isPresent()){
            cliente = clienteToEdit.get();
            cliente.addContacto(contacto);
            clienteService.update(cliente);
            return "exito";
        } else {
            return "notFound";
        }
    }
    @RequestMapping("/listarContactos")
    public String listadoContactos(Model model) {
        model.addAttribute("contactos", contactoService.getAll());
        return "listarContactos";
    }

    @RequestMapping(value = "/editarContacto/{id}")
    public String irAEditarContacto(Model model, @PathVariable int id) {
        Optional<Contacto> contactoToEdit = contactoService.getById(id);
        if (contactoToEdit.isPresent()){
            model.addAttribute("contacto", contactoToEdit);
            return "editarContacto";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/editarContacto/{id}", method = RequestMethod.POST)
    public String guardarCambiosContacto(Contacto contacto, BindingResult result,Model model, @PathVariable int id) {
        Optional<Contacto> contactoToEdit = contactoService.getById(id);
        if (contactoToEdit.isPresent()){
            contacto.setCliente(contactoToEdit.get().getCliente());
            List<Contacto> listaContactos = contacto.getCliente().getContactos();
            Cliente tempCliente = contacto.getCliente();

            for (int i = 0; i < listaContactos.size(); i++) {
                if (contactoToEdit.get().getId() == listaContactos.get(i).getId()){
                    listaContactos.set(i ,contacto);
                }
            }
            tempCliente.setContactos(listaContactos);
            clienteService.update(tempCliente);
            contactoService.update(contacto);
            return "exito";
        } else {
            return "notFound";
        }
    }

}
