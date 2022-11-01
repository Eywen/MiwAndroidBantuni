package es.upm.miw.bantumi.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PuntuacionRepository {

    private IPuntuacionDAO puntuacionDAO;
    private LiveData<List<PuntuacionEntity>> listPuntuaciones;

    /**
     * Constructor
     *
     * @param application app
     */
    public PuntuacionRepository(Application application) {
        PuntuacionRoomDatabase db = PuntuacionRoomDatabase.getDatabase(application);
        puntuacionDAO = db.grupoDAO();
        listPuntuaciones = puntuacionDAO.getAll();
    }

    public LiveData<List<PuntuacionEntity>> getAll() {
        return listPuntuaciones;
    }

    public long insert(PuntuacionEntity item) {
        return puntuacionDAO.insert(item);
    }

    public void deleteAll() {
        puntuacionDAO.deleteAll();
    }

    public void delete(PuntuacionEntity item)  {puntuacionDAO.delete(item);    }

    public void updateUser(PuntuacionEntity user) {puntuacionDAO.updateUser(user);}
}
