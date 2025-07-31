package com.groupeisi.SectorClasseExamen.Service;

import com.groupeisi.SectorClasseExamen.Entity.Sector;
import com.groupeisi.SectorClasseExamen.Repository.SectorRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class SectorService {

    private final SectorRepository sectorRepository;

    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    public List<Sector> getAllSectors() {
        return sectorRepository.findAll();
    }

    public Optional<Sector> getSectorById(Long id) {
        return sectorRepository.findById(id);
    }

    public Sector saveSector(Sector sector) {
        return sectorRepository.save(sector);
    }

    public void deleteSector(Long id) {
        sectorRepository.deleteById(id);
    }
}

