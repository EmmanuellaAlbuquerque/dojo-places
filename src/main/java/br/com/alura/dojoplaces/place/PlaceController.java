package br.com.alura.dojoplaces.place;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("places")
public class PlaceController {

    private final PlaceRepository placeRepository;

    public PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @PostMapping("/new")
    public String createPlace(@Valid PlaceCreateDTO place) {

        placeRepository.save(new Place(place));
        return "redirect:/oi";
    }

    @GetMapping("/create")
    public String createPlaceForm(Model model, PlaceCreateDTO placeCreateDTO) {

        model.addAttribute("PlaceCreateDTO", placeCreateDTO);

        System.out.println(model);
        System.out.println(placeCreateDTO);

        return "/PlaceCreateForm";
    }
}
