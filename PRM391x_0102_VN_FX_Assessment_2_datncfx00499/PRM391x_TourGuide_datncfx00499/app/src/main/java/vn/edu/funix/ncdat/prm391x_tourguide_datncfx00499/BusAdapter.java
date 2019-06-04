package vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BusAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Bus> listBus;

    public BusAdapter(Context context, int layout, List<Bus> listBus) {
        this.context = context;
        this.layout = layout;
        this.listBus = listBus;
    }

    @Override
    public int getCount() {
        return listBus.size();
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

        Bus bus = listBus.get(position);
        txtBusRoute.setText(bus.getRoute());
        txtBusAddress.setText(bus.getAddress());
        iconBus.setImageResource(bus.getImage());
        return convertView;
    }
}
