package Examen2.Cenfotec.TeLoAuditoYTeCobro.repositories;

import Examen2.Cenfotec.TeLoAuditoYTeCobro.domain.Consultor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultorRepository extends JpaRepository <Consultor, Long> {
}
