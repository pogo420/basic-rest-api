package com.movie.info.service.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MovieInfo {
    // Java bean which is linked with MySQL
    @Id
    private Integer movie_id = null;
    private String movie_name = null;
    private String movie_description = null;
    private String release_date = null;
    private String create_date = null;
    private String update_date = null;

    public MovieInfo() {

    }

    public MovieInfo(Integer movie_id, String movie_name, String movie_description, String release_date, String create_date, String update_date) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.movie_description = movie_description;
        this.release_date = release_date;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public int getMovie_id() {
            return movie_id;
        }

    public String getMovie_name() {
        return movie_name;
    }

    public String getMovie_description() {
        return movie_description;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getCreate_date() {
        return create_date;
    }

    public String getUpdate_date() {
        return update_date;
    }

}
