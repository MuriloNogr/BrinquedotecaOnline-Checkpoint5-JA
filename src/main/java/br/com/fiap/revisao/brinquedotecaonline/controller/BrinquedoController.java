package br.com.fiap.revisao.brinquedotecaonline.controller;

import br.com.fiap.revisao.brinquedotecaonline.service.BrinquedoService;
import br.com.fiap.revisao.brinquedotecaonline.dto.BrinquedoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brinquedos")
public class BrinquedoController {
    @Autowired
    private BrinquedoService brinquedoService;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping
    public List<BrinquedoDTO> getAllBrinquedos() {
        return brinquedoService.getAllBrinquedos();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/{id}")
    public BrinquedoDTO getBrinquedoById(@PathVariable Long id) {
        return brinquedoService.getBrinquedoById(id);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping
    public BrinquedoDTO createBrinquedo(@RequestBody BrinquedoDTO brinquedoDTO) {
        return brinquedoService.saveBrinquedo(brinquedoDTO);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PutMapping("/{id}")
    public BrinquedoDTO updateBrinquedo(@PathVariable Long id, @RequestBody BrinquedoDTO brinquedoDTO) {
        return brinquedoService.updateBrinquedo(id, brinquedoDTO);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @DeleteMapping("/{id}")
    public void deleteBrinquedo(@PathVariable Long id) {
        brinquedoService.deleteBrinquedo(id);
    }

}




