package com.pdf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdf.entity.StudentEntity;

@Repository
public interface PdfRepository extends JpaRepository<StudentEntity, Integer> {

}
