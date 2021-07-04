package com.github.akazver.poc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class SpringAopJavaAgent {

    private static final Logger LOGGER = Logger.getLogger(SpringAopJavaAgent.class.getName());

    public static void premain(String args) {
        try (InputStream is = SpringAopJavaAgent.class.getResourceAsStream("/META-INF/aop.xml");
             InputStreamReader isr = new InputStreamReader(Objects.requireNonNull(is));
             BufferedReader br = new BufferedReader(isr)) {
            String content = br.lines().collect(Collectors.joining("\n"));
            LOGGER.info("Content of aop.xml:\n" + content);
        } catch (IOException exception) {
            throw new IllegalStateException("Can't process aop.xml", exception);
        }
    }

}
