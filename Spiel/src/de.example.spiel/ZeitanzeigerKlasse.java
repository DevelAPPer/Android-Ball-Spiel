package de.example.spiel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

public class ZeitanzeigerKlasse extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zeitangezeigt);
		TextView tv = (TextView)findViewById(R.id.textView2);
		Intent intent2 = getIntent();
		String diezeitstring = intent2.getStringExtra("diezeit");
		tv.setText(diezeitstring);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			startActivity(new Intent(ZeitanzeigerKlasse.this,MainActivity.class));
		}	
		return false;
	}	

}
