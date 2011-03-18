package se.tidensavtryck;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class RouteActivity extends MapActivity {

    MapView mapView;
    List<Overlay> mapOverlays;
    Drawable drawable;
    Drawable drawable2;
    PlaceItemizedOverlay itemizedOverlay;
    PlaceItemizedOverlay itemizedOverlay2;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.route);

        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        
        mapOverlays = mapView.getOverlays();
        
        // first overlay
        drawable = getResources().getDrawable(R.drawable.marker);
        itemizedOverlay = new PlaceItemizedOverlay(drawable, mapView);
        
        GeoPoint point = new GeoPoint((int)(51.5174723*1E6),(int)(-0.0899537*1E6));
        OverlayItem overlayItem = new OverlayItem(point, "Tomorrow Never Dies (1997)", 
                "(M gives Bond his mission in Daimler car)");
        itemizedOverlay.addOverlay(overlayItem);
        
        GeoPoint point2 = new GeoPoint((int)(51.515259*1E6),(int)(-0.086623*1E6));
        OverlayItem overlayItem2 = new OverlayItem(point2, "GoldenEye (1995)", 
                "(Interiors Russian defence ministry council chambers in St Petersburg)");      
        itemizedOverlay.addOverlay(overlayItem2);
        
        mapOverlays.add(itemizedOverlay);
        
        // second overlay
        drawable2 = getResources().getDrawable(R.drawable.marker2);
        itemizedOverlay2 = new PlaceItemizedOverlay(drawable2, mapView);
        
        GeoPoint point3 = new GeoPoint((int)(51.513329*1E6),(int)(-0.08896*1E6));
        OverlayItem overlayItem3 = new OverlayItem(point3, "Sliding Doors (1998)", 
                "(interiors)");
        itemizedOverlay2.addOverlay(overlayItem3);
        
        GeoPoint point4 = new GeoPoint((int)(51.51738*1E6),(int)(-0.08186*1E6));
        OverlayItem overlayItem4 = new OverlayItem(point4, "Mission: Impossible (1996)", 
                "(Ethan & Jim cafe meeting)");      
        itemizedOverlay2.addOverlay(overlayItem4);
        
        mapOverlays.add(itemizedOverlay2);
        
        final MapController mc = mapView.getController();
        mc.animateTo(point2);
        mc.setZoom(16);
        
    }

    @Override
    protected boolean isRouteDisplayed() {
        // TODO Auto-generated method stub
        return false;
    }
}
