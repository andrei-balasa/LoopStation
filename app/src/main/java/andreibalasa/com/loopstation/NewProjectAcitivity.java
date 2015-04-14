package andreibalasa.com.loopstation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by SAM on 10/04/2015.
 */
public class NewProjectAcitivity extends Activity {

    DrawerLayout mDrawer;
    ListView instrumentGroups;
    GridView instruments;
    ListView layers;
    Button[] buttons;
    ArrayAdapter groupAdapter;
    ButtonAdapter instrumentsAdapter;

    ButtonGridListener gridListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_project);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        instrumentGroups = (ListView) findViewById(R.id.instrumentGroups);
        instruments = (GridView) findViewById(R.id.instruments);
        layers = (ListView) findViewById(R.id.layerList);
        buttons = new Button[9];
        //de initializat 9 butoane
        gridListener = new ButtonGridListener();

        buttons[0] = (Button) findViewById(R.id.button1);
        buttons[1] = (Button) findViewById(R.id.button2);
        buttons[2] = (Button) findViewById(R.id.button3);
        buttons[3] = (Button) findViewById(R.id.button4);
        buttons[4] = (Button) findViewById(R.id.button5);
        buttons[5] = (Button) findViewById(R.id.button6);
        buttons[6] = (Button) findViewById(R.id.button7);
        buttons[7] = (Button) findViewById(R.id.button8);
        buttons[8] = (Button) findViewById(R.id.button9);

        for (Button b : buttons)
            b.setOnClickListener(gridListener);

        try {
            String[] groups = getAssets().list("groups");
            groupAdapter = new ArrayAdapter(this, R.layout.instrument_groups_layout, groups);
        } catch (IOException e) {
            e.printStackTrace();
        }

        instrumentGroups.setAdapter(groupAdapter);

        //nu afiseaza a doua lista, stiu ca e ciudatel codu da l-am facut in mai multe moduri pt ca nu-mi dadeam seama dc nu merge

        instrumentGroups.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    String group = ((TextView) view).getText().toString();
                    String[] instrumentNames = getAssets().list("groups/" + group + "");
                    if (instrumentsAdapter == null) {
                        instrumentsAdapter = new ButtonAdapter(NewProjectAcitivity.this, instrumentNames);
                        instruments.setAdapter(instrumentsAdapter);
                    }
                    else
                        instrumentsAdapter.setFilesNames(instrumentNames);
                    instruments.setVisibility(View.VISIBLE);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        instruments.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //nu merge deocamdata, s-ar putea sa fie de la faptul ca ai butoane in vieweuri
                Log.d("TAG", "onItemClick");
                //aici ma gandeam ca ar trb sa cante sampleu ala
            }
        });

        instruments.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //nu merge deocamdata, s-ar putea sa fie de la faptul ca ai butoane in vieweuri
                Log.d("TAG", "onItemLongClick");
                //aici ar trb sa se inchida draweru si sa salveze pe ce sample ai apasat si apoi cand apesi pe un button din gridu
                //ala de 9x9 sa se salveze sampleu pe butonu ala
                return true;
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ButtonGridListener implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1:
                    break;
                case R.id.button2:
                    break;
                //de populat
            }
        }

    }

}
