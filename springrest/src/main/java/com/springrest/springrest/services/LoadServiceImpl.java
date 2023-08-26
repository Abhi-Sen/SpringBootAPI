package com.springrest.springrest.services;

import com.springrest.springrest.model.LoadRequestWrapper;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Load;
import com.springrest.springrest.entities.LoadRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.util.CollectionUtils;

@Service
public class LoadServiceImpl implements LoadService {

    public static final String DD_MM_YYYY = "dd-MM-yyyy";
    @Autowired
    private LoadRepository loadRepository;

    @Override
    public Load addLoad(LoadRequestWrapper loadRequestWrapper) {
        Load load = new Load();
        load.setComment(loadRequestWrapper.getComment());
        load.setDate(LocalDate.parse(loadRequestWrapper.getDate(),DateTimeFormatter.ofPattern(
          DD_MM_YYYY)));
        load.setLoadingPoint(loadRequestWrapper.getLoadingPoint());
        load.setNoOfTrucks(loadRequestWrapper.getNoOfTrucks());
        load.setProductType(loadRequestWrapper.getProductType());
        load.setShipperId(loadRequestWrapper.getShipperId());
        load.setWeight(loadRequestWrapper.getWeight());
        load.setUnloadingPoint(loadRequestWrapper.getUnloadingPoint());
        load.setTruckType(loadRequestWrapper.getTruckType());
        return loadRepository.save(load);
    }

    @Override
    public List<Load> getLoadsByShipperId(String shipperId) {
    	System.out.print("Getting load by shipperId");
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
            if (updatedLoad.getComment() != null) {
                existingLoad.setLoadingPoint(updatedLoad.getLoadingPoint());
            }
            if (updatedLoad.getNoOfTrucks() != 0) {
                existingLoad.setLoadingPoint(updatedLoad.getLoadingPoint());
            }
            if (updatedLoad.getProductType() != null) {
                existingLoad.setLoadingPoint(updatedLoad.getLoadingPoint());
            }
            if (updatedLoad.getTruckType() != null) {
                existingLoad.setLoadingPoint(updatedLoad.getLoadingPoint());
            }
            if (updatedLoad.getUnloadingPoint() != null) {
                existingLoad.setLoadingPoint(updatedLoad.getLoadingPoint());
            }
            if (updatedLoad.getWeight() != 0) {
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
