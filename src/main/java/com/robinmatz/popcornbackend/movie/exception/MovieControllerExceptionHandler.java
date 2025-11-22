package com.robinmatz.popcornbackend.movie.exception;

import com.robinmatz.popcornbackend.global.ErrorDto;
import com.robinmatz.popcornbackend.movie.controller.MovieController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = MovieController.class)
public class MovieControllerExceptionHandler {

  @ExceptionHandler(MovieNotFoundException.class)
  @ResponseBody
  public ErrorDto handleMovieNotFoundException(MovieNotFoundException ex) {
    return new ErrorDto(ex.getMessage());
  }
}
