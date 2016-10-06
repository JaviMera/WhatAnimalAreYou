package com.example.javier.whatanimalareyou;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import com.example.javier.whatanimalareyou.ui.MainActivityPresenter;
import com.example.javier.whatanimalareyou.ui.MainActivityView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Javier on 10/5/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {

    private MainActivityPresenter mPresenter;

    @Mock
    private MainActivityView mView;

    @Before
    public void SetUp() {

        mPresenter = new MainActivityPresenter(mView);
    }

    @Test
    public void updateTextViewTypeface() throws Exception {

        // Arrange
        TextView tv = new TextView(null);
        Typeface font = Typeface.DEFAULT;

        // Act
        mPresenter.updateViewTypeface(tv, font);

        // Assert
        Mockito.verify(mView).updateViewTypeface(tv, font);
    }

    @Test
    public void setSpinnerAdapter() throws Exception {

        // Arrange
        int spinnerLayout = 1234;
        String fontPath = "fonts/lol.ttf";
        List<String> spinnerChoiceItems = new ArrayList<>();

        // Act
        mPresenter.setSpinnerAdapterView(null, spinnerLayout, fontPath, spinnerChoiceItems);

        // Assert
        Mockito.verify(mView).setSpinnerAdapterView(null, spinnerLayout, fontPath, spinnerChoiceItems);
    }

    @Test
    public void updateViewText() throws Exception {

        // Arrange
        View view = new View(null);
        String text = "some text";

        // Act
        mPresenter.updateTextViewText(view, text);

        // Assert
        Mockito.verify(mView).updateTextViewText(view, text);
    }

    @Test
    public void updateTextColor() throws Exception {

        // Arrange
        View view = new View(null);
        int color = 1234;

        // Act
        mPresenter.updateTextColor(view, color);

        // Assert
        Mockito.verify(mView).updateTextColor(view, color);
    }

    @Test
    public void setViewEnabled() throws Exception {

        // Arrange
        View view = new View(null);
        boolean enabled = true;

        // Act
        mPresenter.setViewEnabled(view, enabled);


        // Assert
        Mockito.verify(mView).setViewEnabled(view, enabled);
    }
}