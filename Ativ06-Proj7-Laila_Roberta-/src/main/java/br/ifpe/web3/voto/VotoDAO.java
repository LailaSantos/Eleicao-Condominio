package br.ifpe.web3.voto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoDAO extends JpaRepository<Voto, Integer> {

}
