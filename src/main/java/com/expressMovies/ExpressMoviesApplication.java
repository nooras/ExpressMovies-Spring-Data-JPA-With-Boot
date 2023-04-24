package com.expressMovies;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.expressMovies.dto.DirectorDTO;
import com.expressMovies.dto.MovieDTO;
import com.expressMovies.service.MovieDirectorService;

@ComponentScan
@EnableJpaRepositories
@SpringBootApplication
public class ExpressMoviesApplication implements CommandLineRunner {

	@Autowired
	MovieDirectorService mdService;

	public static void main(String[] args) {
		SpringApplication.run(ExpressMoviesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
//			addMovieAndDirector();
//			getMovieDetailsByID();
			getAllMovie();
//			updateMovie();
//			deleteMovie();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void addMovieAndDirector() {
		DirectorDTO directorDTO1 = new DirectorDTO("sam", "gomez", "fferf in", "sam@gmail.com", 98765678);
		DirectorDTO directorDTO2 = new DirectorDTO("alex", "aa", "fferf in", "alex@gmail.com", 98765678);
		List<DirectorDTO> directorDTOList1 = new ArrayList<DirectorDTO>();
		directorDTOList1.add(directorDTO1);
		MovieDTO movieDTO1 = new MovieDTO("Soulmate", new Date(2022, 12, 01), new Date(2022, 12, 01), directorDTOList1);
		List<DirectorDTO> directorDTOList2 = new ArrayList<DirectorDTO>();
		directorDTOList2.add(directorDTO2);
		MovieDTO movieDTO2 = new MovieDTO("SpiderMan", new Date(2022, 12, 01), new Date(2022, 12, 01),
				directorDTOList2);

		System.out.println("-----Inserting Movie and Director------");
		System.out.println("Data inserted of MovieId: " + mdService.addMovieAndDirector(movieDTO1));
		System.out.println("Data inserted of MovieId: " + mdService.addMovieAndDirector(movieDTO2));
	}

	void getMovieDetailsByID() {
		System.out.println("-----Get Movie Details of id 1------");
		MovieDTO movie = mdService.getMovieDetails(1);
		System.out.println("-----Movie Details------");
		System.out.println("Movie Title: " + movie.getMovie_title());
		System.out.println("Movie Date Released: " + movie.getDate_released());
		System.out.println("Movie Date Running Time: " + movie.getMove_running_time());
		for (DirectorDTO director : movie.getDirectors()) {
			System.out.println("-----Director Details------");
			System.out.println("Director First Name: " + director.getFirst_Name());
			System.out.println("Director Last Name: " + director.getLast_Name());
			System.out.println("Director Mobile Number: " + director.getContact_Number());
			System.out.println("Director Address: " + director.getAddress());
			System.out.println("Director Email Id: " + director.getEmail());
		}
	}

	void getAllMovie() {
		System.out.println("-----Show All Movies------");
		List<MovieDTO> movies = mdService.getAllMovie();
		for (MovieDTO m : movies) {
			System.out.println("Movie Title: " + m.getMovie_title());
			System.out.println("Movie Date Released: " + m.getDate_released());
			System.out.println("Movie Date Running Time: " + m.getMove_running_time());
		}
	}

	void updateMovie() {
//		DirectorDTO directorDTOUpdate = new DirectorDTO("bob", "bb", "fferf in", "bob@gmail.com", 98765678);
//		List<DirectorDTO> directorDTOListUpdate = new ArrayList<DirectorDTO>();
//		directorDTOListUpdate.add(directorDTOUpdate);
		MovieDTO movieDTOUpdate = new MovieDTO("Soulmate S2", new Date(2022, 12, 01), new Date(2022, 12, 01));
		System.out.println("-----Updating Movies & Director Details------");
		mdService.updateMovie(1, movieDTOUpdate);
	}

	void deleteMovie() {
		System.out.println("-----Deleting Movies------");
		mdService.deleteMovie(3);
	}
}
