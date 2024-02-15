package prog.concurrente.feedback_final.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class UsuarioDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String nombre;

    @NotNull
    @Size(max = 255)
    private String direccion;

    @NotNull
    @Size(max = 255)
    private String email;

    @NotNull
    @Size(max = 255)
    private String pass;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(final String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(final String pass) {
        this.pass = pass;
    }

}
