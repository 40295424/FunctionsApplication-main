package com.assignment.functions.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SCORES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Scores {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "Module One cannot be Null")
    @NotBlank(message = "Module One cannot be blank")
    private String moduleOne;
    @NotNull(message = "Module Two cannot be Null")
    @NotBlank(message = "Module Two cannot be blank")
    private String moduleTwo;
    @NotNull(message = "Module Three cannot be Null")
    @NotBlank(message = "Module Three cannot be blank")
    private String moduleThree;
    @NotNull(message = "Module Four cannot be Null")
    @NotBlank(message = "Module Four cannot be blank")
    private String moduleFour;
    @NotNull(message = "Module Five cannot be Null")
    @NotBlank(message = "Module Five cannot be blank")
    private String moduleFive;

    @Min(value = 0, message = "Minimum value for Marks 1 is 0")
    @Max(value = 100, message = "Minimum value for Marks 1 is 100")
    private Integer marksOne;
    @Min(value = 0, message = "Minimum value for Marks 2 is 0")
    @Max(value = 100, message = "Minimum value for Marks 2 is 100")
    private Integer marksTwo;
    @Min(value = 0, message = "Minimum value for Marks 3 is 0")
    @Max(value = 100, message = "Minimum value for Marks 3 is 100")
    private Integer marksThree;
    @Min(value = 0, message = "Minimum value for Marks 4 is 0")
    @Max(value = 100, message = "Minimum value for Marks 4 is 100")
    private Integer marksFour;
    @Min(value = 0, message = "Minimum value for Marks 5 is 0")
    @Max(value = 100, message = "Minimum value for Marks 5 is 100")
    private Integer marksFive;
    private String operation;
    private String response;
}
