package de.example.spiel;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	public int schwierigkeitsgrad = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.item1:
			setContentView(R.layout.informationen);
			return true;
			default:
		return super.onOptionsItemSelected(item);
		}
	}
	public int getschwierigkeitsgrad () {
		return schwierigkeitsgrad;
	}
		public void leichtdruck (View view) {
			schwierigkeitsgrad = 1;
			setContentView(new SpielActivity(this));
		}
		public void mitteldruck (View view) {
			schwierigkeitsgrad = 2;
			setContentView(new SpielActivity(this));
		}
		public void schwerdruck (View view) {
			schwierigkeitsgrad = 3;
			setContentView(new SpielActivity(this));
		}
		public void appschließen (View view) {
			AlertDialog ad = new AlertDialog.Builder(this).create();
			ad.setTitle("Applikation wirklich schließen?");
			ad.setButton("Ok", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					MainActivity.this.finish();
					
				}
			});
			ad.setButton2("Nein", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getApplicationContext(), "Applikation wird fortgesetzt", Toast.LENGTH_LONG).show();
				};
			});
			ad.setIcon(R.drawable.ic_launcher);
			ad.show();
	}

		@Override
		public boolean onKeyDown(int keyCode, KeyEvent event) {
			if (keyCode == KeyEvent.KEYCODE_BACK) {
				setContentView(R.layout.activity_main);
			}
			return false;
		}
}
