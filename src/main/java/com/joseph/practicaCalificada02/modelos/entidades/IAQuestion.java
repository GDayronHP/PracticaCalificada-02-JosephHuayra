package com.joseph.practicaCalificada02.modelos.entidades;

import com.joseph.practicaCalificada02.aspectos.AuditoriaAspect;
import jakarta.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "IAQuestion")
public class IAQuestion implements AuditoriaAspect.Identificable{

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // Cambiado de int a Integer

    @Column
    @NotNull
    @Size(min = 2, max = 200)
    private String questionText; // Texto de la pregunta

    @Column
    @NotNull
    private String timeLimit; // Límite de tiempo para responder

    @Column
    @NotNull
    private int quizId; // Foreign key para la tabla Quizizz (almacenado solo como entero)

    @Column
    @NotNull
    private int questionTypeId; // Foreign key para la tabla QuestionType (almacenado solo como entero)

    // Constructor vacío
    public IAQuestion() {}

    // Constructor con parámetros
    public IAQuestion(Integer id, String questionText, String timeLimit, int quizId, int questionTypeId) {
        this.id = id;
        this.questionText = questionText;
        this.timeLimit = timeLimit;
        this.quizId = quizId;
        this.questionTypeId = questionTypeId;
    }

    // Getters y Setters
    @Override
    public Integer getId() {  // Cambiado de int a Integer
        return id;
    }

    public void setId(Integer id) {  // Cambiado de int a Integer
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    @Override
    public String toString() {
        return "IAQuestion{" +
                "id=" + id +
                ", questionText='" + questionText + '\'' +
                ", timeLimit='" + timeLimit + '\'' +
                ", quizId=" + quizId +
                ", questionTypeId=" + questionTypeId +
                '}';
    }
}
