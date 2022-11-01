package es.upm.miw.bantumi.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface IPuntuacionDAO {
    @Query("SELECT * FROM " + PuntuacionEntity.TABLA)
    LiveData<List<PuntuacionEntity>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(PuntuacionEntity grupo);

    @Query("DELETE FROM " + PuntuacionEntity.TABLA)
    void deleteAll();

    @Delete
    void delete(PuntuacionEntity grupo);

    @Update
    void updateUser (PuntuacionEntity user);
}
