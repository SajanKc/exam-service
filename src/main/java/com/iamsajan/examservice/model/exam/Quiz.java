package com.iamsajan.examservice.model.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "quiz")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quizId;
    private String title;
    private String description;
    private String maxMarks;
    private String numberOfQuestions;
    private boolean active = false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Question> questions = new HashSet<>();
}
