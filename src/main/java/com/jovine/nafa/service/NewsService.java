package com.jovine.nafa.service;

import com.jovine.nafa.entity.Leagues;
import com.jovine.nafa.entity.News;
import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public ResponseEntity<StandardResponse> createNews(News news) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successfully created", newsRepository.save(news));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not create news");
        }
    }

    public ResponseEntity<StandardResponse> getNEWS(Long newsId) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successfully created", newsRepository.findById(newsId));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get news");
        }
    }

    public ResponseEntity<StandardResponse> getAllNEWS() {
        try {
            return StandardResponse.sendHttpResponse(true, "Successfully created", newsRepository.findAll());
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get news");
        }
    }

    public ResponseEntity<StandardResponse> getNEWSByCategory(String category) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successfully created", newsRepository.findByCategory(category));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not fetch news category");
        }
    }

    public ResponseEntity<StandardResponse> deleteNEWS(Long newsId) {
        try {
            newsRepository.deleteById(newsId);
            return StandardResponse.sendHttpResponse(true, "Successfully created");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete news");
        }
    }
    public ResponseEntity<StandardResponse> deleteAllNEWS() {
        try {
            newsRepository.deleteAll();
            return StandardResponse.sendHttpResponse(true, "Successfully created");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete all news");
        }
    }

    public ResponseEntity<StandardResponse> updateNEWSDetails(News news) {
        try {
            News newsDB = newsRepository.findById(news.getNewsId()).get();
            if(Objects.nonNull(news.getNewsCaption()) && !"".equalsIgnoreCase(news.getNewsCaption())) {
                newsDB.setNewsCaption(news.getNewsCaption());
            }

            if(Objects.nonNull(news.getDescription()) && !"".equalsIgnoreCase(news.getDescription())) {
                newsDB.setDescription(news.getDescription());
            }

            if(Objects.nonNull(news.getContent()) && !"".equalsIgnoreCase(news.getContent())) {
                newsDB.setContent(news.getContent());
            }

            if(Objects.nonNull(news.getCategory()) && !"".equalsIgnoreCase(news.getCategory())) {
                newsDB.setCategory(news.getCategory());
            }

            return StandardResponse.sendHttpResponse(true, "Successful", newsRepository.save(newsDB));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not update League info");
        }
    }
}
