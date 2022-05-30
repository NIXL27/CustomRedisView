package com.fc.controller;

import com.fc.Service.CURDService;
import com.fc.entity.CustomRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import java.util.Set;


@Controller
@RequestMapping("redis")
public class CURDController {

    @Autowired
    private CURDService curdService;

    @RequestMapping("connect")
    public ModelAndView connect(ModelAndView mv, CustomRedis customRedis) {
        Jedis jedis = new Jedis(customRedis.getHost(), customRedis.getPort());

        jedis.auth(customRedis.getPassword());

        jedis.select(0);

        Set<String> keys = jedis.keys("*");

        String aTrue = jedis.ping("true");

        if (aTrue.equals("true")) {
            mv.addObject("keys",keys);
        }else {
            mv.addObject("message","连接失败");
        }

        mv.setViewName("show.jsp");
        return mv;
    }


    @RequestMapping("findKey")
    public ModelAndView findKey(ModelAndView mv, String key) {

        Object key1 = curdService.findKey(key);
        System.out.println(key1);

        mv.addObject("key",key1);
        mv.setViewName("show.jsp");
        return mv;
    }

    @RequestMapping("addKey")
    public ModelAndView addKV(ModelAndView mv, String key, String type, Object value) {

        Jedis jedis = new Jedis("redis.ihzsr.cn", 6379);

        jedis.auth("Redis#123");

        jedis.select(0);

        curdService.addKV(key, type, value);
        mv.setViewName("show.jsp");
        return mv;
    }

}
