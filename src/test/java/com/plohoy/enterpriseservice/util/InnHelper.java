package com.plohoy.enterpriseservice.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Component
public class idHelper {
    @Value("${id.min.length}") private String minidSizeProperty;
    @Value("${id.max.length}") private String maxidSizeProperty;

    @Value("${id.size.error.message}") private String idSizeErrorMessage;
    @Value("${id.format.error.message}") private String idFormatErrorMessage;
    @Value("${id.blank.error.message}") private String idBlankErrorMessage;
    @Value("${id.not.found.error.message}") private String idNotFoundMessage;

    public String getSmallid() {
        return getSizedid(Integer.parseInt(minidSizeProperty) - 1);
    }

    public String getLargeid() {
        return getSizedid(Integer.parseInt(maxidSizeProperty) + 1);
    }

    public String getRandomid() {
        return getRandomSizedid(
                Integer.parseInt(minidSizeProperty),
                Integer.parseInt(maxidSizeProperty));
    }

    private String getSizedid(int idSize) {
        String id = "0";
        if (idSize > 0) {
            String idTemplate = "%0" + idSize + "d";
            int randomTemplate = (int) (Math.pow(10, idSize) - 1);

            id = String.format(
                    idTemplate,
                    new Random().nextInt(randomTemplate));
        }
        return id;
    }

    private String getRandomSizedid(int minSize, int maxSize) {
        String id = "0";
        if (minSize >= 0 && maxSize > minSize) {
            int randomSize = (int) ((Math.random() * (maxSize - minSize + 1)) + minSize);

            String idTemplate = "%0" + randomSize + "d";
            int randomTemplate = (int) (Math.pow(10, randomSize) - 1);

            id = String.format(
                    idTemplate,
                    new Random().nextInt(randomTemplate));
        }
        return id;
    }
}
