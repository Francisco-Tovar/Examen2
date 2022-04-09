package Examen2.Cenfotec.TeLoAuditoYTeCobro.repositories;

import Examen2.Cenfotec.TeLoAuditoYTeCobro.domain.Auditoria;
import Examen2.Cenfotec.TeLoAuditoYTeCobro.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaRepository extends JpaRepository <Auditoria, Long> {
}
