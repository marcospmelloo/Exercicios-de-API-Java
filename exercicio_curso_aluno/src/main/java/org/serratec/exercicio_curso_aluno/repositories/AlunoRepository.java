package org.serratec.exercicio_curso_aluno.repositories;

import org.serratec.exercicio_curso_aluno.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
