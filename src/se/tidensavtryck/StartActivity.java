package se.tidensavtryck;

import java.util.List;

import se.tidensavtryck.gateway.RouteGateway;
import se.tidensavtryck.model.Route;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class StartActivity extends ListActivity {
	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        new RetrieveRoutesTask().execute();
    }

	private class RetrieveRoutesTask extends AsyncTask<Void, Integer, List<Route>> {
		protected List<Route> doInBackground(Void... voids) {
			RouteGateway gw = new RouteGateway(getResources().getAssets());
			List<Route> routes = gw.list();
			return routes;
		}

		protected void onProgressUpdate(Integer... progress) {

		}

		protected void onPostExecute(List<Route> routes) {
			setListAdapter(new RouteAdapter(StartActivity.this, routes));
		}
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
        Route route = (Route) getListAdapter().getItem(position);
        Intent i = new Intent(StartActivity.this, RouteInfoActivity.class);
        i.putExtra("route", route);
        startActivity(i);
	}
	
    private class RouteAdapter extends ArrayAdapter<Route> {
        private LayoutInflater mInflater;

        public RouteAdapter(Context context, List<Route> routes) {
            super(context, android.R.layout.simple_list_item_1, routes);

            mInflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
        }

        
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = mInflater.inflate(R.layout.route_list_row, null);

            Route route = getItem(position);
            TextView title = (TextView) convertView.findViewById(R.id.routeTitle);
            title.setText(route.getTitle());
            TextView duration = (TextView) convertView.findViewById(R.id.routeDuration);
            duration.setText(""+route.getDurationInMinutes());
            
            ImageView likes = (ImageView) convertView.findViewById(R.id.routeLikes);
            likes.setBackgroundDrawable(createLikes(route.getLikes()));
            return convertView;
        }

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
    
    private Drawable createLikes(int likes) {
    	Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.thumb_up);

    	int size = 34;
    	int x = 46;
    	int y = 75;
    	
    	// create a mutable bitmap with the same size as the background image
    	Bitmap bmOverlay = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), 
    	    Bitmap.Config.ARGB_4444);
    	// create a canvas on which to draw
    	Canvas canvas = new Canvas(bmOverlay);

    	
    	RectF oval = new RectF(38, 38, 88, 88);
    	Paint ovalPaint = new Paint();
    	
    	ovalPaint.setColor(Color.WHITE);
    	ovalPaint.setAlpha(160);
    	
    	Paint textPaint = new Paint();
    	textPaint.setColor(Color.BLACK);
    	textPaint.setAlpha(160);
    	textPaint.setTextSize(size);
    	textPaint.setFlags(Paint.FAKE_BOLD_TEXT_FLAG);

    	// if the background image is defined in main.xml, omit this line
    	canvas.drawBitmap(mBitmap, 0, 0, null);
    	canvas.drawOval(oval, ovalPaint);
    	// draw the text and the point

    	canvas.drawText(""+likes, x, y, textPaint);
    	
    	// set the bitmap into the ImageView
    	return new BitmapDrawable(bmOverlay);
    }
}