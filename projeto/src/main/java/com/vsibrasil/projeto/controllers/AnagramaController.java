package com.vsibrasil.projeto.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vsibrasil.projeto.models.AnagramaRequest;
import com.vsibrasil.projeto.models.AnagramaResponse;
import com.vsibrasil.projeto.services.AnagramaService;

@RestController
@RequestMapping("/api/anagramas")
@CrossOrigin(origins = "*") // Habilita CORS

public class AnagramaController {

 private final AnagramaService service;

 public AnagramaController(AnagramaService service) {
     this.service = service;
 }

 @PostMapping
 public ResponseEntity<?> gerarAnagramas(@RequestBody AnagramaRequest request) {
     try {
         return ResponseEntity.ok(new AnagramaResponse(service.gerarAnagramas(request.getLetras())));
     } catch (IllegalArgumentException e) {
         return ResponseEntity.badRequest().body(e.getMessage());
     }
 }
}
