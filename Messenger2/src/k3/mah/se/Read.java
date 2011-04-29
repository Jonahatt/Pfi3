package k3.mah.se;

import java.util.ArrayList;

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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.lang.ClassCastException;;

public class Read extends Activity implements OnClickListener, EssemmessListener {
	
	Essemmess server;
	private ListView lv1;
	
	ArrayList<String> arrlist=new ArrayList<String>();
	ListView listView1;
	ArrayAdapter<String> adapter;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read);
        
        server = EssemmessHelper.getServer(this);
        
        server.addEssemmessEventListener(this);
        
        listView1=(ListView)findViewById(R.id.listView1);
        listView1.setAdapter(adapter = new ArrayAdapter<String>(this, R.layout.listview, R.id.list_content, arrlist));
        server.read("");
        
     // Set up click listeners for all the buttons
        /*View refreshButton = findViewById(R.id.refresh_button);
        refreshButton.setOnClickListener(this);*/
    }
    
        /*public void onClick(View v) {
        	server.read("");
        }*/
        
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
        startActivity(new Intent(this, Main.class));
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
			for (int i = 0; i < evt.getPosts().size(); i++) {
				arrlist.add(evt.getPosts().get(i).getUser() + ": " + evt.getPosts().get(i).getMessage());
			}
			adapter.notifyDataSetChanged();
		}

		@Override
		public void NewEssemmessLogin(EssemmessLoginEvent evt) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void NewEssemmessPublish(EssemmessPublishEvent evt) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
        
}
