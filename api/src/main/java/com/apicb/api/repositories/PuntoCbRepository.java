package com.apicb.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apicb.api.models.PuntoCb;
import java.util.Optional;

@Repository
public interface PuntoCbRepository extends JpaRepository<PuntoCb, Long> {
    Optional<PuntoCb> findByCodigoPunto(Integer codigoPunto);
    boolean existsByCodigoPunto(Integer codigoPunto);
} 