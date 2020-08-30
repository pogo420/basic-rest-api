package com.movie.info.service.controller;

import com.movie.info.service.bean.AuthenticationRequest;
import com.movie.info.service.bean.AuthenticationResponse;
import com.movie.info.service.bean.MovieInfo;
import com.movie.info.service.dao.MovieRepository;
import com.movie.info.service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(value = "/movie/info")
public class MovieInfoController {

    @Autowired
    private MovieRepository moveInfo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<AuthenticationResponse> authenticateTokenCreate(
            @RequestBody AuthenticationRequest authenticationRequest) throws Exception{

        try { // userid/password validation
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()
                    )
            );
        }
        catch (BadCredentialsException e){
              throw new Exception("Incorrect Username/Password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return  new ResponseEntity<AuthenticationResponse>(
                new AuthenticationResponse(jwt), HttpStatus.OK);
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