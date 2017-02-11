package javier.whatanimalareyou.ui.ResultsActivity;

/**
 * Created by Javi on 10/10/2016.
 */

public interface ResultsActivityView {

    void updateAnimalImageView(int imageId);
    void showToastWithAnimalName(String animalName);
    void launchActivity(Class newActivity);
    void updateCaptionButtonView(String caption);
}
