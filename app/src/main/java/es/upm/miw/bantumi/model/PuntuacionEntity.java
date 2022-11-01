package es.upm.miw.bantumi.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = PuntuacionEntity.TABLA)
public class PuntuacionEntity {
    static public final String TABLA = "puntuacion";

    @PrimaryKey(autoGenerate = true)
    protected int uid;

    private String jugador;
    private Date fecha;
    private int almacenJugador;
    private int almacenMaquina;
}
