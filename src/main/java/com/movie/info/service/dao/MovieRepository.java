package com.movie.info.service.dao;

import com.movie.info.service.bean.MovieInfo;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<MovieInfo,Integer> {
    ;
}
