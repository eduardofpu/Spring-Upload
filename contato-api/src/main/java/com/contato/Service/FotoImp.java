package com.contato.Service;

import com.contato.model.Foto;
import com.contato.model.ArquivoRepresentation;
import com.contato.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

import static com.contato.utils.MediaTypeUtils.extensionFoto;
import static java.lang.String.valueOf;

@Service
public class FotoImp implements FotoService {

    @Autowired
    private FotoRepository arquivoRepository;

    @Override
    public ArquivoRepresentation UploadFoto(MultipartFile arquivo) {
        Foto dados = salvar(arquivo);
        ArquivoRepresentation params = getArquivoRepresentation(dados);
        return params;
    }

    @Override
    public HttpEntity<byte[]> dowloadFoto(Long id) {
        Optional<Foto> byId = arquivoRepository.findById(id);
        Foto download = byId.get();

        MediaType extension = MediaType.valueOf(valueOf("image/" + extensionFoto(download)));
        byte[] arquivo = download.getArquivo();
        HttpEntity<byte[]> entity = getHttpEntity(download, extension, arquivo);
        return entity;
    }


    private Foto salvar(MultipartFile arquivo) {
        Foto request = new Foto();
        String originalFilename = arquivo.getOriginalFilename();
        Foto create;

        try {
            create = request.builder()
                    .nomeFoto(originalFilename)
                    .arquivo(arquivo.getBytes().clone()).build();
            arquivoRepository.save(create);
        } catch (IOException e) {
            throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
        }
        return create;
    }


    private ArquivoRepresentation getArquivoRepresentation(Foto dados) {
        return ArquivoRepresentation.builder()
                .id(dados.getId())
                .nomeFoto(dados.getNomeFoto())
                .build();
    }

    private HttpEntity<byte[]> getHttpEntity(Foto download, MediaType extension, byte[] arquivo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment;filename=\"" + download.getNomeFoto() + "\"");
        httpHeaders.setContentType(extension);
        return new HttpEntity<>(arquivo, httpHeaders);
    }
}
