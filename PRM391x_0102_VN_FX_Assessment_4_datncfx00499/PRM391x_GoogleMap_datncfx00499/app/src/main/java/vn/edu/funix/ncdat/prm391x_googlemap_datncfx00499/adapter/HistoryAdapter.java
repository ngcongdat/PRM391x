package vn.edu.funix.ncdat.prm391x_googlemap_datncfx00499.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
import vn.edu.funix.ncdat.prm391x_googlemap_datncfx00499.R;
import vn.edu.funix.ncdat.prm391x_googlemap_datncfx00499.data.DBHistory;
import vn.edu.funix.ncdat.prm391x_googlemap_datncfx00499.model.History;

public class HistoryAdapter extends BaseAdapter {

    private Context mContext;
    private int layout;
    private List<History> listHistories;
    DBHistory db;

    public HistoryAdapter(Context mContext, int layout, List<History> listHistories) {
        this.mContext = mContext;
        this.layout = layout;
        this.listHistories = listHistories;
        db = new DBHistory(mContext);
    }

    @Override
    public int getCount() {
        return listHistories.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // Return view on listview
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        TextView tvOrigin = convertView.findViewById(R.id.tvOrigin);
        TextView tvDest = convertView.findViewById(R.id.tvDest);

        History history = listHistories.get(position);
        tvOrigin.setText(history.getmOrigin());
        tvDest.setText(history.getmDest());
        return convertView;
    }
}
