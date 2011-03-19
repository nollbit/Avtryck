package se.tidensavtryck;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import se.tidensavtryck.gateway.RouteGateway;
import se.tidensavtryck.model.Place;
import se.tidensavtryck.model.Record;
import se.tidensavtryck.model.Route;

import com.google.android.imageloader.ImageLoader;
import com.google.android.imageloader.ImageLoader.BindResult;

import java.util.List;

public class RecordActivity extends Activity implements ImageLoader.Callback {
    private ImageView imageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
        setContentView(R.layout.record);

//        initActionBar();

        RouteGateway gw = new RouteGateway(getResources().getAssets());
        List<Route> routes = gw.list();

        Route route = routes.get(0);
        Place place = route.getPlaces().get(0);
        Record record = place.getRecords().get(0);

        imageView = (ImageView) findViewById(R.id.recordThumbnail);

        BindResult result = ImageLoader.get(this).bind(imageView, record.getThumbnailURL(), this);
	    if(result == ImageLoader.BindResult.LOADING) {
            imageView.setVisibility(ImageView.GONE);
        }
	}
	
    private void initActionBar() {
//        ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
//        actionBar.setHomeAction(new ActionBar.IntentAction(
//                this, StartActivity.createIntent(this),
//                R.drawable.ic_actionbar_home_default));
    }

    @Override
    public void onImageLoaded(ImageView imageView, String s) {
        imageView.setVisibility(ImageView.VISIBLE);
    }

    @Override
    public void onImageError(ImageView imageView, String s, Throwable throwable) {
        Log.w("Avtryck", s);
    }
}
