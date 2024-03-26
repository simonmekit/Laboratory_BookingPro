package org.simon.laboratory_bookingpro.service;

import org.simon.laboratory_bookingpro.dto.LabLocation;
import org.simon.laboratory_bookingpro.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabLocationService {

    private final LocationRepository labLocationRepository;

    @Autowired
    public LabLocationService(LocationRepository labLocationRepository) {
        this.labLocationRepository = labLocationRepository;
    }

    // Create operation
    public LabLocation createLabLocation(LabLocation labLocation) {
        return labLocationRepository.save(labLocation);
    }

    public LabLocation getLabLocationByCode(int code){
        return labLocationRepository.findLabLocationByLocationCode(code);
    }

    // Read operation
    public LabLocation getLabLocationById(Long id) {
        return labLocationRepository.findById(id).orElse(null);
    }

    // Update operation
    public LabLocation updateLabLocation(Long id, LabLocation labLocation) {
        LabLocation existingLabLocation = labLocationRepository.findById(id).orElse(null);
        if (existingLabLocation != null) {
            existingLabLocation.setName(labLocation.getName());
            existingLabLocation.setLocationCode(labLocation.getLocationCode());
            return labLocationRepository.save(existingLabLocation);
        }
        return null;
    }

    // Delete operation
    public void deleteLabLocation(Long id) {
        labLocationRepository.deleteById(id);
    }

    // Custom query operation
    public LabLocation findLabLocationByName(String name) {
        return labLocationRepository.findByName(name);
    }
}

