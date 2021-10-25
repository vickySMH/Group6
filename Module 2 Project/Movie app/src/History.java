import java.util.Date;

public class History implements java.io.Serializable {

    private Date watchedDate;
    private Date addedDate;
    private Movie movie;


    public void setWatchedDate(Date watchedDate){
        this.watchedDate = watchedDate;
    }
    public Date getWatchedDate(){
        return watchedDate;
    }


    public void setAddedDate(Date addedDate){
        this.addedDate = addedDate;
    }
    public Date getAddedDate(){
        return addedDate;
    }


    public void setMovie(Movie movie){
        this.movie = movie;
    }
    public Movie getMovie(){
        return movie;
    }
}
