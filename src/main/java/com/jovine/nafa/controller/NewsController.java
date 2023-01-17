package com.jovine.nafa.controller;

import com.jovine.nafa.entity.News;
import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @PostMapping("/createnews")
    public ResponseEntity<StandardResponse> createNews(@RequestBody News news){
        return newsService.createNews(news);
    }
    @GetMapping("/getnews")
    public ResponseEntity<StandardResponse> getNews(@RequestParam("newsId") Long newsId){
        return newsService.getNEWS(newsId);
    }
    @GetMapping("/getallnews")
    public ResponseEntity<StandardResponse> getAllNews(){
        return newsService.getAllNEWS();
    }
    @GetMapping("/getnewscategory")
    public ResponseEntity<StandardResponse> getNEWSByCategory(@RequestParam("category") String category){
        return newsService.getNEWSByCategory(category);
    }
    @PutMapping("/updatenews")
    public ResponseEntity<StandardResponse> updateNEWSDetails(@RequestBody News news){
        return newsService.updateNEWSDetails(news);
    }
    @DeleteMapping("/deletenews")
    public ResponseEntity<StandardResponse> deleteNews(@RequestParam("newsId") Long newsId){
        return newsService.deleteNEWS(newsId);
    }
    @DeleteMapping("/deleteallnews")
    public ResponseEntity<StandardResponse> deleteAllNEWS(){
        return newsService.deleteAllNEWS();
    }
}
