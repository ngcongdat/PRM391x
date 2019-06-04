package vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499.bus_hcm;


import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499.R;

public class FragmentBusHcm extends Fragment {

    ListView lvBusHcm;
    ArrayList<BusHcm> arrBusHcm;
    BusHcmAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bus_hcm, container, false);

        lvBusHcm = view.findViewById(R.id.lvBusHcm);
        arrBusHcm = new ArrayList<>();

        addBusHcm();

        adapter = new BusHcmAdapter(getActivity(), R.layout.row_bus, arrBusHcm);
        lvBusHcm.setAdapter(adapter);

        addEvents();
        return view;
    }

    private void addEvents() {
        lvBusHcm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_bus);

                TextView txtDialogBusRoute = dialog.findViewById(R.id.txtDialogBusRoute);
                TextView txtDialogBusAddress = dialog.findViewById(R.id.txtDialogBusAddress);
                TextView txtDialogBusPrice = dialog.findViewById(R.id.txtDialogBusPrice);
                Button btnOK = dialog.findViewById(R.id.btnOK);

                txtDialogBusRoute.setText("Route: " + arrBusHcm.get(position).getRoute());
                txtDialogBusAddress.setText("Address: " + arrBusHcm.get(position).getAddress());
                txtDialogBusPrice.setText("Price: " + arrBusHcm.get(position).getPrice());
                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    private void addBusHcm() {
        arrBusHcm.add(new BusHcm("Tuyến 01", "BX Bến Thành - BX Chợ Lớn", R.drawable.metro, "3000 VNĐ"));
        arrBusHcm.add(new BusHcm( "Tuyến 02", "BX Bến Thành - BX Miền Tây", R.drawable.metro, "3500 VNĐ"));
        arrBusHcm.add(new BusHcm("Tuyến 03", "BX Bến Thành - BX Thạnh Lộc", R.drawable.metro, "2000 VNĐ"));
        arrBusHcm.add(new BusHcm("Tuyến 04", "Bx Bến Thành - Cộng Hòa - BX An Sương", R.drawable.metro, "4000 VNĐ"));
        arrBusHcm.add(new BusHcm("Tuyến 05", "BX Chợ Lớn - BX Biên Hòa", R.drawable.metro, "5000 VNĐ"));
        arrBusHcm.add(new BusHcm("Tuyến 06", "BX. Chợ Lớn - Đại học Nông Lâm", R.drawable.metro, "Miễn phí"));
        arrBusHcm.add(new BusHcm("Tuyến 07", "BX Chợ Lớn - Gò vấp", R.drawable.metro, "6000 VNĐ"));
        arrBusHcm.add(new BusHcm("Tuyến 08", "BX Quận 8 - Đại học Quốc Gia", R.drawable.metro, "4500 VNĐ"));
    }
}
