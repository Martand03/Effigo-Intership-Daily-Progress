package com.inEffigo.library_one_to_one.repository;

import com.inEffigo.library_one_to_one.entity.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDetailsRepository extends JpaRepository<BookDetails, Long> {

}
