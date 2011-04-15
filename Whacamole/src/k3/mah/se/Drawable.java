package k3.mah.se;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface Drawable {
	void update();
	void draw(Canvas c);
	boolean pressed(MotionEvent m);
}
