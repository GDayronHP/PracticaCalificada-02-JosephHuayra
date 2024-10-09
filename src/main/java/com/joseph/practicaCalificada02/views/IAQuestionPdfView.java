package com.joseph.practicaCalificada02.views;

import com.joseph.practicaCalificada02.modelos.entidades.IAQuestion;
import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import java.awt.*;
import java.util.List;
import java.util.Map;

@Component("iaQuestion/verIAQuestion")
public class IAQuestionPdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<IAQuestion> iaQuestions = (List<IAQuestion>)model.get("iaQuestion");

        PdfPTable tabla = new PdfPTable(1);
        tabla.setSpacingAfter(20);

        PdfPCell cell = null;

        cell = new PdfPCell(new Phrase("Lista de Preguntas"));
        cell.setBackgroundColor(new Color(184, 218, 255));
        cell.setPadding(8f);
        tabla.addCell(cell);

        PdfPTable tabla2 = new PdfPTable(5);
        //tabla2.setWidths(new float [] {3.5f, 1, 1, 1});
        tabla2.addCell("id");
        tabla2.addCell("Pregunta");
        tabla2.addCell("Tiempo Límite");
        tabla2.addCell("Quiz ID");
        tabla2.addCell("Tipo de Pregunta ID");

        for(IAQuestion iaQuestion: iaQuestions) {
            tabla2.addCell(""+iaQuestion.getId());
            tabla2.addCell(""+iaQuestion.getQuestionText());
            tabla2.addCell(""+iaQuestion.getTimeLimit());
            tabla2.addCell(""+iaQuestion.getQuizId());
            tabla2.addCell(""+iaQuestion.getQuestionTypeId());

        }
        document.add(tabla);
        document.add(tabla2);
    }
}
