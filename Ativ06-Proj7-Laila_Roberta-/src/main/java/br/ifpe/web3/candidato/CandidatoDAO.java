package br.ifpe.web3.candidato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoDAO extends JpaRepository<Candidato, Integer> {

}
