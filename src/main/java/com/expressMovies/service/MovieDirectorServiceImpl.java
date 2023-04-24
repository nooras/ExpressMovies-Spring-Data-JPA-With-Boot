package com.expressMovies.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expressMovies.dto.DirectorDTO;
import com.expressMovies.dto.MovieDTO;
import com.expressMovies.entity.Director;
import com.expressMovies.entity.Movie;
import com.expressMovies.repository.MovieRepository;

@Service("movieDirectorService")
public class MovieDirectorServiceImpl implements MovieDirectorService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Integer addMovieAndDirector(MovieDTO movieDTO) {
		List<Director> directors = new ArrayList<>();
		for (DirectorDTO directorDTO : movieDTO.getDirectors()) {
			Director director = new Director();
			director.setFirst_Name(directorDTO.getFirst_Name());
			director.setLast_Name(directorDTO.getLast_Name());
			director.setEmail(directorDTO.getEmail());
			director.setContact_Number(directorDTO.getContact_Number());
			director.setAddress(directorDTO.getAddress());
			directors.add(director);
		}
		Movie movie = new Movie();
		movie.setMovie_title(movieDTO.getMovie_title());
		movie.setDate_released(movieDTO.getDate_released());
		movie.setMove_running_time(movieDTO.getMove_running_time());
		movie.setDirectors(directors);
		movieRepository.save(movie);
		return movie.getMovie_id();
	}

	@Override
	public MovieDTO getMovieDetails(Integer movie_id) {
		Optional<Movie> optional = movieRepository.findById(movie_id);
		Movie movie = optional.orElseThrow();

		List<DirectorDTO> directorsDto = new ArrayList<>();
		for (Director director : movie.getDirectors()) {
			DirectorDTO directorDTO = new DirectorDTO();
			directorDTO.setDirector_Id(director.getDirector_Id());
			directorDTO.setFirst_Name(director.getFirst_Name());
			directorDTO.setLast_Name(director.getLast_Name());
			directorDTO.setEmail(director.getEmail());
			directorDTO.setContact_Number(director.getContact_Number());
			directorDTO.setAddress(director.getAddress());
			directorsDto.add(directorDTO);
		}
		MovieDTO movieDTO = new MovieDTO();
		movieDTO.setMovie_id(movie.getMovie_id());
		movieDTO.setMovie_title(movie.getMovie_title());
		movieDTO.setDate_released(movie.getDate_released());
		movieDTO.setMove_running_time(movie.getMove_running_time());
		movieDTO.setDirectors(directorsDto);
		return movieDTO;
	}

	@Override
	public List<MovieDTO> getAllMovie() {
		List<MovieDTO> moviesDTO = new ArrayList<>();
		Iterable<Movie> iterableMovies = movieRepository.findAll();
		for (Movie m : iterableMovies) {
			List<DirectorDTO> directorsDto = new ArrayList<>();
			for (Director d : m.getDirectors()) {
				DirectorDTO directorDTO = new DirectorDTO();
				directorDTO.setDirector_Id(d.getDirector_Id());
				directorDTO.setFirst_Name(d.getFirst_Name());
				directorDTO.setLast_Name(d.getLast_Name());
				directorDTO.setEmail(d.getEmail());
				directorDTO.setContact_Number(d.getContact_Number());
				directorDTO.setAddress(d.getAddress());
				directorsDto.add(directorDTO);
			}
			MovieDTO movieDTO = new MovieDTO();
			movieDTO.setMovie_id(m.getMovie_id());
			movieDTO.setMovie_title(m.getMovie_title());
			movieDTO.setDate_released(m.getDate_released());
			movieDTO.setMove_running_time(m.getMove_running_time());
			movieDTO.setDirectors(directorsDto);
			moviesDTO.add(movieDTO);
		}
		return moviesDTO;
	}

	@Override
	public void updateMovie(Integer movie_id, MovieDTO movieDTO) {
		// TODO Auto-generated method stub
		Optional<Movie> optional = movieRepository.findById(movie_id);
		Movie movie = optional.orElseThrow();
		List<Director> directors = new ArrayList<>();
		for (DirectorDTO directorDTO : movieDTO.getDirectors()) {
			Director director = new Director();
			director.setFirst_Name(directorDTO.getFirst_Name());
			director.setLast_Name(directorDTO.getLast_Name());
			director.setEmail(directorDTO.getEmail());
			director.setContact_Number(directorDTO.getContact_Number());
			director.setAddress(directorDTO.getAddress());
			directors.add(director);
		}
		movie.setMovie_title(movieDTO.getMovie_title());
		movie.setDate_released(movieDTO.getDate_released());
		movie.setMove_running_time(movieDTO.getMove_running_time());
		movie.setDirectors(directors);
		movieRepository.save(movie);
	}

	@Override
	public void deleteMovie(Integer movie_id) {
		movieRepository.deleteById(movie_id);
	}

}
