package au.com.kamailio.skillset;

import android.test.ActivityInstrumentationTestCase2;

import au.com.kamailio.skillset.ui.MainActivity;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.assertion.ViewAssertions;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by FRincon on 6/09/16.
 */
public class ApplicationEspressoTest extends ActivityInstrumentationTestCase2<MainActivity> {

    //Good link
    //http://junit.sourceforge.net/javadoc/org/junit/Assert.html
    private MainActivity activity;

    public ApplicationEspressoTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    //Test if hello world test is available
    public void testDependencyInjectionMainActivity() {
        String valueToMatch = "Dependency injection worked";
        ViewInteraction helloWorldText;
        helloWorldText = onView(withText(valueToMatch)); // Find the text
        helloWorldText.check(matches(isDisplayed())); // Assert text is displayed
    }

    //Check that if user click button next will show next activity
    public void testClickButtonNextActivity() {
        onView(withId(R.id.nextButton1)).perform(click());
        onView(withText("Home Screen!!")).check(matches(isDisplayed()));
    }

    //Check that if user click button next will show next activity
    public void testButton4MainActivity() {
        onView(withId(R.id.nextButton4)).perform(click());
        String valueToMatch = "Still in the MainActivity";
        onView(withText(valueToMatch)).check(matches(isDisplayed()));
    }

    //Check that if user click button next will show next activity
    public void testApiDataActivity() {
        onView(withId(R.id.nextButton2)).perform(click());
        String valueToMatch = "repo1";
        onView(withText(valueToMatch)).check(matches(isDisplayed()));
    }

}
