package com.collado.annuaire.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.collado.annuaire.carnet.Carnet;
import com.collado.annuaire.carnet.Civilite;
import com.collado.annuaire.repository.CarnetRepository;

@Service
public class CarnetService implements CarnetRepository{
	List<Carnet> listeCarnets = new ArrayList<Carnet>(Arrays.asList(
			new Carnet(1, Civilite.M, "Besson", "Luc", "1959-13-18", "0000000000", "5 avenue de l'Element", "75015", "Paris"),
			new Carnet(2, Civilite.MME, "Ullmann", "Liv", "1938-12-16", "0101010101", "1-16-5", "22", "Tokyo"),
			new Carnet(3, Civilite.M, "Lynch", "David", "1946-01-20", "0202020202", "423 Fire Terrace", "59801", "Missoula")));
	
	//GET
	public List<Carnet> getAll() {
		//salut
		return this.listeCarnets;
	}
	
	//GET
	public Carnet getById(int id) {
		for (Carnet c : this.listeCarnets) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}

	//DELETE
	public void DelById(Integer id) {
		this.listeCarnets.removeIf(carnet -> carnet.getId() == id);
	}

	//POST
	public void add(Carnet carnet) {
		this.listeCarnets.add(carnet);
	}

	//PUT
	public Carnet update(Carnet carnet,Integer id) {
		for (Integer i = 0; i < this.listeCarnets.size(); i++) {
			Carnet c = this.listeCarnets.get(i);
			if (c.getId() == id) {
				this.listeCarnets.set(i, carnet);
				break;
			}
		}
		return null;
	}
	
	public void addCarnet(Carnet carnet) {
			carnet.setId(this.listeCarnets.size()+1);
			listeCarnets.add(carnet);
	}
	
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void delete(Carnet arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAll(Iterable<? extends Carnet> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteById(Integer arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean existsById(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Iterable<Carnet> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterable<Carnet> findAllById(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<Carnet> findById(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Carnet> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Carnet> Iterable<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
