package eu.henok.document.converter.controller;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;

import eu.henok.document.converter.service.DocumentConversionService;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import org.jodconverter.core.office.OfficeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DocumentConversionController {

  final DocumentConversionService documentConversionService;

  public DocumentConversionController(DocumentConversionService documentConversionService) {
    this.documentConversionService = documentConversionService;
  }

  @PostMapping(value = "/convert", produces = APPLICATION_OCTET_STREAM_VALUE)
  @ApiOperation(
      value = "convert document",
      tags = {"convert"})
  public ResponseEntity<byte[]> convertDocument(
      @RequestParam("file") MultipartFile file,
      @RequestParam("inputFormat") String inputFormat,
      @RequestParam String outputFormat)
      throws IOException, OfficeException {

    return ResponseEntity.ok(
        documentConversionService.convert(file.getInputStream(), inputFormat, outputFormat));
  }
}
