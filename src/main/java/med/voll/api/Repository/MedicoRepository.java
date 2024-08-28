package med.voll.api.Repository;

import med.voll.api.Models.Medico;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicoRepository extends JpaRepository<Medico,Long> {
}
