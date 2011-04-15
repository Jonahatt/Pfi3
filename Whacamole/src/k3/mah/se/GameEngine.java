package k3.mah.se;

import java.util.*;


import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


public class GameEngine extends View implements Callback {
	private Handler myHandler;
	Paint background;
	Paint holes;
	Paint holes_shallow;
	Paint holes_shallowest;
	
private List<Drawable> myMoles = new ArrayList<Drawable>();
//private List<Drawable> myHoles = new ArrayList<Drawable>();

public GameEngine(Context context) {
	super(context);
	background = new Paint(Paint.ANTI_ALIAS_FLAG);
	background.setColor(Color.parseColor("#00AA00"));
	holes = new Paint(Paint.ANTI_ALIAS_FLAG);
	holes.setColor(Color.parseColor("#000000"));
	holes_shallow = new Paint(Paint.ANTI_ALIAS_FLAG);
	holes_shallow.setColor(Color.parseColor("#111111"));
	holes_shallowest= new Paint(Paint.ANTI_ALIAS_FLAG);
	holes_shallowest.setColor(Color.parseColor("#222222"));
	
	myHandler = new Handler(this);
		//Create Thread
	new GameUpdateThread(myHandler).start();
	//createHoles();
	createMoles();
}

private void createMoles() {
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			myMoles.add(new Mole(60+(i*100),98+(j*100), "#5E2605"));
		}
	}
}

/*private void createHoles() {
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			myHoles.add(new Mole(50+(i*50),50+(j*50), "#000000"));
		}
	}
}*/

@Override
public boolean onTouchEvent(MotionEvent event) {
	for (Drawable d : myMoles) {
		d.pressed(event);
	}
	Log.i("K3", "Touch "+event.getX()+","+event.getY());
	update();
	return super.onTouchEvent(event);
}

private void update() {
	for (Drawable d : myMoles){
		d.update();
	}
	this.invalidate();
}

@Override
public boolean handleMessage(Message arg0) {
	// TODO Auto-generated method stub
	Log.i("K3", "Handle");
	update();
	return false;
}

@Override
protected void onDraw(Canvas canvas) {
	super.onDraw(canvas);
	canvas.drawPaint(background);
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			canvas.drawCircle(60+(i*100), 100+(j*100), 40, holes_shallowest);
		}
	}
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			canvas.drawCircle(60+(i*100), 99+(j*100), 38, holes_shallow);
		}
	}
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			canvas.drawCircle(60+(i*100), 98+(j*100), 36, holes);
		}
	}
	/*for (Drawable d : myHoles) {
		d.draw(canvas);
	}*/
	for (Drawable d : myMoles) {
		d.draw(canvas);
	}

	//update();
}

}
