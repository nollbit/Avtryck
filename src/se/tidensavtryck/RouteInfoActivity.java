package se.tidensavtryck;

import se.tidensavtryck.model.Route;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RouteInfoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Route dummyRoute = Route.createKnaustRoute();
        
        setContentView(R.layout.route_info);
        
        TextView title = (TextView) findViewById(R.id.routeInfoTitle);
        title.setText(dummyRoute.getTitle());
        
        TextView description = (TextView) findViewById(R.id.routeInfoDescription);
        description.setText(dummyRoute.getDescription());
        
        TextView duration = (TextView) findViewById(R.id.routeDuration);
        duration.setText(""+dummyRoute.getDurationInMinutes());
        
        ImageView thumbnail = (ImageView) findViewById(R.id.routeThumbnail);
        thumbnail.setBackgroundResource(R.drawable.route_thumbnail_example);
        
        Button button = (Button) findViewById(R.id.button_route);
        button.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RouteInfoActivity.this, RouteActivity.class);
                startActivity(i);
            }
        });
    }
}
