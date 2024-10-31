package com.practice.moviejpa.controller;


import com.practice.moviejpa.model.Movie;
import com.practice.moviejpa.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    @GetMapping("/year/{releaseYear}")
    public List<Movie> findMoviesByReleaseYear(@PathVariable("releaseYear") short releaseYear) {
        return movieRepository.findAllByReleaseYear(releaseYear);
    }

    @GetMapping("/rating/greater/{rating}")
    public List<Movie> findMoviesByGreaterRating(@PathVariable("rating") float rating) {
        return movieRepository.findAllByRatingGreaterThan(rating);
    }

    @GetMapping("/title/{keyWord}")
    public List<Movie> findMoviesByKeyWord(@PathVariable("keyWord") String keyWord) {
        return movieRepository.findAllByTitleContainingIgnoreCase(keyWord);
    }

    @GetMapping("/years")
    public List<Movie> findMoviesBetweenYears(@RequestParam("from") short from,
                                              @RequestParam("to") short to) {
        return movieRepository.findAllByReleaseYearBetween(from, to);
    }

    @GetMapping("/years_rating")
    public List<Movie> findMoviesInYearsAndRatingBetween(@RequestParam("years") String years,
                                                         @RequestParam("from") float from,
                                                         @RequestParam("to") float to) {
        List<Short> yearsList = Arrays.stream(years.split(", "))
                .map(Short::parseShort)
                .toList();
        return movieRepository.findAllByReleaseYearInAndRatingBetween(yearsList,from, to);
    }
}
