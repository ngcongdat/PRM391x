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

public class FragmentHotel extends Fragment {

    ListView lvHotel;
    ArrayList<Hotel> arrHotel;
    HotelAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotel, container, false);
        lvHotel = view.findViewById(R.id.lvHotel);
        arrHotel = new ArrayList<>();

        addHotels();

        adapter = new HotelAdapter(getActivity(), R.layout.row_hotel, arrHotel);
        lvHotel.setAdapter(adapter);

        addEvents();


        return view;
    }

    private void addEvents() {
        lvHotel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_hotel);

                TextView txtDialogHotelName = dialog.findViewById(R.id.txtDialogHotelName);
                TextView txtDialogHotelAddress = dialog.findViewById(R.id.txtDialogHotelAddress);
                TextView txtDialogHotelPhone = dialog.findViewById(R.id.txtDialogHotelPhone);
                Button btnOK = dialog.findViewById(R.id.btnOK);

                txtDialogHotelName.setText("Name: " + arrHotel.get(position).getName());
                txtDialogHotelAddress.setText("Address: " + arrHotel.get(position).getAddress());
                txtDialogHotelPhone.setText("Phone: " + arrHotel.get(position).getPhone());
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

    // Thêm danh sách khách sạn
    private void addHotels() {
        arrHotel.add(new Hotel("The Queen Hotel & Spa", "67 Thuốc Bắc, Hàng Bồ, Hàng Bồ, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel, "(+84) 987 - 123456"));
        arrHotel.add(new Hotel("Hanoi Nostalgia Hotel & Spa", "13-15 Luong Ngoc Quyen, Hang Buom, Hoan Kiem, Hàng Buồm, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel, "(+84) 987 - 234567"));
        arrHotel.add(new Hotel("Church Legend Hotel Hanoi", "46 Ấu Triệu, Phường Hàng Trống, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel, "(+84) 987 - 345678"));
        arrHotel.add(new Hotel("Little Hanoi Diamond Hotel", "11 Bát Đàn, Quận Hoàn Kiếm, Hàng Bồ, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel, "(+84) 987 - 456789"));
        arrHotel.add(new Hotel("Flamingo Dai Lai Resort", "Thôn Ngọc Quang, Xã Ngọc Thanh, Vĩnh Phúc, Phúc Yên, Hà Nội, Việt Nam", R.drawable.hotel, "(+84) 987 - 654321"));
        arrHotel.add(new Hotel("Annam Legend Hotel", "27 Hàng Bè, Hàng Bạc, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel, "(+84) 987 - 765432"));
        arrHotel.add(new Hotel("Hanoi Zesty Hotel", "20 Hàng Cân, Hàng Đào, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel, "(+84) 987 - 876543"));
        arrHotel.add(new Hotel("Bluebell Hotel", "41 Ngõ Huyện, Phường Hàng Trống, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel, "(+84) 987 - 987654"));
    }
}
