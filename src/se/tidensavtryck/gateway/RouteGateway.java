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

        Place place1 = new Place();
        place1.setTitle("Place 1");
        place1.setDescription("Place 1 description. Very long text to test that the UI really works");
        
        Place place2 = new Place();
        place2.setTitle("Place 2");
        place2.setDescription("Place 2 description. Very long text to test that the UI really works");
        
        Place place3 = new Place();
        place3.setTitle("Place 3");
        place3.setDescription("Place 3 description. Very long text to test that the UI really works");
        
        Place place4 = new Place();
        place4.setTitle("Place 4");
        place4.setDescription("Place 4 description. Very long text to test that the UI really works");

        Location loc1 = new Location("se.tidensavtryck");
        loc1.setLatitude(62.382413);
        loc1.setLongitude(17.337112);
        place1.setGeoLocation(loc1);

        Location loc2 = new Location("se.tidensavtryck");
        loc2.setLatitude(62.3908789765665);
        loc2.setLongitude(17.3038633831725);

        Location loc3 = new Location("se.tidensavtryck");
        loc3.setLatitude(62.3908789765665);
        loc3.setLongitude(17.3038633831725);
        
        Location loc4 = new Location("se.tidensavtryck");
        loc4.setLatitude(62.3908789765665);
        loc4.setLongitude(17.3038633831725);
        
        Location loc5 = new Location("se.tidensavtryck");
        loc5.setLatitude(62.3908789765665);
        loc5.setLongitude(17.3038633831725);

        InputStream is = null;
        List<Record> recordList = null;
        try {
            is = this.mAssetManager.open("place1.xml");
            XMLPull pull = new XMLPull(is);
            recordList = pull.parse();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        place1.setRecords(recordList);
        Place p2 = new Place("Bla bla bla plats", loc2, 50, recordList);

        List<Place> places = new LinkedList<Place>();
        places.add(place1);
        places.add(p2);

        route.setPlaces(places);
        routeList.add(route);

		return routeList;
	}
}
