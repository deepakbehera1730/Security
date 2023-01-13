package com.pdf.serviceimpl;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.pdf.entity.StudentEntity;
import com.pdf.repository.PdfRepository;
import com.pdf.service.PdfService;

@Service
public class PdfServiceImpl implements PdfService {

	@Autowired
	private PdfRepository pdfRepository;
	@Override
	public List<StudentEntity> getAllDetails() {
		// TODO Auto-generated method stub
		return pdfRepository.findAll();
	}

	@Override
	public StudentEntity addData(StudentEntity studentEntity) {
		// TODO Auto-generated method stub
		return pdfRepository.save(studentEntity);
	}

	@Override
	public void pdfExport(List<StudentEntity> studentList,HttpServletResponse httpServletResponse) throws DocumentException, IOException {
		// TODO Auto-generated method stub
		
		Document document=new Document();
		
		PdfWriter.getInstance(document, httpServletResponse.getOutputStream());
		
		document.open();
		
	Font fontTitle= FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	fontTitle.setSize(18);
	Paragraph paragraph=new Paragraph("Student Details",fontTitle);
	
	paragraph.setAlignment(Paragraph.ALIGN_CENTER);
	
	document.add(paragraph);
	
	PdfPTable pdfTable=new PdfPTable(5);
	
	PdfPCell cell = new PdfPCell();
	cell.setBackgroundColor(CMYKColor.RED);
    cell.setPadding(5);
    Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
    font.setColor(CMYKColor.BLUE);
    
    cell.setPhrase(new Phrase("ID",font));
    pdfTable.addCell(cell);
    
    cell.setPhrase(new Phrase("Name",font));
    pdfTable.addCell(cell);
    
    cell.setPhrase(new Phrase("Email",font));
    pdfTable.addCell(cell);
    
    cell.setPhrase(new Phrase("Department",font));
    pdfTable.addCell(cell);
    
    cell.setPhrase(new Phrase("time",font));
    pdfTable.addCell(cell);
    
    for (StudentEntity students: studentList)
    {
    	pdfTable.addCell(String.valueOf(students.getId()));
    	
    	pdfTable.addCell(String.valueOf(students.getName()));
    	
    	pdfTable.addCell(String.valueOf(students.getEmail()));
    	pdfTable.addCell(String.valueOf(students.getDepartment()));
    	pdfTable.addCell(String.valueOf(students.getCreated_at()));
    }
    
    document.add(pdfTable);
    document.close();
    
    
    
    
	
	
		
		
	}
	

}
