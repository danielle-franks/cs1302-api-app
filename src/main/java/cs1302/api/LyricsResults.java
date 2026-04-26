package cs1302.api;


/**
 * Represents a lyrics record from the LRCLIB API.
 * This class maps to the individual lyrics objects returned by the
 * search and get endpoints.
 */
public class LyricsResults {
    public int id;
    public String trackName;
    public String artistName;
    public String albumName;
    public int duration;
    public boolean instrumental;
    public String plainLyrics;
    public String syncedLyrics;

} //LyricsResults
