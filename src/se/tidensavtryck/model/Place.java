package se.tidensavtryck.model;

import java.util.List;

import android.location.Location;
import com.google.android.maps.GeoPoint;

public class Place {
	private String description;
	private Location geoLocation;
	private int radiusInMeters;
	private List<Record> records;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGeoLocation(Location geoLocation) {
        this.geoLocation = geoLocation;
    }

    public void setRadiusInMeters(int radiusInMeters) {
        this.radiusInMeters = radiusInMeters;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public Place() {

    }

    public Place(String description, Location geoLocation, int radiusInMeters, List<Record> records) {
		this.description = description;
		this.geoLocation = geoLocation;
		this.radiusInMeters = radiusInMeters;
		this.records = records;
	}

	public String getDescription() {
		return description;
	}

	public Location getGeoLocation() {
		return geoLocation;
	}

	public int getRadiusInMeters() {
		return radiusInMeters;
	}
	
	public List<Record> getRecords() {
		return records;
	}
	
}
