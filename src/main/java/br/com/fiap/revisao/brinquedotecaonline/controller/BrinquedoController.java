package br.com.fiap.revisao.brinquedotecaonline.controller;

import br.com.fiap.revisao.brinquedotecaonline.dto.BrinquedoDTO;
import br.com.fiap.revisao.brinquedotecaonline.service.BrinquedoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
        List<BrinquedoDTO> brinquedos = brinquedoService.getAllBrinquedos();
        brinquedos.forEach(brinquedo ->
                brinquedo.add(WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(BrinquedoController.class).getBrinquedoById(brinquedo.getID_BRINQUEDO())
                ).withSelfRel())
        );
        return brinquedos;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/{id}")
    public BrinquedoDTO getBrinquedoById(@PathVariable Long id) {
        BrinquedoDTO brinquedo = brinquedoService.getBrinquedoById(id);
        brinquedo.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(BrinquedoController.class).getAllBrinquedos()
        ).withRel("all-brinquedos"));
        brinquedo.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(BrinquedoController.class).getBrinquedoById(id)
        ).withSelfRel());
        return brinquedo;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping
    public BrinquedoDTO createBrinquedo(@RequestBody BrinquedoDTO brinquedoDTO) {
        BrinquedoDTO savedBrinquedo = brinquedoService.saveBrinquedo(brinquedoDTO);
        savedBrinquedo.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(BrinquedoController.class).getBrinquedoById(savedBrinquedo.getID_BRINQUEDO())
        ).withSelfRel());
        return savedBrinquedo;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PutMapping("/{id}")
    public BrinquedoDTO updateBrinquedo(@PathVariable Long id, @RequestBody BrinquedoDTO brinquedoDTO) {
        BrinquedoDTO updatedBrinquedo = brinquedoService.updateBrinquedo(id, brinquedoDTO);
        updatedBrinquedo.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(BrinquedoController.class).getBrinquedoById(id)
        ).withSelfRel());
        return updatedBrinquedo;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @DeleteMapping("/{id}")
    public void deleteBrinquedo(@PathVariable Long id) {
        brinquedoService.deleteBrinquedo(id);
    }
}
