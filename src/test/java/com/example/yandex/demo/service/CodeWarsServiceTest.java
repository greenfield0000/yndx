package com.example.yandex.demo.service;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Paths;

@SpringBootTest
class CodeWarsServiceTest {

    private final CodeWarsService codeWarsService;

    @Autowired
    CodeWarsServiceTest(CodeWarsService codeWarsService) {
        this.codeWarsService = codeWarsService;
    }

    @Test
    void stringRLE() {
        Assertions.assertEquals("3A", codeWarsService.stringRLE("AAA"));
        Assertions.assertEquals("A", codeWarsService.stringRLE("A"));
        Assertions.assertEquals("A2BACD", codeWarsService.stringRLE("ABBACD"));
        Assertions.assertEquals("A2BACD", codeWarsService.stringRLE("ABBACD"));
        Assertions.assertEquals("A2BAC5D", codeWarsService.stringRLE("ABBACDDDDD"));
        Assertions.assertEquals("A2BAC5D2A", codeWarsService.stringRLE("ABBACDDDDDAA"));
    }

    @Test
    void normalize() throws Exception {
        Assertions.assertEquals(Paths.get("/", "a/../../b").normalize().toString(), codeWarsService.normalize("a/../../b"));
        Assertions.assertEquals(Paths.get("/", "/foo/bar//baz/asdf/quux/..").normalize().toString(), codeWarsService.normalize("/foo/bar//baz/asdf/quux/.."));
        Assertions.assertEquals(Paths.get("/", "/////documents/root/.././../etc").normalize().toString(), codeWarsService.normalize("/////documents/root/.././../etc"));
        Assertions.assertEquals(Paths.get("/", "a/../../b").normalize().toString(), codeWarsService.normalize("a/../../b"));
        Assertions.assertEquals(Paths.get("/", "/a/../../b").normalize().toString(), codeWarsService.normalize("/a/../../b"));
    }
}