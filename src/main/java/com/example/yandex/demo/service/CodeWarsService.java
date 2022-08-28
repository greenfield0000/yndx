package com.example.yandex.demo.service;

import org.springframework.stereotype.Service;

import java.util.Stack;
import java.util.stream.Collectors;

@Service
public class CodeWarsService {

    /**
     * Разбирем путь на составляющие.
     * <p>
     * Делим на "/".
     * - Если встречаем пустой слеш - просто игнорируем
     * - Если встречаем "..", то игнорируем предыдущий
     * - Если встречаем ".", то это просто текущий путь, просто пропускаем ее
     * <p>
     * 1 normalize('/foo/bar//baz/asdf/quux/..'); // '/foo/bar/baz/asdf'
     * 2 normalize('./config/../etc'); // 'etc'
     * 3 normalize('/////documents/root/.././../etc'); // '/etc'
     * 4 normalize('a/../../b'); // '../b'
     * 5 normalize('/a/../../b'); // '/b'
     *
     * @param path путь для нормализации
     * @return преобразованный путь
     */
    public String normalize(String path) throws Exception {
        Stack<String> pathStack = new Stack<>();

        String[] splitedStr = path.split("/");
        int i = 0;
        while (i < splitedStr.length) {
            String curVal = splitedStr[i];
            if (!curVal.equals(".") && !curVal.equals("..") && !curVal.equals("")) {
                pathStack.push(curVal);
            }
            if (curVal.equals("..")) {
                int j = i + 1;
                int countBack = 1;
                while (j < splitedStr.length && splitedStr[j].equals("..")) {
                    countBack++;
                    j++;
                }
                if (countBack >= 1) {
                    while (!pathStack.isEmpty() && countBack >= 1) {
                        pathStack.pop();
                        countBack--;
                    }
                }
            }
            i++;
        }
        return pathStack.stream().map(it -> "/" + it).collect(Collectors.joining());
    }
}
