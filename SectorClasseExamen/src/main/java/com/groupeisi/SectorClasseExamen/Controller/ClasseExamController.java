package com.groupeisi.SectorClasseExamen.Controller;


import com.groupeisi.SectorClasseExamen.Entity.ClasseExam;
import com.groupeisi.SectorClasseExamen.Service.ClasseExamService;
import com.groupeisi.SectorClasseExamen.Service.SectorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/classes")
public class ClasseExamController {

    private final ClasseExamService classeService;
    private final SectorService sectorService;


    public ClasseExamController(ClasseExamService classeService , SectorService sectorService) {
        this.classeService = classeService;
        this.sectorService = sectorService;
    }

    @GetMapping
    public String listClasses(Model model) {
        model.addAttribute("classes", classeService.getAllClasses());
        return "classes/list";
    }

    @PostMapping
    public String createClasse(@ModelAttribute ClasseExam classe) {
        classeService.saveClasse(classe);
        return "redirect:/classes";
    }



    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        ClasseExam classe = classeService.getClasseById(id)
                .orElseThrow(() -> new RuntimeException("Classe non trouvée"));
        model.addAttribute("classe", classe);
        model.addAttribute("sectors", sectorService.getAllSectors());
        return "classes/edit";
    }


    @PostMapping("/update/{id}")
    public String updateClasse(@PathVariable Long id, @ModelAttribute ClasseExam classe) {
        classe.setId(id);
        classeService.saveClasse(classe);
        return "redirect:/classes";
    }


    @GetMapping("/delete/{id}")
    public String deleteClasse(@PathVariable Long id) {
        classeService.deleteClasse(id);
        return "redirect:/classes";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("classe", new ClasseExam());
        model.addAttribute("sectors", sectorService.getAllSectors());
        return "classes/create";
    }

}
