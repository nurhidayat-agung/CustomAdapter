package selow.kazt.customadapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kazt on 11/13/2016.
 */
public class CustomAdapter extends ArrayAdapter<String>{

    String[] arrNama = {};
    String[] arrHarga = {};
    int[] arrGambar = {};
    Context c;
    LayoutInflater inflater;

    public CustomAdapter(Context context, String[] arNama, String[] arHarga, int[] arGambar) {
        super(context, R.layout.layout_inflat, arNama);
        this.arrNama = arNama;
        this.arrHarga = arHarga;
        this.arrGambar = arGambar;
        this.c = context;
    }

    public class ViewHolder{
        TextView vhNama, vhHarga;
        Button vhBeli;
        ImageView vhGambar;
    }
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if (convertView == null){
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_inflat,null);
        }
        final ViewHolder holder = new ViewHolder();
        holder.vhNama = (TextView) convertView.findViewById(R.id.tv_inf_nama_barang);
        holder.vhHarga = (TextView) convertView.findViewById(R.id.tv_inf_harga);
        holder.vhGambar = (ImageView) convertView.findViewById(R.id.iv_inf_gambar);
        holder.vhBeli = (Button) convertView.findViewById(R.id.btn_inf_beli);

        holder.vhNama.setText(arrNama[position]);
        holder.vhHarga.setText("Rp. "+arrHarga[position]);
        holder.vhGambar.setImageResource(arrGambar[position]);

        holder.vhBeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(parent.getContext(),arrNama[position],Toast.LENGTH_SHORT).show();
                Intent goDetail = new Intent(parent.getContext(),GoDetail.class);
                goDetail.putExtra("gambar",arrGambar[position]);
                goDetail.putExtra("nama",arrNama[position]);
                goDetail.putExtra("harga",arrHarga[position]);
                parent.getContext().startActivity(goDetail);//bis-nya udah jalan bawa data
            }
        });
        return convertView;
    }
}
