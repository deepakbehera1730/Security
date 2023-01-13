package com.pdf.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.DocumentException;
import com.pdf.entity.StudentEntity;

public interface PdfService {

	public List<StudentEntity> getAllDetails();
	public StudentEntity  addData(StudentEntity studentEntity);
	public void  pdfExport(List<StudentEntity> studentList,HttpServletResponse httpServletResponse) throws DocumentException, IOException;
	
}
