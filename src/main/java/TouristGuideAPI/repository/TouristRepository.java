package TouristGuideAPI.repository;

import TouristGuideAPI.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    private final List<TouristAttraction> attractions = new ArrayList<>();

    public TouristRepository() {
        // Basic examples
        attractions.add(new TouristAttraction("Tivoli", "Forlystelsespark midt i København centrum"));
        attractions.add(new TouristAttraction("Nyhavn", "Historisk havn og turistmål i København"));
    }

    public void addAttraction(TouristAttraction attraction) {
        attractions.add(attraction);
    }

    public List<TouristAttraction> getAllAttractions() {
        return new ArrayList<>(attractions);
    }

    public TouristAttraction getAttractionByName(String name) {
        for (TouristAttraction touristAttraction : attractions) {
            if (touristAttraction.getName().equals(name)) {
                return touristAttraction;
            }
        }
        return null;
    }

    public void updateAttraction(String name, TouristAttraction updatedAttraction) {
        for (int i = 0; i < attractions.size(); i++) {
            if (attractions.get(i).getName().equalsIgnoreCase(name)) {
                attractions.set(i, updatedAttraction);
                return;
            }
        }
    }

    public void deleteAttraction(String name) {
        attractions.removeIf(attraction -> attraction.getName().equalsIgnoreCase(name));
    }
}
