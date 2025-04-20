package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Player;
import com.nt.repository.IMedalRepository;
import com.nt.repository.IPlayerRepository;
import com.nt.repository.ISportRepository;

@Service("onetomanyserv")
public class OneToManyAssociationServiceImpl implements IOneToManyAssociationService {

	@Autowired
	private IMedalRepository medalrepo;
	@Autowired
	private IPlayerRepository playrepo;
	@Autowired
	private ISportRepository sportrepo;
	
	@Override
	public String saveDataUsingPerson(Player player) {
		int idVal=playrepo.save(player).getPid();
		return "Player details has been saved with id No of:: "+idVal;
	}

}
