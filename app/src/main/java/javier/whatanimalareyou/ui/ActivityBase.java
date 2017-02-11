package javier.whatanimalareyou.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Javi on 10/10/2016.
 */

public abstract class ActivityBase extends AppCompatActivity {

    protected <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }
}
