package com.assignment.functions.service;

import com.assignment.functions.exception.BadRequestException;
import com.assignment.functions.model.Scores;
import com.assignment.functions.repository.ScoresRepository;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class FunctionService {


    @Autowired
    private ScoresRepository scoresRepository ;

    public Scores getTotal(Scores scores) {
        int sum = scores.getMarksOne()
                + scores.getMarksTwo()
                + scores.getMarksThree()
                + scores.getMarksFour()
                + scores.getMarksFive();
        scores.setOperation("sum");
        scores.setResponse("Total marks = " + sum);
        Scores newEntity = scoresRepository.save(scores);
        System.out.println(scores.getResponse());
        return newEntity;
    }

    public Scores alphabetSortModules(Scores scores) {

        String[] modules = {scores.getModuleOne(),
                scores.getModuleTwo(),
                scores.getModuleThree(),
                scores.getModuleFour(),
                scores.getModuleFive()};

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
        List<String> moduleList = List.of(modules);
        scores.setOperation("alphabetSortModules");
        scores.setResponse(Arrays.toString(modules));
        System.out.println(scores.getResponse());
        Scores newEntity =   scoresRepository.save(scores);
        return newEntity;
    }

    public Scores getClassification(Scores scores) {

        int grades = (scores.getMarksOne()
                + scores.getMarksTwo()
                + scores.getMarksThree()
                + scores.getMarksFour()
                + scores.getMarksFive() ) / 5;
        String classification;
        if (grades >= 70 && grades <= 77) {
            classification = "Your Overall Grade Classification is Distinction";
        } else if (grades >= 78 && grades <= 84) {
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
        scores.setOperation("classification");
        scores.setResponse(classification);
        System.out.println(scores.getResponse());
        Scores newEntity =  scoresRepository.save(scores);
        return  newEntity ;
    }

    public Scores getAverage(Scores scores) throws BadRequestException {
        Double average = scores.getMarksOne()
                + scores.getMarksTwo()
                + scores.getMarksThree()
                + scores.getMarksFour()
                + scores.getMarksFive()   / 5.0;
        scores.setOperation("average");
        scores.setResponse("Your Overall Grade Average is " + average);
        System.out.println(scores.getResponse());
        Scores newEntity =  scoresRepository.save(scores);
        return  newEntity ;
    }

    public Scores getMinMax(Scores scores) throws BadRequestException, ParseException {
        scores.setOperation("minmax");
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = String.format("http://maxmin.esha.qpc.hal.davecutting.uk/" +
                        "?module_1=%s&module_2=%s&module_3=%s&module_4=%s" +
                        "&module_5=%s&mark_1=%d&mark_2=%d&mark_3=%d&mark_4=%d&mark_5=%d",
                scores.getModuleOne(),
                scores.getModuleTwo(),
                scores.getModuleThree(),
                scores.getModuleFour(),
                scores.getModuleFive(),
                scores.getMarksOne(),
                scores.getMarksTwo(),
                scores.getMarksThree(),
                scores.getMarksFour(),
                scores.getMarksFive());
        ResponseEntity<String> entity = restTemplate
                .getForEntity(endpoint+
                        endpoint, String.class);
        String response = entity.getBody();
        JSONParser parser = new JSONParser(response);
        Map minMaxModules = (Map)parser.parse();
        scores.setResponse("Highest scoring module = " + minMaxModules.get("max_module")
                + "\nLowest scoring module = " + minMaxModules.get("min_module"));
        System.out.println(scores.getResponse());
        Scores newEntity =  scoresRepository.save(scores);
        return  newEntity ;
    }

    public Scores getSort(Scores scores) throws BadRequestException, ParseException {
        scores.setOperation("sort");
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = String.format("http://sort.esha.qpc.hal.davecutting.uk/" +
                        "?module_1=%s&module_2=%s&module_3=%s&module_4=%s" +
                        "&module_5=%s&mark_1=%d&mark_2=%d&mark_3=%d&mark_4=%d&mark_5=%d",
                scores.getModuleOne(),
                scores.getModuleTwo(),
                scores.getModuleThree(),
                scores.getModuleFour(),
                scores.getModuleFive(),
                scores.getMarksOne(),
                scores.getMarksTwo(),
                scores.getMarksThree(),
                scores.getMarksFour(),
                scores.getMarksFive());
        ResponseEntity<String> entity = restTemplate
                .getForEntity(endpoint+
                        endpoint, String.class);
        String response = entity.getBody();
        JSONParser parser = new JSONParser(response);
        Map sortedModules = (Map)parser.parse();
        List<LinkedHashMap> objects = (List<LinkedHashMap>) sortedModules.get("sorted_modules");
        String sortedModuleString = "\r\n";
        for (int i = 0; i < objects.size(); i++) {
            sortedModuleString += objects.get(i).get("module") + " - " + objects.get(i).get("marks")  + "\r\n";
        }
        scores.setResponse(sortedModuleString);
        System.out.println(scores.getResponse());
        Scores newEntity =  scoresRepository.save(scores);
        return  newEntity ;
    }

    public Scores getOperation(Integer id) {
        return scoresRepository.findById(id).orElse(null);
    }
}
