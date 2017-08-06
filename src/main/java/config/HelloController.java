package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import sourcing.client.EbayAuthenticationClient;
import sourcing.client.EbayBuyAPIClient;
import sourcing.client.EbayBuyAPIClientImpl;

@RestController
public class HelloController {
    @Autowired
    private EbayAuthenticationClient ebayAuthenticationClient;
    @Autowired
    private EbayBuyAPIClient ebayBuyAPIClient;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!\n";
    }

    @RequestMapping("/test/auth")
    public String testAuth() {
        return ebayAuthenticationClient.getAppAuthenticationToken();
    }

    @RequestMapping("/test/search")
    public String testSearch() {
       return ebayBuyAPIClient.search("iphone6", 3).toString();
    }
}