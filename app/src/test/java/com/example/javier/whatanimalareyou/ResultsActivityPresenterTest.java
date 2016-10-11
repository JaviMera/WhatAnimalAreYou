package com.example.javier.whatanimalareyou;

import com.example.javier.whatanimalareyou.ui.MainActivity.MainActivity;
import com.example.javier.whatanimalareyou.ui.ResultsActivity.ResultsActivityPresenter;
import com.example.javier.whatanimalareyou.ui.ResultsActivity.ResultsActivityView;

import org.apache.maven.artifact.ant.Mvn;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by Javi on 10/10/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ResultsActivityPresenterTest {

    private ResultsActivityPresenter mPresenter;

    @Mock
    ResultsActivityView mView;

    @Before
    public void SetUp(){

        mPresenter = new ResultsActivityPresenter(mView);
    }

    @Test
    public void updateAnimalImageView() throws Exception {

        // Assert
        int imageId = R.drawable.hawk;

        // Act
        mPresenter.updateAnimalResultImageView(imageId);

        // Assert
        Mockito.verify(mView).updateAnimalImageView(imageId);
    }

    @Test
    public void showAnimalName() throws Exception {

        // Arrange
        String name = "Tiger";

        // Act
        mPresenter.showToastWithAnimalName(name);

        // Assert
        Mockito.verify(mView).showToastWithAnimalName(name);
    }

    @Test
    public void startOverButtonLaunchesMainActivity() throws Exception {

        // Arrange
        Class newActivity = MainActivity.class;

        // Act
        mPresenter.launchActivity(newActivity);

        // Assert
        Mockito.verify(mView).launchActivity(newActivity);
    }

    @Test
    public void updateCaptionButtonView() throws Exception {

        // Arrange
        String caption = "Bark";

        // Act
        mPresenter.updateCaptionButtonView(caption);

        // Assert
        Mockito.verify(mView).updateCaptionButtonView(caption);
    }
}