package com.lms.presentation;

import com.lms.persistence.Course;
import com.lms.persistence.Lesson;
import com.lms.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<String> createCourse(@RequestBody Course course) {
        courseService.createCourse(course);
        return ResponseEntity.ok("Course created successfully!");
    }

    @PostMapping("/{courseId}/media")
    public ResponseEntity<String> uploadMedia(@PathVariable Long courseId, @RequestParam("file") MultipartFile file) {
        courseService.uploadMedia(courseId, file);
        return ResponseEntity.ok("Media uploaded successfully!");
    }

    @GetMapping("/{courseId}/media")
    public ResponseEntity<List<String>> getMediaForCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseService.getMediaForCourse(courseId));
    }

    @PostMapping("/{courseId}/lessons")
    public ResponseEntity<String> addLessonToCourse(@PathVariable Long courseId, @RequestBody Lesson lesson) {
        courseService.addLessonToCourse(courseId, lesson);
        return ResponseEntity.ok("Lesson added successfully!");
    }

    @GetMapping("/{courseId}/lessons")
    public ResponseEntity<List<Lesson>> getLessonsForCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseService.getLessonsForCourse(courseId));
    }
}

