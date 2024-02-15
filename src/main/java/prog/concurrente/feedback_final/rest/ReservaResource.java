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
import prog.concurrente.feedback_final.model.ReservaDTO;
import prog.concurrente.feedback_final.service.ReservaService;


@RestController
@RequestMapping(value = "/api/reservas", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservaResource {

    private final ReservaService reservaService;

    public ReservaResource(final ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> getAllReservas() {
        return ResponseEntity.ok(reservaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> getReserva(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(reservaService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createReserva(@RequestBody @Valid final ReservaDTO reservaDTO) {
        final Long createdId = reservaService.create(reservaDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateReserva(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final ReservaDTO reservaDTO) {
        reservaService.update(id, reservaDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteReserva(@PathVariable(name = "id") final Long id) {
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
