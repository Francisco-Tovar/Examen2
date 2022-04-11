package Examen2.Cenfotec.TeLoAuditoYTeCobro.services;

import Examen2.Cenfotec.TeLoAuditoYTeCobro.domain.Cliente;
import Examen2.Cenfotec.TeLoAuditoYTeCobro.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public void save(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getById(int id){
        return clienteRepository.findById(Long.valueOf(id));
    }

    public void update(Cliente cliente){
        clienteRepository.save(cliente);
    }


    public void delete(int id){
        clienteRepository.deleteById(Long.valueOf(id));
    }

}
