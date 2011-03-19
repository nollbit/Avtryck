package se.tidensavtryck;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import com.markupartist.android.widget.ActionBar;
import se.tidensavtryck.model.Place;
import se.tidensavtryck.model.Record;

import com.google.android.imageloader.ImageLoader;
import com.google.android.imageloader.ImageLoader.BindResult;

public class RecordActivity extends Activity implements ImageLoader.Callback {
    private ImageView mImageView;
    private Place mPlace;
    private int mRecordIndex;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
        setContentView(R.layout.record);

        mPlace = (Place) getIntent().getParcelableExtra("place");
        mRecordIndex = 0;

        initActionBar();

        mImageView = (ImageView) findViewById(R.id.recordThumbnail);

        showRecord();
	}
	
    private void initActionBar() {
        ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
        actionBar.setTitle(String.format("%1$d av %2$d", mRecordIndex+1, mPlace.getRecords().size()));
        actionBar.setHomeAction(new ActionBar.IntentAction(
                this, StartActivity.createIntent(this),
                R.drawable.ic_actionbar_home_default));
    }

    private void showRecord() {
        Record record = mPlace.getRecords().get(mRecordIndex);
        BindResult result = ImageLoader.get(this).bind(mImageView, record.getThumbnailURL(), this);
	    if(result == ImageLoader.BindResult.LOADING) {
            mImageView.setVisibility(ImageView.GONE);
        }
    }

    @Override
    public void onImageLoaded(ImageView imageView, String s) {
        mImageView.setVisibility(ImageView.VISIBLE);
    }

    @Override
    public void onImageError(ImageView imageView, String s, Throwable throwable) {
        Log.w("Avtryck", s);
    }
}
