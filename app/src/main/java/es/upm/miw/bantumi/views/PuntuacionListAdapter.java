package es.upm.miw.bantumi.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.upm.miw.bantumi.R;
import es.upm.miw.bantumi.model.PuntuacionEntity;


public class PuntuacionListAdapter extends RecyclerView.Adapter<PuntuacionListAdapter.PuntuacionViewHolder> {

    class PuntuacionViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvJugador;
        private final TextView tvAlmacenJugador;
        private final TextView tvAlmacenMaquina;
        private final TextView tvFecha;

        private PuntuacionViewHolder(View itemView) {
            super(itemView);
            tvJugador = itemView.findViewById(R.id.tvJugador);
            tvAlmacenJugador = itemView.findViewById(R.id.tvAlmacenJugador);
            tvAlmacenMaquina = itemView.findViewById(R.id.tvAlmacenMaquina);
            tvFecha = itemView.findViewById(R.id.tvFecha);
        }
    }

    private final LayoutInflater mInflater;
    private List<PuntuacionEntity> puntuacionesList;

    /**
     * Constructor
     *
     * @param context context
     */
    public PuntuacionListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PuntuacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new PuntuacionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PuntuacionViewHolder holder, int position) {
        if (puntuacionesList != null) {
            PuntuacionEntity current = puntuacionesList.get(position);
            holder.tvJugador.setText(current.getJugador());
            holder.tvAlmacenJugador.setText("Almacen Jugador: "+ current.getAlmacenJugador().toString());
            holder.tvAlmacenMaquina.setText("Almacen Maquina: "+ current.getAlmacenMaquina().toString());
            holder.tvFecha.setText(current.getFecha().toString());
        } else {
            // Covers the case of data not being ready yet.
            holder.tvJugador.setText("No item");
            holder.tvAlmacenJugador.setText("No item");
            holder.tvAlmacenMaquina.setText("No item");
            holder.tvFecha.setText("No item");
        }
    }

    public void setItems(List<PuntuacionEntity> puntuacionesList){
        this.puntuacionesList = puntuacionesList;
        notifyDataSetChanged();
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return (puntuacionesList == null)
                ? 0
                : puntuacionesList.size();
    }

    public PuntuacionEntity getPuntuacionAtPosition(int position) {
        return puntuacionesList.get(position);
    }

    public void setTopTen(List<PuntuacionEntity> topTen){
        puntuacionesList = topTen;
        notifyDataSetChanged();
    }
}
