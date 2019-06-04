package vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499.hospital_hcm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499.R;

public class HospitalHcmAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<HospitalHcm> listHospitalHcm;

    public HospitalHcmAdapter(Context context, int layout, List<HospitalHcm> listHospitalHcm) {
        this.context = context;
        this.layout = layout;
        this.listHospitalHcm = listHospitalHcm;
    }

    @Override
    public int getCount() {
        return listHospitalHcm.size();
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

        TextView txtHospitalName = convertView.findViewById(R.id.txtHospitalName);
        TextView txtHospitalAddress = convertView.findViewById(R.id.txtHospitalAddress);
        ImageView iconHospital = convertView.findViewById(R.id.iconHospital);

        HospitalHcm hospitalHcm = listHospitalHcm.get(position);
        txtHospitalName.setText(hospitalHcm.getName());
        txtHospitalAddress.setText(hospitalHcm.getAddress());
        iconHospital.setImageResource(hospitalHcm.getImage());
        return convertView;
    }
}
