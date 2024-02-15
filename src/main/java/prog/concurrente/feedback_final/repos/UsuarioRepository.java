package prog.concurrente.feedback_final.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import prog.concurrente.feedback_final.domain.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
