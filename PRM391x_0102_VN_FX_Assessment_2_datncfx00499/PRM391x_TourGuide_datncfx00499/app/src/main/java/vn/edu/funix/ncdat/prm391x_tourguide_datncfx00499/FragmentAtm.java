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

public class FragmentAtm extends Fragment {

    ListView lvAtm;
    ArrayList<AtmMachine> arrAtm;
    AtmAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_atm, container, false);

        lvAtm = view.findViewById(R.id.lvAtm);
        arrAtm = new ArrayList<>();

        addAtmMachine();

        adapter = new AtmAdapter(getActivity(), R.layout.row_atm, arrAtm);
        lvAtm.setAdapter(adapter);

        addEvents();

        return view;
    }

    private void addEvents() {
        lvAtm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_atm);

                TextView txtDialogAtmName = dialog.findViewById(R.id.txtDialogAtmName);
                TextView txtDialogAtmAddress = dialog.findViewById(R.id.txtDialogAtmAddress);
                TextView txtDialogAtmOpenningHours = dialog.findViewById(R.id.txtDialogAtmOpenningHours);
                Button btnOK = dialog.findViewById(R.id.btnOK);

                txtDialogAtmName.setText("Name: " + arrAtm.get(position).getName());
                txtDialogAtmAddress.setText("Address: " + arrAtm.get(position).getAddress());
                txtDialogAtmOpenningHours.setText("Openning Hours: " + arrAtm.get(position).getOpenningHours());
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

    // Thêm danh sách máy atm
    private void addAtmMachine() {
        arrAtm.add(new AtmMachine("ATM Hoàn Kiếm", "17 phố Lý Thường Kiệt, Phường Phan Chu Trinh, Quận Hoàn Kiếm, Hà Nội", R.drawable.atm_machine, "07.00 - 18.00"));
        arrAtm.add(new AtmMachine("ATM Đinh Tiên Hoàng", "7 Đinh Tiên Hoàng, Quận Hoàn Kiếm, Hà Nội", R.drawable.atm_machine, "07.30 - 19.00"));
        arrAtm.add(new AtmMachine("ATM Hội sở", "57 Lý Thường Kiệt, Quận Hoàn Kiếm, Hà Nội", R.drawable.atm_machine, "07.00 - 20.00"));
        arrAtm.add(new AtmMachine("ATM Nam Hà Nội", "236 Lê Thanh Nghị, Quận Hai Bà Trưng, Hà Nội", R.drawable.atm_machine, "24/24 Hours"));
        arrAtm.add(new AtmMachine("ATM Hai Bà Trưng","300-302 Trần Khát Chân, Quận Hai Bà Trưng, Hà Nội", R.drawable.atm_machine, "06.00 - 22.00"));
        arrAtm.add(new AtmMachine("ATM Lê Ngọc Hân", "44 Lê Ngọc Hân, Quận Hai Bà Trưng, Hà Nội", R.drawable.atm_machine, "07.00 - 19.00"));
        arrAtm.add(new AtmMachine("ATM Thăng Long", "129-131 Hoàng Quốc Việt, Quận Cầu Giấy, Hà Nội", R.drawable.atm_machine, "24/24 Hours"));
        arrAtm.add(new AtmMachine("ATM Phạm Hùng", "Tòa nhà FPT Phạm Hùng, Quận Cầu Giấy, Hà Nội", R.drawable.atm_machine, "08.00 - 17.00"));
        arrAtm.add(new AtmMachine("ATM Khâm Thiên","158 Khâm Thiên, Quận Đống Đa, Hà Nội", R.drawable.atm_machine, "24/24 Hours"));
    }
}
