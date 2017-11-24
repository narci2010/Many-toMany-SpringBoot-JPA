/*  
 * Copyright 2010-2017 Tocean Group.  
 * 版权：商业代码，未经许可，禁止任何形式拷贝、传播及使用
 * 文件名：MovieService.java
 * 描述：  
 * 修改人：Administrator  
 * 修改时间：2017年11月23日  
 * 跟踪单号：  
 * 修改单号：  
 * 修改内容：  
 */
package me.moosecanswim.manytomany.Repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tocean.common.entity.BaseServiceImpl;

import lombok.extern.slf4j.Slf4j;
import me.moosecanswim.manytomany.Model.Movie;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author Administrator
 * @version 1.0.0
 * @see MovieService
 * @since 2017年11月23日
 */
@Service
@Slf4j
public class MovieService extends BaseServiceImpl<Movie, Long> {
	@Autowired
	private MovieDao movieDao;

	/**
	 * 
	 * Description: 1、初始化dao
	 * 
	 * @see
	 */
	@PostConstruct
	public void init() {
		log.debug("enter init...");
		super.setBaseDao(movieDao);
	}

}
