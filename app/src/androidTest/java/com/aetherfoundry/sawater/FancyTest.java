package com.aetherfoundry.sawater;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.aetherfoundry.sawater.presenter.SAPresenterMock;
import com.aetherfoundry.sawater.view.MainActivity;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static org.assertj.core.api.Assertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.Espresso.*;



import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by EJ on 7/15/2015.
 */
@RunWith(AndroidJUnit4.class)
public class FancyTest {

    private MainActivity myActivity;
    private SAPresenterMock myMockPresenter;
    @Rule
    public ActivityRule<MainActivity> mActivityRule = new ActivityRule(MainActivity.class);


    @Before
    public void setUp()
    {
        myActivity=mActivityRule.get();
        myMockPresenter=new SAPresenterMock();
        myActivity.injectPresenter(myMockPresenter);
    }

    @Test
    public void aVerifyActivity(){

        assertThat(myActivity).isNotNull();
    }

    @Test
    public void SetupMock(){
        assertThat(myActivity.myPresenter).isNotNull();
    }

    @Test
    public void getWaterLevel() throws Exception{
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.currentWaterLevel)).check(matches(withText("")));
    }
}
