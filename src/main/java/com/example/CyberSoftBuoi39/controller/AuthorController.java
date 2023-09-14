package com.example.CyberSoftBuoi39.controller;

import com.example.CyberSoftBuoi39.entity.AuthorEntity;
import com.example.CyberSoftBuoi39.entity.PostsEntity;
import com.example.CyberSoftBuoi39.repository.AuthorRepository;
import com.example.CyberSoftBuoi39.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tacgia")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("")
    public ResponseEntity<?> getAllAuthors(){

        List<AuthorEntity> list = authorRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> addAuthor(@RequestParam int id, @RequestParam String tentacgia,
                                     @RequestParam String hoten, @RequestParam String gioitinh){

        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setId(id);
        authorEntity.setGioitinh(gioitinh);
        authorEntity.setTentacgia(tentacgia);
        authorEntity.setHoten(hoten);
        authorRepository.save(authorEntity);

        return new ResponseEntity<>(authorEntity, HttpStatus.OK);
    }
    @DeleteMapping("")
    public ResponseEntity<?> deleteAuthorById(@RequestParam int id){

        authorRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable int id, @RequestBody AuthorEntity authorEntity){
        AuthorEntity author = authorRepository.findById(id).orElseThrow();

        author.setHoten(authorEntity.getHoten());
        author.setTentacgia(authorEntity.getTentacgia());
        author.setGioitinh(authorEntity.getGioitinh());
        authorRepository.save(author);

        return new ResponseEntity<>(author, HttpStatus.OK);
    }




}
