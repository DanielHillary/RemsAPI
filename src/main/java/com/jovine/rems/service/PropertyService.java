package com.jovine.rems.service;

import com.jovine.rems.entity.Property;
import com.jovine.rems.entity.StandardResponse;
import com.jovine.rems.entity.User;
import com.jovine.rems.repository.PropertyRepository;
import com.jovine.rems.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public ResponseEntity<StandardResponse> createProperty(Property property) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successfully created property", propertyRepository.save(property));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not create property");
        }
    }

    public ResponseEntity<StandardResponse> getAllProperties(){
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", propertyRepository.findAll());
        } catch (Exception e) {
            return  StandardResponse.sendHttpResponse(false, "Could not get all properties");
        }
    }

    public ResponseEntity<StandardResponse> getPropertyById(Long id){
        try {
            Property propert;
            Optional<Property> property = propertyRepository.findById(id);
            if(property.isPresent()){
                propert = property.get();
                return StandardResponse.sendHttpResponse(true, "Successful", propert);
            }else {
                return StandardResponse.sendHttpResponse(false, "Property doesn't exist in our database");
            }
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not find property");
        }
    }

    public ResponseEntity<StandardResponse> getPropertyByState(String state){
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", propertyRepository.findByState(state));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get property");
        }
    }

    public ResponseEntity<StandardResponse> updateProperty(Property property){
        try {
            return StandardResponse.sendHttpResponse(true, "Successfully created property", propertyRepository.save(property));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not create property");
        }
    }

    public ResponseEntity<StandardResponse> deleteAllProperties(){
        try {
            propertyRepository.deleteAll();
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete property");
        }
    }

    public ResponseEntity<StandardResponse> deleteAllPropertiesInState(String state){
        try {
            propertyRepository.deleteByState(state);

//            List<Property> propertyList = propertyRepository.findByState(state);
//            for(Property pr : propertyList){
//                propertyRepository.delete(pr);
//            }
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete property");
        }
    }

    public ResponseEntity<StandardResponse> deletePropertyById(Long id){
        try {
            propertyRepository.deleteById(id);
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete property");
        }
    }

    public ResponseEntity<StandardResponse> uploadPhoto(MultipartFile multipartFile, Long propertyId) {
        try {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

            Property property = propertyRepository.findById(propertyId).get();
            property.setPhoto(fileName);

            Property saveProperty = propertyRepository.save(property);

            String uploadDir = "property-photos/" + property.getPropertyId();

            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not upload photo");
        }
    }
}
