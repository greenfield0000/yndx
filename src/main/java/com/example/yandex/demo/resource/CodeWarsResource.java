package com.example.yandex.demo.resource;

import com.example.yandex.demo.resource.pojo.NormalizePathRequest;
import com.example.yandex.demo.resource.pojo.RleRequest;
import com.example.yandex.demo.service.CodeWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.nio.file.Path;

@RestController
@RequestMapping(path = "wars")
public class CodeWarsResource {

    private final CodeWarsService codeWarsService;

    @Autowired
    public CodeWarsResource(CodeWarsService codeWarsService) {
        this.codeWarsService = codeWarsService;
    }

    @PostMapping(path = "/normalize", consumes = "application/json")
    public String normalize(@RequestBody NormalizePathRequest normalizePathRequest) throws Exception {
        return String.format("Path is %s; Custom is %s"
                , Path.of("/", normalizePathRequest.getPath()).normalize()
                , codeWarsService.normalize(normalizePathRequest.getPath())
        );
    }

    @PostMapping(path = "/rle")
    public String stringRLE(@RequestBody RleRequest rleRequest) {
        return codeWarsService.stringRLE(rleRequest.getS4Rle());
    }

}
