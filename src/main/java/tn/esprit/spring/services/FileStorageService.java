package tn.esprit.spring.services;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import tn.esprit.spring.entities.Annonce;
import tn.esprit.spring.entities.FileDB;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.repository.FileDBRepository;



@Service
public class FileStorageService {
	Long idf;
  @Autowired
  private FileDBRepository fileDBRepo;
  @Autowired
  AnnonceRepository annonceRepo;
  public FileDB store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
    return fileDBRepo.save(FileDB);
  }
  public Long store1(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
	    fileDBRepo.save(FileDB);
	    return FileDB.getId();
	  }
  public void deletefile(Long idfile) {
	  FileDB f =fileDBRepo.findById(idfile).orElse(null);
	  Annonce a=f.getAnnonce();
	  a.setFiles(null);
	  fileDBRepo.delete(f);
  }
  public FileDB getFile(Long id) {
    return fileDBRepo.findById(id).orElse(null);
  }
  
  
  public Stream<FileDB> getAllFiles() {
    return fileDBRepo.findAll().stream();
  }
  public FileDB getFileByannonce(Long id) {
	  Annonce t =annonceRepo.findById(id).orElse(null);
	    return t.getFiles();
	  }
 
}