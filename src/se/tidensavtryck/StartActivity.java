package se.tidensavtryck;

import java.util.List;

import se.tidensavtryck.gateway.RouteGateway;
import se.tidensavtryck.model.Route;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
            
            TextView numPlaces = (TextView) convertView.findViewById(R.id.routeNumPlaces);
            numPlaces.setBackgroundResource(R.drawable.circle_background);
            numPlaces.setText(""+route.getPlaces().size());

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
}