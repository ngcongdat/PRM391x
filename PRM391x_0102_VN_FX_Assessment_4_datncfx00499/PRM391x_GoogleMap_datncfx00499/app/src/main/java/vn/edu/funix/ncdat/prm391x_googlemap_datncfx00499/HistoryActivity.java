package vn.edu.funix.ncdat.prm391x_googlemap_datncfx00499;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.List;
import vn.edu.funix.ncdat.prm391x_googlemap_datncfx00499.adapter.HistoryAdapter;
import vn.edu.funix.ncdat.prm391x_googlemap_datncfx00499.data.DBHistory;
import vn.edu.funix.ncdat.prm391x_googlemap_datncfx00499.model.History;

public class HistoryActivity extends AppCompatActivity {

    ListView lvHistory;
    List<History> listHistories;
    HistoryAdapter adapter;
    DBHistory dbHistory;
    Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        addControls();
        setAdapter();
        setEvents();
    }

    private void setEvents() {

        // Set item click to return MainActivity and find again
        lvHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            History history;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                history = listHistories.get(position);
                mIntent.putExtra("origin", history.getmOrigin());
                mIntent.putExtra("dest", history.getmDest());
                startActivity(mIntent);
            }
        });

        // Set long item click to delete in database
        lvHistory.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            History history;

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                history = listHistories.get(position);
                dbHistory.deleteHistory(history);
                listHistories.clear();
                listHistories.addAll(dbHistory.getHistory());
                setAdapter();
                return true;
            }
        });
    }

    private void addControls() {
        dbHistory = new DBHistory(this);
        lvHistory = findViewById(R.id.lvHistory);
        listHistories = dbHistory.getHistory();
        mIntent = new Intent(HistoryActivity.this, MainActivity.class);
    }

    // Set adapter for listview
    public void setAdapter() {
        if (adapter == null) {
            adapter = new HistoryAdapter(this, R.layout.row_items, listHistories);
            lvHistory.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
        lvHistory.setSelection(adapter.getCount() - 1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_history, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.back) {
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
