package br.com.alura.dojoplaces.place;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("places")
public class PlaceController {

    private PlaceRepository placeRepository;

    @PostMapping("/new")
    public void createPlace(@Valid PlaceCreateDTO place) {

        System.out.println(place);
    }

    @GetMapping("/create")
    public String createPlaceForm(Model model, PlaceCreateDTO placeCreateDTO) {

        model.addAttribute("PlaceCreateDTO", placeCreateDTO);
        System.out.println(model);
        System.out.println(placeCreateDTO);

        return "/PlaceCreateForm";
    }
}
