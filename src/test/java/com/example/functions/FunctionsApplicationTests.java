package com.example.functions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
class FunctionsApplicationTests {
    /*
     * Copyright 2012-2014 the original author or authors.
     *
     * Licensed under the Apache License, Version 2.0 (the "License");
     * you may not use this file except in compliance with the License.
     * You may obtain a copy of the License at
     *
     *	  https://www.apache.org/licenses/LICENSE-2.0
     *
     * Unless required by applicable law or agreed to in writing, software
     * distributed under the License is distributed on an "AS IS" BASIS,
     * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * See the License for the specific language governing permissions and
     * limitations under the License.
     */


    @ExtendWith(SpringExtension.class)
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    @DirtiesContext
    public static class FunctionsConfigurationTests {

        @LocalServerPort
        private int port;

        @Autowired
        private TestRestTemplate restTemplate;

        @Test
        public void Totaltest() throws Exception {

            String module1 = "module1";
            String module2 = "module2";
            String module3 = "module3";
            String module4 = "module4";
            String module5 = "module5";
            Integer mark1 = 10;
            Integer mark2 = 10;
            Integer mark3 = 10;
            Integer mark4 = 10;
            Integer mark5 = 10;
            String endpoint = String.format("/total?module_1=%s&module_2=%s&module_3=%s&module_4=%s&module_5=%s&mark_1=%d&mark_2=%d&mark_3=%d&mark_4=%d&mark_5=%d",
                    module1, module2, module3, module4, module5, mark1, mark2, mark3, mark4, mark5);
            ResponseEntity<String> entity = restTemplate
                    .getForEntity("http://localhost:" + this.port +
                            endpoint, String.class);
            Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());
            Assertions.assertEquals(mark1 + mark2 + mark3 + mark4, mark5, Integer.parseInt(entity.getBody()));
        }

        @Test
        public void AverageTest() throws Exception {
            {
                String module1 = "module1";
                String module2 = "module2";
                String module3 = "module3";
                String module4 = "module4";
                String module5 = "module5";
                Integer mark1 = 10;
                Integer mark2 = 10;
                Integer mark3 = 10;
                Integer mark4 = 10;
                Integer mark5 = 10;
                String endpoint = String.format("/Average?module_1=%s&module_2=%s&module_3=%s&module_4=%s&module_5=%s&mark_1=%d&mark_2=%d&mark_3=%d&mark_4=%d&mark_5=%d",
                        module1, module2, module3, module4, module5, mark1, mark2, mark3, mark4, mark5);
                ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:" + this.port + endpoint, String.class);
                Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());
                Assertions.assertEquals(Double.valueOf(10.0), Double.valueOf(entity.getBody()));
            }
        }

        @Test
        public void ClassificationTest() throws Exception {
            {
                String module1 = "module1";
                String module2 = "module2";
                String module3 = "module3";
                String module4 = "module4";
                String module5 = "module5";
                Integer mark1 = 5;
                Integer mark2 = 10;
                Integer mark3 = 10;
                Integer mark4 = 10;
                Integer mark5 = 10;
                String endpoint = String.format("/Classification?module_1=%s&module_2=%s&module_3=%s&module_4=%s&module_5=%s&mark_1=%d&mark_2=%d&mark_3=%d&mark_4=%d&mark_5=%d",
                        module1, module2, module3, module4, module5, mark1, mark2, mark3, mark4, mark5);
                ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:" + this.port + endpoint, String.class);
                Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());
                Assertions.assertEquals("Your Overall Grade Classification is Low Fail", String.valueOf(entity.getBody()));
            }

        }

        @Test
            public void AlphabeticSortTest () throws Exception {
                {
                    String module1 = "a1";
                    String module2 = "a3";
                    String module3 = "c2";
                    String module4 = "c3";
                    String module5 = "b2";
                    Integer mark1 = 10;
                    Integer mark2 = 10;
                    Integer mark3 = 10;
                    Integer mark4 = 10;
                    Integer mark5 = 10;
                    String endpoint = String.format("/AlphabeticalOrder?module_1=%s&module_2=%s&module_3=%s&module_4=%s&module_5=%s&mark_1=%d&mark_2=%d&mark_3=%d&mark_4=%d&mark_5=%d",
                            module1, module2, module3, module4, module5, mark1, mark2, mark3, mark4, mark5);
                    ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:" + this.port + endpoint, String.class);
                    Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());
                    List<String> expected = List.of("a1", "a3", "b2", "c2", "c3");
                    ObjectMapper objectMapper = new ObjectMapper();
                    List<String> actual = objectMapper.readValue(entity.getBody(),new TypeReference<List<String>>(){});
                    Assertions.assertEquals(expected.toString(), actual.toString());
                }

            }
        }
    }
