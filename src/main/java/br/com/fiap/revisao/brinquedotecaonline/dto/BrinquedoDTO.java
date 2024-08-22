package br.com.fiap.revisao.brinquedotecaonline.dto;

import org.springframework.hateoas.RepresentationModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BrinquedoDTO extends RepresentationModel<BrinquedoDTO> {

    private Long ID_BRINQUEDO;
    private String NOME_BRINQUEDO;
    private String TIPO_BRINQUEDO;
    private String CLASSIFICACAO_BRINQUEDO;
    private String TAMANHO_BRINQUEDO;
    private String PRECO_BRINQUEDO;
}