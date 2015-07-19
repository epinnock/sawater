package com.aetherfoundry.sawater.view;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.aetherfoundry.sawater.R;
import com.aetherfoundry.sawater.SAWaterApplication;
import com.aetherfoundry.sawater.model.WaterLevelModel;
import com.aetherfoundry.sawater.presenter.MVPPresenter;
import com.aetherfoundry.sawater.presenter.SAPresenter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements MVPView {

    @InjectView(R.id.currentWaterLevel)TextView currentWaterLevel;
    @InjectView(R.id.button)Button myButton;
    public MVPPresenter myPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
        ((SAWaterApplication)getApplication()).register(this);
    }
    @OnClick(R.id.button)
    public void clicked(Button b){

        System.out.println("Attempting Button Click");
        try {
            myPresenter.onRefresh();
        }
        catch(NullPointerException ne){
            System.out.println("Please inject a MVPPresenter");
        }

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

    @Override
    public void update(WaterLevelModel wm) {
        System.out.println("updated");
        currentWaterLevel.setText(wm.getLevel().getRecent()+" ft");
    }

    @Override
    public void progressBarUpdate(boolean b) {

    }

    @Override
    public void injectPresenter(MVPPresenter myPresenter) {
        this.myPresenter=myPresenter;
    }
}
