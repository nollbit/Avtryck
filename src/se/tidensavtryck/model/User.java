package se.tidensavtryck.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String userName;

    public User() {
    }

	public User(Parcel parcel) {
		this.userName = parcel.readString();
	}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
