package javier.whatanimalareyou.ui.ResultsActivity;

/**
 * Created by Javi on 10/10/2016.
 */

public class ResultsActivityPresenter {

    private ResultsActivityView mView;

    public ResultsActivityPresenter(ResultsActivityView view){

        mView = view;
    }

    public void updateAnimalResultImageView(int imageId){

        mView.updateAnimalImageView(imageId);
    }

    public void showToastWithAnimalName(String animalName) {

        mView.showToastWithAnimalName(animalName);
    }

    public void launchActivity(Class newActivity) {

        mView.launchActivity(newActivity);
    }

    public void updateCaptionButtonView(String caption) {
        mView.updateCaptionButtonView(caption);
    }
}
