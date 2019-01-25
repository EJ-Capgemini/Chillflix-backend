package com.angular.backend.Chillflix.controller;

import com.angular.backend.Chillflix.model.Video;
import com.angular.backend.Chillflix.repository.VideoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/video")
public class VideoController {
    @Autowired
    private VideoRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(VideoController.class);

    HttpHeaders headers;


    public VideoController(VideoRepository repository) {
        headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");

        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Video> all() {
        LOGGER.info("/all aangeroepen.");
        return repository.findAll();
    }

    @PostMapping("/add")
    public Video addVideo(@RequestBody Video video) {
        LOGGER.info("/add aangeroepen voor video: " + video.toString());
        return repository.save(video); //kopie met alles
    }

    @GetMapping("/get/{id}")
    public Video getVideo(@PathVariable String id) throws EntityNotFoundException {
        LOGGER.info("/get/{id} aangeroepen.");
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    //Hier geen ResponseEntity gebruiken! Gaat dan lastig doen over de extra headers. -> CORS
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateVideo(@RequestBody Video video, @PathVariable String id) {
        LOGGER.info("/update/{id} aangeroepen.");
        Optional<Video> videoOptional = repository.findById(id);

        if (!videoOptional.isPresent())
            return ResponseEntity.notFound().build();

        video.setId(id);

        repository.save(video);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVideo(@PathVariable String id) {
        LOGGER.info("/delete/{id} aangeroepen.");
        repository.deleteById(id);
    }
}
