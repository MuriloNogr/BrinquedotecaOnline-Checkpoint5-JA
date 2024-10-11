package br.com.fiap.revisao.brinquedotecaonline.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "TB_BRINQUEDOS")
public class Brinquedo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_BRINQUEDO;

    @Column(nullable = false)
    private String NOME_BRINQUEDO;

    @Column(nullable = false)
    private String TIPO_BRINQUEDO;

    @Column(nullable = false)
    private String CLASSIFICACAO_BRINQUEDO;

    @Column(nullable = false)
    private String TAMANHO_BRINQUEDO;

    @Column(nullable = false)
    private String PRECO_BRINQUEDO;

    @Column(nullable = false)
    private String URL_IMAGEM_BRINQUEDO;
}
