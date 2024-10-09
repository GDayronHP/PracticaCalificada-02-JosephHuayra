package com.joseph.practicaCalificada02.modelos.entidades;

import com.joseph.practicaCalificada02.aspectos.AuditoriaAspect;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "IAAnswers")
public class IAAnswers implements AuditoriaAspect.Identificable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Cambiado a Integer

    @NotNull
    @Size(min = 2, max = 45)
    private String answerText; // Texto de la respuesta

    @NotNull
    private boolean isCorrect; // Si es correcta o no (true = correcta, false = incorrecta)

    @NotNull
    private Integer questionId; // Cambiado a Integer

    // Constructor vacío
    public IAAnswers() {}

    // Constructor con parámetros
    public IAAnswers(Integer id, String answerText, boolean isCorrect, Integer questionId) {
        this.id = id;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
        this.questionId = questionId;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public void setCorrectAnswer(boolean correct) { // Cambiado a setCorrectAnswer
        isCorrect = correct;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "IAAnswers{" +
                "id=" + id +
                ", answerText='" + answerText + '\'' +
                ", isCorrect=" + isCorrect +
                ", questionId=" + questionId +
                '}';
    }
}
