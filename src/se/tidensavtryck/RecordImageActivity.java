package se.tidensavtryck;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.markupartist.android.widget.ActionBar;
import se.tidensavtryck.model.Record;

/**
 * Created by IntelliJ IDEA.
 * User: joakimb
 * Date: 2011-03-19
 * Time: 11.52
 * To change this template use File | Settings | File Templates.
 */
public class RecordImageActivity extends Activity {
    private Record record;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.record_image);

        record = getIntent().getParcelableExtra("record");

        initActionBar();

        WebView wv = (WebView) findViewById(R.id.recordImageWebView);
        wv.setScrollbarFadingEnabled(true);
        wv.setInitialScale(100);
        wv.getSettings().setBuiltInZoomControls(true);
        wv.loadUrl(record.getImages().get(0));
    }

    private void initActionBar() {
        ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
        actionBar.setTitle(record.getTitle());
        actionBar.setHomeAction(new ActionBar.IntentAction(
                this, StartActivity.createIntent(this),
                R.drawable.ic_actionbar_home_default));
    }
}