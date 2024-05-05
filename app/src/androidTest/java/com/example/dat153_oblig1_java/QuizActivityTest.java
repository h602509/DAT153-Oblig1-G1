package com.example.dat153_oblig1_java;

import static androidx.test.InstrumentationRegistry.getTargetContext;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;

import com.example.dat153_oblig1_java.activities.GalleryActivity;
import com.example.dat153_oblig1_java.activities.MainActivity;
import com.example.dat153_oblig1_java.activities.QuizActivity;
import com.example.dat153_oblig1_java.activities.ResultActivity;
import com.example.dat153_oblig1_java.quiz_entries.LiveEntriesRepo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class QuizActivityTest {

    @Rule
    public ActivityScenarioRule<QuizActivity> activityScenarioRule
            = new ActivityScenarioRule<>(QuizActivity.class);

    @Before public void setup() { Intents.init(); }

    @After public void after() { Intents.release(); }

    @Test
    public void goToResultActivityAfterQuiz() {

        Context context = ApplicationProvider.getApplicationContext();
        LiveEntriesRepo repo = new LiveEntriesRepo(context);

        int quizLength = repo.getSize();
        for (int i = 0; i < quizLength; i++) {
            onView(withId(R.id.quiz_button_answerA)).perform(click());
            onView(withId(R.id.quiz_submit_button)).perform(click());
            onView(withId(R.id.quiz_submit_button)).perform(click());
        }

        intended(hasComponent(new ComponentName(getTargetContext(), ResultActivity.class)));
    }

    @Test
    public void testResultValuesAllRight() {
        Context context = ApplicationProvider.getApplicationContext();
        LiveEntriesRepo repo = new LiveEntriesRepo(context);
        QuizActivity activity = (QuizActivity) getActivityInstance();

        Button a = activity.findViewById(R.id.quiz_button_answerA);
        Button b = activity.findViewById(R.id.quiz_button_answerB);
        Button c = activity.findViewById(R.id.quiz_button_answerC);

        int quizLength = repo.getSize();

        for (int i = 0; i < quizLength; i++) {

            InstrumentationRegistry.getInstrumentation().waitForIdleSync();

            String answer = activity.getAnswer();

            if (a.getText().equals(answer)) {
                onView(withId(R.id.quiz_button_answerA)).perform(click());
            }
            if (b.getText().equals(answer)) {
                onView(withId(R.id.quiz_button_answerB)).perform(click());
            }
            if (c.getText().equals(answer)) {
                onView(withId(R.id.quiz_button_answerC)).perform(click());
            }

            onView(withId(R.id.quiz_submit_button)).perform(click());
            onView(withId(R.id.quiz_submit_button)).perform(click());
        }

        Assert.assertEquals(quizLength, activity.getScore());

    }


    @Test
    public void testResultValuesAllWrong() {
        Context context = ApplicationProvider.getApplicationContext();
        LiveEntriesRepo repo = new LiveEntriesRepo(context);
        QuizActivity activity = (QuizActivity) getActivityInstance();

        Button a = activity.findViewById(R.id.quiz_button_answerA);
        Button b = activity.findViewById(R.id.quiz_button_answerB);

        int quizLength = repo.getSize();

            for (int i = 0; i < quizLength; i++) {

            InstrumentationRegistry.getInstrumentation().waitForIdleSync();

            String answer = activity.getAnswer();

            if (!a.getText().equals(answer)) {
                onView(withId(R.id.quiz_button_answerA)).perform(click());
            } else  {
                onView(withId(R.id.quiz_button_answerB)).perform(click());
            }

            onView(withId(R.id.quiz_submit_button)).perform(click());
            onView(withId(R.id.quiz_submit_button)).perform(click());
        }

        Assert.assertEquals(0, activity.getScore());

    }

    private Activity getActivityInstance(){
        final Activity[] currentActivity = {null};

        getInstrumentation().runOnMainSync(new Runnable(){
            public void run(){
                Collection<Activity> resumedActivity = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
                Iterator<Activity> it = resumedActivity.iterator();
                currentActivity[0] = it.next();
            }
        });

        return currentActivity[0];
    }
}