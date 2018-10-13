package com.evertdev.lastfm;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Matcher;
import org.junit.Assert;

import static org.hamcrest.Matchers.is;

/**
 * Created by Evert Dev on 1317/2018.
 * Checks For a RecyclerView item if it displays right string data in the textviews
 */

public class RecyclerViewItemStringDataAssertion implements ViewAssertion {

    private Matcher<String> mMatcher;
    private int mTextViewId;
    private int mPosition;

    public RecyclerViewItemStringDataAssertion(int textViewId, String expectedText, int position) {
        this.mMatcher = is(expectedText);
        this.mTextViewId = textViewId;
        this.mPosition = position;
    }



    @Override
    public void check(View view, NoMatchingViewException noViewFoundException) {
        if (noViewFoundException != null) {
            throw noViewFoundException;
        }

        RecyclerView recyclerView = (RecyclerView) view;
        View item = recyclerView.getLayoutManager().findViewByPosition(mPosition);
        TextView textView = (TextView) item.findViewById(mTextViewId);
        Assert.assertTrue(mMatcher.matches(textView.getText().toString()));

    }


}