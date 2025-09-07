import java.io.Serializable;

public class SeriesModel implements Serializable {
    private static final long serialVersionUID = 1L;  // Recommended for Serializable classes

    private String seriesId;
    private String seriesName;
    private int seriesAge;
    private int numberOfEpisodes;

    public SeriesModel(String seriesId, String seriesName, int seriesAge, int numberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public int getSeriesAge() {
        return seriesAge;
    }

    public void setSeriesAge(int seriesAge) {
        this.seriesAge = seriesAge;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    @Override
    public String toString() {
        return "ID: " + seriesId +
               ", Name: " + seriesName +
               ", Age Restriction: " + seriesAge +
               ", Episodes: " + numberOfEpisodes;
    }
}
