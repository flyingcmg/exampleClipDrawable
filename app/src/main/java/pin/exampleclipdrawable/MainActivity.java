package pin.exampleclipdrawable;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView pulseImageView = (ImageView)findViewById(R.id.heart_image_pulse);
        final ClipDrawable clipDrawable = (ClipDrawable) pulseImageView.getDrawable();
        final int maxWidth = 10400;

        Button bt = (Button)findViewById(R.id.finger_print) ;
        bt.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("Range")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_MOVE:

                        if(clipDrawable.getLevel() == maxWidth){
                            clipDrawable.setLevel(0);
                        }else{
                            clipDrawable.setLevel(clipDrawable.getLevel() + 80);
                        }
                        break;
                }
                return false;
            }
        });

      /*  bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("CMG", "onClick: clipDrawable.getLevel()="+clipDrawable.getLevel());
                clipDrawable.setLevel(1000);
            }
        });*/
    }
}
