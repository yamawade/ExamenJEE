package com.groupeisi.SectorClasseExamen.Service;

import com.groupeisi.SectorClasseExamen.Entity.ClasseExam;
import org.springframework.stereotype.Service;
import com.groupeisi.SectorClasseExamen.Repository.ClasseExamRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ClasseExamService {

    private final ClasseExamRepository classeRepository;

    public ClasseExamService(ClasseExamRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    public List<ClasseExam> getAllClasses() {
        return classeRepository.findAll();
    }

    public Optional<ClasseExam> getClasseById(Long id) {
        return classeRepository.findById(id);
    }

    public ClasseExam saveClasse(ClasseExam classe) {
        return classeRepository.save(classe);
    }

    public void deleteClasse(Long id) {
        classeRepository.deleteById(id);
    }
}
