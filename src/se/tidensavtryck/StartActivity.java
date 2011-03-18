package se.tidensavtryck;

import com.markupartist.android.widget.ActionBar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button button = (Button) findViewById(R.id.button_route_info);
        button.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartActivity.this, RouteInfoActivity.class);
                startActivity(i);
            }
        });
    }

    /**
     * Creates an {@link Intent} for this activity, since this is the home
     * intent the flag {@link #Intent.FLAG_ACTIVITY_CLEAR_TOP} is also set. 
     * @param context The Context.
     * @return An Intent for this activity.
     */
    public static Intent createIntent(Context context) {
        Intent i = new Intent(context, StartActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return i;
    }
}