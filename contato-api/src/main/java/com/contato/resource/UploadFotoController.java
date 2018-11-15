package com.contato.resource;

import com.contato.Service.FotoService;
import com.contato.model.ArquivoRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/foto")
public class UploadFotoController {

    @Autowired
    private FotoService fotoService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    ArquivoRepresentation UploadArquivo(@RequestParam MultipartFile foto) {
        return fotoService.UploadFoto(foto);
    }
}
