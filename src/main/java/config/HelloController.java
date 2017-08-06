package config;

import ebay.service.EbayAuthenticationService;
import ebay.service.EbayBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private EbayAuthenticationService ebayAuthenticationService;
    @Autowired
    private EbayBuyService ebayBuyService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!\n";
    }

    @RequestMapping("/test/auth")
    public String testAuth() {
        return ebayAuthenticationService.getAppAuthenticationToken();
    }

    @RequestMapping("/test/search")
    public String testSearch() {
       return ebayBuyService.search("iphone6", 3).toString();
    }
}