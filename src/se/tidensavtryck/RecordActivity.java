package se.tidensavtryck;

import android.app.Activity;
import android.os.Bundle;

public class RecordActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
        setContentView(R.layout.record);

//        initActionBar();

	}
	
    private void initActionBar() {
//        ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
//        actionBar.setHomeAction(new ActionBar.IntentAction(
//                this, StartActivity.createIntent(this),
//                R.drawable.ic_actionbar_home_default));
    }
}
