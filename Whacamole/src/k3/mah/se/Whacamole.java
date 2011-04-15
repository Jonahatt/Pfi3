package k3.mah.se;

import android.app.Activity;
import android.os.Bundle;

public class Whacamole extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameEngine(this));
    }
}