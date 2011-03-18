package se.tidensavtryck;

import java.util.List;

import se.tidensavtryck.model.Place;
import se.tidensavtryck.model.Route;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class RouteActivity extends MapActivity {

    MapView mMapView;
    List<Overlay> mMapOverlays;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.route);

        mMapView = (MapView) findViewById(R.id.mapview);
        mMapView.setBuiltInZoomControls(true);

        mMapOverlays = mMapView.getOverlays();

        Route route = Route.createKnaustRoute();
        addOverlaysFromRoute(route, mMapOverlays);

        final MapController mc = mMapView.getController();

        if (mMapOverlays.size() > 0) {
            PlaceItemizedOverlay first = (PlaceItemizedOverlay) mMapOverlays.get(0);
            GeoPoint point = first.getCenter();

            mc.animateTo(point);
            mc.setZoom(16);
        }
    }

    /**
     * Add overlays from a {@link Route}.
     * @param route The route.
     * @param mapOverlays The overlays.
     */
    private void addOverlaysFromRoute(Route route, List<Overlay> mapOverlays) {
        for (Place place : route.getPlaces()) {
            mapOverlays.add(createPlaceOverlay(place));
        }
    }

    /**
     * Creates an overlay from a {@link Place}.
     * @param place The place.
     * @return An overlay.
     */
    private PlaceItemizedOverlay createPlaceOverlay(Place place) {
        Drawable drawable = getResources().getDrawable(R.drawable.marker);
        PlaceItemizedOverlay itemizedOverlay = new PlaceItemizedOverlay(drawable, mMapView);

        GeoPoint point = new GeoPoint(
                (int)(place.getGeoLocation().getLatitude()*1E6),
                (int)(place.getGeoLocation().getLongitude()*1E6));
        OverlayItem overlayItem = new OverlayItem(point, "Runsten", 
                place.getDescription());

        itemizedOverlay.addOverlay(overlayItem);

        return itemizedOverlay;
    }

    @Override
    protected boolean isRouteDisplayed() {
        // TODO Auto-generated method stub
        return false;
    }
}
