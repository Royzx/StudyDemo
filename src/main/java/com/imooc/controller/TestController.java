package com.imooc.controller;

import com.imooc.object.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 59215_000 on 2016/5/5.
 */
@Controller
public class TestController {

    @RequestMapping(value = "baseType.do")
    @ResponseBody
    public String baseType(@RequestParam("xage") int age){
        return "age =" +age;
    }

    @RequestMapping(value = "baseType2.do")
    @ResponseBody
    public String baseType2(Integer age){
        return "age =" +age;
    }

    @RequestMapping(value = "array.do")
    @ResponseBody
    public String array(String[] name){
        StringBuilder sbf = new StringBuilder();
        for (String s: name) {
            sbf.append(s).append("  ");
        }
        return  sbf.toString();
    }

    
    @RequestMapping(value = "object.do")
    @ResponseBody
    public String object(User user, Admin admin){
        return  user.toString()+"  "+admin.toString();
    }

    //Todo http://localhost:8080/list.do?users[0].name=tom&users[1].name=lucy
    @RequestMapping(value = "list.do")
    @ResponseBody
    public String list(UserListForm list){
        return "listSize:"+list.getUsers().size()+"  "+ list.toString();
    }

    @RequestMapping(value = "set.do")
    @ResponseBody
    public String set(UserSetForm set){
        return "setSize:"+set.getUsers().size()+"  "+ set.toString();
    }

    @RequestMapping(value = "map.do")
    @ResponseBody
    public String map(UserMapForm map){
        return "mapSize:"+map.getUsers().size()+"  "+ map.toString();
    }

//    {
//        "name": "Jim",
//            "age": 16,
//            "contactInfo": {
//                "address": "beijing",
//                "phone": "10010"
//              }
//    }

    @RequestMapping(value = "json.do")
    @ResponseBody
    public String json(@RequestBody User user){
        return user.toString();
    }

//    <?xml version="1.0" encoding="UTF-8" ?>
//    <admin>
//      <name>Jim</name>
//      <age>16</age>
//    </admin>
    //application/xml
    @RequestMapping(value = "xml.do")
    @ResponseBody
    public String xml(@RequestBody Admin admin){
        return admin.toString();
    }

    @RequestMapping(value = "date1.do")
    @ResponseBody
    public String date1(Date date1){
        return date1.toString();
    }

    @RequestMapping(value = "date2.do")
    @ResponseBody
    public String date2(Date date2){
        return date2.toString();
    }

    @RequestMapping(value = "/book",method = RequestMethod.GET)
    @ResponseBody
    public String book(HttpServletRequest request){
        String type = request.getContentType();
        if (type==null){
            return "contentType is null";
        }else if (type.equals("html")){
            return "contentType is html";
        }else if (type.equals("txt")){
            return "contentType is txt";
        }

        return "contentType is default";

    }

    @RequestMapping(value = "/subject/{subjectId}",method = RequestMethod.GET)
    @ResponseBody
    public String subjectGet(@PathVariable("subjectId") String subjectId){
        return "this is get method"+subjectId;
    }
    @RequestMapping(value = "/subject/{subjectId}",method = RequestMethod.POST)
    @ResponseBody
    public String subjectPost(@PathVariable("subjectId") String subjectId){
        return "this is post method"+subjectId;
    }
    @RequestMapping(value = "/subject/{subjectId}",method = RequestMethod.PUT)
    @ResponseBody
    public String subjectPut(@PathVariable("subjectId") String subjectId){
        return "this is put method"+subjectId;
    }
    @RequestMapping(value = "/subject/{subjectId}",method = RequestMethod.DELETE)
    @ResponseBody
    public String subjectDelete(@PathVariable("subjectId") String subjectId){
        return "this is delete method"+subjectId;
    }



   /* @InitBinder("date1")
    public void initDate1(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }*/



   /* @InitBinder("user")
    public void initUser(WebDataBinder binder){
        binder.setFieldDefaultPrefix("user.");
    }

    @InitBinder("admin")
    public void initAdmin(WebDataBinder binder){
        binder.setFieldDefaultPrefix("admin.");
    }*/

}
