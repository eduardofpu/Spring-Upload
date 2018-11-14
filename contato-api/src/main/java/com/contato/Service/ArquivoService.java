package com.contato.Service;

import com.contato.model.ArquivoRepresentation;
import org.springframework.web.multipart.MultipartFile;

public interface ArquivoService {
    ArquivoRepresentation UploadArquivo(MultipartFile foto);
}
