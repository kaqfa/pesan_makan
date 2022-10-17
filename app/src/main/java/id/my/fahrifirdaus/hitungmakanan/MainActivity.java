package id.my.fahrifirdaus.hitungmakanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ArrayList<PesananModel> listPesanan;
    private RecyclerView recPesanan;
    PesananAdapter adapter;

    EditText edtMakanan, edtHarga, edtJumlah;
    Button btnHitung, btnReset;
    TextView txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listPesanan = new ArrayList<>();
        initComponents();

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPesanan();
            }
        });

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPesanan();
            }
        });
    }

    public void initComponents(){
        recPesanan = findViewById(R.id.rec_records);
        adapter = new PesananAdapter(listPesanan);
        recPesanan.setAdapter(adapter);
        recPesanan.setLayoutManager(new LinearLayoutManager(this));

        edtMakanan = findViewById(R.id.edt_makanan);
        edtHarga = findViewById(R.id.edt_harga);
        edtJumlah = findViewById(R.id.edt_jumlah);

        btnHitung = findViewById(R.id.btn_hitung);
        btnReset = findViewById(R.id.btn_reset);

        txtTotal = findViewById(R.id.txt_total);
        txtTotal.setText("0");
    }

    public void resetInput(){
        edtMakanan.setText("");
        edtHarga.setText("");
        edtJumlah.setText("");
    }

    public void resetPesanan(){
        resetInput();
        listPesanan.clear();
        adapter.notifyDataSetChanged();
        txtTotal.setText("0");
    }

    public String getSumTotal(){
        int total = 0;
        for (PesananModel pesanan: listPesanan) {
            total += pesanan.harga * pesanan.jumlah;
        }
        Locale locale = new Locale("in", "ID");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        format.setMaximumFractionDigits(0);
        return format.format(total); // Integer.toString(total);
    }

    public void addPesanan(){
        PesananModel pesanan = new PesananModel(edtMakanan.getText().toString(),
                                        Integer.parseInt(edtHarga.getText().toString()),
                                        Integer.parseInt(edtJumlah.getText().toString()));
        listPesanan.add(pesanan);
        adapter.notifyDataSetChanged();
        resetInput();

        txtTotal.setText(getSumTotal());
    }
}