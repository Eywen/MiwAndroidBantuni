package es.upm.miw.bantumi.model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PuntuacionViewModel extends AndroidViewModel {

    private PuntuacionRepository puntuacionRepository;
    private LiveData<List<PuntuacionEntity>> listpuntuaciones;

    /**
     * Constructor
     *
     * @param application app
     */
    public PuntuacionViewModel (Application application){
        super(application);
        puntuacionRepository = new PuntuacionRepository(application);
        listpuntuaciones = puntuacionRepository.getAll();
    }

    /**
     * Obtiene todos los grupos
     *
     * @return lista de grupos
     */
    public LiveData<List<PuntuacionEntity>> getAll() {
        return listpuntuaciones;
    }

    public void insert(PuntuacionEntity item) {
        puntuacionRepository.insert(item);
    }

    public void deleteAll() {
        puntuacionRepository.deleteAll();
    }

    public void delete(PuntuacionEntity item) {
        puntuacionRepository.delete(item);
    }

    public void UpdatePuntuacion(PuntuacionEntity puntuacion){puntuacionRepository.updatePuntuacion(puntuacion);}

    public LiveData<List<PuntuacionEntity>> getTopTen(){return puntuacionRepository.getTopTen();}
}
