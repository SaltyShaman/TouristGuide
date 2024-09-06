package TouristGuideAPI.repository;

import TouristGuideAPI.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    // ArrayList til opbevaring af TouristAttraction objekter
    private final List<TouristAttraction> attractions = new ArrayList<>();

    // Constructor
    public TouristRepository() {
        // Basic examples
        attractions.add(new TouristAttraction("Tivoli", "Forlystelsespark midt i København centrum"));
        attractions.add(new TouristAttraction("Nyhavn", "Historisk havn og turistmål i København"));
    }

    // Create
    public void addAttraction(TouristAttraction attraction) {
        attractions.add(attraction);
    }

    // Read - all tourist attractions
    public List<TouristAttraction> getAllAttractions() {
        return new ArrayList<>(attractions);
    }

    // Read - based on singlugar name
    public TouristAttraction getAttractionByName(String name) {
        return attractions.stream()
                .filter(attraction -> attraction.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    // Update existing attractions
    public void updateAttraction(String name, TouristAttraction updatedAttraction) {
        for (int i = 0; i < attractions.size(); i++) {
            if (attractions.get(i).getName().equalsIgnoreCase(name)) {
                attractions.set(i, updatedAttraction);
                return;
            }
        }
    }

    // Delete based on name
    public void deleteAttraction(String name) {
        attractions.removeIf(attraction -> attraction.getName().equalsIgnoreCase(name));
    }
}