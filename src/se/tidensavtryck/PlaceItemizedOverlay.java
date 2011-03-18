package se.tidensavtryck;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.readystatesoftware.mapviewballoons.BalloonItemizedOverlay;

public class PlaceItemizedOverlay  extends BalloonItemizedOverlay<OverlayItem> {

    private ArrayList<OverlayItem> m_overlays = new ArrayList<OverlayItem>();
    private Context c;
    
    public PlaceItemizedOverlay(Drawable defaultMarker, MapView mapView) {
        super(boundCenter(defaultMarker), mapView);
        c = mapView.getContext();
    }

    public void addOverlay(OverlayItem overlay) {
        m_overlays.add(overlay);
        populate();
    }

    @Override
    protected OverlayItem createItem(int i) {
        return m_overlays.get(i);
    }

    @Override
    public int size() {
        return m_overlays.size();
    }

    @Override
    protected boolean onBalloonTap(int index) {
        Toast.makeText(c, "onPlaceTap for overlay index " + index,
                Toast.LENGTH_LONG).show();
        return true;
    }
    
}
