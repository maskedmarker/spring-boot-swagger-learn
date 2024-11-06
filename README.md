# spring-boot-swagger-learn


## swagger主页
http://localhost:9080/myapp/swagger-ui/index.html
### 接口的定义
http://localhost:9080/myapp/v2/api-docs


## 工作原理

In Spring Boot projects with Springfox, ApiListingScanner and OperationReader are key classes responsible for reading controller metadata, while RequestMappingHandlerMapping identifies available endpoints. 
Together, these classes enable the automatic generation of Swagger documentation.


In the Swagger framework, the class responsible for reading annotations and generating API documentation is RequestMappingHandlerMapping, used in combination with ApiListingScanner and OperationReader. 
Here’s how it works:
1. RequestMappingHandlerMapping:
   * This is a Spring MVC component that scans controller classes for mappings like @RequestMapping, @GetMapping, etc., to register endpoints. 
   * Springfox (the library commonly used to integrate Swagger with Spring Boot) hooks into this mapping process to access endpoint metadata.
2. ApiListingScanner and OperationReader:
   * In Springfox, ApiListingScanner and OperationReader classes handle the core processing of controller metadata to generate the OpenAPI specification. 
   * They look at each handler method, reading the @RequestMapping, @GetMapping, @PostMapping, and other annotations like @RequestBody, @PathVariable, etc.
   * These classes extract details such as URL paths, HTTP methods, parameters, and request/response types, then map them to Swagger models.
3. ModelConverters:
   * When ApiListingScanner or OperationReader encounters complex request or response types, it leverages ModelConverters to analyze these types and create models in the OpenAPI specification. 
   * This ensures that data types are accurately documented.
4. Docket:
   * In Springfox, the Docket bean configures which parts of the application should be included in the documentation. 
   * It provides a way to customize the paths, API groups, and other options that the scanner should consider.


## 核心类

### RequestHandlerProvider
提供暴露的http endpoint

对于springmvc,实现类为WebMvcRequestHandlerProvider
WebMvcRequestHandlerProvider通过spring的构造函数自动注入,获取到所有的RequestMappingInfoHandlerMapping
springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider#requestHandlers将spring的RequestMappingInfo转换为springfox的RequestHandler

对于web-flux,实现类为WebFluxRequestHandlerProvider.

### ApiListingScanner


### OperationReader



## 启动过程

启动入口
springfox.documentation.spring.web.plugins.DocumentationPluginsBootstrapper#start

endpoint暴露是通过在spring容器中添加controller.如下类都添加了@RestController
OpenApiControllerWebMvc
ApiResourceController
Swagger2ControllerWebMvc


