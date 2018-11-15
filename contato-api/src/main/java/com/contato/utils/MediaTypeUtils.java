package com.contato.utils;

import com.contato.model.Foto;

public class MediaTypeUtils {

    public static String extensionFoto(Foto arquivo){

        String img = arquivo.getNomeFoto();
        int length = img.length();
        int index = img.indexOf(".");
        int ponto = index + 1;
        String extension = img.substring(ponto, length);
        return extension;
    }
}
