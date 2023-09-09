package az.code.course26a.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {


    
    void uploadFile(MultipartFile multipartFile) throws IOException;




    


}
