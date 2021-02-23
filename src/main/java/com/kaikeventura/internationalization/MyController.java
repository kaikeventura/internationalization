package com.kaikeventura.internationalization;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@RestController
@RequestMapping("/")
public class MyController {

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid final MyObject myObject, @RequestHeader("Accept-Language") final Locale locale) {
        return ResponseEntity.noContent().build();
    }
}
