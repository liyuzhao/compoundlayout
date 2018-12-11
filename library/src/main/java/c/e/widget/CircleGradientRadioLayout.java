package c.e.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;

/**
 * Circle gradient radio layout.
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class CircleGradientRadioLayout extends GradientRadioLayout{

	/**
	 * Draw path.
	 */
	private Path mPath;

	public CircleGradientRadioLayout(Context context){
		super(context);
		initialize();
	}

	public CircleGradientRadioLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize();
	}

	public CircleGradientRadioLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initialize();
	}

	public CircleGradientRadioLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		initialize();
	}

	/**
	 * Initialize view.
	 */
	private void initialize(){
		// - Defines rounded background.
		setBackgroundResource(R.drawable.rounded);
	}


	@Override
	public void draw(Canvas canvas) {
		canvas.save();
		canvas.clipPath(mPath);
		super.draw(canvas);
		canvas.restore();
	}

	@Override
	protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
		super.onSizeChanged(width, height, oldWidth, oldHeight);
		mPath = new Path();
		mPath.addOval(0, 0, width, height, Path.Direction.CW);
		mPath.close();
	}
}
