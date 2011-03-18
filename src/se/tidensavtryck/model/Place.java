package se.tidensavtryck.model;

import java.util.LinkedList;
import java.util.List;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.maps.GeoPoint;

public class Place implements Parcelable {
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

    public Place(Parcel parcel) {
        description = parcel.readString();
	    geoLocation = parcel.readParcelable(null);
        radiusInMeters = parcel.readInt();
        title = parcel.readString();

        records = new LinkedList<Record>();
        parcel.readTypedList(records, Record.CREATOR);
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(description);
	    parcel.writeParcelable(geoLocation, 0);
        parcel.writeInt(radiusInMeters);
        parcel.writeString(title);

        parcel.writeTypedList(records);
    }

    public static final Parcelable.Creator<Place> CREATOR = new Parcelable.Creator<Place>() {
        public Place createFromParcel(Parcel parcel) {
            return new Place(parcel);
        }

        public Place[] newArray(int size) {
            return new Place[size];
        }
    };
}
