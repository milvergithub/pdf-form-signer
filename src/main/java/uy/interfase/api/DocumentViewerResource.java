package uy.interfase.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/documentviewer")
public class DocumentViewerResource {

    @Value("${basepath}")
    private String baseUrl;

    @GetMapping("/{fileName}")
    public RedirectView signCallback(
            @PathVariable("fileName") String fileName,
            @RequestParam(value = "signer_process_id", required = false) String processId,
            @RequestParam(value = "status", required = false) String status) {
        String url2 = baseUrl+"#/documentviewer/"+fileName+"?processId="+processId+"&status="+status;
        return new RedirectView(url2);
    }
}
