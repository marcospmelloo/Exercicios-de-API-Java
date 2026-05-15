package org.serratec.exercicio_curso_aluno.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar vazio.")
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @DecimalMin(value = "0.00", message = "O preco deve ser maior que zero.")
    @Column(name = "preco")
    private BigDecimal preco;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "curso_aluno",
    joinColumns = @JoinColumn(name = "id_curso"),
    inverseJoinColumns = @JoinColumn(name = "id_aluno"))

    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos;
}
