package com.contato.resource;

import com.contato.Service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/download")
public class DowloadFotoController {
    @Autowired
    private FotoService fotoService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public HttpEntity<byte[]> download(@RequestHeader Long id) {
        return fotoService.dowloadFoto(id);
    }
}
