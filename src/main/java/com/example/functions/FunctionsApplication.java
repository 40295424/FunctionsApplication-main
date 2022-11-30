package com.example.functions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class FunctionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FunctionsApplication.class, args);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/total")
    static Integer getTotal(@RequestParam String module_1, @RequestParam String module_2,
                            @RequestParam String module_3, @RequestParam String module_4,
                            @RequestParam String module_5,
                            @RequestParam Integer mark_1, @RequestParam Integer mark_2,
                            @RequestParam Integer mark_3, @RequestParam Integer mark_4,
                            @RequestParam Integer mark_5) {
        int[] marks_array = {mark_1, mark_2, mark_3, mark_4, mark_5};
        int sum = marks_array[0] + marks_array[1] + marks_array[2] + marks_array[3] + marks_array[4];
        System.out.println("Total marks = " + sum);
        return sum;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping("/AlphabeticalOrder")
    static List<String> AlphabetSortModules(@RequestParam String module_1, @RequestParam String module_2, @RequestParam String module_3, @RequestParam String module_4, @RequestParam String module_5,
                                            @RequestParam Integer mark_1, @RequestParam Integer mark_2, @RequestParam Integer mark_3, @RequestParam Integer mark_4, @RequestParam Integer mark_5) {
        String[] modules = {module_1, module_2, module_3, module_4, module_5};

        for (int i = 0; i < modules.length; i++)   //Holds each element
        {

            for (int j = i + 1; j < modules.length; j++)  //Check for remaining elements
            {
                //compares each element of the array to all the remaining elements
                if (modules[i].compareTo(modules[j]) > 0) {
                    //swapping array elements
                    String temp = modules[i];
                    modules[i] = modules[j];
                    modules[j] = temp;
                }
            }
        }
        //prints the sorted array in alphabetical order
        List<String> moduleList = List.of(modules);
        System.out.println(Arrays.toString(modules));
        return moduleList;
    }

    @RequestMapping("/Classification")
    static String getClassification(@RequestParam String module_1, @RequestParam String module_2, @RequestParam String module_3, @RequestParam String module_4, @RequestParam String module_5,
                                    @RequestParam Integer mark_1, @RequestParam Integer mark_2, @RequestParam Integer mark_3, @RequestParam Integer mark_4, @RequestParam Integer mark_5) {
        int[] marks = {mark_1, mark_2, mark_3, mark_4, mark_5};
        int totalmarks = marks[0] + marks[1] + marks[2] + marks[3] + marks[4];
        int grades = totalmarks / 5;
        String classification = null;
        if (grades >= 70 && grades <= 77) {
            classification = "Your Overall Grade Classification is Distinction";
        } else if
        (grades >= 78 && grades <= 84) {
            classification ="Your Overall  Grade Classification is Mid Distinction";
        } else if (grades >= 85 && grades <= 92) {
            classification ="Your Overall  Grade Classification is High Distinction";
        } else if (grades >= 93 && grades <= 100) {
            classification = "Your Overall Grade Classification is Exceptional Distinction";
        } else if (grades >= 60 && grades <= 63) {
            classification = "Your Overall Grade Classification is Commendation";
        } else if (grades >= 50 && grades <= 53) {
            classification ="Your Overall Grade Classification is Pass";
        } else if (grades >= 45 && grades <= 49) {
            classification ="Your Overall Grade Classification is Marginal Fail";
        } else if (grades >= 40 && grades <= 44) {
            classification ="Your Overall Grade Classification is Mid Fail";
        } else if (grades >= 1 && grades <= 39) {
            classification ="Your Overall Grade Classification is Low Fail";
        } else if (grades == 0) {
            classification ="Your Grade Overall Classification is Zero";
        } else if (grades >= 64 && grades <= 66) {
            classification =" Your Grade Overall Classification is Mid Commendation";
        } else if (grades >= 67 && grades <= 69) {
            classification ="Your Grade Overall Classification is High Commendation";
        } else if (grades >= 57 && grades <= 59) {
            classification ="Your Grade Overall Classification is High Pass";
        } else if (grades >= 54 && grades <= 56) {
            classification ="Your Grade Overall Classification is Mid Pass";
        } else {
            classification = "Error";
        }
        return  classification ;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping("/Average")
    static Double getAverage(@RequestParam String module_1, @RequestParam String module_2, @RequestParam String module_3, @RequestParam String module_4, @RequestParam String module_5,
                             @RequestParam Integer mark_1, @RequestParam Integer mark_2, @RequestParam Integer mark_3, @RequestParam Integer mark_4, @RequestParam Integer mark_5) {
        int [] marks = {mark_1,mark_2,mark_3,mark_4,mark_5};
        int totalmarks = marks[0] + marks[1] + marks[2] + marks[3] + marks[4];
        Double average = totalmarks / 5.0;
        System.out.println("Your Overall Grade Average is " + average) ;
        return average;
    }
}


