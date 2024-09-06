package TouristGuideAPI.service;

import TouristGuideAPI.model.TouristAttraction;
import TouristGuideAPI.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    private final TouristRepository touristRepository;

    @Autowired
    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    // Create
    public void addAttraction(TouristAttraction attraction) {
        touristRepository.addAttraction(attraction);
    }

    // Read - all attractions
    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.getAllAttractions();
    }

    // Read - single attraction by name
    public TouristAttraction getAttractionByName(String name) {
        return touristRepository.getAttractionByName(name);
    }

    // Update
    public void updateAttraction(String name, TouristAttraction updatedAttraction) {
        touristRepository.updateAttraction(name, updatedAttraction);
    }

    // Delete
    public void deleteAttraction(String name) {
        touristRepository.deleteAttraction(name);
    }
}

