package selow.kazt.customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listItem;
    //data
    String[] nama = {"Mobilio","Xenia","Jazz","Yaris","Datsun"};
    String[] harga = {"1000000","2000000","3000000","4000000","5000000"};
    int[] gambar = {R.drawable.mobil,R.drawable.mobil,R.drawable.mobil,R.drawable.mobil,R.drawable.mobil};
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new CustomAdapter(MainActivity.this, nama, harga, gambar);
        listItem = (ListView) findViewById(R.id.lv_item);
        listItem.setAdapter(adapter);
    }
}
