package Examen2.Cenfotec.TeLoAuditoYTeCobro.services;

import Examen2.Cenfotec.TeLoAuditoYTeCobro.domain.Contacto;
import Examen2.Cenfotec.TeLoAuditoYTeCobro.repositories.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoService {

    @Autowired
    ContactoRepository contactoRepository;

    public void save(Contacto contacto){
        contactoRepository.save(contacto);
    }

    public List<Contacto> getAll(){
        return contactoRepository.findAll();
    }

    public Optional<Contacto> getById(int id){
        return contactoRepository.findById(Long.valueOf(id));
    }

    public void update(Contacto contacto){
        contactoRepository.save(contacto);
    }

    public void delete(int id){
        contactoRepository.deleteById(Long.valueOf(id));
    }

}
