package vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499.atm_hcm;

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

public class FragmentAtmHcm extends Fragment {

    ListView lvAtmHcm;
    ArrayList<AtmMachineHcm> arrAtmHcm;
    AtmHcmAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_atm_hcm, container, false);

        lvAtmHcm = view.findViewById(R.id.lvAtmHcm);
        arrAtmHcm = new ArrayList<>();

        addAtmHcm();

        adapter = new AtmHcmAdapter(getActivity(), R.layout.row_atm, arrAtmHcm);
        lvAtmHcm.setAdapter(adapter);

        addEvents();
        return view;
    }

    private void addEvents() {
        lvAtmHcm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_atm);

                TextView txtDialogAtmName = dialog.findViewById(R.id.txtDialogAtmName);
                TextView txtDialogAtmAddress = dialog.findViewById(R.id.txtDialogAtmAddress);
                TextView txtDialogAtmOpenningHours = dialog.findViewById(R.id.txtDialogAtmOpenningHours);
                Button btnOK = dialog.findViewById(R.id.btnOK);

                txtDialogAtmName.setText("Name: " + arrAtmHcm.get(position).getName());
                txtDialogAtmAddress.setText("Address: " + arrAtmHcm.get(position).getAddress());
                txtDialogAtmOpenningHours.setText("Openning Hours: " + arrAtmHcm.get(position).getOpenningHours());
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

    private void addAtmHcm() {
        arrAtmHcm.add(new AtmMachineHcm("ATM Tân Phú", "79 Lê Trọng Tấn, Phường Sơn Kỳ, Quận Tân Phú, Phường 15, Tân Phú, TP.Hồ Chí Minh", R.drawable.atm_machine, "07.00 - 18.00"));
        arrAtmHcm.add(new AtmMachineHcm("ATM Đông Nam Củ Chi", "Lô TT2-1 Đ D4, KCN Đông Nam, Xã Bình Mỹ, Huyện Củ Chi, TP.Hồ Chí Minh", R.drawable.atm_machine, "07.30 - 19.00"));
        arrAtmHcm.add(new AtmMachineHcm("ATM Bắc Sài Gòn ", "167/2 Nguyễn Ảnh Thủ, Phường Trung Mỹ Tây, Quận 12, TP.Hồ Chí Minh", R.drawable.atm_machine, "07.00 - 20.00"));
        arrAtmHcm.add(new AtmMachineHcm("ATM Bình Tây", "129 Hậu Giang, Phường 5, Quận 6, TP.Hồ Chí Minh", R.drawable.atm_machine, "24/24 Hours"));
        arrAtmHcm.add(new AtmMachineHcm("ATM Cách Mạng Tháng Tám","460 Cách Mạng Tháng Tám, Phường 11, Quận 3, TP.Hồ Chí Minh", R.drawable.atm_machine, "06.00 - 22.00"));
        arrAtmHcm.add(new AtmMachineHcm("ATM Hồ Văn Huê", "228 Hồ Văn Huê, Phường 9, Quận Phú Nhuận, TP.Hồ Chí Minh", R.drawable.atm_machine, "07.00 - 19.00"));
        arrAtmHcm.add(new AtmMachineHcm("ATM Lạc Long Quân", "339B Lạc Long Quân, Phường 5, Quận 11, TP.Hồ Chí Minh", R.drawable.atm_machine, "24/24 Hours"));
        arrAtmHcm.add(new AtmMachineHcm("ATM Nguyễn Kiệm", "464 Nguyễn Kiệm, Phường 3, Quận Phú Nhuận, TP.Hồ Chí Minh", R.drawable.atm_machine, "08.00 - 17.00"));
        arrAtmHcm.add(new AtmMachineHcm("ATM Nơ Trang Long","272A Nơ Trang Long, Phường 12, Quận Bình Thạnh, TP.Hồ Chí Minh", R.drawable.atm_machine, "24/24 Hours"));
    }
}
