package prog.concurrente.feedback_final.rest;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prog.concurrente.feedback_final.model.ServicioDTO;
import prog.concurrente.feedback_final.service.ServicioService;
import prog.concurrente.feedback_final.util.ReferencedException;
import prog.concurrente.feedback_final.util.ReferencedWarning;


@RestController
@RequestMapping(value = "/api/servicios", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServicioResource {

    private final ServicioService servicioService;

    public ServicioResource(final ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping
    public ResponseEntity<List<ServicioDTO>> getAllServicios() {
        return ResponseEntity.ok(servicioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicioDTO> getServicio(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(servicioService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createServicio(@RequestBody @Valid final ServicioDTO servicioDTO) {
        final Long createdId = servicioService.create(servicioDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateServicio(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final ServicioDTO servicioDTO) {
        servicioService.update(id, servicioDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteServicio(@PathVariable(name = "id") final Long id) {
        final ReferencedWarning referencedWarning = servicioService.getReferencedWarning(id);
        if (referencedWarning != null) {
            throw new ReferencedException(referencedWarning);
        }
        servicioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
