package se.tidensavtryck.model;

import android.location.Location;

import java.util.ArrayList;
import java.util.List;

public class Record {
    private String mTitle = "-";
    private String mThumbnailURL;
    private String mThumbnailUrl = null;
    private List<String> mImages = new ArrayList<String>();
    private String mDescription;
    private String mType;
    private String mIdLabel;
    private String mTimeLabel;
    private String mPlaceLabel;
    private String mOrganization;
    private String mLink;
    private Location mCoordinates;

    public Record() {
        //To change body of created methods use File | Settings | File Templates.
    }

    /**
     * Gets and sets the items title.
     */
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title.trim();
    }

    /**
     * Gets and sets the items thumbnail.
     */
    public String getThumbnailURL() {
        return mThumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.mThumbnailURL = thumbnailURL.trim();
        setThumbnail(thumbnailURL.trim());
    }

    /**
     * Gets and sets the items thumbnail.
     */
    public String getThumbnail() {
        return mThumbnailUrl;
    }

    private void setThumbnail(String thumbnailURL) {
        this.mThumbnailUrl = thumbnailURL;
    }

    /**
     * Gets and sets the items images.
     */
    public List<String> getImages() {
        return mImages;
    }

    public void setImages(String image) {
        if (!(image.contains("dokument") && image.contains("http://www.fmis.raa.se/fmis/")))
            this.mImages.add(image);
    }

    /**
     * Gets and sets the items description.
     */
    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        if (this.mDescription != null) {
            this.mDescription += "\n\n" + description.trim();
        } else {
            this.mDescription = description.trim();
        }
    }

    /**
     * Gets and sets the items type.
     */
    public String getType() {
        return mType;
    }

    public void setType(String type) {
        this.mType = type.trim();
    }

    /**
     * Gets and sets the items id label.
     */
    public String getIdLabel() {
        return mIdLabel;
    }

    public void setIdLabel(String idLabel) {
        this.mIdLabel = idLabel.trim();
    }

    /**
     * Gets and sets the items time label.
     */
    public String getTimeLabel() {
        return mTimeLabel;
    }

    public void setTimeLabel(String timeLabel) {
        this.mTimeLabel = timeLabel.trim();
    }

    /**
     * Gets and sets the items place label.
     */
    public String getPlaceLabel() {
        return mPlaceLabel;
    }

    public void setPlaceLabel(String placeLabel) {
        this.mPlaceLabel = placeLabel.trim();
    }

    /**
     * Gets and sets the items organization.
     */
    public String getOrganization() {
        return mOrganization;
    }

    public void setOrganization(String organization) {
        this.mOrganization = organization.trim();
    }

    /**
     * Gets and sets the source link.
     */
    public String getLink() {
        return mLink;
    }

    public void setLink(String link) {
        this.mLink = link.trim();
    }

    /**
     * Gets and sets the items coordinates.
     */
    public Location getCoordinates() {
        return mCoordinates;
    }

    public void setCoordinates(String coordinates) {
        String[] coords = coordinates.split("\\,");

        Double latitude = Double.parseDouble(coords[1]);
        Double longitude = Double.parseDouble(coords[0]);

        Location location = new Location("se.tidensavtryck");
        location.setLatitude(latitude);
        location.setLongitude(longitude);

        this.mCoordinates = location;
    }
}
