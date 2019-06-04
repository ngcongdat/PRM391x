package vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AtmAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<AtmMachine> listAtm;

    public AtmAdapter(Context context, int layout, List<AtmMachine> listAtm) {
        this.context = context;
        this.layout = layout;
        this.listAtm = listAtm;
    }

    @Override
    public int getCount() {
        return listAtm.size();
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
        ImageView iconAtm = (ImageView) convertView.findViewById(R.id.iconAtm);

        AtmMachine atm = listAtm.get(position);
        txtAtmName.setText(atm.getName());
        txtAtmAddress.setText(atm.getAddress());
        iconAtm.setImageResource(atm.getImage());
        return convertView;
    }
}
