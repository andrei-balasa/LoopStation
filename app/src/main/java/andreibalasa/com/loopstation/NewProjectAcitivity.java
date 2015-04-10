package andreibalasa.com.loopstation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ListView;

/**
 * Created by SAM on 10/04/2015.
 */
public class NewProjectAcitivity extends Activity {

    DrawerLayout mDrawer;
    HorizontalScrollView drawerScrollView;
    ListView instrumentGroups;
    ListView instruments;
    ListView layers;
    Button[] buttons;

    ButtonGridListener gridListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_project);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerScrollView = (HorizontalScrollView) findViewById(R.id.scrollView);
        instrumentGroups = (ListView) findViewById(R.id.instrumentGroups);
        instruments = (ListView) findViewById(R.id.instruments);
        layers = (ListView) findViewById(R.id.layerList);
        buttons = new Button[9];
        //de initializat 9 butoane
        gridListener = new ButtonGridListener();
        buttons[0] = (Button) findViewById(R.id.button1);
        buttons[0].setOnClickListener(gridListener);
        //asa si la rest
        buttons[1] = (Button) findViewById(R.id.button2);
        buttons[2] = (Button) findViewById(R.id.button3);
        buttons[3] = (Button) findViewById(R.id.button4);
        buttons[4] = (Button) findViewById(R.id.button5);
        buttons[5] = (Button) findViewById(R.id.button6);
        buttons[6] = (Button) findViewById(R.id.button7);
        buttons[7] = (Button) findViewById(R.id.button8);
        buttons[8] = (Button) findViewById(R.id.button9);

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


    private class ButtonGridListener implements Button.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.button1:
                           break;
                case R.id.button2:
                            break;
                //de populat
            }
        }

    }

}
