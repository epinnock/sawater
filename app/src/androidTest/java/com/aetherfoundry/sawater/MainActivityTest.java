package com.aetherfoundry.sawater;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.aetherfoundry.sawater.view.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.*;
/**
 * Created by EJ on 7/15/2015. ASD
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity myActivity;
    public MainActivityTest() {
        super(MainActivity.class);
    }
    @Before
    public void setUp() throws Exception{
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        myActivity=getActivity();
    }
    @Test
    public void checkPreCondition(){
        assertThat(myActivity==null);
        assertThat(getInstrumentation()!=null);
    }

    @After
    public void tearDown() throws Exception{
        super.tearDown();
    }


}
