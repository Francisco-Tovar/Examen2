package Examen2.Cenfotec.TeLoAuditoYTeCobro.repositories;

import Examen2.Cenfotec.TeLoAuditoYTeCobro.domain.Cliente;
import Examen2.Cenfotec.TeLoAuditoYTeCobro.domain.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository <Contacto, Long> {
}
