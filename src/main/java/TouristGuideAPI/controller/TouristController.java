package TouristGuideAPI.controller;

import TouristGuideAPI.model.TouristAttraction;
import TouristGuideAPI.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {

    private final TouristService touristService;

    @Autowired
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("url")
    public ResponseEntity<List<TouristAttraction>> getAllTouristAttractions() {
        List list = touristService.getAllAttractions();
        return new ResponseEntity<List<TouristAttraction>>(list, HttpStatus.OK);

    }

    // Create a new tourist attraction
    @PostMapping
    public ResponseEntity<Void> addAttraction(@RequestBody TouristAttraction attraction) {
        touristService.addAttraction(attraction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Get a single tourist attraction by name
    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        TouristAttraction attraction = touristService.getAttractionByName(name);
            return new ResponseEntity<TouristAttraction>(attraction, HttpStatus.OK);
    }

    // Update a tourist attraction
    @PutMapping("/{name}")
    public ResponseEntity<Void> updateAttraction(@PathVariable String name, @RequestBody TouristAttraction updatedAttraction) {
        touristService.updateAttraction(name, updatedAttraction);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Delete a tourist attraction
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteAttraction(@PathVariable String name) {
        touristService.deleteAttraction(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
