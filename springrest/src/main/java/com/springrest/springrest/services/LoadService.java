package com.springrest.springrest.services;

import com.springrest.springrest.model.LoadRequestWrapper;
import java.util.List;
import java.util.Optional;

import com.springrest.springrest.entities.Load;

public interface LoadService {
    Load addLoad(Load load);
    List<Load> getLoadsByShipperId(String shipperId);
    Optional<Load> getLoadById(Long loadId);
    Load updateLoad(Long loadId, Load updatedLoad);
    void deleteLoad(Long loadId);

    void updateLoad(Long loadId, LoadRequestWrapper loadRequestWrapper);
}


