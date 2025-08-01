package com.groupeisi.SectorClasseExamen.Controller;

import com.groupeisi.SectorClasseExamen.Entity.Sector;
import com.groupeisi.SectorClasseExamen.Service.SectorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sectors")
public class SectorExamController {

    private final SectorService sectorService;

    public SectorExamController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @GetMapping
    public String listSectors(Model model) {
        model.addAttribute("sectors", sectorService.getAllSectors());
        return "sectors/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("sector", new Sector());
        return "sectors/create";
    }

    @PostMapping
    public String createSector(@ModelAttribute Sector sector) {
        sectorService.saveSector(sector);
        return "redirect:/sectors";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Sector sector = sectorService.getSectorById(id).orElseThrow(() -> new RuntimeException("Secteur non trouvé"));
        model.addAttribute("sector", sector);
        return "sectors/edit";
    }

    @PostMapping("/update/{id}")
    public String updateSector(@PathVariable Long id, @ModelAttribute Sector sector) {
        sector.setId(id);
        sectorService.saveSector(sector);
        return "redirect:/sectors";
    }

    @GetMapping("/delete/{id}")
    public String deleteSector(@PathVariable Long id) {
        sectorService.deleteSector(id);
        return "redirect:/sectors";
    }
}
