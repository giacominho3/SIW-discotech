package it.uniroma3.siw.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.repository.UtenteRepository;

@Service
public class UtenteService {
	
	@Autowired
	private UtenteRepository utrepo;
	
    @Transactional
    public Utente save(Utente utente) {
        return this.utrepo.save(utente);
    }
    
	/*@Transactional
	public Utente findById (Long id) {
		return this.utrepo.findById(id).get();
	}
    */
    
    public Optional<Utente> findById(Long id){
    	return this.utrepo.findById(id);
    }
    
    public Utente getUtenti(Long id) {
        Optional<Utente> result = this.utrepo.findById(id);
        return result.orElse(null);
    }
	
    public List<Utente> getAllUtenti() {
        List<Utente> result = new ArrayList<>();
        Iterable<Utente> iterable = this.utrepo.findAll();
        for(Utente user : iterable)
            result.add(user);
        return result;
    }
    
	public boolean alreadyExists(Utente u) {
		return utrepo.existsByNomeAndCognome(u.getNome(), u.getCognome());
	}
	
	public void update(Utente utente, Utente newUtente) {
		utente.setNome(newUtente.getNome());
		utente.setCognome(newUtente.getCognome());
		this.utrepo.save(utente);
	}
	
	@Transactional
	public void delete(Long id) {
		this.utrepo.deleteById(id);
	}
}
