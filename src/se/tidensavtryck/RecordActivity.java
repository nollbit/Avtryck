package se.tidensavtryck;

import se.tidensavtryck.model.Place;
import se.tidensavtryck.model.Record;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.imageloader.ImageLoader;
import com.google.android.imageloader.ImageLoader.BindResult;
import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.actionbar.R;


public class RecordActivity extends Activity implements ImageLoader.Callback {
    private Place mPlace;
    private int mRecordIndex;
    private LayoutInflater mInflater;
    private LinearLayout mImageHolder;
    private ThumbnailOnClickListener mThumbnailOnClickListener;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
        setContentView(R.layout.record);

        mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mPlace = (Place) getIntent().getParcelableExtra("place");
        mRecordIndex = 0;

        initActionBar();

        mImageHolder = (LinearLayout) findViewById(R.id.thumbnail_holder);
        mThumbnailOnClickListener = new ThumbnailOnClickListener();

        for (Record record : mPlace.getRecords()) {
            //mThumbnailUrls.add(record.getThumbnailURL());
            mImageHolder.addView(inflateThumbnail(record));
        }

        if (mPlace.getRecords().size() > 0) {
            final Record record = mPlace.getRecords().get(0);
            showRecord(record);
        }
	}

    private View inflateThumbnail(Record record) {
        View view = mInflater.inflate(R.layout.record_thumbnail, mImageHolder, false);

        ImageView imageView =
            (ImageView) view.findViewById(R.id.record_thumbnail);

        BindResult result = ImageLoader.get(this).bind(imageView, record.getThumbnailURL(), this);
        if(result == ImageLoader.BindResult.LOADING) {
            imageView.setVisibility(ImageView.GONE);
            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(RecordActivity.this, "click", Toast.LENGTH_SHORT).show();
                }
            });
        }
        view.setTag(record);
        view.setOnClickListener(mThumbnailOnClickListener);

        return view;
    }
    
    private void initActionBar() {
        ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
        actionBar.setTitle(String.format("%1$d av %2$d", mRecordIndex+1, mPlace.getRecords().size()));
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setHomeAction(new ActionBar.Action() {

            @Override
            public int getDrawable() {
                return R.drawable.ic_actionbar_home_default;
            }

            @Override
            public void performAction(View view) {
                finish();
            }

        });
    }

    private void showRecord(Record record) {
        TextView title = (TextView) findViewById(R.id.recordTitle);
        title.setText(record.getTitle());

        TextView description = (TextView) findViewById(R.id.recordDescription);
        description.setText(record.getDescription());
    }

    @Override
    public void onImageLoaded(ImageView imageView, String s) {
        imageView.setVisibility(ImageView.VISIBLE);
    }

    @Override
    public void onImageError(ImageView imageView, String s, Throwable throwable) {
        Log.w("Avtryck", throwable.toString());
    }

    private class ThumbnailOnClickListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            final Object tag = v.getTag();
            if (tag instanceof Record) {
                final Record record = (Record) tag;
                showRecord(record);
            }
        }

    }
}
