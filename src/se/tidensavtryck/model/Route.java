package se.tidensavtryck.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import se.tidensavtryck.User;

import android.location.Location;

public class Route {

	private String title;

	private String description;

	private Location geoLocation;

	private User creator;

	private LinkedList<Place> places;

	public Route(String title, String description, Location geoLocation,
			User creator, LinkedList<Place> places) {
		this.title = title;
		this.description = description;
		this.geoLocation = geoLocation;
		this.creator = creator;
		this.places = places;
	}

	public Route() {
		// TODO Auto-generated constructor stub
	}

	public List<Place> getPlaces() {
		return Collections.unmodifiableList(places);
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Location getGeoLocation() {
		return geoLocation;
	}

	public User getCreator() {
		return creator;
	}

}
