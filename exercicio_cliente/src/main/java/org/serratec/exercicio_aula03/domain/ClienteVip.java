package org.serratec.exercicio_aula03.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ClienteVip")
public class ClienteVip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do consultor não pode estar vazio.")
    @Size(max=60, message = "O nome do consultor deve conter no maximo 60 carcteres.")
    private String consultorResponsavel;

    public ClienteVip() {
    }

    public ClienteVip(Long id, String consultorResponsavel) {
        this.id = id;
        this.consultorResponsavel = consultorResponsavel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConsultorResponsavel() {
        return consultorResponsavel;
    }

    public void setConsultorResponsavel(String consultorResponsavel) {
        this.consultorResponsavel = consultorResponsavel;
    }
}
