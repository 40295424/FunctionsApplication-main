package com.assignment.functions.controller;

import com.assignment.functions.exception.BadRequestException;
import com.assignment.functions.model.Scores;
import com.assignment.functions.service.FunctionService;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FunctionController {

    @Autowired
    private FunctionService functionService;

    @CrossOrigin(origins = "*")
    @GetMapping("/total")
    public String getTotal(@RequestParam String module_1, @RequestParam String module_2,
                            @RequestParam String module_3, @RequestParam String module_4,
                            @RequestParam String module_5,
                            @RequestParam Integer mark_1, @RequestParam Integer mark_2,
                            @RequestParam Integer mark_3, @RequestParam Integer mark_4,
                            @RequestParam Integer mark_5) throws BadRequestException {

        Scores newScores = functionService.getTotal(Scores.builder()
                .marksOne(mark_1)
                .marksTwo(mark_2)
                .marksThree(mark_3)
                .marksFour(mark_4)
                .marksFive(mark_5)
                .moduleOne(module_1)
                .moduleTwo(module_2)
                .moduleThree(module_3)
                .moduleFour(module_4)
                .moduleFive(module_5)
                .build());
        return  String.format("Request ID: %d Response: %s",
                newScores.getId(),
                newScores.getResponse());
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/AlphabeticalOrder")
    public String AlphabetSortModules(@RequestParam String module_1, @RequestParam String module_2,
                                      @RequestParam String module_3, @RequestParam String module_4,
                                      @RequestParam String module_5,
                                      @RequestParam Integer mark_1, @RequestParam Integer mark_2,
                                      @RequestParam Integer mark_3, @RequestParam Integer mark_4,
                                      @RequestParam Integer mark_5) throws BadRequestException {

        Scores newScores = functionService.alphabetSortModules(Scores.builder()
                .marksOne(mark_1)
                .marksTwo(mark_2)
                .marksThree(mark_3)
                .marksFour(mark_4)
                .marksFive(mark_5)
                .moduleOne(module_1)
                .moduleTwo(module_2)
                .moduleThree(module_3)
                .moduleFour(module_4)
                .moduleFive(module_5)
                .build());
        return  String.format("Request ID: %d Response: %s",
                newScores.getId(),
                newScores.getResponse());
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/Classification")
    public String getClassification(@RequestParam String module_1, @RequestParam String module_2,
                                    @RequestParam String module_3, @RequestParam String module_4,
                                    @RequestParam String module_5,
                                    @RequestParam Integer mark_1, @RequestParam Integer mark_2,
                                    @RequestParam Integer mark_3, @RequestParam Integer mark_4,
                                    @RequestParam Integer mark_5) throws BadRequestException {

        Scores newScores = functionService.getClassification(Scores.builder()
                .marksOne(mark_1)
                .marksTwo(mark_2)
                .marksThree(mark_3)
                .marksFour(mark_4)
                .marksFive(mark_5)
                .moduleOne(module_1)
                .moduleTwo(module_2)
                .moduleThree(module_3)
                .moduleFour(module_4)
                .moduleFive(module_5)
                .build());
        return  String.format("Request ID: %d Response: %s",
                newScores.getId(),
                newScores.getResponse());
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/Average")
    public String getAverage(@RequestParam String module_1, @RequestParam String module_2,
                             @RequestParam String module_3, @RequestParam String module_4,
                             @RequestParam String module_5,
                             @RequestParam Integer mark_1, @RequestParam Integer mark_2,
                             @RequestParam Integer mark_3, @RequestParam Integer mark_4,
                             @RequestParam Integer mark_5) throws BadRequestException {


        Scores newScores = functionService.getAverage(Scores.builder()
                .marksOne(mark_1)
                .marksTwo(mark_2)
                .marksThree(mark_3)
                .marksFour(mark_4)
                .marksFive(mark_5)
                .moduleOne(module_1)
                .moduleTwo(module_2)
                .moduleThree(module_3)
                .moduleFour(module_4)
                .moduleFive(module_5)
                .build());
        return  String.format("Request ID: %d Response: %s",
                newScores.getId(),
                newScores.getResponse());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/retrieve")
    public String getTotal(@RequestParam Integer id) {
        return functionService.getOperation(id).getResponse();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/minmax")
    public String getMinMax(@RequestParam String module_1, @RequestParam String module_2,
                                   @RequestParam String module_3, @RequestParam String module_4,
                                   @RequestParam String module_5,
                                   @RequestParam Integer mark_1, @RequestParam Integer mark_2,
                                   @RequestParam Integer mark_3, @RequestParam Integer mark_4,
                                   @RequestParam Integer mark_5) throws BadRequestException, ParseException {
        Scores newScores = functionService.getMinMax(Scores.builder()
                .marksOne(mark_1)
                .marksTwo(mark_2)
                .marksThree(mark_3)
                .marksFour(mark_4)
                .marksFive(mark_5)
                .moduleOne(module_1)
                .moduleTwo(module_2)
                .moduleThree(module_3)
                .moduleFour(module_4)
                .moduleFive(module_5)
                .build());
        return  String.format("Request ID: %d Response: %s",
                newScores.getId(),
                newScores.getResponse());

    }

    @CrossOrigin(origins = "*")
    @GetMapping("/sort")
    public String getSort(@RequestParam String module_1, @RequestParam String module_2,
                            @RequestParam String module_3, @RequestParam String module_4,
                            @RequestParam String module_5,
                            @RequestParam Integer mark_1, @RequestParam Integer mark_2,
                            @RequestParam Integer mark_3, @RequestParam Integer mark_4,
                            @RequestParam Integer mark_5) throws BadRequestException, ParseException {
        Scores newScores = functionService.getSort(Scores.builder()
                .marksOne(mark_1)
                .marksTwo(mark_2)
                .marksThree(mark_3)
                .marksFour(mark_4)
                .marksFive(mark_5)
                .moduleOne(module_1)
                .moduleTwo(module_2)
                .moduleThree(module_3)
                .moduleFour(module_4)
                .moduleFive(module_5)
                .build());

        return  String.format("Request ID: %d Response: %s",
                newScores.getId(),
                newScores.getResponse());

    }

}
