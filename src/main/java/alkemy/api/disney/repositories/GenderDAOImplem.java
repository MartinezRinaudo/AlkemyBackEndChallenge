package alkemy.api.disney.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import alkemy.api.disney.exceptions.BadRequestException;
import alkemy.api.disney.exceptions.ErrorEnum;
import alkemy.api.disney.exceptions.NotFoundException;
import alkemy.api.disney.models.GenderModel;

@Repository
public class GenderDAOImplem {

	@Autowired
	GenderDAO genderDAO;

	public List<GenderDTO> getAllGenders() {
		List<GenderModel> genders = genderDAO.findAll();
		List<GenderDTO> gendersDTO = new ArrayList<>();

		if (genders == null) {
			throw new NotFoundException(ErrorEnum.INVALIDGENDER);
		} else {
			genders.forEach(g -> {
				var genderDTO = new GenderDTO(g);
				gendersDTO.add(genderDTO);
			});
			return gendersDTO;
		}
	}

	public GenderDTO getGenderById(Integer id) {
		var genderFound = genderDAO.findById(id);
		if (genderFound == null) {
			throw new NotFoundException(ErrorEnum.INVALIDGENDER);
		} else {
			var genderDTO = new GenderDTO(genderFound);
			return genderDTO;
		}
	}

	public GenderDTO postGender(GenderModel gender) {
		var existingGenderId = gender.getIdGender();
		var existingGenderName = genderDAO.findByName(gender.getName());
		
		if (existingGenderId != null || existingGenderName != null) {
			throw new BadRequestException("This character already exists", ErrorEnum.EXISTINGCHARACTER);
		} else {
			genderDAO.save(gender);
			var genderDTO = new GenderDTO(gender);
			return genderDTO;
		}
	}
	
	public String deleteGender(Integer id) {
		var genderFound = genderDAO.findById(id);
		if(genderFound == null) {
			throw new NotFoundException(ErrorEnum.INVALIDGENDER);
		} else {
			genderDAO.deleteById(id);
			return "Removed character";
		}
	}
	
	public GenderDTO updateGender(GenderModel gender) {
		var genderFound = genderDAO.findByName(gender.getName());
		if(genderFound == null) {
			throw new NotFoundException(ErrorEnum.INVALIDGENDER);
		} else if(gender.equals(genderFound)) {
			throw new BadRequestException("The gender has no modification", ErrorEnum.EXISTINGGENDER);
		} else {
			genderDAO.save(gender);
			var genderDTO = new GenderDTO(gender);
			return genderDTO;
		}
	}
}
