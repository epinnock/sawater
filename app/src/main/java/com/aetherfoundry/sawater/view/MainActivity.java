package com.aetherfoundry.sawater.view;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.text.DateFormat;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    @InjectView(R.id.updateTime) TextView updateTime;
    @InjectView(R.id.stageLevel)TextView stageLevel;
    @InjectView(R.id.averageLevel)TextView averageLevel;
    public MVPPresenter myPresenter;
    public DateFormat myDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        myDateFormat=DateFormat.getDateTimeInstance();
    }

    @Override
    protected void onResume(){
        super.onResume();
        ((SAWaterApplication)getApplication()).register(this);
    }


    @OnClick(R.id.button)
    public void clicked(Button b){

        performRefresh();

    }

    public void performRefresh()
    {
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
    /*
     @param WaterLevelModel wm

     update the view with new water level model
     */
    public void update(WaterLevelModel wm) {
        System.out.println("updated");

        currentWaterLevel.setText(wm.getLevel().getRecent() + " ft");
        updateTime.setText(myDateFormat.format(wm.getMyDate()));
        averageLevel.setText(wm.getLevel().getAverage()+" ft");
        //Update stage level and show if Drought stage is 1 or greater
        if(wm.getStageLevel()>0) {
            stageLevel.setText("Stage Level: "+wm.getStageLevel());
            stageLevel.setVisibility(View.VISIBLE);
        }
        else {
            stageLevel.setText("Stage Level: "+wm.getStageLevel());
            stageLevel.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void progressBarUpdate(boolean b) {

    }

    @Override
    public void injectPresenter(MVPPresenter myPresenter) {
        this.myPresenter=myPresenter;
        performRefresh();

    }
    @Override
    public void error(String message)
    {
        Toast.makeText(getApplicationContext(),"error "+message,Toast.LENGTH_SHORT);
    }
}
