package com.evertdev.lastfm;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Assert;

import static org.hamcrest.Matchers.is;

/**
 * Created by Evert Dev.
 * Asserts the number of items of a RecyclerView
 */

public class RecyclerViewItemsCountAssertion implements ViewAssertion {
    private Matcher<Integer> mMatcher;

    public RecyclerViewItemsCountAssertion(int expectedCount) {
        this.mMatcher = is(expectedCount);
    }

    @Override
    public void check(View view, NoMatchingViewException noViewFoundException) {
        if (noViewFoundException != null) {
            throw noViewFoundException;
        }

        RecyclerView recyclerView = (RecyclerView) view;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Assert.assertTrue(mMatcher.matches(adapter.getItemCount()));
    }
}
