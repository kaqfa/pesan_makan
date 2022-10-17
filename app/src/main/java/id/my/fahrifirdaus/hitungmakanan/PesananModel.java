package id.my.fahrifirdaus.hitungmakanan;

import java.text.NumberFormat;
import java.util.Locale;

public class PesananModel {
    public String nama;
    public int harga;
    public int jumlah;

    public PesananModel(String nama, int harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return nama + " (" + jumlah + " x " + harga + ')';
    }

    public String getJmlHarga(){
        Locale locale = new Locale("in", "ID");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        format.setMaximumFractionDigits(0);
        return format.format(harga*jumlah); // Integer.toString(harga * jumlah);
    }
}
