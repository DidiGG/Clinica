package co.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Usuario implements Serializable {

    @OneToMany(mappedBy = "usuario")
    private List<Medico> medicos;

    @OneToMany(mappedBy = "usuario")
    private List<Paciente> pacientes;

    @OneToOne(mappedBy = "usuario")
    private Admin admin;

    @Id
    @NotNull
    @Column(name = "id_usuaio", unique = true, updatable = false, length = 15)
    private String id_usuario;

    @NotNull
    @Column(name = "rol", unique = true, updatable = false, length = 15)
    private String rol;

    @NotNull
    @Column(name = "nombre", unique = true, updatable = false, length = 15)
    private String nombre;

    @NotNull
    @Column(name = "apellido", unique = true, updatable = false, length = 30)
    private String apellido;

    @NotNull
    @Column(name = "telefono", unique = true, updatable = true, length = 20)
    private String telofono;

    public Usuario() {
        super();
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelofono() {
        return telofono;
    }

    public void setTelofono(String telofono) {
        this.telofono = telofono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id_usuario, usuario.id_usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_usuario);
    }
}
