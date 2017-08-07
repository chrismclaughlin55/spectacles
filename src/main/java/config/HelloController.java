package config;

import ebay.service.EbayAuthenticationService;
import ebay.service.EbayBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sourcing.service.ItemService;
import sourcing.vo.ItemBean;

@RestController
public class HelloController {
    @Autowired
    private EbayAuthenticationService ebayAuthenticationService;
    @Autowired
    private EbayBuyService ebayBuyService;
    @Autowired
    private ItemService itemService;

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

    @RequestMapping("/test/itemService/create")
    public long testCreate(){
        ItemBean itemBean = new ItemBean();
        itemBean.setCategory("poop");
        itemBean.setEbayId("123");

        return itemService.createItem(itemBean);
    }

    @RequestMapping( method=RequestMethod.DELETE, value="/test/itemService/delete/{id}")
    public String testDelete(@PathVariable long id){
        itemService.deleteItem(id);
        return "Success!\n";
    }
}
