package vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499.bus_hcm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499.R;

public class BusHcmAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<BusHcm> listBusHcm;

    public BusHcmAdapter(Context context, int layout, List<BusHcm> listBusHcm) {
        this.context = context;
        this.layout = layout;
        this.listBusHcm = listBusHcm;
    }

    @Override
    public int getCount() {
        return listBusHcm.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        TextView txtBusRoute = convertView.findViewById(R.id.txtBusRoute);
        TextView txtBusAddress = convertView.findViewById(R.id.txtBusAddress);
        ImageView iconBus = convertView.findViewById(R.id.iconBus);

        BusHcm busHcm = listBusHcm.get(position);
        txtBusRoute.setText(busHcm.getRoute());
        txtBusAddress.setText(busHcm.getAddress());
        iconBus.setImageResource(busHcm.getImage());
        return convertView;
    }
}
