package vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499;

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

public class FragmentBus extends Fragment {

    ListView lvBus;
    ArrayList<Bus> arrBus;
    BusAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bus, container, false);
        lvBus = view.findViewById(R.id.lvBus);
        arrBus = new ArrayList<>();

        addBuses();
        adapter = new BusAdapter(getActivity(), R.layout.row_bus, arrBus);
        lvBus.setAdapter(adapter);

        addEvents();

        return view;
    }

    private void addEvents() {
        lvBus.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_bus);

                TextView txtDialogBusRoute = dialog.findViewById(R.id.txtDialogBusRoute);
                TextView txtDialogBusAddress = dialog.findViewById(R.id.txtDialogBusAddress);
                TextView txtDialogBusPrice = dialog.findViewById(R.id.txtDialogBusPrice);
                Button btnOK = dialog.findViewById(R.id.btnOK);

                txtDialogBusRoute.setText("Route: " + arrBus.get(position).getRoute());
                txtDialogBusAddress.setText("Address: " + arrBus.get(position).getAddress());
                txtDialogBusPrice.setText("Price: " + arrBus.get(position).getPrice());
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

    // Thêm danh sách tuyến xe bus
    private void addBuses() {
        arrBus.add(new Bus("Tuyến 01", "BX Gia Lâm - BX Yên Nghĩa", R.drawable.metro, "3000 VNĐ"));
        arrBus.add(new Bus( "Tuyến 02", "Bác cổ - BX Yên Nghĩa", R.drawable.metro, "3500 VNĐ"));
        arrBus.add(new Bus("Tuyến 03A", "BX Giáp Bát - BX Gia Lâm", R.drawable.metro, "2000 VNĐ"));
        arrBus.add(new Bus( "Tuyến 03B", "Bx Giáp Bát - Vincom - Phúc Lợi", R.drawable.metro, "2500 VNĐ"));
        arrBus.add(new Bus("Tuyến 04", "Long Biên - BX Nước Ngầm", R.drawable.metro, "4000 VNĐ"));
        arrBus.add(new Bus("Tuyến 05", "Linh Đàm - Phú Diễn", R.drawable.metro, "5000 VNĐ"));
        arrBus.add(new Bus("Tuyến 06", "BX. Giáp Bát - Phú Minh (Phú Xuyên)", R.drawable.metro, "Miễn phí"));
        arrBus.add(new Bus("Tuyến 07", "Cầu Giấy - Nội Bài", R.drawable.metro, "6000 VNĐ"));
        arrBus.add(new Bus("Tuyến 08", "Long Biên - Đông Mỹ", R.drawable.metro, "4500 VNĐ"));
    }
}
