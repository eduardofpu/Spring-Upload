package com.contato.Service;

import com.contato.model.ArquivoRepresentation;
import org.springframework.http.HttpEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FotoService {

    ArquivoRepresentation UploadFoto(MultipartFile foto);
    HttpEntity<byte[]> dowloadFoto(Long id);
}
