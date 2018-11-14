package com.contato.resource;

import com.contato.Service.ArquivoService;
import com.contato.model.ArquivoRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/arquivo")
public class UploadController {

    @Autowired
    private ArquivoService arquivoService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    ArquivoRepresentation UploadArquivo(@RequestParam MultipartFile foto) {
       return arquivoService.UploadArquivo(foto);
    }
}
