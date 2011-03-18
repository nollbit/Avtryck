package se.tidensavtryck.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import se.tidensavtryck.User;
import android.location.Location;

public class Route {

	private String title;

	private String description;

	private User creator;

	private LinkedList<Place> places;

	public Route(String title, String description,
			User creator, LinkedList<Place> places) {
		this.title = title;
		this.description = description;
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

	public User getCreator() {
		return creator;
	}
	
	public int getDurationInMinutes() {
		return 54;
	}

	public static Route createKnaustRoute() {
		// records
		Record knaustRecord = new Record();
        List<Record> records = new ArrayList<Record>();
        records.add(knaustRecord);

        // places
        Location loc1 = new Location("se.tidensavtryck");
        loc1.setLatitude(62.382413);
        loc1.setLongitude(17.337112);
        Place p1 = new Place("Hotel Knaust", loc1, 50, records);
        
        Location loc2 = new Location("se.tidensavtryck");
        loc2.setLatitude(62.3908789765665);
        loc2.setLongitude(17.3038633831725);
        Place p2 = new Place("Bla bla bla plats", loc2, 50, records);

        LinkedList<Place> places = new LinkedList<Place>();
        places.add(p1);
        places.add(p2);
        
        // route
        User creator = new User();
        Route route = new Route("Knaust-rutten", "En trevlig tur runt kvarteret Knaust med historiska platser och f�rem�l.", creator, places);
        
        return route;
	}
	
}
