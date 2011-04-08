package k3.mah.se;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Messenger extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
     // Set up click listeners for all the buttons
        View aboutButton = findViewById(R.id.submit_button);
        aboutButton.setOnClickListener(this);
    }
    
        public void onClick(View v) {
        	EditText text = (EditText) findViewById(R.id.editText1);
        	EditText tag = (EditText) findViewById(R.id.editText2);
    		//Get the radiobutton
    		String s = text.getText().toString() + "\n" + "TAG:" + tag.getText().toString();
    		Toast t = Toast.makeText(this, s, Toast.LENGTH_LONG);
    		t.show();
    		text.setText(""); 
    		tag.setText("");
        }
        	/*switch (v.getId()) {
        	case R.id.submit_button:
        	Intent i = new Intent(this, Submit.class);
        	startActivity(i);
        	break;*/
        	// More buttons go here (if any) ...
        	
        
}