package config;

import client.EbayAuthenticationClient;
import client.EbayBuyAPIClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

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