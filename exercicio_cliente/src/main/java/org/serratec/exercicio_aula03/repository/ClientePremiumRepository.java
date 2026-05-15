package org.serratec.exercicio_aula03.repository;

import org.serratec.exercicio_aula03.domain.ClientePremium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientePremiumRepository extends JpaRepository<ClientePremium, Long> {
}
