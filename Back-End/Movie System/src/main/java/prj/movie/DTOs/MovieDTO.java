package prj.movie.DTOs;

import java.sql.Date;

public class MovieDTO
{
    private String title;
    private Date addedDate;

    public MovieDTO() {
    }

    public MovieDTO(String title, Date addedDate) {
        this.title = title;
        this.addedDate = addedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "title='" + title + '\'' +
                ", addedDate=" + addedDate +
                '}';
    }
}
