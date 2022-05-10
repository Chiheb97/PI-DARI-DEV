package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entities.Annonce;
import tn.esprit.spring.entities.Etat;
import tn.esprit.spring.entities.Transaction;
import tn.esprit.spring.entities.TypeBien;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.services.AnnonceService;


@RestController
@CrossOrigin

public class AnnonceController {

	// Annotation
	//autoweired taamel el recherche bein selon type 
	@Autowired 
	AnnonceService annonceService;
	// Save operation
	@PostMapping("/add-annonce/{id}")
	public Annonce saveAnnonce(@RequestBody Annonce annonce,@PathVariable("id") Long id) {
		return annonceService.saveAnnonce(annonce,id);
	}

	// Read operation
	@GetMapping("/retreive-annonces")
	public List<Annonce> listAllAnnonces() {

		return annonceService.listAllAnnonces();
	}
	
	// Read operation
		@GetMapping("/findAllByuser/{id}")
		public List<Annonce> findAllByuser(@PathVariable("id") Long id) {

			return annonceService.findAllByuser(id);
		}
		
	// Read operation
	@GetMapping("/liste-annonces/{nbrchambre}/{localisation}/{etat}/{age}/{typedebien}/{transaction}")
	public List<Annonce> suggsetion(
				@PathVariable("nbrchambre") int nbrchambre,
				@PathVariable("age") int age,
				@PathVariable("localisation") String localisation,
				@PathVariable("etat") Etat etat,
				@PathVariable("typedebien") TypeBien typedebien,
				@PathVariable("transaction") Transaction transaction)
	   {
		
			return annonceService.suggsetion(nbrchambre,age,localisation,etat,typedebien,transaction);
		}
	
	// Update operation
	@PutMapping("/update-annonces/{id}")
	public Annonce updateAnnonce(@RequestBody Annonce annonce, @PathVariable("id") Long annonceId) {

		return annonceService.updateAnnonce(annonce, annonceId);
	}

	// Delete operation
	@DeleteMapping("/delete-annonces/{id}")
	@ResponseBody
	public String deleteAnnonceById(@PathVariable("id") Long annonceId) {

		annonceService.deleteAnnonceById(annonceId);
		return "Deleted Successfully";
	}
	
	// Read operation
	@GetMapping("/find-annonces/{description}")
	public List<Annonce> fetchAnnonceList(@PathVariable("description") String keyword) {

		return annonceService.fetchAnnonceList(keyword);
	}
	
	
	// range of price
	@GetMapping("/range/{max}")
	public List<Annonce> RangeProducts(@PathVariable("max") Double max) {
		return annonceService.Range(max);
    }
	
	// indexsation des prix 
	
	@GetMapping("/avrege")
	public String Avregeofprice(Annonce annonce) {
		return annonceService.Avregeofprice(annonce);
    }
	
	@GetMapping("/nbr-vue/{id}")
	@ResponseBody
	public String  nombrevue(@PathVariable("id") Long annonceId)
	{
		 annonceService.nombrevue(annonceId);
		return "vu ";

	}
	
	// Save operation
	@PostMapping("/add-annoncebyestimation")
	public Annonce saveAnnoncebyestimation(@RequestBody Annonce annonce) {
			return annonceService.estimationprix(annonce);		}
	//image
	@PutMapping("/affecter-fileToAnnonce/{id-annonce}/{files}")
	@ResponseBody
	public void affecterFilesToTrip(@PathVariable("files") Long idfile, @PathVariable("id-annonce") Long idAnnonce) {
		annonceService.affecterFileToAnnonce(idfile, idAnnonce);

	}
	
	@GetMapping("/retreive-annonces-vente")
	public ResponseEntity<?> fetchAnnonceListByTransaction() {

		return ResponseEntity.ok(annonceService.fetchAnnonceListByTransaction(Transaction.valueOf("Buy")));
	}
	
	@GetMapping("/retreive-annonces-location")
	public ResponseEntity<?> fetchAnnonceListByTransaction1() {

		return ResponseEntity.ok(annonceService.fetchAnnonceListByTransaction(Transaction.valueOf("Rent")));
	}
	@GetMapping("/annonceById/{id}")
	public  Annonce getbyid(@PathVariable Long id ){
		return annonceService.retrieveAnnonce(id);
	}
	
	@GetMapping("/sugg")
	public List<Annonce> suggsetion(int nbrchambre, int age, String localisation, Etat etat, TypeBien typedebien, Transaction transaction);
	{
		return annonceService.suggsetione(int nbrchambre, int age, String localisation, Etat etat, TypeBien typedebien, Transaction transaction);

	}
	
	
	 // importer la liste des annonces en vente dans un fichier PDF
 //	@RequestMapping(value = "/pdfreport", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
 //	public ResponseEntity<InputStreamResource> AnnonceReport() {
//
 //		List<Annonce> an = (List<Annonce>) annonceService.findselected();
 
 	//	ByteArrayInputStream bis = GeneratePdfReport.AnnonceReport(mb);
//
 //		HttpHeaders headers = new HttpHeaders();
 	//	headers.add("Content-Disposition", "inline; filename=annoncereport.pdf");

 		//return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
 			//	.body(new InputStreamResource(bis));
 	//}

	
}
