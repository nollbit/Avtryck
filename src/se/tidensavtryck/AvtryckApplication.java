package se.tidensavtryck;

import android.app.Application;
import com.google.android.imageloader.ImageLoader;

/**
 * Created by IntelliJ IDEA.
 * User: joakimb
 * Date: 2011-03-19
 * Time: 03.25
 * To change this template use File | Settings | File Templates.
 */
public class AvtryckApplication extends Application {
    private ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();

        imageLoader = new ImageLoader();
    }

    @Override
	public Object getSystemService(String name) {
		if(name.equals(ImageLoader.IMAGE_LOADER_SERVICE)) {
			return imageLoader;
		}

		return super.getSystemService(name);
	}
}
