package org.serratec.exercicio_aula03.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Inheritance(strategy = InheritanceType.JOINED)
public class PessoaBase {

    @NotBlank(message = "O telefone não deve ser vazio.")
    @Size(max=11, message = "O telefone deve conter no máximo 11 caracteres.")
    private String telefone;

    @NotBlank(message = "O endereço não deve ser nulo.")
    private String endereco;

    private Boolean ativo;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
