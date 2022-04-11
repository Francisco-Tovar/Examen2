package Examen2.Cenfotec.TeLoAuditoYTeCobro.controllers;

import Examen2.Cenfotec.TeLoAuditoYTeCobro.domain.Consultor;
import Examen2.Cenfotec.TeLoAuditoYTeCobro.services.ConsultorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ConsultorController {

    @Autowired
    ConsultorService consultorService;

    @RequestMapping(value = "/registrarConsultor", method = RequestMethod.GET)
    public String navegarRegistroConsultor(Model model){
        List options = new ArrayList<String>();
        options.add("ISO-Calidad");
        options.add("ISO-Procesos");
        options.add("ISO-Salubridad");
        options.add("Seguridad Laboral");
        options.add("Seguridad de IT");
        model.addAttribute("options", options);

        List yesno = new ArrayList<String>();
        yesno.add("Si");
        yesno.add("No");
        yesno.add("Fines de semana");
        yesno.add("Anos bisiestos");
        yesno.add("Cada muerte de Obispo");
        yesno.add("Solo si NO hay luna llena");
        model.addAttribute("yesno", yesno);

        List status = new ArrayList<String>();
        status.add("Activo");
        status.add("Inactivo");
        model.addAttribute("status", status);

        model.addAttribute(new Consultor());
        return "registrarConsultor";
    }

    @RequestMapping(value = "/registrarConsultor", method = RequestMethod.POST)
    public String accionRegistrarConsultor(Consultor consultor, BindingResult result, Model model){
        consultorService.save(consultor);
        return "exito";
    }

    @RequestMapping("/listarConsultores")
    public String listadoConsultores(Model model) {
        model.addAttribute("consultores", consultorService.getAll());
        return "listarConsultores";
    }

}
