package me.moosecanswim.manytomany.Repository;

import me.moosecanswim.manytomany.Model.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor,Long> {
}
