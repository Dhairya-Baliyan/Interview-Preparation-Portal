package com.prepforge.model;
import jakarta.persistence.*;

@Entity
@Table(name = "interview_question")
public class InterviewQuestion {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Difficulty difficulty;

    @Column(nullable = false)
    private String explanation;

    @Column
    private String answer;

    protected InterviewQuestion(){

    }
    // Parameterized Constructor
    public InterviewQuestion(String title, String description, Category category, Difficulty difficulty, String explanation, String answer){
        this.title = title;
        this.description = description;
        this.category = category;
        this.difficulty = difficulty;
        this.explanation = explanation;
        this.answer = answer;
    }

    public Long getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public Category getCategory(){
        return this.category;
    }
    public void setCategory(Category category){
        this.category = category;
    }

    public Difficulty getDifficulty(){
        return this.difficulty;
    }
    public void setDifficulty(Difficulty difficulty){
        this.difficulty = difficulty;
    }

    public String getExplanation(){
        return this.explanation;
    }
    public void setExplanation(String explanation){
        this.explanation = explanation;
    }

    public String getAnswer(){
        return this.answer;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }
}
