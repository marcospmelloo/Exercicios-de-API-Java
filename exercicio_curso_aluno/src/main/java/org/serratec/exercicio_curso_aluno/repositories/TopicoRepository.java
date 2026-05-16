package org.serratec.exercicio_curso_aluno.repositories;

import org.serratec.exercicio_curso_aluno.domain.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
