package k3.mah.se;

import se.k3.goransson.andreas.essemmesslib.Essemmess;
import se.k3.goransson.andreas.essemmesslib.EssemmessHelper;
import se.k3.goransson.andreas.essemmesslib.EssemmessListener;
import se.k3.goransson.andreas.essemmesslib.EssemmessLoginEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessPublishEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessReadEvent;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener, EssemmessListener {
	
	Essemmess server;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        server = EssemmessHelper.getServer(this);
        server.addEssemmessEventListener(this);
        
     // Set up click listeners for all the buttons
        View submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(this);
    }
    
        public void onClick(View v) {
        	EditText text = (EditText) findViewById(R.id.editText1);
        	EditText tag = (EditText) findViewById(R.id.editText2);
    		
    		String text1 = text.getText().toString();
    		String tag1 = tag.getText().toString();
    		server.post(text1, tag1);
    		text.setText(""); 
    		tag.setText("");
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
        }
        
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.send:
        startActivity(new Intent(this, Read.class));
        return true;
        // More items go here (if any)
        case R.id.read:
            startActivity(new Intent(this, Read.class));
            return true;
        }
        return false;
        }

		@Override
		public void NewEssemmessPosts(EssemmessReadEvent evt) {
			// TODO Auto-generated method stub
		}

		@Override
		public void NewEssemmessLogin(EssemmessLoginEvent evt) {
			// TODO Auto-generated method stub
		}

		@Override
		public void NewEssemmessPublish(EssemmessPublishEvent evt) {
			// TODO Auto-generated method stub
			String toastString = "Meddelande skickat!";
    		Toast toastMessage = Toast.makeText(this, toastString, Toast.LENGTH_LONG);
    		toastMessage.show();
		}
        
}
