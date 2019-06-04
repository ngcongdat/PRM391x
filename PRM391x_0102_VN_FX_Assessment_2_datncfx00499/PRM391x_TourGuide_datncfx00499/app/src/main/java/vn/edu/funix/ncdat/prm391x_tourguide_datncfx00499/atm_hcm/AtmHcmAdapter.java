package vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499.atm_hcm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499.R;

public class AtmHcmAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<AtmMachineHcm> listAtmHcm;

    public AtmHcmAdapter(Context context, int layout, List<AtmMachineHcm> listAtmHcm) {
        this.context = context;
        this.layout = layout;
        this.listAtmHcm = listAtmHcm;
    }

    @Override
    public int getCount() {
        return listAtmHcm.size();
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

        TextView txtAtmName = convertView.findViewById(R.id.txtAtmName);
        TextView txtAtmAddress = convertView.findViewById(R.id.txtAtmAddress);
        ImageView iconAtm = convertView.findViewById(R.id.iconAtm);

        AtmMachineHcm atmMachineHcm = listAtmHcm.get(position);
        txtAtmName.setText(atmMachineHcm.getName());
        txtAtmAddress.setText(atmMachineHcm.getAddress());
        iconAtm.setImageResource(atmMachineHcm.getImage());
        return convertView;
    }
}
