package xiezhy.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * version:
 * --------------------
 * date:2016/4/20
 * author:binbin
 */
@Controller
@Scope("prototype")
@RequestMapping("/")
public class HomeController {

    @RequestMapping("")
    public String index() {
        return "index";
    }

}
