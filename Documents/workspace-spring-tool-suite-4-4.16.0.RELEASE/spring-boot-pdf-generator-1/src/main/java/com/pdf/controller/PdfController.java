package com.pdf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.DocumentException;
import com.pdf.entity.StudentEntity;
import com.pdf.serviceimpl.PdfServiceImpl;

@RequestMapping("/student")
@RestController
public class PdfController {
	
	@Autowired
	private PdfServiceImpl pdfServiceImpl;
	
	@GetMapping()
public List<StudentEntity> getAll()
{
	return pdfServiceImpl.getAllDetails();	
}
@PostMapping()
public String addStudent(@RequestBody StudentEntity studentEntity)
{
	pdfServiceImpl.addData(studentEntity);
	return "Users Added Succesfully";
}

@GetMapping("/export-to-pdf")
public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException 
{
  response.setContentType("application/pdf");
  
  
  String headerkey = "Content_Disposition";
  String headervalue = "attachment;filename=pdf_;.pdf";
  response.setHeader(headerkey, headervalue);
  List < StudentEntity> listofStudents = pdfServiceImpl.getAllDetails();
  
  pdfServiceImpl.pdfExport(listofStudents, response);
}
}