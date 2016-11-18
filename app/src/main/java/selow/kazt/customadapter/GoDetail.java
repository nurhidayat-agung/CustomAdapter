package selow.kazt.customadapter;

import android.content.Intent;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GoDetail extends AppCompatActivity {
    ImageView ivDetail;
    TextView tvNamaDetail;
    TextView tvHargaDetail;
    Button btnOrder,btnTambah,btnKurang;
    int quantitas = 1;
    TextView tvQuantitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_detail);

        // wiring
        ivDetail = (ImageView) findViewById(R.id.iv_detail);
        tvNamaDetail = (TextView) findViewById(R.id.tv_nama_detail);
        tvHargaDetail = (TextView) findViewById(R.id.tv_hatga_mobil);
        btnTambah = (Button) findViewById(R.id.btn_tambah);
        btnKurang = (Button) findViewById(R.id.btn_kurang);
        tvQuantitas = (TextView) findViewById(R.id.tv_quantitas);

        // get data from intent
        Intent getDetail = getIntent();
        ivDetail.setImageResource(getDetail.getIntExtra("gambar",0));
        tvNamaDetail.setText(getDetail.getStringExtra("nama"));
        tvHargaDetail.setText(getDetail.getStringExtra("harga"));

        // set temporary variable for convert to int and string
        tvQuantitas.setText("x"+quantitas);
        String tampungHarga = String.valueOf(tvHargaDetail.getText());
        final Integer intHarga = Integer.parseInt(tampungHarga);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantitas = quantitas + 1; // 2
                int jumlah = quantitas * intHarga; // 2 * satu juta iya gk?
                tvHargaDetail.setText(jumlah+"");
                tvQuantitas.setText("x"+quantitas);
            }
        });
        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantitas == 1){
                    Toast.makeText(GoDetail.this,"mau ngutang ?",Toast.LENGTH_SHORT).show();
                }else if (quantitas >= 1){
                    quantitas = quantitas - 1;
                    int jumlah = quantitas * intHarga;
                    tvHargaDetail.setText(jumlah+"");
                    tvQuantitas.setText("x"+quantitas);
                }
            }
        });
    }
}
