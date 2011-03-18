package se.tidensavtryck.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable{
    private String userName;

    public User(String username) {
        this.userName = username;
    }

	public User(Parcel parcel) {
		this.userName = parcel.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.userName);
	}

    public static final Creator<User> CREATOR = new Creator<User>() {
        public User createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
