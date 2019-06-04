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

public class FragmentHospital extends Fragment {

    ListView lvHospital;
    ArrayList<Hospital> arrHospital;
    HospitalAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_hospital, container, false);
        lvHospital = view.findViewById(R.id.lvHospital);
        arrHospital = new ArrayList<>();

        addHospitals();

        adapter = new HospitalAdapter(getActivity(), R.layout.row_hospital, arrHospital);
        lvHospital.setAdapter(adapter);

        addEvents();

        return view;
    }

    private void addEvents() {
        lvHospital.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_hospital);

                TextView txtDialogHospitalName = dialog.findViewById(R.id.txtDialogHospitalName);
                TextView txtDialogHospitalAddress = dialog.findViewById(R.id.txtDialogHospitalAddress);
                TextView txtDialogHospitalPhone = dialog.findViewById(R.id.txtDialogHospitalPhone);
                Button btnOK = dialog.findViewById(R.id.btnOK);

                txtDialogHospitalName.setText("Name: " + arrHospital.get(position).getName());
                txtDialogHospitalAddress.setText("Address: " + arrHospital.get(position).getAddress());
                txtDialogHospitalPhone.setText("Phone: " + arrHospital.get(position).getPhone());
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

    // Thêm danh sách bệnh viện
    private void addHospitals() {
        arrHospital.add(new Hospital("Bệnh viện Bạch Mai", "78 – Đường Giải Phóng – Phương Mai – Đống Đa – Hà Nội", R.drawable.hospital, "(+84) 908 - 123456"));
        arrHospital.add(new Hospital("Bệnh Viện Hữu Nghị", "Số 1 – Trần Khánh Dư – Quận Hai Bà Trưng – Hà Nội", R.drawable.hospital, "(+84) 908 - 234567"));
        arrHospital.add(new Hospital("Bệnh Viện E, Hà Nội", "89 – Trần Cung – Nghĩa Tân – Cầu Giấy – Hà Nội", R.drawable.hospital, "(+84) 908 - 345678"));
        arrHospital.add(new Hospital("Viện Răng Hàm Mặt", "40B – Tràng Thi – Hoàn Kiếm – Hà Nội", R.drawable.hospital, "(+84) 908 - 456789"));
        arrHospital.add(new Hospital("Bệnh Viện Tai Mũi Họng Trung Ương", "78 – Đường Giải Phóng – Quận Đống Đa – Hà Nội", R.drawable.hospital, "(+84) 908 - 654321"));
        arrHospital.add(new Hospital("Bệnh Viện Mắt Trung Ương", "85 – Phố Bà Triệu – Quận Hai Bà Trưng – Hà Nội", R.drawable.hospital, "(+84) 908 - 765432"));
        arrHospital.add(new Hospital("Viện Y Học Cổ Truyền Trung Ương", "29 – Phố Nguyễn Bỉnh Khiêm – Quận Hai Bà Trưng – Hà Nội", R.drawable.hospital, "(+84) 908 - 876543"));
        arrHospital.add(new Hospital("Bệnh Viện Nội Tiết", "80 – Thái Thịnh II – Thịnh Quang – Đống Đa – Hà Nội", R.drawable.hospital, "(+84) 908 - 987654"));
        arrHospital.add(new Hospital("Bệnh Viện Việt Đức", "8 – Phố Phủ Doãn – Quận Hoàn Kiếm – Hà Nội", R.drawable.hospital, "(+84) 908 - 147369"));
        arrHospital.add(new Hospital("Bệnh Viện Nhi Trung Ương", "18/879 – Đường La Thành – Quận Đống Đa – Hà Nội", R.drawable.hospital, "(+84) 908 - 963741"));
    }
}
