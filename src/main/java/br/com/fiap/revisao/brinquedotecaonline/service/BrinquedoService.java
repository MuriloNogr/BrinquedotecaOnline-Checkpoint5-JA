package br.com.fiap.revisao.brinquedotecaonline.service;

import br.com.fiap.revisao.brinquedotecaonline.dto.BrinquedoDTO;
import br.com.fiap.revisao.brinquedotecaonline.model.Brinquedo;
import br.com.fiap.revisao.brinquedotecaonline.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrinquedoService {

    @Autowired
    private BrinquedoRepository brinquedoRepository;

    public List<BrinquedoDTO> getAllBrinquedos() {
        return brinquedoRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public BrinquedoDTO getBrinquedoById(Long id) {
        return brinquedoRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException("Brinquedo não encontrado"));
    }

    public void saveBrinquedo(BrinquedoDTO brinquedoDTO) {
        Brinquedo brinquedo = convertToEntity(brinquedoDTO);
        brinquedoRepository.save(brinquedo);
    }

    public void updateBrinquedo(Long id, BrinquedoDTO brinquedoDTO) {
        Brinquedo brinquedo = convertToEntity(brinquedoDTO);
        brinquedo.setID_BRINQUEDO(id);
        brinquedoRepository.save(brinquedo);
    }

    public void deleteBrinquedo(Long id) {
        brinquedoRepository.deleteById(id);
    }

    private BrinquedoDTO convertToDto(Brinquedo brinquedo) {
        BrinquedoDTO dto = new BrinquedoDTO();
        dto.setID_BRINQUEDO(brinquedo.getID_BRINQUEDO());
        dto.setNOME_BRINQUEDO(brinquedo.getNOME_BRINQUEDO());
        dto.setTIPO_BRINQUEDO(brinquedo.getTIPO_BRINQUEDO());
        dto.setCLASSIFICACAO_BRINQUEDO(brinquedo.getCLASSIFICACAO_BRINQUEDO());
        dto.setTAMANHO_BRINQUEDO(brinquedo.getTAMANHO_BRINQUEDO());
        dto.setPRECO_BRINQUEDO(brinquedo.getPRECO_BRINQUEDO());
        dto.setURL_IMAGEM_BRINQUEDO(brinquedo.getURL_IMAGEM_BRINQUEDO());
        return dto;
    }

    private Brinquedo convertToEntity(BrinquedoDTO dto) {
        Brinquedo brinquedo = new Brinquedo();
        brinquedo.setID_BRINQUEDO(dto.getID_BRINQUEDO());
        brinquedo.setNOME_BRINQUEDO(dto.getNOME_BRINQUEDO());
        brinquedo.setTIPO_BRINQUEDO(dto.getTIPO_BRINQUEDO());
        brinquedo.setCLASSIFICACAO_BRINQUEDO(dto.getCLASSIFICACAO_BRINQUEDO());
        brinquedo.setTAMANHO_BRINQUEDO(dto.getTAMANHO_BRINQUEDO());
        brinquedo.setPRECO_BRINQUEDO(dto.getPRECO_BRINQUEDO());
        brinquedo.setURL_IMAGEM_BRINQUEDO(dto.getURL_IMAGEM_BRINQUEDO());
        return brinquedo;
    }
}
