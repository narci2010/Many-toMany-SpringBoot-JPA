/*  
 * Copyright 2010-2017 Tocean Group.  
 * 版权：商业代码，未经许可，禁止任何形式拷贝、传播及使用
 * 文件名：TestCascasdeController.java
 * 描述：  
 * 修改人：Administrator  
 * 修改时间：2017年11月23日  
 * 跟踪单号：  
 * 修改单号：  
 * 修改内容：  
 */
package me.moosecanswim.manytomany.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import me.moosecanswim.manytomany.Model.Actor;
import me.moosecanswim.manytomany.Model.Movie;
import me.moosecanswim.manytomany.Repository.ActorRepository;
import me.moosecanswim.manytomany.Repository.MovieRepository;
import me.moosecanswim.manytomany.Repository.MovieService;

@RestController
@Slf4j
public class TestCascasdeController {
	@Autowired
	ActorRepository actorRepository;
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	MovieService movieService;

	@RequestMapping("/create")
	public Movie create(@RequestBody Movie movie) {
		movieRepository.save(movie);
		return movie;
	}

	@RequestMapping("/update")
	// actor has id
	public Movie update(@RequestBody Movie movie) {

		movieRepository.save(movie);
		return movie;
	}

	@RequestMapping("/del")
	public void del(Long id) {
		log.debug("id:" + id);
		Movie tmp = movieRepository.findOne(id);
		movieRepository.delete(tmp);

	}

	@RequestMapping("/query")
	public void query(Long id) {
		log.debug("id:" + id);
		movieRepository.findOne(id);

	}

	@GetMapping("/gogo")
	public Movie gogo() {
		System.out.println("id");
		Movie m = movieRepository.findOne(1L);
		System.out.println(m.getTitle());
		Set<Actor> actors = m.getActors();
		for (Actor actor : actors) {
			System.out.println(actor.getName());
		}
		return m;

	}

}
