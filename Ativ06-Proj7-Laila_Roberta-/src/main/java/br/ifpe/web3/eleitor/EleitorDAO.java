package br.ifpe.web3.eleitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleitorDAO extends JpaRepository<Eleitor, Integer> {

}
