package com.inEffigo.fileUpload_AWS.repository;

import com.inEffigo.fileUpload_AWS.entity.UploadedFileAWS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadedFileRepository extends JpaRepository<UploadedFileAWS, Long> {
}
