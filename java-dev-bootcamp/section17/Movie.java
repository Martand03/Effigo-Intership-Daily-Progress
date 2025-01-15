package section17;

public class Movie {
    private String name;
    private String format;
    private double rating;


    // constructor
    public Movie(String name, String format, double rating){
        this.name = name;
        this.format = format;
        this.rating = rating;
    }

    // copy constructor
    public Movie( Movie source){
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    // toString method

    public String toString(){
        return this.rating + "\t" + this.format + "\t\t" + this.name + " ";
    }
}
