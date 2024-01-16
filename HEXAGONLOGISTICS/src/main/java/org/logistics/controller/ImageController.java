package org.logistics.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.ServletContextResource;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ImageController {
	
	 @Autowired
	    private ResourceLoader resourceLoader;

	    @GetMapping("/imageServlet")
	    @ResponseBody
	    public ResponseEntity<byte[]> getImage(@RequestParam String imageName) throws IOException {
	        try {
	            // ServletContextResource를 사용하여 웹 어플리케이션 루트 디렉토리 기준으로 접근
	            ServletContextResource resource = new ServletContextResource(((WebApplicationContext) resourceLoader).getServletContext(), "/resources/images/" + imageName);

	            if (resource.exists()) {
	                byte[] bytes = Files.readAllBytes(Paths.get(resource.getURI()));

	                HttpHeaders headers = new HttpHeaders();
	                headers.setContentType(MediaType.IMAGE_PNG);

	                return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
	            } else {
	                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
}