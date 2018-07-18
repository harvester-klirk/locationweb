package come.razouki.location.controller;

import come.razouki.location.entities.Location;
import come.razouki.location.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
