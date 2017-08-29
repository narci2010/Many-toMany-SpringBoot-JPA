package me.moosecanswim.manytomany.Repository;

import me.moosecanswim.manytomany.Model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
