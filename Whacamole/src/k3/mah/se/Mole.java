package k3.mah.se;

import java.util.Random;
import java.util.Timer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;

public class Mole implements Drawable {
	private float _posX;
	private float _posY;
	private int alpha;
	private Paint _p;
	private Paint eye;
	private float _radius = 30;
	private boolean alive = false;
	
	public Mole(float posX, float posY, String color) {
		_posX = posX;
		_posY = posY;
		alpha = 255;
		_p = new Paint(Paint.ANTI_ALIAS_FLAG);
		_p.setColor(Color.parseColor(color));
		eye = new Paint(Paint.ANTI_ALIAS_FLAG);
		eye.setColor(Color.parseColor("#990000"));
		alive = false;
	}
		
	public void update() {
		/*if (alive&&alpha > 0){
			alpha = alpha -1;
			_p.setARGB(255, 128, 128, alpha);
			if (alpha<20)
		}*/
		Random randGen = new Random();
		if (randGen.nextInt(100)>95){
			alpha = 255;
			alive = true;
		}
		if (alpha>0) {
			alpha=alpha-5;
		}
		
	}	
	
	public void kill() {
		alive = false;
	}
		
	public void draw(Canvas c) {
		float eyeX = _posX-12;
		float eyeY = _posY-7;
		float _eyeX = _posX+12;
		
		if (alpha > 0){
			 alpha = alpha - 20;
			 }
			 else if (alpha <= 0){
			 alpha = 0;
			 alive = false;
			 }

		if (alive){
			c.drawCircle(_posX, _posY, _radius, _p);
			c.drawCircle(eyeX, eyeY, 5, eye);
			c.drawCircle(_eyeX, eyeY, 5, eye);
		}
	}		

	@Override
	public boolean pressed(MotionEvent m) {
		Log.i("K3", "Pressed");
		boolean hit = false;
		float dx = (_posX - m.getX());
		float dy = (_posY - m.getY());
		float dist = (float) Math.sqrt(dx * dx + dy * dy);
		
		if(alpha>0){
		if (dist < _radius) {
			alive = false;
			alpha = 0;
			hit = true;
		}
		
		}
		return hit;
	}
		
}
