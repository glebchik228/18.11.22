package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ThemeController {
    private List<Theme> themes = new ArrayList<Theme>();

    @PostMapping("themes")
    public ResponseEntity<Void> addTheme(@RequestBody Theme theme){
        themes.add(theme);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("themes/{index}")
    public ResponseEntity<Void> deleteTheme(@PathVariable("index") Integer index){
        themes.remove(index);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("themes")
    public ResponseEntity<List<Theme>> getThemes(){
        return ResponseEntity.ok(themes);
    }

    @PutMapping("themes/{index}")
    public ResponseEntity<Void> putTheme(@PathVariable("index") Integer index, @RequestBody Theme theme){
        themes.remove(index);
        themes.add(index, theme);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("themes/count")
    public ResponseEntity<Integer> getCountOfThemes(){
        return ResponseEntity.ok(themes.size());
    }

    @DeleteMapping("themes")
    public ResponseEntity<Void> deleteAllThemes(){
        themes.clear();
        return ResponseEntity.accepted().build();
    }

    @GetMapping("themes/{index}")
    public ResponseEntity<Theme> getTheme(@PathVariable("index") Integer index){
        return ResponseEntity.ok(themes.get(index));
    }
    @PutMapping("themes/{index}/comments")
    public ResponseEntity<Void> putComment(@PathVariable("index") Integer index, @RequestBody User user,@RequestBody String text){
        Comment comment = new Comment(user, themes.get(index), text);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("themes/{index}/comments")
    public ResponseEntity<Void> deleteComments(@PathVariable("index") Integer index){
        themes.get(index).clearThemeOfComments();
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("themes/{index}/comments")
    public ResponseEntity<Void> deleteComment(@PathVariable("index") Integer index, @RequestBody User user){
        themes.get(index).clearThemeOfUserComment(user);
        return ResponseEntity.accepted().build();
    }
}
