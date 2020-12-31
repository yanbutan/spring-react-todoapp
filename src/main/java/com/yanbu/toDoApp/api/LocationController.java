package com.yanbu.toDoApp.api;

import com.yanbu.toDoApp.model.Location;
import com.yanbu.toDoApp.service.LocationService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Location> getLocationByTaskId(HttpServletRequest request,
                                                        @PathVariable("taskId") Integer taskId
                                                        ){
        Location location = locationService.findByTaskId(taskId);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> addLocationToTask(HttpServletRequest request,
                                                     @RequestBody Location location
                                                     ){
        Integer locationId = locationService.addLocation(location);

        return new ResponseEntity<>(locationId, HttpStatus.CREATED);
    }

    @PutMapping("/{locationId}")
    public ResponseEntity<Map<String, Boolean>> updateLocation(HttpServletRequest request,
                                                               @PathVariable("locationId") Integer locationId,
                                                               @RequestBody Location location
                                                               ) {
        locationService.updateLocation(locationId, location);
        Map<String, Boolean> map = new HashMap<>();
        map.put("Update success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping("/{locationId}")
    public  ResponseEntity<Map<String, Boolean>> deleteLocation(HttpServletRequest request,
                                                                @PathVariable("locationId") Integer locationId
                                                                ){
        locationService.removeLocation(locationId);
        Map<String, Boolean> map = new HashMap<>();
        map.put("Delete success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
