package org.serratec.exercicio_aula03.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "Cliente")
public class Cliente extends PessoaBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar vazio.")
    @Size(max=60, message = "O nome deve conter no maximo 60 carcteres.")
    @Column(name="nome", nullable=false, length=60)
    private String nome;

    @NotBlank(message = "O CPF não pode estar vazio.")
    @Size(max=11, min=11, message = "O CPF deve conter 11 caracteres.")
    @Column(name= "cpf", length = 11, unique = true)
    private String cpf;

    @Email(message = "Deve estar no formato de e-mail.")
    @Column(name="email", length = 50)
    private String email;

    @NotNull
    @Column(name="dataNascimento")
    private LocalDate dataNascimento;

    @Embedded
    private DocumentoCliente docCliente;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String cpf, String email, LocalDate dataNascimento, DocumentoCliente docCliente) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.docCliente = docCliente;
    }

    public DocumentoCliente getDocCliente() {
        return docCliente;
    }

    public void setDocCliente(DocumentoCliente docCliente) {
        this.docCliente = docCliente;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
