package com.movie.info.service.controller;

import com.movie.info.service.bean.MovieInfo;
import com.movie.info.service.dao.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;


@RestController
@RequestMapping(value = "/movie/info")
public class MovieInfoController {

    @Autowired
    private MovieRepository moveInfo;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<String>("Test movie info..", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<MovieInfo>> getMovieDetailsAll() {
        return new ResponseEntity<Iterable<MovieInfo>>(moveInfo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Optional<MovieInfo>> getMovieId(@PathVariable("movieId") Integer movieId) {
        return new ResponseEntity<Optional<MovieInfo>>(moveInfo.findById(movieId), HttpStatus.OK);
    }

}