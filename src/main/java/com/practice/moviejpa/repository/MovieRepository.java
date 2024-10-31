package com.practice.moviejpa.repository;

import com.practice.moviejpa.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByReleaseYear(short releaseYear);

    List<Movie> findAllByRatingGreaterThan(float rating);

    List<Movie> findAllByTitleContainingIgnoreCase(String word);

    List<Movie> findAllByReleaseYearBetween(short from, short to);

    List<Movie> findAllByReleaseYearInAndRatingBetween(Collection<Short> years, float from, float to);
}
