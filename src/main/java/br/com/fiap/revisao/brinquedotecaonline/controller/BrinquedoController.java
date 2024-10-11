package br.com.fiap.revisao.brinquedotecaonline.controller;

import br.com.fiap.revisao.brinquedotecaonline.dto.BrinquedoDTO;
import br.com.fiap.revisao.brinquedotecaonline.service.BrinquedoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoService brinquedoService;

    @GetMapping
    public String getAllBrinquedos(Model model) {
        List<BrinquedoDTO> brinquedos = brinquedoService.getAllBrinquedos();
        model.addAttribute("brinquedos", brinquedos);
        return "brinquedos";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("brinquedo", new BrinquedoDTO());
        return "brinquedo-form";
    }

    @PostMapping
    public String createBrinquedo(@ModelAttribute("brinquedo") BrinquedoDTO brinquedoDTO) {
        brinquedoService.saveBrinquedo(brinquedoDTO);
        return "redirect:/api/brinquedos";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        BrinquedoDTO brinquedo = brinquedoService.getBrinquedoById(id);
        model.addAttribute("brinquedo", brinquedo);
        return "brinquedo-form";
    }

    @PostMapping("/edit/{id}")
    public String updateBrinquedo(@PathVariable Long id, @ModelAttribute("brinquedo") BrinquedoDTO brinquedoDTO) {
        brinquedoService.updateBrinquedo(id, brinquedoDTO);
        return "redirect:/api/brinquedos";
    }

    @GetMapping("/delete/{id}")
    public String deleteBrinquedo(@PathVariable Long id) {
        brinquedoService.deleteBrinquedo(id);
        return "redirect:/api/brinquedos";
    }
}
