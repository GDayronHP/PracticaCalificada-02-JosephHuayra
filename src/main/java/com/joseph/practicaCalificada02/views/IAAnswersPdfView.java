package com.joseph.practicaCalificada02.views;

import com.joseph.practicaCalificada02.modelos.entidades.IAAnswers;
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

@Component("iaAnswers/verIAAnswers")
public class IAAnswersPdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<IAAnswers> iaAnswers = (List<IAAnswers>)model.get("iaAnswers");

        PdfPTable tabla = new PdfPTable(1);
        tabla.setSpacingAfter(20);

        PdfPCell cell = null;

        cell = new PdfPCell(new Phrase("Lista de Preguntas"));
        cell.setBackgroundColor(new Color(184, 218, 255));
        cell.setPadding(8f);
        tabla.addCell(cell);

        PdfPTable tabla2 = new PdfPTable(4);
        //tabla2.setWidths(new float [] {3.5f, 1, 1, 1});
        tabla2.addCell("id");
        tabla2.addCell("Respuesta");
        tabla2.addCell("¿Es correcta?");
        tabla2.addCell("ID de Pregunta");

        for(IAAnswers iaAnswer: iaAnswers) {
            tabla2.addCell(""+iaAnswer.getId());
            tabla2.addCell(""+iaAnswer.getAnswerText());
            tabla2.addCell(""+iaAnswer.getIsCorrect());
            tabla2.addCell(""+iaAnswer.getQuestionId());

        }
        document.add(tabla);
        document.add(tabla2);
    }
}
