package prog.concurrente.feedback_final.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import prog.concurrente.feedback_final.domain.Servicio;


public interface ServicioRepository extends JpaRepository<Servicio, Long> {
}
