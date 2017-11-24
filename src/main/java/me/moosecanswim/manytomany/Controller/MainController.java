package me.moosecanswim.manytomany.Controller;

import me.moosecanswim.manytomany.Model.Actor;
import me.moosecanswim.manytomany.Model.Movie;
import me.moosecanswim.manytomany.Repository.ActorRepository;
import me.moosecanswim.manytomany.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class MainController {
	@Autowired
	ActorRepository actorRepository;
	@Autowired
	MovieRepository movieRepository;

	@RequestMapping("/")
	public @ResponseBody String index() {
		// first add an actor
		Actor actor = new Actor();
		actor.setName("Sandra Bullock");
		actor.setRealname("Sandra Mae Bullowski");
		actorRepository.save(actor);

		// create a movie
		Movie movie = new Movie();
		movie.setTitle("Emoji Movie");
		movie.setYear(2017);
		movie.setDescription("About Emojis...");
		movie.addActor(actor);

		movieRepository.save(movie);

		// Add the movie to an empty set
		Set<Movie> movies = new HashSet<Movie>();
		movies.add(movie);

		// add the list of movies to the actors movie list
		// actor.setMovies(movies);
		// actor.addMovie(movie);

		return "results added";

	}

	@RequestMapping(value = "/addMovie", method = RequestMethod.GET)
	public String addMovies(Model toSend) {
		toSend.addAttribute("aMovie", new Movie());
		return "FormMovie";

	}

	@RequestMapping(value = "/addMovie", method = RequestMethod.POST)
	public String processMovies(@Valid Movie aMovie, BindingResult result) {
		if (result.hasErrors()) {
			return "FormMovie";
		}
		movieRepository.save(aMovie);
		return "redirect:/showMovies";
	}

	@RequestMapping("/showMovies")
	public String showMovies(Model model) {
		model.addAttribute("listMovies", movieRepository.findAll());
		return "showMovies";
	}

}
