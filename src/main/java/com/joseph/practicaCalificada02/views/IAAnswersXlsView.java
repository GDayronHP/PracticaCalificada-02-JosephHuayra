package com.joseph.practicaCalificada02.views;

import com.joseph.practicaCalificada02.modelos.entidades.IAAnswers;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import java.util.List;
import java.util.Map;

@Component("iaAnswers/verIAAnswers.xlsx")
public class IAAnswersXlsView extends AbstractXlsxView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=\"iaAnswers_view.xlsx\"");

        List<IAAnswers> iaAnswersList = (List<IAAnswers>) model.get("iaAnswers");
        Sheet sheet = workbook.createSheet("Lista de Respuestas");

        // Crear fila de título
        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("Lista de Respuestas");

        // Crear cabecera
        Row headerRow = sheet.createRow(1);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Respuesta");
        headerRow.createCell(2).setCellValue("¿Es correcta?");
        headerRow.createCell(3).setCellValue("ID de Pregunta");

        // Estilos de cabecera
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setBorderBottom(BorderStyle.MEDIUM);
        headerStyle.setBorderTop(BorderStyle.MEDIUM);
        headerStyle.setBorderRight(BorderStyle.MEDIUM);
        headerStyle.setBorderLeft(BorderStyle.MEDIUM);
        headerStyle.setFillForegroundColor(IndexedColors.GOLD.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Aplicar estilos a las cabeceras
        for (int i = 0; i < 4; i++) {
            headerRow.getCell(i).setCellStyle(headerStyle);
        }

        // Estilos de cuerpo
        CellStyle bodyStyle = workbook.createCellStyle();
        bodyStyle.setBorderBottom(BorderStyle.THIN);
        bodyStyle.setBorderTop(BorderStyle.THIN);
        bodyStyle.setBorderRight(BorderStyle.THIN);
        bodyStyle.setBorderLeft(BorderStyle.THIN);

        int rownum = 2;

        // Agregar datos de las respuestas
        for (IAAnswers iaAnswer : iaAnswersList) {
            Row row = sheet.createRow(rownum++);

            Cell cell = row.createCell(0);
            cell.setCellValue(iaAnswer.getId());
            cell.setCellStyle(bodyStyle);

            cell = row.createCell(1);
            cell.setCellValue(iaAnswer.getAnswerText());
            cell.setCellStyle(bodyStyle);

            cell = row.createCell(2);
            cell.setCellValue(iaAnswer.getIsCorrect());
            cell.setCellStyle(bodyStyle);

            cell = row.createCell(3);
            cell.setCellValue(iaAnswer.getQuestionId());
            cell.setCellStyle(bodyStyle);
        }
    }
}
