package se.tidensavtryck;

import java.util.ArrayList;
import java.util.List;

import com.markupartist.android.widget.ActionBar;

import se.tidensavtryck.gateway.RouteGateway;
import se.tidensavtryck.model.Comment;
import se.tidensavtryck.model.Route;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class RouteInfoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.route_info);
        
        final Route route = (Route) getIntent().getParcelableExtra("route");

        initActionBar();

        TextView title = (TextView) findViewById(R.id.routeInfoTitle);
        title.setText(route.getTitle());
        
        TextView description = (TextView) findViewById(R.id.routeInfoDescription);
        description.setText(route.getDescription());
        
        TextView duration = (TextView) findViewById(R.id.routeDuration);
        duration.setText(""+route.getDurationInMinutes());
        
        ImageView thumbnail = (ImageView) findViewById(R.id.routeThumbnail);
        thumbnail.setBackgroundResource(R.drawable.route_thumbnail_example);
        
        Button button = (Button) findViewById(R.id.button_route);
        button.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RouteInfoActivity.this, RouteActivity.class);
                i.putExtra("route", route);
                startActivity(i);
            }
        });
        
        List<Comment> comments = new ArrayList<Comment>();
         ListView commentsList = (ListView) findViewById(R.id.routeComments);
         commentsList.setAdapter(new CommentsAdapter(this, comments));
    }

    private void initActionBar() {
        ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
        actionBar.setHomeAction(new ActionBar.IntentAction(
                this, StartActivity.createIntent(this),
                R.drawable.ic_actionbar_home_default));
        actionBar.setTitle("Översikt");
    }
    
    private class CommentsAdapter extends ArrayAdapter<Comment> {
//        private LayoutInflater mInflater;

        public CommentsAdapter(Context context, List<Comment> comments) {
            super(context, android.R.layout.simple_list_item_1, comments);

//            mInflater = (LayoutInflater) context.getSystemService(
//                    Context.LAYOUT_INFLATER_SERVICE);
        }

        
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            convertView = mInflater.inflate(R.layout.route_list_row, null);
//
//            Route route = getItem(position);
//            TextView title = (TextView) convertView.findViewById(R.id.routeTitle);
//            title.setText(route.getTitle());
//            TextView duration = (TextView) convertView.findViewById(R.id.routeDuration);
//            duration.setText(""+route.getDurationInMinutes());
//            
//            ImageView likes = (ImageView) convertView.findViewById(R.id.routeLikes);
//            likes.setBackgroundDrawable(createLikes(route.getLikes()));
//            return convertView;
//        }

    }
}
