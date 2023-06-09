package uy.interfase.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import uy.interfase.dto.TokenDto;

/**
 * @author Milver Flores Acevedo
 * @since 1.0
 */
@FeignClient(name = "tspdemoidas", url = "${tspdemoidas.url}")
public interface TspDemoIdasClient {

    @PostMapping(value = "/trustedx-authserver/oauth/as-principal/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    ResponseEntity<TokenDto> getToken(@RequestParam("grant_type") String grantType,
                                      @RequestParam("scope") String scope,
                                      @RequestParam("client_id") String clientId,
                                      @RequestParam("client_secret") String clientSecret);

    @PostMapping(value = "/trustedx-resources/esignsp/v2/signer_processes", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<Object> createSignerProcess(@RequestHeader("Authorization") String token,
                                               @RequestPart(value = "process") MultipartFile process,
                                               @RequestPart(value = "document") MultipartFile document);

    @GetMapping(value = "trustedx-resources/esignsp/v2/signer_processes/{process_id}")
    ResponseEntity<Object> getSignerProcess(@RequestHeader("Authorization") String token,
                                            @PathVariable("process_id") String processId);

    @DeleteMapping(value = "trustedx-resources/esignsp/v2/signer_processes/{process_id}")
    ResponseEntity<Object> deleteSignerProcess(@RequestHeader("Authorization") String token,
                                            @PathVariable("process_id") String processId);

    @GetMapping(value = "trustedx-resources/esignsp/v2/documents/{document_id}/content")
    ResponseEntity<byte[]> getDocument(@RequestHeader("Authorization") String token,
                                       @PathVariable("document_id") String documentId);
}
