package com.rodrigosouza.qrcode.generator.controller;

import com.rodrigosouza.qrcode.generator.dto.QrCodeGenerateResponse;
import com.rodrigosouza.qrcode.generator.dto.QrcodeGenerateRequest;
import com.rodrigosouza.qrcode.generator.service.QrCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeGeneratorService qrCodeGeneratorService;

    public QrCodeController(QrCodeGeneratorService qrCodeGeneratorService) {
        this.qrCodeGeneratorService = qrCodeGeneratorService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generate(@RequestBody QrcodeGenerateRequest request){
        try {
            QrCodeGenerateResponse response = this.qrCodeGeneratorService.generateAndUploadQrCode(request.text());
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

}
