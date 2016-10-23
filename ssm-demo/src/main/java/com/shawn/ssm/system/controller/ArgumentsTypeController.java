/**
 * Project Name:ssm-demo
 * File Name:ArgumentsTypeController.java
 * Package Name:com.shawn.ssm.system.controller
 * Date:2016-10-22下午5:32:03
 *
 */


package com.shawn.ssm.system.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

/**
 * ClassName: ArgumentsTypeController <br/>
 * Date: 2016-10-22 下午5:32:03 <br/>
 * Description: TODO 
 *
 * @author luxf
 * @version 
 * @see
 */
@Controller
@RequestMapping("/argstest")
public class ArgumentsTypeController {
    @RequestMapping("/session")
    public void showSession(HttpSession session){
        String status = (String)session.getAttribute("status");
        int i;
        if(null==status){
            status = "0";
        }else{
            status = status + "0";
        }
        System.out.println(status);
        session.setAttribute("status", status);
    }
    @RequestMapping("/request")
    public void showRequest(WebRequest wr,NativeWebRequest nr){
        System.out.println(wr);
        System.out.println(nr);
    }
    
    @RequestMapping("/others")
    public void showOthers(Principal pa,HttpMethod hm){
        System.out.println(pa);
        System.out.println(hm);
    }
    
    @RequestMapping("/io")
    public void showIO(InputStream is,OutputStream os){
        System.out.println(is);
        System.out.println(os);
    }
}

