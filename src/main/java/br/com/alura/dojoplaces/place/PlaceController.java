package br.com.alura.dojoplaces.place;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String placeList(Model model) {
        List<PlaceListDTO> places = placeRepository.findAll().stream()
                .map(place -> place.toDTO()).toList();

        model.addAttribute("places", places);
        return "/PlaceList";
    }
}
