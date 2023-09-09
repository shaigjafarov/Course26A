package az.code.course26a.controller;

import az.code.course26a.service.FileService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;


@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {
    private final ResourceLoader resourceLoader;
    private final FileService fileService;

    @PostMapping("/upload")
    void employeePage(
            @RequestBody MultipartFile file) throws IOException {
        fileService.uploadFile(file);
    }

    @GetMapping("/download")
    ResponseEntity<Resource> employeePage(
            @RequestParam String fileName) throws MalformedURLException {


//        image name, id ,userid , excention


        Resource resource = resourceLoader.getResource("classpath:files/243c5ea4-857d-44a4-8797-2305dc183ce41694275787893-gul.png");
        // Define the file path
//        Path filePath = Path.of("classpath:/files/243c5ea4-857d-44a4-8797-2305dc183ce41694275787893-gul.png"); // Adjust the path
//
//         Load the file as a Resource
//        Resource resource = new UrlResource(filePath.toUri());

        if (resource.exists() && resource.isReadable()) {
            // Set the content type based on the file's MIME type
            String contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
            try {
                contentType = Files.probeContentType(resource.getFile().toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Set response headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(contentType));
            headers.setContentDispositionFormData("attachment", "gul.png");

            // Return the file as a ResponseEntity
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(resource);
        } else {
            // Handle the case when the file doesn't exist or is not readable
            return ResponseEntity.notFound().build();
        }



        // Load the file as a Resource
//        Resource resource = new UrlResource(filePath.toUri());
//        Resource resource = new ClassPathResource("/Users/shaiqjafarov/IdeaProjects/Course26A/src/main/resources/files/243c5ea4-857d-44a4-8797-2305dc183ce41694275787893-gul.png");
//        return new ResponseEntity<>(resource, HttpStatus.OK);
    }


}
