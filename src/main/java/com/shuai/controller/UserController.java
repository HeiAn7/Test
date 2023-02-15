package com.shuai.controller;
import com.shuai.entity.User;
import com.shuai.entity.UserDetails;
import com.shuai.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
    }

    @RequestMapping({"/QueryBalance/{id}"})
    public String QueryBalance(@PathVariable("id") Integer id) {
        Double money = this.userService.QueryBalance(id);
        return "当前用户钱包余额为:" + money;
    }

    @RequestMapping({"/Consumer100/{id}"})
    public String Consumer100(@PathVariable("id") Integer id) {
        Double money = this.userService.QueryBalance(id);
        if (money < 100.0D) {
            return "用户余额不足消费100,当前钱包余额为：" + money;
        } else {
            Double balance = money - 100.0D;
            Boolean flag = this.userService.Consumer100(new User(id, balance));
            if (!flag) {
                return "消费未成功";
            } else {
                this.userService.addDetails(id, "-100");
                return "消费成功，用户当前钱包余额为：" + this.userService.QueryBalance(id);
            }
        }
    }

    @RequestMapping({"/refund20/{id}"})
    public String refund20(@PathVariable("id") Integer id) {
        Double money = this.userService.QueryBalance(id);
        Double balance = money + 20.0D;
        boolean flag = this.userService.refund20(new User(id, balance));
        if (!flag) {
            return "退款未成功";
        } else {
            this.userService.addDetails(id, "+20");
            return "退款成功，用户当前钱包余额为：" + this.userService.QueryBalance(id);
        }
    }

    @RequestMapping({"/QueryDetails/{uid}"})
    public List<UserDetails> Details(@PathVariable("uid") Integer uid) {
        System.out.println(this.userService.Details(uid));
        return this.userService.Details(uid);
    }
}

