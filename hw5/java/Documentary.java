public class Documentary extends Movie {
    // TV rating of the type String
    private String tvRating;

    // constructor that creates an instance of a documentary by accepting inputs for all the instance variables: -- name, MIPAA rating, TV rating.
    public Documentary(String name, String mipaaRating, String tvRating) {
        //  inherits the name and MIPAA rating from the Movie class.
        super(name, mipaaRating);
        this.tvRating = tvRating;
    }

    // accessor method to get tv rating
    public String getTvRating() {
        return tvRating;
    }

    // mutator method to change tv rating
    public void setTvRating(String tvRating) {
        this.tvRating = tvRating;
    }

    // prints the values of all the instance variables for a given documentary
    public void writeOutput() {
        System.out.println("Name: " + getName());
        System.out.println("MIPAA rating: " + getMipaaRating());
        System.out.println("TV rating: " + tvRating);
    }
}