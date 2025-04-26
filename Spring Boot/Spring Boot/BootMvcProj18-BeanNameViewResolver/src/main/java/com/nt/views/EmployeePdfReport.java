package com.nt.views;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.entity.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("pdf_report")	//pdf_report matches with lvn in controller
public class EmployeePdfReport extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//get Model Attribute data
		List<Employee> list=(List<Employee>) map.get("result");
		//add heading content
		Paragraph para=new Paragraph("Employee Report",new Font(Font.COURIER,20,Font.BOLD,Color.blue));
		document.add(para);
		//create table having employee info
		Table table=new Table(5,list.size());	//cols,rows
		table.setBackgroundColor(Color.cyan);
		for(Employee emp:list) {
			table.addCell(String.valueOf(emp.getEmpno()));
			table.addCell(emp.getEname());
			table.addCell(emp.getJob());
			table.addCell(String.valueOf(emp.getSal()));
			table.addCell(String.valueOf(emp.getDeptno()));	
		}
		document.add(table);
	}

}
