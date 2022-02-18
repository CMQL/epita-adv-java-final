package prj.movie.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "userid")
    private String userid;

    @ManyToOne
    @JoinColumn(name = "roleuser")
    private User user;

    @Column(name = "name")
    private String name;


    public Role() {
    }

    public Role(String userid, User user, String name) {
        this.userid = userid;
        this.user = user;
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "userid='" + userid + '\'' +
                ", user=" + user +
                ", name='" + name + '\'' +
                '}';
    }
}
