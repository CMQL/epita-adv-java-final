package prj.movie.data;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "theuser")
public class User {
    @Id
    @GeneratedValue(generator="system_uuid")
    @GenericGenerator(name = "system_uuid",strategy = "uuid")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private String userid;

    @Column(name = "username")
    private String username;

    @ManyToOne
    @JoinColumn(name = "seenmovie")
    private SeenMovie seenMovie;

    @OneToOne
    @JoinColumn(name = "contact", nullable = false)
    private Contact contact;

    public User() {
    }

    public User(String userid, String username, SeenMovie seenMovie, Contact contact) {
        this.userid = userid;
        this.username = username;
        this.seenMovie = seenMovie;
        this.contact = contact;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SeenMovie getSeenMovie() {
        return seenMovie;
    }

    public void setSeenMovie(SeenMovie seenMovie) {
        this.seenMovie = seenMovie;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", seenMovie=" + seenMovie +
                ", contact=" + contact +
                '}';
    }
}
