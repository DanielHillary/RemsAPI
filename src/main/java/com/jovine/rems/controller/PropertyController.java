package com.jovine.rems.controller;

import com.jovine.rems.entity.Property;
import com.jovine.rems.entity.StandardResponse;
import com.jovine.rems.repository.PropertyRepository;
import com.jovine.rems.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/createproperty")
    public ResponseEntity<StandardResponse> createProperty(@RequestBody Property property){
        return propertyService.createProperty(property);
    }

    @PostMapping("/uploadphoto")
    public ResponseEntity<StandardResponse> uploadPhoto(@RequestParam("image")MultipartFile multipartFile,
                                                        @RequestParam("propertyId") Long propertyId){
        return propertyService.uploadPhoto(multipartFile, propertyId);
    }

}
