package com.example.javier.whatanimalareyou;

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
    private MainActivityView view;

    @Before
    public void SetUp() {

        mPresenter = new MainActivityPresenter(view);
    }

    @Test
    public void updateTextViewTypeface() throws Exception {

        // Arrange
        int someId = 1234;
        String somePath = "fonts/amazing.ttf";

        // Act
        mPresenter.updateTextViewTypeface(someId, somePath);

        // Assert
        Mockito.verify(view).updateTextViewTypeface(someId, somePath);
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
        Mockito.verify(view).setSpinnerAdapterView(null, spinnerLayout, fontPath, spinnerChoiceItems);
    }
}