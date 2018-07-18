package come.razouki.location.controller;

import come.razouki.location.entities.Location;
import come.razouki.location.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {

    @Autowired
    LocationService locationService;
    @RequestMapping("/showCreate")
    public String showCreate(){
        return "createLocation";
    }

    @RequestMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap){

       Location locationSaved =  locationService.saveLocation(location);
        String  msg = " Location is saved with id "+ location.getId();
        modelMap.addAttribute("msg", msg);
        return "createLocation";
        }

        @RequestMapping("/display_all_locations")
        public String displayLocations(ModelMap modelMap){
            List<Location> locations = locationService.getAllLocations();
            modelMap.addAttribute("locations" , locations);
            return "display_all_locations";
        }

        @RequestMapping("/delete_location")
        public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap){
            Location location = new Location();
            location.setId(id);
            locationService.deleteLocation(location);
            List<Location> locations = locationService.getAllLocations();
            modelMap.addAttribute("locations", locations);
            return "display_all_locations";
        }
}
