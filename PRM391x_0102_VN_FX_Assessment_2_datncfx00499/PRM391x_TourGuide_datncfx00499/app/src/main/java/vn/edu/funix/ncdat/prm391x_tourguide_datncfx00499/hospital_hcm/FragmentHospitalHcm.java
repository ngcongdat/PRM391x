package vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499.hospital_hcm;

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


public class FragmentHospitalHcm extends Fragment {

    ListView lvHospitalHcm;
    ArrayList<HospitalHcm> arrHospitalHcm;
    HospitalHcmAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hospital_hcm, container, false);

        lvHospitalHcm = view.findViewById(R.id.lvHospitalHcm);
        arrHospitalHcm = new ArrayList<>();

        addHospitalHcm();
        adapter = new HospitalHcmAdapter(getActivity(), R.layout.row_hospital, arrHospitalHcm);
        lvHospitalHcm.setAdapter(adapter);

        addEvents();
        return view;
    }

    private void addEvents() {
        lvHospitalHcm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_hospital);

                TextView txtDialogHospitalName = dialog.findViewById(R.id.txtDialogHospitalName);
                TextView txtDialogHospitalAddress = dialog.findViewById(R.id.txtDialogHospitalAddress);
                TextView txtDialogHospitalPhone = dialog.findViewById(R.id.txtDialogHospitalPhone);
                Button btnOK = dialog.findViewById(R.id.btnOK);

                txtDialogHospitalAddress.setText("Address: " + arrHospitalHcm.get(position).getAddress());
                txtDialogHospitalName.setText("Name: " + arrHospitalHcm.get(position).getName());
                txtDialogHospitalPhone.setText("Phone: " + arrHospitalHcm.get(position).getPhone());
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

    private void addHospitalHcm() {
        arrHospitalHcm.add(new HospitalHcm("Bệnh viện 175", " 782 Nguyễn Kiệm, Quận Gò Vấp, TP.Hồ Chí Minh", R.drawable.hospital, "(+84) 908 - 123456"));
        arrHospitalHcm.add(new HospitalHcm("Bệnh Viện An Bình", "146 An Bình, Phường 7, Quận 5, TP.Hồ Chí Minh", R.drawable.hospital, "(+84) 908 - 234567"));
        arrHospitalHcm.add(new HospitalHcm("Bệnh Viện An Sinh", "10 Trần Huy Liệu, Phường 12, Quận Phú Nhuận, TP.Hồ Chí Minh", R.drawable.hospital, "(+84) 908 - 345678"));
        arrHospitalHcm.add(new HospitalHcm("Bệnh Viện An Sương", "171/3 Phường Tân Thới Nhất, Quận 12, TP.Hồ Chí Minh", R.drawable.hospital, "(+84) 908 - 456789"));
        arrHospitalHcm.add(new HospitalHcm("Bệnh Viện Bình Dân", "371 Điện Biên Phủ, Phường 4, Quận 3, TP.Hồ Chí Minh", R.drawable.hospital, "(+84) 908 - 654321"));
        arrHospitalHcm.add(new HospitalHcm("Bệnh Viện Chợ Rẫy", "201B Nguyễn Chí Thanh, Quận 5, TP.Hồ Chí Minh", R.drawable.hospital, "(+84) 908 - 765432"));
        arrHospitalHcm.add(new HospitalHcm("Bệnh Viện Đa Khoa Thủ Đức", "Phường Linh Trung, Quận Thủ Đức, TP.Hồ Chí Minh", R.drawable.hospital, "(+84) 908 - 876543"));
        arrHospitalHcm.add(new HospitalHcm("Bệnh Viện Da Liễu", "2 Nguyễn Thông, Phường 6, Quận 3, TP.Hồ Chí Minh", R.drawable.hospital, "(+84) 908 - 987654"));
        arrHospitalHcm.add(new HospitalHcm("Bệnh Viện Hùng Vương", "128 Hùng Vương, Phường 12, Quận 5, TP.Hồ Chí Minh", R.drawable.hospital, "(+84) 908 - 147369"));
        arrHospitalHcm.add(new HospitalHcm("Bệnh Viện Mắt", "280 Điện Biên Phủ, Phường 7, Quận 3, TP.Hồ Chí Minh", R.drawable.hospital, "(+84) 908 - 963741"));
    }
}
