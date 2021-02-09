package eu.henok.document.converter.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.jodconverter.core.DocumentConverter;
import org.jodconverter.core.document.DefaultDocumentFormatRegistry;
import org.jodconverter.core.office.OfficeException;
import org.springframework.stereotype.Service;

@Service
public class DocumentConversionService {

  final DocumentConverter converter;

  public DocumentConversionService(DocumentConverter converter) {
    this.converter = converter;
  }

  public byte[] convert(InputStream input, String inputFormat, String outputFormat)
      throws OfficeException {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    converter
        .convert(input)
        .as(DefaultDocumentFormatRegistry.getFormatByExtension(inputFormat))
        .to(output)
        .as(DefaultDocumentFormatRegistry.getFormatByExtension(outputFormat))
        .execute();

    return output.toByteArray();
  }
}
