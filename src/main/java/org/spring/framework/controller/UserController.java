package org.spring.framework.controller;

import org.spring.framework.User;
import org.spring.framework.annottation.Action;
import org.spring.framework.annottation.Autowired;
import org.spring.framework.annottation.Controller;
import org.spring.framework.bean.Data;
import org.spring.framework.bean.Param;
import org.spring.framework.bean.View;
import org.spring.framework.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangyixuan
 * @date 2018-03-02
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Action("get:/user1")
    public Data getUser() {
        User person = userService.getUser();
        Data data = new Data(person);
        return data;
    }

    @Action("get:/user2")
    public View getUserHtml(Param param) {
        View view = new View("/asset/html/user.html", null);
        return view;
    }

    @Action("get:/user3")
    public View getUserJsp(Param param) {
        Map map = new HashMap();
        map.put("name", "jiangyixuan");
        map.put("age", 24);

        View view = new View("user", map);
        return view;
    }

}
