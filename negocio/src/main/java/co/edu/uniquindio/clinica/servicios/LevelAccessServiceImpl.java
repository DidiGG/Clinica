package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.entidades.LevelAccess;
import co.edu.uniquindio.clinica.repo.LevelAccessRepo;

public class LevelAccessServiceImpl implements LevelAccessService{
    private final LevelAccessRepo levelAccessRepo;

    public LevelAccessServiceImpl(LevelAccessRepo levelAccessRepo) {
        this.levelAccessRepo = levelAccessRepo;
    }

    @Override
    public LevelAccess registerLevelAccess(LevelAccess l) throws Exception {
        return levelAccessRepo.save(l);
    }

    @Override
    public LevelAccess updateLevelAccess(LevelAccess l) throws Exception {
        return levelAccessRepo.save(l);
    }

    @Override
    public void deleteLevelAccess(int id) throws Exception {
        levelAccessRepo.deleteById(id);
    }
}
