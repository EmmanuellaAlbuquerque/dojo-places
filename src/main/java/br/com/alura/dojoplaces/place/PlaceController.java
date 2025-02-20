package br.com.alura.dojoplaces.place;

import br.com.alura.dojoplaces.utils.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("places")
public class PlaceController {

    private final PlaceRepository placeRepository;

    public PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @GetMapping
    public String placeList(Model model) {
        List<PlaceListDTO> places = placeRepository.findAll().stream()
                .map(place -> PlaceListDTO.fromModel(place)).toList();

        model.addAttribute("places", places);
        return "/PlaceList";
    }

    @GetMapping("/new")
    public String createPlaceForm(Model model, PlaceCreateDTO placeCreateDTO) {

        model.addAttribute("placeCreateDTO", placeCreateDTO);

        return "/PlaceCreateForm";
    }

    @PostMapping("/create")
    public String createPlace(@Valid PlaceCreateDTO placeCreateDTO, BindingResult bindingResult, Model model) {
        List<statusDTO> errors = new ArrayList<>();

        if (bindingResult.hasErrors()) {
            return "/PlaceCreateForm";
        }

        Optional<Place> duplicatedCodeForPlace = placeRepository.findByCode(placeCreateDTO.code());

        if (duplicatedCodeForPlace.isPresent()) {
            errors.add(new statusDTO("Código", "O código já está em uso!"));
            model.addAttribute("statusList", errors);
            return "/PlaceCreateForm";
        }

        placeRepository.save(new Place(placeCreateDTO));
        return "redirect:/places";
    }

    @GetMapping("/edit/{id}")
    public String editPlace(Model model, @PathVariable Long id) {

        Place place = placeRepository.findById(id).orElseThrow(NotFoundException::new);
        PlaceEditDTO placeEditDTO = PlaceEditDTO.fromModel(place);

        model.addAttribute("placeEditDTO", placeEditDTO);
        return "PlaceEditForm";
    }

    @Transactional
    @PostMapping("/update")
    public String updatePlace(@Valid PlaceEditDTO placeEditDTO, BindingResult bindingResult, Model model) {

        List<statusDTO> errors = new ArrayList<>();

        if (bindingResult.hasErrors()) {
            return "/PlaceEditForm";
        }

        Optional<Place> duplicatedCodeForPlace = placeRepository.findByCode(placeEditDTO.code());

        if (duplicatedCodeForPlace.isPresent()) {
            errors.add(new statusDTO("Código", "O código já está em uso!"));
            model.addAttribute("statusList", errors);
            return "/PlaceEditForm";
        }

        Place place = placeRepository.findById(placeEditDTO.id()).orElseThrow(NotFoundException::new);
        place.edit(placeEditDTO);

        return "redirect:/places";
    }
}
