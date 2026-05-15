package org.serratec.exercicio_aula03.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 60, message = "Nome deve ter no máximo 60 caracteres")
    @Column(name="nome", nullable=false, length=60)
    private String nome;

    @NotBlank(message = "O cargo é obrigatório.")
    @Column(name= "cargo")
    private String cargo;

    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero.")
    @Column(name="salario")
    private BigDecimal salario;

    public Funcionario(Long id, String nome, String cargo, BigDecimal salario) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Funcionario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setEmail(BigDecimal salario) {
        this.salario = salario;
    }
}
