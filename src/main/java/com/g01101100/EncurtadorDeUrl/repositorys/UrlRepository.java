package com.g01101100.EncurtadorDeUrl.repositorys;

import com.g01101100.EncurtadorDeUrl.models.URL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UrlRepository extends JpaRepository<URL, Long> {
    Optional<URL> findByShortCode(String shortCode);
    boolean existsByShortCode(String shortCode);
}
