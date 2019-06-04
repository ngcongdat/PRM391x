package vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HotelAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Hotel> listHotel;

    public HotelAdapter(Context context, int layout, List<Hotel> listHotel) {
        this.context = context;
        this.layout = layout;
        this.listHotel = listHotel;
    }

    @Override
    public int getCount() {
        return listHotel.size();
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
        TextView txtHotelName = convertView.findViewById(R.id.txtHotelName);
        TextView txtHotelAddress = convertView.findViewById(R.id.txtHotelAddress);
        ImageView iconHotel = (ImageView) convertView.findViewById(R.id.iconHotel);

        Hotel hotel = listHotel.get(position);
        txtHotelName.setText(hotel.getName());
        txtHotelAddress.setText(hotel.getAddress());
        iconHotel.setImageResource(hotel.getImage());
        return convertView;
    }
}
