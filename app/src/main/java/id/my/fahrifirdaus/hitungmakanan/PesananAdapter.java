package id.my.fahrifirdaus.hitungmakanan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PesananAdapter extends RecyclerView.Adapter<PesananAdapter.ViewHolder> {

    ArrayList<PesananModel> listPesanan;

    public PesananAdapter(ArrayList<PesananModel> listPesanan) {
        this.listPesanan = listPesanan;
    }

    @NonNull
    @Override
    public PesananAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.item_record, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PesananAdapter.ViewHolder holder, int position) {
        PesananModel pesanan = listPesanan.get(position);
        holder.txtPesanan.setText(pesanan.toString());
        holder.txtJmlHarga.setText(pesanan.getJmlHarga());
    }

    @Override
    public int getItemCount() {
        return listPesanan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtPesanan, txtJmlHarga;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtPesanan = itemView.findViewById(R.id.txt_pesanan);
            txtJmlHarga = itemView.findViewById(R.id.txt_jmlharga);
        }
    }
}
