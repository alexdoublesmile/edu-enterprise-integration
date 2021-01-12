package com.plohoy.enterpriseservice.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Component
public class InnHelper {
    @Value("${inn.min.length}") private String minInnSizeProperty;
    @Value("${inn.max.length}") private String maxInnSizeProperty;

    @Value("${inn.size.error.message}") private String innSizeErrorMessage;
    @Value("${inn.format.error.message}") private String innFormatErrorMessage;
    @Value("${inn.blank.error.message}") private String innBlankErrorMessage;
    @Value("${inn.not.found.error.message}") private String innNotFoundMessage;

    public String getSmallInn() {
        return getSizedInn(Integer.parseInt(minInnSizeProperty) - 1);
    }

    public String getLargeInn() {
        return getSizedInn(Integer.parseInt(maxInnSizeProperty) + 1);
    }

    public String getRandomInn() {
        return getRandomSizedInn(
                Integer.parseInt(minInnSizeProperty),
                Integer.parseInt(maxInnSizeProperty));
    }

    private String getSizedInn(int innSize) {
        String inn = "0";
        if (innSize > 0) {
            String innTemplate = "%0" + innSize + "d";
            int randomTemplate = (int) (Math.pow(10, innSize) - 1);

            inn = String.format(
                    innTemplate,
                    new Random().nextInt(randomTemplate));
        }
        return inn;
    }

    private String getRandomSizedInn(int minSize, int maxSize) {
        String inn = "0";
        if (minSize >= 0 && maxSize > minSize) {
            int randomSize = (int) ((Math.random() * (maxSize - minSize + 1)) + minSize);

            String innTemplate = "%0" + randomSize + "d";
            int randomTemplate = (int) (Math.pow(10, randomSize) - 1);

            inn = String.format(
                    innTemplate,
                    new Random().nextInt(randomTemplate));
        }
        return inn;
    }
}
