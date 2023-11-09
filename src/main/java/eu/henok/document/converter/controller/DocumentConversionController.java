package eu.henok.document.converter.controller;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;

import eu.henok.document.converter.service.DocumentConversionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.IOException;
import org.jodconverter.core.office.OfficeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Tag(name = "convert")
public class DocumentConversionController {

  final DocumentConversionService documentConversionService;

  public DocumentConversionController(DocumentConversionService documentConversionService) {
    this.documentConversionService = documentConversionService;
  }

  @PostMapping(value = "/convert", produces = APPLICATION_OCTET_STREAM_VALUE)
  @Operation(summary = "convert a document")
  public ResponseEntity<byte[]> convertDocument(
      @RequestParam("file") MultipartFile file,
      @RequestParam("inputFormat") String inputFormat,
      @RequestParam String outputFormat)
      throws IOException, OfficeException {

    return ResponseEntity.ok(
        documentConversionService.convert(file.getInputStream(), inputFormat, outputFormat));
  }
}
