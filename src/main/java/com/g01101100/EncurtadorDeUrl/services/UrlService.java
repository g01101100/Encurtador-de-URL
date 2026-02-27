package com.g01101100.EncurtadorDeUrl.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.g01101100.EncurtadorDeUrl.models.URL;
import com.g01101100.EncurtadorDeUrl.repositorys.UrlRepository;
import com.g01101100.EncurtadorDeUrl.utils.ShortCodeGenerator;

@Service
public class UrlService {

    private final UrlRepository repository;

    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    public String getOriginalUrl(String code) {
        return repository.findByShortCode(code)
                .orElseThrow(() -> new RuntimeException("URL not found"))
                .getOriginalUrl();
    }

    @Transactional
    public String createShortUrl(String originalUrl) {

        String shortCode;

        // evita colisão
        do {
            shortCode = ShortCodeGenerator.generate();
        } while (repository.existsByShortCode(shortCode));

        URL url = new URL(originalUrl, shortCode);
        repository.save(url);

        return shortCode;
    }
}
