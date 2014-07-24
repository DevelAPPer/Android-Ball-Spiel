package de.example.spiel;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Ball {
	
	private int x,y;
	private boolean angezeigt = true;
	private Bitmap bitmap;

	public Ball(Resources resources, int new_x, int new_y) {
		x = new_x;
		y = new_y;
		bitmap = BitmapFactory.decodeResource(resources, R.drawable.ball1);
	}
	public boolean getangezeigt() {
		return angezeigt;
	}
	public void drawBitmap(Canvas canvas) {
		canvas.drawBitmap(bitmap, x, y,null);
	}
	public void addy (int value) {
		y = y +value;
	}
	public void addx (int value) {
		x = x +value;
	}
	public void setangezeigt(boolean show) {
		angezeigt = show;
	}
	public boolean isTouched(float eventx, float eventy) {
		float x1 = x;
		float x2 = x + bitmap.getWidth();
		float y1 = y;
		float y2 = y + bitmap.getHeight();
		if (eventx >= x1 && eventx <=x2
				&& eventy >= y1 && eventy <= y2) {
			return true;
		}
		return false;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int value) {
		value = x;
	}
	public void setY(int value) {
		value = y;
	}
}
