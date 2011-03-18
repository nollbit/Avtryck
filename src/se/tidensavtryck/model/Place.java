package se.tidensavtryck.model;

import android.location.Location;

public class Place {

	private String description;
	
	private Location geoLocation;
	
	private int radiusInMeters;

	public Place(String description, Location geoLocation, int radiusInMeters) {
		super();
		this.description = description;
		this.geoLocation = geoLocation;
		this.radiusInMeters = radiusInMeters;
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
	
}
