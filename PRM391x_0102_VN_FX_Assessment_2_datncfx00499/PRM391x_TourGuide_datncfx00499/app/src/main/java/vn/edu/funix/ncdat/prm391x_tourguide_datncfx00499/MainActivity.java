package vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499.atm_hcm.FragmentAtmHcm;
import vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499.bus_hcm.FragmentBusHcm;
import vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499.hospital_hcm.FragmentHospitalHcm;
import vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499.hotel_hcm.FragmentHotelHcm;

public class MainActivity extends AppCompatActivity {

    ImageView showHotel, showAtm, showHospital, showBus;
    Spinner spnLocation;
    ArrayAdapter<String> adapter;
    FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
        getSupportActionBar().hide();
    }


    private void addEvents() {
        spnLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Nạp tất cả Fragment Hà Nội lên Activity Main
                if (position == 0) {
                    showHotel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.add(R.id.main_activity, new FragmentHotel(), "FragmentHotel");
                            fragmentTransaction.addToBackStack("FragmentHotel");
                            fragmentTransaction.commit();
                        }
                    });
                    showAtm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.add(R.id.main_activity, new FragmentAtm(), "FragmentATM");
                            fragmentTransaction.addToBackStack("FragmentATM");
                            fragmentTransaction.commit();
                        }
                    });
                    showHospital.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.add(R.id.main_activity, new FragmentHospital(), "FragmentHospital");
                            fragmentTransaction.addToBackStack("FragmentHospital");
                            fragmentTransaction.commit();
                        }
                    });
                    showBus.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.add(R.id.main_activity, new FragmentBus(), "FragmentBus");
                            fragmentTransaction.addToBackStack("FragmentBus");
                            fragmentTransaction.commit();
                        }
                    });
                }
                // Nạp tất cả Fragment HCM lên Activity Main
                if (position == 1) {
                    showHotel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.main_activity, new FragmentHotelHcm(), "FragmentHotel");
                            fragmentTransaction.addToBackStack("FragmentHotel");
                            fragmentTransaction.commit();
                        }
                    });
                    showAtm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.add(R.id.main_activity, new FragmentAtmHcm(), "FragmentATM");
                            fragmentTransaction.addToBackStack("FragmentATM");
                            fragmentTransaction.commit();
                        }
                    });
                    showHospital.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.add(R.id.main_activity, new FragmentHospitalHcm(), "FragmentHospital");
                            fragmentTransaction.addToBackStack("FragmentHospital");
                            fragmentTransaction.commit();
                        }
                    });
                    showBus.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.add(R.id.main_activity, new FragmentBusHcm(), "FragmentBus");
                            fragmentTransaction.addToBackStack("FragmentBus");
                            fragmentTransaction.commit();
                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void addControls() {
        showHotel = findViewById(R.id.showHotel);
        showAtm = findViewById(R.id.showAtm);
        showHospital = findViewById(R.id.showHospital);
        showBus = findViewById(R.id.showBus);
        spnLocation = findViewById(R.id.spnLocation);
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item);
        adapter.add("Hà Nội, Việt Nam");
        adapter.add("TP.Hồ Chí Minh, Việt Nam");
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnLocation.setAdapter(adapter);

    }

    // Bắt sự kiện click vào icon Back tại Fragment hotel
    public void backHotel(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentHotel fragmentHotel = (FragmentHotel) getFragmentManager().findFragmentByTag("FragmentHotel");
        fragmentTransaction.remove(fragmentHotel);
        fragmentTransaction.commit();

    }

    public void backHotelHcm(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentHotelHcm fragmentHotel = (FragmentHotelHcm) getFragmentManager().findFragmentByTag("FragmentHotel");
        fragmentTransaction.remove(fragmentHotel);
        fragmentTransaction.commit();
    }

    // Bắt sự kiện click vào icon Back tại Fragment atm
    public void backAtm(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentAtm fragmentAtm = (FragmentAtm) getFragmentManager().findFragmentByTag("FragmentATM");
        fragmentTransaction.remove(fragmentAtm);
        fragmentTransaction.commit();
    }
    public void backAtmHcm(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentAtmHcm fragmentAtm = (FragmentAtmHcm) getFragmentManager().findFragmentByTag("FragmentATM");
        fragmentTransaction.remove(fragmentAtm);
        fragmentTransaction.commit();
    }

    // Bắt sự kiện click vào icon Back tại Fragment bệnh viện
    public void backHospital(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentHospital fragmentHospital = (FragmentHospital) getFragmentManager().findFragmentByTag("FragmentHospital");
        fragmentTransaction.remove(fragmentHospital);
        fragmentTransaction.commit();
    }
    public void backHospitalHcm(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentHospitalHcm fragmentHospital = (FragmentHospitalHcm) getFragmentManager().findFragmentByTag("FragmentHospital");
        fragmentTransaction.remove(fragmentHospital);
        fragmentTransaction.commit();
    }


    // Bắt sự kiện click vào icon Back tại Fragment xe bus
    public void backBus(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentBus fragmentBus = (FragmentBus) getFragmentManager().findFragmentByTag("FragmentBus");
        fragmentTransaction.remove(fragmentBus);
        fragmentTransaction.commit();
    }

    public void backBusHcm(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentBusHcm fragmentBus = (FragmentBusHcm) getFragmentManager().findFragmentByTag("FragmentBus");
        fragmentTransaction.remove(fragmentBus);
        fragmentTransaction.commit();
    }

    // Phương thức click nút Back của thiết bị di động
    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

}
