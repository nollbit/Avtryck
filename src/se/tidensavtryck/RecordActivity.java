package se.tidensavtryck;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import se.tidensavtryck.model.Place;
import se.tidensavtryck.model.Record;

import com.google.android.imageloader.ImageLoader;
import com.google.android.imageloader.ImageLoader.BindResult;

public class RecordActivity extends Activity implements ImageLoader.Callback {
    private ImageView mImageView;
    private Place mPlace;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
        setContentView(R.layout.record);

//        initActionBar();

        mPlace = (Place) getIntent().getParcelableExtra("place");
        Record record = mPlace.getRecords().get(0);

        mImageView = (ImageView) findViewById(R.id.recordThumbnail);

        BindResult result = ImageLoader.get(this).bind(mImageView, record.getThumbnailURL(), this);
	    if(result == ImageLoader.BindResult.LOADING) {
            mImageView.setVisibility(ImageView.GONE);
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
