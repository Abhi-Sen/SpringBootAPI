package com.springrest.springrest.services;

import com.springrest.springrest.model.LoadRequestWrapper;
import java.util.List;
import java.util.Optional;

import com.springrest.springrest.entities.Load;

public interface LoadService {
    Load addLoad(LoadRequestWrapper load);
    List<Load> getLoadsByShipperId(String shipperId);
    Optional<Load> getLoadById(Long loadId);
    Load updateLoad(Long loadId, Load updatedLoad);
    void deleteLoad(Long loadId);

    Load updateLoad(Long loadId, LoadRequestWrapper loadRequestWrapper);
}


