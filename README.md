# Description
This project is the PoC of injecting AspectJ aspects into already built Spring Boot application through Java agent

# How to run
Create demo application with [Spring Initializr](https://start.spring.io/)

Build this project and modify starting script of your Spring Boot application like that:
```shell
#!/usr/bin/env bash

java -javaagent:aspectjweaver-1.9.7.jar \
     -javaagent:spring-aop-java-agent-inject-1.0.0.jar \
     -jar demo-1.0.0.jar
```

You should see aspect execution in the log just before `main()` method:
```text
[AppClassLoader@2437c6dc] info AspectJ Weaver Version 1.9.7 built on Thursday Jun 24, 2021 at 16:14:45 PDT
[AppClassLoader@2437c6dc] info register classloader jdk.internal.loader.ClassLoaders$AppClassLoader@2437c6dc
[AppClassLoader@2437c6dc] info using configuration file:/C:/Workspace/spring-aop-java-agent-inject-1.0.0.jar!/META-INF/aop.xml
[AppClassLoader@2437c6dc] info register aspect com.github.akazver.poc.SpringBootInterceptAspect
Jul 04, 2021 5:49:27 PM com.github.akazver.poc.SpringAopJavaAgent premain
INFO: Content of aop.xml:
<aspectj>
    <aspects>
        <aspect name="com.github.akazver.poc.SpringBootInterceptAspect"/>
    </aspects>
    <weaver options="-verbose -nowarn"/>
</aspectj>
[LaunchedURLClassLoader@610f7aa] info AspectJ Weaver Version 1.9.7 built on Thursday Jun 24, 2021 at 16:14:45 PDT
[LaunchedURLClassLoader@610f7aa] info register classloader org.springframework.boot.loader.LaunchedURLClassLoader@610f7aa
[LaunchedURLClassLoader@610f7aa] info using configuration file:/C:/Workspace/spring-aop-java-agent-inject-1.0.0.jar!/META-INF/aop.xml
[LaunchedURLClassLoader@610f7aa] info register aspect com.github.akazver.poc.SpringBootInterceptAspect
Jul 04, 2021 5:49:27 PM com.github.akazver.poc.SpringBootInterceptAspect execute
INFO: Hello from AspectJ

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.5.2)

2021-07-04 17:49:27.990  INFO 24572 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication using Java 11.0.9 on DESKTOP-VOL3PG3 with PID 24572 (C:\Workspace\demo-1.0.0.jar started by aka_zver in C:\Workspace)
2021-07-04 17:49:27.993  INFO 24572 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
2021-07-04 17:49:28.518  INFO 24572 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 0.984 seconds (JVM running for 1.667)

```
