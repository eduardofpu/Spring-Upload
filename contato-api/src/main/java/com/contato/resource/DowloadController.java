package com.contato.resource;

import com.contato.model.Arquivo;
import com.contato.repository.ArquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/download")
public class DowloadController {

    @Autowired
    private ArquivoRepository arquivoRepository;

    private static final String DEFAULT_FILE_NAME = "java-tutorial.jpeg";

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public HttpEntity<byte[]> download(@RequestHeader Long id) {

        Optional<Arquivo> byId = arquivoRepository.findById(id);

        Arquivo download = byId.get();

        byte[] arquivo = download.getArquivo();

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("Content-Disposition", "attachment;filename=\""+ download.getNomeFoto() +"\"");

        HttpEntity<byte[]> entity = new HttpEntity<byte[]>( arquivo, httpHeaders);


        return entity;
    }

}
