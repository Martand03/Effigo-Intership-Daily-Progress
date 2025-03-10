package com.inEffigo.fileStorageInAzure.repository;

import com.inEffigo.fileStorageInAzure.entity.FileMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileMetadataRepository extends JpaRepository<FileMetadata, Long> {
}
