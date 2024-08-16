package br.com.fiap.revisao.brinquedotecaonline.service;

import br.com.fiap.revisao.brinquedotecaonline.model.Brinquedo;
import br.com.fiap.revisao.brinquedotecaonline.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.fiap.revisao.brinquedotecaonline.dto.BrinquedoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrinquedoService {
    @Autowired
    private BrinquedoRepository brinquedoRepository;

    public List<BrinquedoDTO> getAllBrinquedos() {
        List<Brinquedo> brinquedos = brinquedoRepository.findAll();
        return brinquedos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BrinquedoDTO getBrinquedoById(Long id) {
        Brinquedo brinquedo = brinquedoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brinquedo não encontrado"));
        return convertToDTO(brinquedo);
    }

    public BrinquedoDTO saveBrinquedo(BrinquedoDTO brinquedoDTO) {
        Brinquedo brinquedo = convertToEntity(brinquedoDTO);
        brinquedo = brinquedoRepository.save(brinquedo);
        return convertToDTO(brinquedo);
    }

    public BrinquedoDTO updateBrinquedo(Long id, BrinquedoDTO brinquedoDTO) {
        Brinquedo brinquedo = brinquedoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brinquedo não encontrado"));
        brinquedo.setNOME_BRINQUEDO(brinquedoDTO.getNOME_BRINQUEDO());
        brinquedo.setTIPO_BRINQUEDO(brinquedoDTO.getTIPO_BRINQUEDO());
        brinquedo.setCLASSIFICACAO_BRINQUEDO(brinquedoDTO.getCLASSIFICACAO_BRINQUEDO());
        brinquedo.setTAMANHO_BRINQUEDO(brinquedoDTO.getTAMANHO_BRINQUEDO());
        brinquedo.setPRECO_BRINQUEDO(brinquedoDTO.getPRECO_BRINQUEDO());
        brinquedo = brinquedoRepository.save(brinquedo);
        return convertToDTO(brinquedo);
    }

    public void deleteBrinquedo(Long id) {
        Brinquedo brinquedo = brinquedoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brinquedo não encontrado"));
        brinquedoRepository.delete(brinquedo);
    }

    private BrinquedoDTO convertToDTO(Brinquedo brinquedo) {
        BrinquedoDTO dto = new BrinquedoDTO();
        dto.setID_BRINQUEDO(brinquedo.getID_BRINQUEDO());
        dto.setNOME_BRINQUEDO(brinquedo.getNOME_BRINQUEDO());
        dto.setTIPO_BRINQUEDO(brinquedo.getTIPO_BRINQUEDO());
        dto.setCLASSIFICACAO_BRINQUEDO(brinquedo.getCLASSIFICACAO_BRINQUEDO());
        dto.setTAMANHO_BRINQUEDO(brinquedo.getTAMANHO_BRINQUEDO());
        dto.setPRECO_BRINQUEDO(brinquedo.getPRECO_BRINQUEDO());
        return dto;
    }

    private Brinquedo convertToEntity(BrinquedoDTO dto) {
        Brinquedo brinquedo = new Brinquedo();
        brinquedo.setNOME_BRINQUEDO(dto.getNOME_BRINQUEDO());
        brinquedo.setTIPO_BRINQUEDO(dto.getTIPO_BRINQUEDO());
        brinquedo.setCLASSIFICACAO_BRINQUEDO(dto.getCLASSIFICACAO_BRINQUEDO());
        brinquedo.setTAMANHO_BRINQUEDO(dto.getTAMANHO_BRINQUEDO());
        brinquedo.setPRECO_BRINQUEDO(dto.getPRECO_BRINQUEDO());
        return brinquedo;
    }

}