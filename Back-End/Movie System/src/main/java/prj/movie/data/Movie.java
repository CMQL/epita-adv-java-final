package prj.movie.data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String externalId;

    @Column(name = "name")
    private String title;

    @Column(name = "date")
    private Date added;

    @ManyToOne
    @JoinColumn(name = "seenmovie")
    private SeenMovie seenMovie;

    public Movie() {
    }

    public Movie(String externalId, String title, Date added, SeenMovie seenMovie) {
        this.externalId = externalId;
        this.title = title;
        this.added = added;
        this.seenMovie = seenMovie;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public SeenMovie getSeenMovie() {
        return seenMovie;
    }

    public void setSeenMovie(SeenMovie seenMovie) {
        this.seenMovie = seenMovie;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "externalId='" + externalId + '\'' +
                ", title='" + title + '\'' +
                ", added=" + added +
                ", seenMovie=" + seenMovie +
                '}';
    }
}
