# Servlet HelloWorld Project 

Content

- Environments
- Building Project
- Implementation
- Test
- References

## Environment

Software

- JDK 1.8
- Maven
- Tomcat7 Maven Plugin

Dependencies

- servlet-api 2.5



## Building Project

### Step 1: Generating Maven Project

Using Maven Template to Generate Project Structure and Artifacts

```shell
$ mvn archetype:generate -DgroupId=com.taogen.example -DartifactId=servlet-helloworld -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
```

### Step2: Configuring Maven Project `pom.xml`

Set Maven Project Properties

```xml
<properties>
    <maven.compiler.target>1.8</maven.compiler.target>
    <maven.compiler.source>1.8</maven.compiler.source>
</properties>
```

Add Maven Dependencies

```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>servlet-api</artifactId>
    <version>2.5</version>
    <!-- provided: indicates you expect the JDK or a container to provide the dependency at runtime. set the dependency on the Servlet API and related Java EE APIs to scope provided because the web container provides those classes. -->
    <scope>provided</scope>
</dependency>
```

Add Tomcat Maven Plugin and Tomcat Configuration

```xml
<project>
  ...
  <build>
    <plugins>
        <!-- maven compile -->
        <plugin>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.5.1</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
        </plugin>
        
        <!-- maven package war -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-war-plugin</artifactId>
            <version>3.2.3</version>
            <configuration>
              <webResources>
                <resource>
                  <!-- this is relative to the pom.xml directory -->
                  <directory>src/main/resources</directory>
                </resource>
              </webResources>
            </configuration>
      	</plugin>
 
        <!-- Tomcat plugin-->
        <plugin>
            <groupId>org.apache.tomcat.maven</groupId>
            <artifactId>tomcat7-maven-plugin</artifactId>
            <version>2.2</version>
            <configuration>
                <port>9000</port>   //Configure port number
                <path>/servlet-helloworld</path>   //Configure application root URL
            </configuration>
        </plugin>
    </plugins>
  </build>
  ...
</project>
```

### Step 3: Add project file structures

Add source root `src/main/java`

Add package path `com/taogen/example/servlet`



## Implementation

### Step 1: Write Servlets

Add `HelloWorldServlet.java` 

```java
package com.taogen.example;

import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class HelloWorldServlet extends HttpServlet {
 
   private String message;

   public void init() throws ServletException {
      // Do required initialization
      message = "Hello World! ";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // Set response content type
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
	  String result = new StringBuilder(message).append(System.currentTimeMillis()).toString();
      out.println("<h3>" + result + "</h3>");
   }

   public void destroy() {
      // do nothing.
   }
}
```

### Step 2: Configuring Servlet

Configuring `HelloWorldServlet` in `src/main/webapp/WEB-INF/web.xml`

```xml
<servlet>
    <servlet-name>HelloWorld</servlet-name>
    <servlet-class>com.taogen.example.HelloWorldServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>HelloWorld</servlet-name>
    <url-pattern>/HelloWorld</url-pattern>
</servlet-mapping>
```



## Test

### Running and Visiting Project

Running Maven Project by Maven Tomcat 7 Plugin

```shell
$ mvn tomcat7:run
```

Visiting Index Page

```shell
$ curl http://localhost:{your_port}/{your_context}
```

Visiting `HelloWorldServlet`

```shell
$ curl http://localhost:{your_port}/{your_context}/HelloWorld
```



## References

[1] [Run Maven Java Web Application in Tomcat Maven Plugin](https://o7planning.org/en/10133/run-maven-java-web-application-in-tomcat-maven-plugin)

[2] [Maven in 5 Minutes](http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

[3] [Servlets - Examples](https://www.tutorialspoint.com/servlets/servlets-first-example.htm)

[4] [Tomcat Maven Plugin Documentation](http://tomcat.apache.org/maven-plugin-trunk/tomcat7-maven-plugin/plugin-info.html)

[5] [Tomcat maven plugin example](https://howtodoinjava.com/maven/tomcat-maven-plugin-example/)

[6] [Apache Tomcat Maven Plugin :: Tomcat 7.x](https://mvnrepository.com/artifact/org.apache.tomcat.maven/tomcat7-maven-plugin)