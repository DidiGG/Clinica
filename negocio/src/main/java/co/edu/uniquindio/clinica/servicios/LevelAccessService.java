package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.entidades.LevelAccess;

public interface LevelAccessService {
    LevelAccess registerLevelAccess(LevelAccess l) throws Exception;

    LevelAccess updateLevelAccess(LevelAccess l) throws Exception;

    void deleteLevelAccess(int id) throws Exception;
}
