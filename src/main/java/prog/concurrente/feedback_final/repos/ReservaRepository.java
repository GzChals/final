package prog.concurrente.feedback_final.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import prog.concurrente.feedback_final.domain.Reserva;
import prog.concurrente.feedback_final.domain.Servicio;
import prog.concurrente.feedback_final.domain.Usuario;


public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    Reserva findFirstByUsuario(Usuario usuario);

    Reserva findFirstByServicio(Servicio servicio);

}
