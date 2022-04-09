package Examen2.Cenfotec.TeLoAuditoYTeCobro.services;

import Examen2.Cenfotec.TeLoAuditoYTeCobro.domain.Consultor;
import Examen2.Cenfotec.TeLoAuditoYTeCobro.repositories.ConsultorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultorService {

    @Autowired
    ConsultorRepository consultorRepository;

    public void save(Consultor consultor){
        consultorRepository.save(consultor);
    }

    public List<Consultor> getAll(){
        return consultorRepository.findAll();
    }

    public Optional<Consultor> getById(int id){
        return consultorRepository.findById(Long.valueOf(id));
    }

    public void update(Consultor consultor){
        consultorRepository.save(consultor);
    }

    public void delete(int id){
        consultorRepository.deleteById(Long.valueOf(id));
    }

}
