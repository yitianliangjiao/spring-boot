package com.wrh.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/WeiBo")
public class DemoWeiBoController {

    static final String RESOU = "resou";

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("/Index")
    public String RedisIndex(){
        return "weibo/index";
    }

    @ResponseBody
    @RequestMapping("/Add")
    public boolean Add(String name){
        redisUtil.addSet(RESOU,name);
        Click(name);
        return true;
    }

    @ResponseBody
    @RequestMapping("/Click")
    public boolean Click(String name){
        redisUtil.INCR(name);
        return true;
    }

    @ResponseBody
    @RequestMapping("/GetLeaderboard")
    public List<ResouBean> Click(int  num){
       Set<Object> set = redisUtil.getSet(RESOU);
       List<ResouBean> resouList = new ArrayList<>();
        for (Object obj: set) {
            ResouBean bean = new ResouBean();
            bean.setName(obj.toString());
            bean.setNum((int)redisUtil.get(obj.toString()));
            resouList.add(bean);
        }
        Collections.sort(resouList, new Comparator<ResouBean>() {
            @Override
            public int compare(ResouBean o1, ResouBean o2) {
                long a = o1.getNum()-o2.getNum();
                if(a >0) {
                    return  -1;
                }else if(a <0){
                    return  1;
                }else{
                    return 0;
                }
            }
        });
        return resouList;
    }

    static class ResouBean
    {
        private String name;
        private int num;

        public void setName(String name) {
            this.name = name;
        }

        public long getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }
    }
}
