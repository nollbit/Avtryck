package se.tidensavtryck.gateway;

import java.io.InputStream;

public abstract class BaseXMLParser
{
	// names of the XML tags
	static final String TOTAL = "totalHits";
	static final String RECORDS = "records";
	static final String RECORD = "record";
	static final String TITLE = "itemLabel";
	static final String THUMBNAIL = "thumbnail";
	static final String IMAGE = "lowresSource";
	static final String DESCRIPTION = "description";
	static final String BYLINE = "byline";
	static final String TYPE = "type";
	static final String ID = "idLabel";
	static final String DATE = "timeLabel";
	static final String PLACE = "placeLabel";
	static final String ORGANIZATION = "organization";
	static final String LINK = "url";
	static final String COORDINATES = "coordinates";

	//The URL to the specified service
	private final InputStream mPlaceMockInputStream;

	/**
	 * Sets up the service URL for later use
	 * @param placeMockInputStream
	 */
	protected BaseXMLParser(InputStream placeMockInputStream)
	{
        this.mPlaceMockInputStream = placeMockInputStream;
	}

	/**
	 * Returns connects to server and returns its response.
	 * @return InputStream, the response from the server
	 */
	protected InputStream getInputStream()
	{
        return this.mPlaceMockInputStream;
	}
}
