public class Movie {
    // class attributes
    private String name;
    private String mipaaRating;
    private int num1Ratings;
    private int num2Ratings;
    private int num3Ratings;
    private int num4Ratings;
    private int num5Ratings;

    // constructor to initialize movie class
    public Movie(String name, String mipaaRating) {
        this.name = name;
        this.mipaaRating = mipaaRating;
        this.num1Ratings = 0;
        this.num2Ratings = 0;
        this.num3Ratings = 0;
        this.num4Ratings = 0;
        this.num5Ratings = 0;
    }

    // add rating function
    public void addRating(int rating) {
        // if the rating is a valid number, increment the corresponding count
        if (rating >= 1 && rating <= 5) {
            switch (rating) {
                case 1:
                    num1Ratings++;
                    break;
                case 2:
                    num2Ratings++;
                    break;
                case 3:
                    num3Ratings++;
                    break;
                case 4:
                    num4Ratings++;
                    break;
                case 5:
                    num5Ratings++;
                    break;
            }
        }
        // otherwise, tell the user that the rating is incorrect
        else {
            System.out.println("Incorrect rating");
        }
    }

    // function to compute the average rating score
    public double getAverage() {
        int denominator = num1Ratings + num2Ratings + num3Ratings + num4Ratings + num5Ratings;

        if (denominator == 0) {
            return 0;
        }

        double numerator = 1*num1Ratings + 2*num2Ratings + 3*num3Ratings + 4*num4Ratings + 5*num5Ratings;
        return numerator / denominator;
    }

    // function to get movie name
    public String getName() {
        return name;
    }

    // function to get mipaa rating
    public String getMipaaRating() {
        return mipaaRating;
    }
}


