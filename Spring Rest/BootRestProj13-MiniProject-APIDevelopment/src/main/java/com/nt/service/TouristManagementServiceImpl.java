package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Tourist;
import com.nt.error.TouristNotFoundException;
import com.nt.repository.ITouritstRepository;

@Service("touristService")
public class TouristManagementServiceImpl implements ITouristManagementService {

	@Autowired
	private ITouritstRepository repo;
	
	@Override
	public String registerTourist(Tourist tourist) {
		int idVal=repo.save(tourist).getTid();
		return "Tourist is registered with the idValue::"+idVal;
	}

	@Override
	public List<Tourist> showAllTourist() {
		List<Tourist> list=repo.findAll();
		list.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));
		//list.sort((t1,t2)->t1.getTname().compareTo(t2.getTname()));
		return list;
	}

	@Override
	public List<Tourist> showTouristByBudgetRange(double start, double end) {
		return repo.searchTouristsByBudgetRange(start, end);
	}

	@Override
	public Tourist showTouristById(int id) throws TouristNotFoundException {
		return repo.findById(id).orElseThrow(()->new TouristNotFoundException(id+" Tourist is not found"));
	}

	@Override
	public String modifyTourist(Tourist tourist) {
		Optional<Tourist> opt=repo.findById(tourist.getTid());
		if(opt.isPresent()) {
			repo.save(tourist);
			return tourist.getTid()+" tourist is updated";
		}
		return tourist.getTid()+" is not found for updation";
	}

	@Override
	public String modifyTouristBudgetById(int id, double hikePercentage) {
		Optional<Tourist> opt=repo.findById(id);
		if(opt.isPresent()) {
			Tourist tourist=opt.get();
			tourist.setBudget(tourist.getBudget()+tourist.getBudget()*hikePercentage/100.0f);
			repo.save(tourist);
			return id+" tourist budget is updated";
		}
		return id+" tourist is not found for updation";
	}

	@Override
	public String removeTouristById(int id) {
		Optional<Tourist> opt=repo.findById(id);
		if(opt.isPresent()) {
			repo.deleteById(id);
			return id+" tourist found and deleted";
		}
		return id+" tourist not found for deletion";
	}

	@Override
	public String removeTouristsByPackageType(String type) {
		int count=repo.deleteTouristByPackageType(type);
		return count+" no.of tourists are removed";
	}
}
