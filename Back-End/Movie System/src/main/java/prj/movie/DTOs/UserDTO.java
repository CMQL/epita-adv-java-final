package prj.movie.DTOs;

import prj.movie.data.Movie;

import java.util.List;

public class UserDTO
{
    private String userid;
    private String username;
    private String role;

    public UserDTO() {
    }

    public UserDTO(String userid, String username, String role) {
        this.userid = userid;
        this.username = username;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
