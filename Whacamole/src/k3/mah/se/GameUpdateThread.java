package k3.mah.se;

import android.os.Handler;
import android.util.Log;

public class GameUpdateThread extends Thread {
	Handler _handler;
	private boolean running = true;
	public GameUpdateThread(Handler handler){
		_handler = handler;
	}
	
	@Override
	public void run() {
		super.run();
		while(running){
			try {
				Log.i("k3", "Tråd1");
				_handler.sendEmptyMessage(NORM_PRIORITY);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				Log.i("k3", "Tråd2");
			}
		}
	}

}
