package com.example.CyberSoftBuoi39.controller;

import com.example.CyberSoftBuoi39.entity.PostsEntity;
import com.example.CyberSoftBuoi39.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baiviet")
public class PostsController {

    @Autowired
    PostsRepository postsRepository;
    @GetMapping("")
    public ResponseEntity<?> getAllPosts(){

        List<PostsEntity> list = postsRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> addPost(@RequestParam int id, @RequestParam String tieude,
                                     @RequestParam String noidung, @RequestParam int idTacgia, @RequestParam String ngayviet){

        PostsEntity postsEntity = new PostsEntity();
        postsEntity.setId(id);
        postsEntity.setTieude(tieude);
        postsEntity.setNoidung(noidung);
        postsEntity.setIdTacgia(idTacgia);
        postsEntity.setNgayviet(ngayviet);
        postsRepository.save(postsEntity);

        return new ResponseEntity<>(postsEntity, HttpStatus.OK);
    }
    @DeleteMapping("")
    public ResponseEntity<?> deletePostById(@RequestParam int id){

        postsRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updatePost(@PathVariable int id, @RequestBody PostsEntity postsEntity){
        PostsEntity posts = postsRepository.findById(id).orElseThrow();

        posts.setTieude(postsEntity.getTieude());
        posts.setNoidung(postsEntity.getNoidung());
        posts.setIdTacgia(postsEntity.getIdTacgia());
        posts.setNgayviet(postsEntity.getNgayviet());

        postsRepository.save(posts);

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }


}
