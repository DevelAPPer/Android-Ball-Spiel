package de.example.spiel;

import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathDashPathEffect.Style;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;


public class SpielActivity extends View {

	private int punkte = 0,zeit = 0;
	private Ball ball1,ball2,ball3,ball4,ball5;
	private int schwierigkeitsgrad = 0;
	private GameLoop gameloop;
	private boolean angeklickt = false;
	private boolean angeklickt2 = false;
	private boolean angeklickt3 = false;
	private boolean angeklickt4 = false;
	private boolean angeklickt5 = false;
	final Handler h = new Handler();
	private int breitespielflaeche,laengespielflaeche;
	private boolean started = false;
	private boolean ballausdemspielfeld = false;
	private boolean ballausdemspielfeld2 = false;
	private boolean ballausdemspielfeld3 = false;
	private boolean ballausdemspielfeld4 = false;
	private boolean ballausdemspielfeld5 = false;
	private Intent intent3 = null;


	public SpielActivity(Context context) {
		super(context);
		ball1 = new Ball(getResources(), 150,300);
		ball2 = new Ball(getResources(), 300,300);
		ball3 = new Ball(getResources(), 400,300);
		ball4 = new Ball(getResources(), 200,300);
		ball5 = new Ball(getResources(), 0,300);
		DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		breitespielflaeche = metrics.widthPixels;
		laengespielflaeche = metrics.heightPixels;
		MainActivity ma = (MainActivity)context;
		schwierigkeitsgrad = ma.getschwierigkeitsgrad();
		Thread t = new Thread(r);
		t.start();

		switch (schwierigkeitsgrad) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			break;
		}
	}		
	Runnable r = new Runnable() {
		@Override
		public void run() {
			while (true) {
				zeit = zeit +1;
				h.post(new Runnable() {
					@Override
					public void run() {
					}
				});
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
			}
				if (angeklickt == true && angeklickt2 == true && angeklickt3
						&& angeklickt4 == true && angeklickt5 == true) {
						Context context = getContext();
						Intent intent2 = new Intent(getContext(),ZeitanzeigerKlasse.class);
						intent2.putExtra("diezeit", Integer.toString(zeit));
						context.startActivity(intent2);
						
						synchronized (this) {
							while (true) {
								try {
									this.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					}	
				}
			}
		};
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (ball1.getangezeigt() && (ball1.isTouched(event.getX(),event.getY()))) {
			punkte = punkte +1;
			ball1.setangezeigt(false);
			angeklickt = true;
		}
		if (ball2.getangezeigt() && (ball2.isTouched(event.getX(),event.getY()))) {
			punkte = punkte +1;
			ball2.setangezeigt(false);
			angeklickt2 = true;
		}
		if (ball3.getangezeigt() && (ball3.isTouched(event.getX(),event.getY()))) {
			punkte = punkte +1;
			ball3.setangezeigt(false);
			angeklickt3 = true;
		}
		if (ball4.getangezeigt() && (ball4.isTouched(event.getX(),event.getY()))) {
			punkte = punkte +1;
			ball4.setangezeigt(false);
			angeklickt4 = true;
		}
		if (ball5.getangezeigt() && (ball5.isTouched(event.getX(),event.getY()))) {
			punkte = punkte +1;
			ball5.setangezeigt(false);
			angeklickt5 = true;
		}
		return super.onTouchEvent(event);
	}
	@Override
	protected void onDraw(Canvas canvas) {
		String diepunkte = null;
		String diezeit;
		Integer.toString(punkte);
		
		if (ball1.getangezeigt() == true) {
			ball1.drawBitmap(canvas);
		}
		if (ball2.getangezeigt() == true) {
			ball2.drawBitmap(canvas);
		}
		if (ball3.getangezeigt() == true) {
			ball3.drawBitmap(canvas);
		}
		if (ball4.getangezeigt() == true) {
			ball4.drawBitmap(canvas);
		}
		if (ball5.getangezeigt() == true) {
			ball5.drawBitmap(canvas);
		}
		Paint paint = new Paint();
		paint.setStyle(android.graphics.Paint.Style.FILL);
		paint.setTextSize(30);
		diepunkte = Integer.toString(punkte);
		diezeit = Integer.toString(zeit);
		canvas.drawText("Punkte", 600, 35, paint);
		canvas.drawText(diepunkte,700,35,paint);
		canvas.drawText("Zeit",0,35,paint);
		canvas.drawText(diezeit,60,35,paint);	
		gameloop = new GameLoop();
		gameloop.run();
	}
	private class GameLoop extends Thread {
		private volatile boolean running = true;
		public void run() {
			try {
				TimeUnit.MILLISECONDS.sleep(5);
				ball1.addy(schwierigkeitsgrad *3);
				ball2.addy(schwierigkeitsgrad *2);
				ball3.addx(schwierigkeitsgrad *(-2));
				ball4.addx(schwierigkeitsgrad *(-3));
				ball5.addy(schwierigkeitsgrad *(-2)); {
				}
				if (ball1.getangezeigt() && (ball1.getY() <(-170) || ball1.getY() > laengespielflaeche)) {
					ballausdemspielfeld = true;
				}
				if (ball2.getangezeigt() && (ball2.getY() <(-170) || ball2.getY() > laengespielflaeche)) {
					ballausdemspielfeld2 = true;
				}
				if (ball5.getangezeigt() && (ball5.getY() <(-170) || ball5.getY() > laengespielflaeche)) {
					ballausdemspielfeld5 = true;
				}
				if (ball3.getangezeigt() && (ball3.getX() <(-170) || ball1.getX() > breitespielflaeche)) {
					ballausdemspielfeld3 = true;
				}
				if (ball4.getangezeigt() && (ball4.getX() <(-170) || ball1.getX() > breitespielflaeche)) {
					ballausdemspielfeld4 = true;
				}
				if (ballausdemspielfeld == true || ballausdemspielfeld2 == true || ballausdemspielfeld3 == true
						|| ballausdemspielfeld4 == true || ballausdemspielfeld5 == true) {
					
					if (intent3 == null) {
						Context context = getContext();
						running = false;
						intent3 = new Intent(getContext(),GameOver.class);
						context.startActivity(intent3);
					}
					if (running == false) {
						Context context = getContext();
						GameLoop.interrupted();
						((Activity) context).finish();
					}
				}
				postInvalidate();
			} catch(InterruptedException ex) {
			}
		}
	}
}
