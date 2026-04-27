package cs1302.api;

/**
   Represents an individual result from an iTunes Search API query.
 * Contains data for a specific track, artist, and album.
 */
public class ItunesResult {
    public String trackName;
    public String artistName;
    public String collectionName;
    public String artworkUrl100;
    public double trackTimeMillis;

}
