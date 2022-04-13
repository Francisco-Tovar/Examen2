package Examen2.Cenfotec.TeLoAuditoYTeCobro.controllers;

import Examen2.Cenfotec.TeLoAuditoYTeCobro.domain.Auditoria;
import Examen2.Cenfotec.TeLoAuditoYTeCobro.domain.Cliente;
import Examen2.Cenfotec.TeLoAuditoYTeCobro.services.AuditoriaService;
import Examen2.Cenfotec.TeLoAuditoYTeCobro.services.ClienteService;
import Examen2.Cenfotec.TeLoAuditoYTeCobro.services.ConsultorService;
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
public class AuditoriaController {

    @Autowired
    AuditoriaService auditoriaService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    ConsultorService consultorService;

    public Model agregarOpciones(Model model){
        List options = new ArrayList<String>();
        options.add("ISO-Calidad");
        options.add("ISO-Procesos");
        options.add("ISO-Salubridad");
        options.add("Seguridad Laboral");
        options.add("Seguridad de IT");
        model.addAttribute("options", options);

        List clientes = clienteService.getAll();
        model.addAttribute("clientes", clientes);

        List consultores = consultorService.getAll();
        model.addAttribute("consultores", consultores);

        return model;
    }

    @RequestMapping(value = "/registrarAuditoria", method = RequestMethod.GET)
    public String navegarRegistroAuditoria(Model model){
        model = agregarOpciones(model);
        model.addAttribute(new Auditoria());
        return "registrarAuditoria";
    }

    @RequestMapping(value = "/registrarAuditoria", method = RequestMethod.POST)
    public String accionRegistrarAuditoria(Auditoria auditoria, BindingResult result, Model model){
        auditoriaService.save(auditoria);
        return "exito";
    }

    @RequestMapping("/listarAuditorias")
    public String listadoAuditoria(Model model) {
        model.addAttribute("auditorias", auditoriaService.getAll());
        return "listarAuditorias";
    }

    @RequestMapping(value = "/editarAuditoria/{id}")
    public String irAEditarAuditoria(Model model, @PathVariable int id) {
        model = agregarOpciones(model);
        Optional<Auditoria> auditoriaToEdit = auditoriaService.getById(id);
        if (auditoriaToEdit.isPresent()){
            model.addAttribute("auditoria", auditoriaToEdit);
            return "editarAuditoria";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/editarAuditoria/{id}", method = RequestMethod.POST)
    public String guardarCambios(Auditoria auditoria, BindingResult result,Model model,
                                 @PathVariable int id) {
        auditoriaService.update(auditoria);
        return "exito";
    }

    @RequestMapping(value = "/borrarAuditoria/{id}")
    public String borrarAuditoria(Auditoria auditoria, BindingResult result,Model model, @PathVariable int id) {
        auditoriaService.delete(id);
        return "exito";
    }
    
}
