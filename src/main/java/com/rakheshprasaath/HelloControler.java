package com.rakheshprasaath;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloControler {
    @RequestMapping("/home")
    public  String home(){
        System.out.print("in home");
//        return "index.jsp";
        return  "addAlien.jsp";
    }

    @RequestMapping("/result")
    public  String result(HttpServletRequest request, HttpSession session){
        try{
        int num1= Integer.parseInt(request.getParameter("num1"));
        int num2= Integer.parseInt(request.getParameter("num2"));
        int result= num1 + num2;
        session.setAttribute("result",result);
        System.out.print("in result");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "result.jsp";
    }

    @RequestMapping("/addAlien")
    public  String addAlien(Alien alien){

        return "result.jsp";
    }

}
