public class TVShow extends NetflixTitle {
    public TVShow(String title, String director, String country, String releaseYear, String rating, String duration, String genre) {
        super(title, director, country, releaseYear, rating, duration, genre);
    }

    public void printAttributes() {
        System.out.println("TV Show Title: " + this.getTitle());
        System.out.println("TV Show Director: " + this.getDirector());
        System.out.println("TV Show Country: " + this.getCountry());
        System.out.println("TV Show Release Year: " + this.getReleaseYear());
        System.out.println("TV Show Rating: " + this.getRating());
        System.out.println("TV Show Duration: " + this.getDuration());
        System.out.println("TV Show Genre: " + this.getGenre());
    }
}