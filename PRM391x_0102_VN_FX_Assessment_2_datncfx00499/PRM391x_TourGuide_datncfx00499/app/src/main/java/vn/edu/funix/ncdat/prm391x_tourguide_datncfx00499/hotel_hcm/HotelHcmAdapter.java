package vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499.hotel_hcm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499.R;


public class HotelHcmAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<HotelHcm> listHotelHcm;

    public HotelHcmAdapter(Context context, int layout, List<HotelHcm> listHotelHcm) {
        this.context = context;
        this.layout = layout;
        this.listHotelHcm = listHotelHcm;
    }

    @Override
    public int getCount() {
        return listHotelHcm.size();
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
        ImageView iconHotel = convertView.findViewById(R.id.iconHotel);

        HotelHcm hotelHcm = listHotelHcm.get(position);
        txtHotelName.setText(hotelHcm.getName());
        txtHotelAddress.setText(hotelHcm.getAddress());
        iconHotel.setImageResource(hotelHcm.getImage());
        return convertView;
    }
}
