package se.tidensavtryck.model;

import java.util.List;

import android.location.Location;

public class Place {

	private String description;
	
	private Location geoLocation;
	
	private int radiusInMeters;
	
	private List<Record> records;

	public Place(String description, Location geoLocation, int radiusInMeters, List<Record> records) {
		super();
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
