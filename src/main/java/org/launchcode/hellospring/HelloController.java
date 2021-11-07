package org.launchcode.hellospring.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 * Created by Chris Bay
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }
//    // lives at /hello/goodbye
//    @GetMapping("goodbye")
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }
    // Handles requests of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello there lady, " + name + "!";
//    }
    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String lang) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, lang);

    }

    public static String createMessage(String name, String lang) {
        String greeting = "";

        if (lang.equals("english")) {
            greeting = "Hello";
        }
        else if (lang.equals("klingon")) {
            greeting = "NuqneH";
        }
        else if (lang.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if (lang.equals("spanish")) {
            greeting = "Hola";
        }
        else if (lang.equals("french")) {
            greeting = "Bonjour";
        }

        return greeting + " " + name;
    }
    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<label for='lang-select'>Select Language:</label>" +
                "<select name='lang' id='lang-select'>" +
                   "<option value='english'>English</option>" +
                    "<option value='klingon'>Klingon</option>" +
                    "<option value='italian'>Italian</option>" +
                    "<option value='spanish'>Spanish</option>" +
                    "<option value='french'>French</option>" +
                "</select>"+
                "<input type = 'text' name = 'name' >" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}