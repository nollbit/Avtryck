package se.tidensavtryck;

import java.util.List;

import se.tidensavtryck.model.Comment;
import se.tidensavtryck.model.Route;
import android.app.Activity;
import android.app.ListActivity;
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

import com.markupartist.android.widget.ActionBar;

public class RouteInfoActivity extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.route_info);
        
        final Route route = (Route) getIntent().getParcelableExtra("route");

        initActionBar();

        // Build the header view.
        View headerView = getLayoutInflater().inflate(R.layout.route_info_header, null);

        TextView title = (TextView) headerView.findViewById(R.id.routeInfoTitle);
        title.setText(route.getTitle());
        
        TextView description = (TextView) headerView.findViewById(R.id.routeInfoDescription);
        description.setText(route.getDescription());
        
        TextView duration = (TextView) headerView.findViewById(R.id.routeDuration);
        duration.setText(""+route.getDurationInMinutes());
        
        ImageView thumbnail = (ImageView) headerView.findViewById(R.id.routeThumbnail);
        thumbnail.setBackgroundResource(R.drawable.route_thumbnail_example);
        
        Button button = (Button) headerView.findViewById(R.id.button_route);
        button.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RouteInfoActivity.this, RouteActivity.class);
                i.putExtra("route", route);
                startActivity(i);
            }
        });

        getListView().addHeaderView(headerView, null, false);
        setListAdapter(new CommentsAdapter(this, Comment.createDummyComments())); 
    }

    private void initActionBar() {
        ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
        actionBar.setHomeAction(new ActionBar.IntentAction(
                this, StartActivity.createIntent(this),
                R.drawable.ic_actionbar_home_default));
        actionBar.setTitle("Översikt");
    }
    
    private class CommentsAdapter extends ArrayAdapter<Comment> {
        private LayoutInflater mInflater;

        public CommentsAdapter(Context context, List<Comment> comments) {
            super(context, android.R.layout.simple_list_item_1, comments);

            mInflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = mInflater.inflate(R.layout.comment_list_row, null);

            Comment comment = getItem(position);
            TextView commentText = (TextView) convertView.findViewById(R.id.commentText);
            commentText.setText(comment.getComment());
            
            ImageView avatar = (ImageView) convertView.findViewById(R.id.avatarView);
            int avatarResource = R.drawable.avatar_example2;
            if (position % 2 == 1) {
            	avatarResource = R.drawable.avatar_example;
            }
            avatar.setBackgroundResource(avatarResource);
            
            TextView timestamp = (TextView) convertView.findViewById(R.id.commentTimestamp);
            timestamp.setText(comment.getTimestamp());
            return convertView;
        }

    }
}
