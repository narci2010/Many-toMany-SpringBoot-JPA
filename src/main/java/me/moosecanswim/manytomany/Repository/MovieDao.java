/*  
 * Copyright 2010-2017 Tocean Group.  
 * 版权：商业代码，未经许可，禁止任何形式拷贝、传播及使用
 * 文件名：MovieDao.java
 * 描述：  
 * 修改人：Administrator  
 * 修改时间：2017年11月23日  
 * 跟踪单号：  
 * 修改单号：  
 * 修改内容：  
 */
package me.moosecanswim.manytomany.Repository;

import org.springframework.stereotype.Repository;

import com.tocean.common.entity.BaseDaoImpl;

import me.moosecanswim.manytomany.Model.Movie;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author Administrator
 * @version 1.0.0
 * @see MovieDao
 * @since 2017年11月23日
 */
@Repository("movieDao")
public class MovieDao extends BaseDaoImpl<Movie, Long> {

}
