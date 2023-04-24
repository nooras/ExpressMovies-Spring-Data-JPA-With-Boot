package com.expressMovies.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.expressMovies.dto.MovieDTO;

@Service
public interface MovieDirectorService {
	public Integer addMovieAndDirector(MovieDTO movieDTO);

	public MovieDTO getMovieDetails(Integer movie_id);

	public List<MovieDTO> getAllMovie();

	public void updateMovie(Integer movie_id, MovieDTO movieDTO);

	public void deleteMovie(Integer movie_id);
}
