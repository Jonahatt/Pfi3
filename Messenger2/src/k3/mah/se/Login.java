package k3.mah.se;

import se.k3.goransson.andreas.essemmesslib.Essemmess;
import se.k3.goransson.andreas.essemmesslib.EssemmessHelper;
import se.k3.goransson.andreas.essemmesslib.EssemmessListener;
import se.k3.goransson.andreas.essemmesslib.EssemmessLoginEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessPublishEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessReadEvent;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity implements OnClickListener,
		EssemmessListener {

	Essemmess server;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		server = EssemmessHelper.getServer(this);
		server.addEssemmessEventListener(this);

		// Set up click listeners for all the buttons
		Button loginButton = (Button) findViewById(R.id.login_button);
		loginButton.setOnClickListener(this);
	}

	public void onClick(View v) {
		loginProgram(1);

	}

	private void loginProgram(int i) {
		Log.d("TAG", "clicked on " + i);

		EditText user = (EditText) findViewById(R.id.user);
		EditText pass = (EditText) findViewById(R.id.pass);

		String user1 = user.getText().toString();
		String pass1 = pass.getText().toString();

		server.login(user1, pass1);

	}

	@Override
	public void NewEssemmessPosts(EssemmessReadEvent evt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void NewEssemmessLogin(EssemmessLoginEvent evt) {
		Log.i("test", "login evt " + evt.getLoggedin());
		// TODO Auto-generated method stub
		if (evt.getLoggedin()) {

			Intent s = new Intent(Login.this, Main.class);
			startActivity(s);
		}
	}

	@Override
	public void NewEssemmessPublish(EssemmessPublishEvent evt) {
		// TODO Auto-generated method stub

	}
}