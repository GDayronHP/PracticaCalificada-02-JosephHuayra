package com.joseph.practicaCalificada02.views;

import com.joseph.practicaCalificada02.modelos.entidades.IAQuestion;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import java.util.List;
import java.util.Map;

@Component("iaQuestion/verIAQuestion.xlsx")
public class IAQuestionXlsView extends AbstractXlsxView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=\"iaQuestion_view.xlsx\"");

        List<IAQuestion> iaQuestionList = (List<IAQuestion>) model.get("iaQuestion");
        Sheet sheet = workbook.createSheet("Lista de Preguntas");

        // Crear fila de título
        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("Lista de Preguntas");

        // Crear cabecera
        Row headerRow = sheet.createRow(1);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Pregunta");
        headerRow.createCell(2).setCellValue("Tiempo Límite");
        headerRow.createCell(3).setCellValue("Quiz ID");
        headerRow.createCell(4).setCellValue("Tipo de Pregunta ID");

        // Estilos de cabecera
        CellStyle theaderStyle = workbook.createCellStyle();
        theaderStyle.setBorderBottom(BorderStyle.MEDIUM);
        theaderStyle.setBorderTop(BorderStyle.MEDIUM);
        theaderStyle.setBorderRight(BorderStyle.MEDIUM);
        theaderStyle.setBorderLeft(BorderStyle.MEDIUM);
        theaderStyle.setFillForegroundColor(IndexedColors.GOLD.index);
        theaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Aplicar estilos a las cabeceras
        for (int i = 0; i < 5; i++) {
            headerRow.getCell(i).setCellStyle(theaderStyle);
        }

        // Estilos de cuerpo
        CellStyle tbodyStyle = workbook.createCellStyle();
        tbodyStyle.setBorderBottom(BorderStyle.THIN);
        tbodyStyle.setBorderTop(BorderStyle.THIN);
        tbodyStyle.setBorderRight(BorderStyle.THIN);
        tbodyStyle.setBorderLeft(BorderStyle.THIN);

        int rownum = 2;

        // Agregar datos de las preguntas
        for (IAQuestion iaQuestion : iaQuestionList) {
            Row row = sheet.createRow(rownum++);

            Cell cell = row.createCell(0);
            cell.setCellValue(iaQuestion.getId());
            cell.setCellStyle(tbodyStyle);

            cell = row.createCell(1);
            cell.setCellValue(iaQuestion.getQuestionText());
            cell.setCellStyle(tbodyStyle);

            cell = row.createCell(2);
            cell.setCellValue(iaQuestion.getTimeLimit());
            cell.setCellStyle(tbodyStyle);

            cell = row.createCell(3);
            cell.setCellValue(iaQuestion.getQuizId());
            cell.setCellStyle(tbodyStyle);

            cell = row.createCell(4);
            cell.setCellValue(iaQuestion.getQuestionTypeId());
            cell.setCellStyle(tbodyStyle);
        }
    }
}
