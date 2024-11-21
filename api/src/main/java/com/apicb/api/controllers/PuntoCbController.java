package com.apicb.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.apicb.api.models.PuntoCb;
import com.apicb.api.repositories.PuntoCbRepository;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/puntos")
public class PuntoCbController {

    @Autowired
    private PuntoCbRepository puntoCbRepository;
    
    @GetMapping
    public List<PuntoCb> obtenerTodos() {
        return puntoCbRepository.findAll();
    }
    
    @GetMapping("/{codigoPunto}")
    public ResponseEntity<PuntoCb> obtenerPorCodigo(@PathVariable Integer codigoPunto) {
        return puntoCbRepository.findByCodigoPunto(codigoPunto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody PuntoCb punto) {
        if (puntoCbRepository.existsByCodigoPunto(punto.getCodigoPunto())) {
            return ResponseEntity.badRequest()
                .body("El código punto " + punto.getCodigoPunto() + " ya existe");
        }
        return ResponseEntity.ok(puntoCbRepository.save(punto));
    }
    
    @PutMapping("/{codigoPunto}")
    public ResponseEntity<?> actualizar(
            @PathVariable Integer codigoPunto,
            @Valid @RequestBody PuntoCb punto) {
        return puntoCbRepository.findByCodigoPunto(codigoPunto)
                .map(puntoExistente -> {
                    puntoExistente.setNombre(punto.getNombre());
                    puntoExistente.setDireccion(punto.getDireccion());
                    puntoExistente.setRed(punto.getRed());
                    return ResponseEntity.ok(puntoCbRepository.save(puntoExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{codigoPunto}")
    public ResponseEntity<?> eliminar(@PathVariable Integer codigoPunto) {
        return puntoCbRepository.findByCodigoPunto(codigoPunto)
                .map(punto -> {
                    puntoCbRepository.delete(punto);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 