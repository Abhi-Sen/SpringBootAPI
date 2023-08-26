package com.springrest.springrest.services;

import com.springrest.springrest.model.LoadRequestWrapper;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Load;
import com.springrest.springrest.entities.LoadRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LoadServiceImpl implements LoadService {
    @Autowired
    private LoadRepository loadRepository;

    @Override
    public Load addLoad(Load load) {
        return loadRepository.save(load);
    }

    @Override
    public List<Load> getLoadsByShipperId(String shipperId) {
    	System.out.print("I am here");
        return loadRepository.findByShipperId(shipperId);
    }

    @Override
    public Optional<Load> getLoadById(Long loadId) {
        return loadRepository.findById(loadId);
    }

    @Override
    public Load updateLoad(Long loadId, Load updatedLoad) {
        Optional<Load> existingLoadOptional = loadRepository.findById(loadId);
        if (existingLoadOptional.isPresent()) {
            Load existingLoad = existingLoadOptional.get();
            
            // Update existingLoad fields with updatedLoad
            existingLoad.setLoadingPoint(updatedLoad.getLoadingPoint());
            existingLoad.setUnloadingPoint(updatedLoad.getUnloadingPoint());
            existingLoad.setProductType(updatedLoad.getProductType());
            existingLoad.setTruckType(updatedLoad.getTruckType());
            existingLoad.setNoOfTrucks(updatedLoad.getNoOfTrucks());
            existingLoad.setWeight(updatedLoad.getWeight());
            existingLoad.setComment(updatedLoad.getComment());
            existingLoad.setDate(updatedLoad.getDate());

            return loadRepository.save(existingLoad);
        } else {
            throw new EntityNotFoundException("Load with ID " + loadId + " not found");
        }
    }

    @Override
    public Load updateLoad(Long loadId, LoadRequestWrapper updatedLoad) {
        Optional<Load> existingLoadOptional = loadRepository.findById(loadId);
        if (existingLoadOptional.isPresent()) {
            Load existingLoad = existingLoadOptional.get();
            //do similar for all the fields
            if (updatedLoad.getLoadingPoint() != null) {
                existingLoad.setLoadingPoint(updatedLoad.getLoadingPoint());
            }
            // Update existingLoad fields with updatedLoad

            return loadRepository.save(existingLoad);
        } else {
            throw new EntityNotFoundException("Load with ID " + loadId + " not found");
        }
    }


    @Override
    public void deleteLoad(Long loadId) {
        loadRepository.deleteById(loadId);
    }
}
