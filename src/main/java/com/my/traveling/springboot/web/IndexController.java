package com.my.traveling.springboot.web;


import com.my.traveling.springboot.config.auth.LoginUser;
import com.my.traveling.springboot.config.auth.dto.SessionUser;
import com.my.traveling.springboot.service.PostsService;
import com.my.traveling.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sun.applet.AppletViewer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){ // 어느 컨트롤러에서도 @LoginUser 어노테이션을 통해 세션 정보를 가져옴
        model.addAttribute("posts", postsService.findAllDesc());

        if(user!=null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }

}
