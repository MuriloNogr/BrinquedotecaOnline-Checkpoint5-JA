package br.com.fiap.revisao.brinquedotecaonline.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.revisao.brinquedotecaonline.model.Brinquedo;

@Repository
public interface BrinquedoRepository extends JpaRepository<Brinquedo, Long> {

}
