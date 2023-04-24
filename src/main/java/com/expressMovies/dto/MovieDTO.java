package com.expressMovies.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class MovieDTO {
	private int movie_id;
	private String movie_title;
	private Date date_released;
	private Date move_running_time;
	private List<DirectorDTO> directors = new ArrayList<>();
	
	public MovieDTO(String movie_title, Date date_released, Date move_running_time,
			List<DirectorDTO> directors) {
		super();
		this.movie_title = movie_title;
		this.date_released = date_released;
		this.move_running_time = move_running_time;
		this.directors = directors;
	}
	
	public MovieDTO(String movie_title, Date date_released, Date move_running_time) {
		super();
		this.movie_title = movie_title;
		this.date_released = date_released;
		this.move_running_time = move_running_time;
	}

	public MovieDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public Date getDate_released() {
		return date_released;
	}

	public void setDate_released(Date date_released) {
		this.date_released = date_released;
	}

	public Date getMove_running_time() {
		return move_running_time;
	}

	public void setMove_running_time(Date move_running_time) {
		this.move_running_time = move_running_time;
	}

	public List<DirectorDTO> getDirectors() {
		return directors;
	}

	public void setDirectors(List<DirectorDTO> directors) {
		this.directors = directors;
	}
}
