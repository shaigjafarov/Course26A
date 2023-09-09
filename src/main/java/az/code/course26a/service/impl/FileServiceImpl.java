package az.code.course26a.service.impl;

import az.code.course26a.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {


    @Override
    public void uploadFile(MultipartFile multipartFile) throws IOException{


            // Define the target folder
            String uploadDirectory = "/Users/shaiqjafarov/IdeaProjects/Course26A/src/main/resources/files";
            UUID uuid = UUID.randomUUID();

            System.out.println( uuid.toString());
            // Generate a unique filename
            String uniqueFilename = uuid.toString()+System.currentTimeMillis() + "-" + multipartFile.getOriginalFilename();

            // Create the target file
            File targetFile = new File(uploadDirectory, uniqueFilename);

            // Save the file
            multipartFile.transferTo(targetFile);



    }
}
