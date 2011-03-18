package se.tidensavtryck.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Route implements Parcelable{

	private String title;

	private String description;

	private User creator;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    private List<Place> places;

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

	public Route(Parcel parcel) {
		this.title = parcel.readString();
		this.description = parcel.readString();
		this.creator = parcel.readParcelable(null);
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

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.title);
		dest.writeString(this.description);
		dest.writeParcelable(this.creator, 0);
	}

    public static final Creator<Route> CREATOR = new Creator<Route>() {
        public Route createFromParcel(Parcel parcel) {
            return new Route(parcel);
        }

        public Route[] newArray(int size) {
            return new Route[size];
        }
    };


}
