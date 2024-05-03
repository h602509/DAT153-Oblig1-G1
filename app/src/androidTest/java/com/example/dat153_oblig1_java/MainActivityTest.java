package com.example.dat153_oblig1_java;

import static androidx.test.InstrumentationRegistry.getTargetContext;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.content.ComponentName;
import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.dat153_oblig1_java.activities.GalleryActivity;
import com.example.dat153_oblig1_java.activities.MainActivity;
import com.example.dat153_oblig1_java.activities.QuizActivity;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Before public void setup() { Intents.init(); }

    @After public void after() { Intents.release(); }

    @Test
    public void goToQuizActivity() {
        onView(withId(R.id.goToQuiz)).perform(click());
        intended(hasComponent(new ComponentName(getTargetContext(), QuizActivity.class)));
    }

    @Test
    public void goToGalleryActivity() {
        onView(withId(R.id.goToGallery)).perform(click());
        intended(hasComponent(new ComponentName(getTargetContext(), GalleryActivity.class)));
    }

}