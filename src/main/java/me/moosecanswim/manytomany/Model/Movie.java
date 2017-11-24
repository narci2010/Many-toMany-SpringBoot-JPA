package me.moosecanswim.manytomany.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private long year;
	private String description;

	@ManyToMany(cascade= {CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinTable(name = "t_actor_movie", joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = {
			@JoinColumn(name = "actor_id") })
	private Set<Actor> actors;

	public Movie() {
		this.actors = new HashSet<Actor>(); // what is this for?
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addActor(Actor anActor) {
		System.out.println("adding an actor: " + anActor.toString());
		this.actors.add(anActor);
	}

	@Override
	public String toString() {
		return this.title;
	}
}
