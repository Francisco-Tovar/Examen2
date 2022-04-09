package Examen2.Cenfotec.TeLoAuditoYTeCobro.services;

import Examen2.Cenfotec.TeLoAuditoYTeCobro.domain.Auditoria;
import Examen2.Cenfotec.TeLoAuditoYTeCobro.repositories.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditoriaService {

    @Autowired
    AuditoriaRepository auditoriaRepository;

    public void save(Auditoria auditoria){
        auditoriaRepository.save(auditoria);
    }

    public List<Auditoria> getAll(){
        return auditoriaRepository.findAll();
    }

    public Optional<Auditoria> getById(int id){
        return auditoriaRepository.findById(Long.valueOf(id));
    }

    public void update(Auditoria auditoria){
        auditoriaRepository.save(auditoria);
    }

    public void delete(int id){
        auditoriaRepository.deleteById(Long.valueOf(id));
    }

}
