package br.ifpe.web3.acesso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

	@Query("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha")
	public Usuario findByLoginAndSenha(String login, String senha);
}
