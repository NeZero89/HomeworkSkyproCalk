package Skypro.HomeworkSkyproCalk.controller;

import Skypro.HomeworkSkyproCalk.service.CalculatorServce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
public class CalculatorController {

    public final CalculatorServce service;

    public CalculatorController(CalculatorServce service) {
        this.service = service;
    }

    @GetMapping()
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam("num1") int num1,
                       @RequestParam("num2") int num2) {
        int result = service.plus(num1, num2);
        return num1 + "+" + num2 + "=" + result;

    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int num1,
                        @RequestParam("num2") int num2) {
        int result = service.minus(num1, num2);

        return num1 + "-" + num2 + "=" + result;
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam("num1") int num1,
                           @RequestParam("num2") int num2) {
        int result = service.multiply(num1, num2);
        return num1 + "*" + num2 + "=" + result;
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam("num1") int num1,
                         @RequestParam("num2") int num2) {
        int result = service.divide(num1, num2);
        return num1 + "/" + num2 + "=" + result;
    }

    @ExceptionHandler
    public ResponseEntity<String> IllegalArgumentException(RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
