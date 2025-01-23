package br.com.alura.dojoplaces.place;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("places")
public class PlaceController {

    private final PlaceRepository placeRepository;

    public PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @PostMapping("/create")
    public String createPlace(@Valid PlaceCreateDTO place, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/PlaceCreateForm";
        }

        placeRepository.save(new Place(place));
        return "redirect:/places";
    }

    @GetMapping("/new")
    public String createPlaceForm(Model model, PlaceCreateDTO placeCreateDTO) {

        model.addAttribute("placeCreateDTO", placeCreateDTO);

        return "/PlaceCreateForm";
    }

    @GetMapping
    public String placeList() {

        return "/PlaceList";
    }
}
