package se.tidensavtryck.gateway;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import android.content.res.AssetManager;
import android.location.Location;
import com.google.android.maps.GeoPoint;
import se.tidensavtryck.model.User;
import se.tidensavtryck.model.Place;
import se.tidensavtryck.model.Record;
import se.tidensavtryck.model.Route;

public class RouteGateway {
    private AssetManager mAssetManager;

    public RouteGateway(AssetManager assetManager) {
        this.mAssetManager = assetManager;
    }

    public List<Route> list() {
		List<Route> routeList = new LinkedList<Route>();

        Route route = new Route();
        route.setTitle("My Best Route");
        User user = new User("Me");
        route.setCreator(user);
        route.setDescription("My Best Description. Very long text to test that the UI really works");

        Place place = new Place();
        place.setTitle("Place 1");
        place.setDescription("Place 1 description. Very long text to test that the UI really works");

        Location loc1 = new Location("se.tidensavtryck");
        loc1.setLatitude(62.382413);
        loc1.setLongitude(17.337112);
        place.setGeoLocation(loc1);

        InputStream is = null;
        List<Record> recordList = null;
        try {
            is = this.mAssetManager.open("place1.xml");
            XMLPull pull = new XMLPull(is);
            recordList = pull.parse();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        place.setRecords(recordList);

        List<Place> places = new LinkedList<Place>();
        places.add(place);

        route.setPlaces(places);
        routeList.add(route);

		return routeList;
	}
}
