package prj.movie.data;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "seenmovie")
public class SeenMovie {
    @Id
    //@GeneratedValue
    @GeneratedValue(generator="system_uuid")
    @GenericGenerator(name = "system_uuid",strategy = "uuid")
    @Column(name = "date")
    private String date;//yyyy-mm-dd

    @ElementCollection
    @CollectionTable(name = "moiveid")
    private List<String> movieid;

    public SeenMovie() {
    }

    public SeenMovie(String date, List<String> movieid) {
        this.date = date;
        this.movieid = movieid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getMovieid() {
        return movieid;
    }

    public void setMovieid(List<String> movieid) {
        this.movieid = movieid;
    }

    @Override
    public String toString() {
        return "SeenMovie{" +
                "date='" + date + '\'' +
                ", movieid=" + movieid +
                '}';
    }
}
