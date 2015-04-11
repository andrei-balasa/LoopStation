package andreibalasa.com.loopstation;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by SAM on 11/04/2015.
 */
public class ButtonAdapter extends BaseAdapter {
    private Context mContext;
    private String[] filesnames;
    LayoutInflater inflater;

    // Gets the context so it can be used later
    public void setFilesnames(String[] filesnames) {
        this.filesnames = filesnames;
    }

    public ButtonAdapter(Context c) {
        mContext = c;
        inflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // Total number of things contained within the adapter
    public int getCount() {
        return filesnames.length;
    }

    // Require for structure, not really used in my code.
    public Object getItem(int position) {
        return null;
    }

    // Require for structure, not really used in my code. Can
    // be used to get the id of an item in the adapter for
    // manual control.
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            convertView = inflater.inflate(R.layout.instrument_layout,null);
        }
        Button button = (Button) convertView.findViewById(R.id.grid_item);
        button.setText(filesnames[position]);

        return convertView;


    }
}