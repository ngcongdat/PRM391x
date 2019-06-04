package vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499.hotel_hcm;

import android.app.Dialog;
import android.os.Bundle;
import android.app.Fragment;
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

public class FragmentHotelHcm extends Fragment {

    ListView lvHotelHcm;
    ArrayList<HotelHcm> arrHotelHcm;
    HotelHcmAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotel_hcm, container, false);
        lvHotelHcm = view.findViewById(R.id.lvHotelHcm);
        arrHotelHcm = new ArrayList<>();

        addHotelHcm();

        adapter = new HotelHcmAdapter(getActivity(), R.layout.row_hotel, arrHotelHcm);
        lvHotelHcm.setAdapter(adapter);

        addEvents();
        return view;
    }

    private void addEvents() {
        lvHotelHcm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_hotel);

                TextView txtDialogHotelName = dialog.findViewById(R.id.txtDialogHotelName);
                TextView txtDialogHotelAddress = dialog.findViewById(R.id.txtDialogHotelAddress);
                TextView txtDialogHotelPhone = dialog.findViewById(R.id.txtDialogHotelPhone);
                Button btnOK = dialog.findViewById(R.id.btnOK);


                txtDialogHotelName.setText("Name: " + arrHotelHcm.get(position).getName());
                txtDialogHotelAddress.setText("Address: " + arrHotelHcm.get(position).getAddress());
                txtDialogHotelPhone.setText("Phone: " + arrHotelHcm.get(position).getPhone());
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

    private void addHotelHcm() {
        arrHotelHcm.add(new HotelHcm("New World Sài Gòn", "76 Lê Lai, Quận 1, TP.Hồ Chí Minh, Việt Nam", R.drawable.hotel, "(+84) 987 - 123456"));
        arrHotelHcm.add(new HotelHcm("Majestic Sài Gòn", "01 Đồng Khởi, Quận 1, TP.Hồ Chí Minh, Việt Nam", R.drawable.hotel, "(+84) 987 - 234567"));
        arrHotelHcm.add(new HotelHcm("Rex", "141 Nguyễn Huệ, Quận 1, TP.Hồ Chí Minh, Việt Nam", R.drawable.hotel, "(+84) 987 - 345678"));
        arrHotelHcm.add(new HotelHcm("Pullman", "148 Trần Hưng Đạo, Quận 1, TP.Hồ Chí Minh, Việt Nam", R.drawable.hotel, "(+84) 987 - 456789"));
        arrHotelHcm.add(new HotelHcm("Caravelle", "19 Công Trường Lam Sơn, Phường Bến Nghé, Quận 1, TP.Hồ Chí Minh, Việt Nam", R.drawable.hotel, "(+84) 987 - 654321"));
        arrHotelHcm.add(new HotelHcm("Windsor Plaza", "18 An Dương Vương, Quận 5, TP.Hồ Chí Minh, Việt Nam", R.drawable.hotel, "(+84) 987 - 765432"));
        arrHotelHcm.add(new HotelHcm("Lotte Legend Sài Gòn", "2A-4A Tôn Đức Thắng, Quận 1, TP.Hồ Chí Minh, Việt Nam", R.drawable.hotel, "(+84) 987 - 876543"));
        arrHotelHcm.add(new HotelHcm("Tân Sơn Nhất", "202 Hoàng Văn Thụ, Quận Phú Nhuận, TP.Hồ Chí Minh, Việt Nam", R.drawable.hotel, "(+84) 987 - 987654"));
    }
}
