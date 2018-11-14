package com.contato.Service;

import com.contato.model.Arquivo;
import com.contato.model.ArquivoRepresentation;
import com.contato.repository.ArquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ArquivoImp implements ArquivoService{

    @Autowired
    private ArquivoRepository arquivoRepository;

    @Override
    public ArquivoRepresentation UploadArquivo(MultipartFile arquivo) {

        Arquivo nomeArquivo = salvar(arquivo);

        ArquivoRepresentation params = ArquivoRepresentation.builder()
                .id(nomeArquivo.getId())
                .nomeFoto(nomeArquivo.getNomeFoto())
                .build();

        return params;
    }

    public Arquivo salvar(MultipartFile arquivo) {

        Arquivo request = new Arquivo();
        String originalFilename = arquivo.getOriginalFilename();

        Arquivo create;

        try {

             create = request.builder()
                    .nomeFoto(originalFilename)
                    .arquivo(arquivo.getBytes()).build();

            arquivoRepository.save(create);

        } catch (IOException e) {
            throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
        }

        return create;
    }
}
