package com.iamsajan.examservice.model.exam;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "question")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qId;
    @Column(length = 1000)
    private String content;
    private String image;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Quiz quiz;
}
