package org.serratec.exercicio_aula03.domain;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

@Entity
public class ClientePremium extends Cliente {

    @NotBlank(message = "O limite de crédito não pode ser vazio.")
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero.")
    private Double limiteCredito;

    @NotBlank(message = "O nível de fidelidade não pode ser vazio.")
    private String nivelFidelidade;

    public Double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getNivelFidelidade() {
        return nivelFidelidade;
    }

    public void setNivelFidelidade(String nivelFidelidade) {
        this.nivelFidelidade = nivelFidelidade;
    }
}
