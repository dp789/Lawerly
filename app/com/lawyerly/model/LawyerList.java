package app.com.lawyerly.model;



public class LawyerList {

    public double getLawyersRating() {
        return lawyersRating;
    }

    private double lawyersRating;
    private double lawyerPrice;

    public LawyerList( double lawyersRating, double lawyerPrice) {
        this.lawyersRating = lawyersRating;
        this.lawyerPrice = lawyerPrice;
    }


    public double getLawyerPrice() {
        return lawyerPrice;
    }


}
