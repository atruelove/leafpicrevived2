package com.alienpants.leafpicrevived2.activities;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.runner.AndroidJUnit4;

import com.alienpants.leafpicrevived2.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class HighBatteryTest {

    @Rule
    public ActivityTestRule<SplashScreen> mActivityTestRule = new ActivityTestRule<>(SplashScreen.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.READ_EXTERNAL_STORAGE",
                    "android.permission.WRITE_EXTERNAL_STORAGE");

    @Test
    public void paletteTest() {
        ViewInteraction cardView = onView(
                allOf(withId(R.id.album_card),
                        childAtPosition(
                                allOf(withId(R.id.albums),
                                        childAtPosition(
                                                withId(R.id.swipe_refresh),
                                                0)),
                                0),
                        isDisplayed()));
        cardView.perform(click());

        ViewInteraction squareRelativeLayout = onView(
                allOf(withId(R.id.media_card_layout),
                        childAtPosition(
                                allOf(withId(R.id.media),
                                        childAtPosition(
                                                withId(R.id.swipe_refresh),
                                                0)),
                                0),
                        isDisplayed()));
        squareRelativeLayout.perform(click());

        ViewInteraction overflowMenuButton = onView(
                allOf(withContentDescription("More options"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar),
                                        2),
                                3),
                        isDisplayed()));
        overflowMenuButton.perform(click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.title), withText("Palette"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction imageView = onView(
                allOf(withId(R.id.palette_image),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.palette_image_card),
                                        0),
                                0),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));
    }

    @Test
    public void shareTest() {
        ViewInteraction cardView = onView(
                allOf(withId(R.id.album_card),
                        childAtPosition(
                                allOf(withId(R.id.albums),
                                        childAtPosition(
                                                withId(R.id.swipe_refresh),
                                                0)),
                                0),
                        isDisplayed()));
        cardView.perform(click());

        ViewInteraction squareRelativeLayout = onView(
                allOf(withId(R.id.media_card_layout),
                        childAtPosition(
                                allOf(withId(R.id.media),
                                        childAtPosition(
                                                withId(R.id.swipe_refresh),
                                                0)),
                                0),
                        isDisplayed()));
        squareRelativeLayout.perform(click());

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.action_share), withContentDescription("Share"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar),
                                        2),
                                0),
                        isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction relativeLayout = onView(
                allOf(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                        childAtPosition(
                                allOf(IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        relativeLayout.check(matches(isDisplayed()));
    }

    @Test
    public void twoPaletteTest() {
        ViewInteraction cardView = onView(
                allOf(withId(R.id.album_card),
                        childAtPosition(
                                allOf(withId(R.id.albums),
                                        childAtPosition(
                                                withId(R.id.swipe_refresh),
                                                0)),
                                0),
                        isDisplayed()));
        cardView.perform(click());

        ViewInteraction squareRelativeLayout = onView(
                allOf(withId(R.id.media_card_layout),
                        childAtPosition(
                                allOf(withId(R.id.media),
                                        childAtPosition(
                                                withId(R.id.swipe_refresh),
                                                0)),
                                0),
                        isDisplayed()));
        squareRelativeLayout.perform(click());

        ViewInteraction overflowMenuButton = onView(
                allOf(withContentDescription("More options"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar),
                                        2),
                                3),
                        isDisplayed()));
        overflowMenuButton.perform(click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.title), withText("Palette"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.toolbar),
                                childAtPosition(
                                        withId(R.id.palette_background),
                                        0)),
                        1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        pressBack();

        ViewInteraction appCompatImageButton2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.toolbar),
                                childAtPosition(
                                        withId(R.id.PhotoPager_Layout),
                                        2)),
                        1),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        pressBack();

        ViewInteraction squareRelativeLayout2 = onView(
                allOf(withId(R.id.media_card_layout),
                        childAtPosition(
                                allOf(withId(R.id.media),
                                        childAtPosition(
                                                withId(R.id.swipe_refresh),
                                                0)),
                                1),
                        isDisplayed()));
        squareRelativeLayout2.perform(click());

        ViewInteraction overflowMenuButton2 = onView(
                allOf(withContentDescription("More options"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar),
                                        2),
                                3),
                        isDisplayed()));
        overflowMenuButton2.perform(click());

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(R.id.title), withText("Palette"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatTextView2.perform(click());

        ViewInteraction imageView = onView(
                allOf(withId(R.id.palette_image),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.palette_image_card),
                                        0),
                                0),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));
    }

    @Test
    public void editTest() {
        ViewInteraction cardView = onView(
                allOf(withId(R.id.album_card),
                        childAtPosition(
                                allOf(withId(R.id.albums),
                                        childAtPosition(
                                                withId(R.id.swipe_refresh),
                                                0)),
                                0),
                        isDisplayed()));
        cardView.perform(click());

        ViewInteraction squareRelativeLayout = onView(
                allOf(withId(R.id.media_card_layout),
                        childAtPosition(
                                allOf(withId(R.id.media),
                                        childAtPosition(
                                                withId(R.id.swipe_refresh),
                                                0)),
                                0),
                        isDisplayed()));
        squareRelativeLayout.perform(click());

        ViewInteraction overflowMenuButton = onView(
                allOf(withContentDescription("More options"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar),
                                        2),
                                3),
                        isDisplayed()));
        overflowMenuButton.perform(click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.title), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction imageView = onView(
                allOf(withId(R.id.image_view_crop),
                        childAtPosition(
                                allOf(withId(R.id.ucrop),
                                        childAtPosition(
                                                withId(R.id.ucrop_frame),
                                                0)),
                                0),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
