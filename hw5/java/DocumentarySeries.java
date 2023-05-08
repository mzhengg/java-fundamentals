public class DocumentarySeries extends Documentary {
    private int numSeasons;
    private int numEpisodes;

    // constructor that creates an instance of a DocumentarySeries by accepting inputs for all the instance variables: -- name, MIPAA rating, TV rating, number of seasons, and number of episodes.
    public DocumentarySeries(String name, String mipaaRating, String tvRating, int numSeasons, int numEpisodes) {
        // inherits the name and MIPAA rating from the Movie class, and TV rating from the Documentary class
        super(name, mipaaRating, tvRating);

        // In addition, DocumentarySeries adds two variables -- number of seasons and number of episodes of type int
        this.numSeasons = numSeasons;
        this.numEpisodes = numEpisodes;
    }

    // accessor method to get number of seasons
    public int getNumSeasons() {
        return numSeasons;
    }

    // mutator method to change the number of seasons
    public void setNumSeasons(int numSeasons) {
        this.numSeasons = numSeasons;
    }

    // accessor method to get number of episodes
    public int getNumEpisodes() {
        return numEpisodes;
    }

    // mutator method to change the number of episodes
    public void setNumEpisodes(int numEpisodes) {
        this.numEpisodes = numEpisodes;
    }

    // method that prints the values of all the instance variables for a given documentary series.
    public void writeOutput() {
        super.writeOutput();
        System.out.println("Number of seasons: " + numSeasons);
        System.out.println("Number of episodes: " + numEpisodes);
    }
}