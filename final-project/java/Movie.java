public class Movie extends NetflixTitle {
    public Movie(String title, String director, String country, String releaseYear, String rating, String duration, String genre) {
        super(title, director, country, releaseYear, rating, duration, genre);
    }

    public void printAttributes() {
        System.out.println("Movie Title: " + this.getTitle());
        System.out.println("Movie Director: " + this.getDirector());
        System.out.println("Movie Country: " + this.getCountry());
        System.out.println("Movie Release Year: " + this.getReleaseYear());
        System.out.println("Movie Rating: " + this.getRating());
        System.out.println("Movie Duration: " + this.getDuration());
        System.out.println("Movie Genre: " + this.getGenre());
    }
}