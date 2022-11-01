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

    public PuntuacionEntity() {
    }

    public PuntuacionEntity(String nombreJugador, Integer almacen1, Integer almacen2) {
        this.fecha = new Date(); //Al guardar la partida cuando se termina el juego siempre se hará con la fecha en milisegundos del instante en el que se produce la accion
        this.jugador = nombreJugador;
        this.almacenJugador = almacen1;
        this.almacenMaquina = almacen2;
    }

    public int getUid() {
        return uid;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getAlmacenJugador() {
        return almacenJugador;
    }

    public void setAlmacenJugador(int almacenJugador) {
        this.almacenJugador = almacenJugador;
    }

    public int getAlmacenMaquina() {
        return almacenMaquina;
    }

    public void setAlmacenMaquina(int almacenMaquina) {
        this.almacenMaquina = almacenMaquina;
    }
}
