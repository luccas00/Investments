package ufop.web2.luccas.Gateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

@Configuration
public class GatewayApiConfig {

    @Value("${gateway.frontend.uri}")
    private String uriFrontendService = "http://localhost:9012";

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("home",
                        p -> p.path("/")
                                .filters(f -> f.rewritePath("/", "/"))
                                .uri("lb://Investments")
                )
                .route("address",
                        p -> p.path("/address")
                                .uri("lb://Investments")
                )
                .route("credit-card",
                        p -> p.path("/cc")
                                .uri("lb://Investments")
                )
                .route("credit-card-network",
                        p -> p.path("/ccn")
                                .uri("lb://Investments")
                )
                .route("investments",
                        p -> p.path("/investments")
                                .uri("lb://Investments")
                )
                .route("investments-api",
                        p -> p.path("/api/investments")
                                .filters(f -> f.rewritePath("/api/investments", "/investments"))
                                .uri("lb://Investments")
                )
                .route("investments-api", p -> p.path("/api/investments/**")
                        .filters(f -> f.rewritePath("^/api(?<segment>/.*)$", "${segment}"))
                        .uri("lb://Investments")
                )
                .route("investments-segment",
                        p -> p.path("/investments/**")
                                .uri("lb://Investments")
                )
                .route("users-api",
                        p -> p.path("/api/users")
                                .filters(f -> f.rewritePath("/api/users", "/users"))
                                .uri("lb://Investments")
                )
                .route("users",
                        p -> p.path("/users")
                                .uri("lb://Investments")
                )
                .route("users-segment",
                        p -> p.path("/users/**")
                                .uri("lb://Investments")
                )
                .route("frontend",
                        p -> p.path("/**")
                                .uri(this.uriFrontendService)
                )
                .build();

    }

}
