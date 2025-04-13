package br.com.alura.dojoplaces.place;

import br.com.alura.dojoplaces.utils.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("places")
public class PlaceController {

    private final PlaceRepository placeRepository;

    public PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @InitBinder("placeCreateDTO")
    public void initBinderPlaceCreateDTO(WebDataBinder binder) {
        binder.addValidators(new PlaceCreateDTOValidator(placeRepository));
    }

    @InitBinder("placeEditDTO")
    public void initBinderPlaceEditDTO(WebDataBinder binder) {
        binder.addValidators(new PlaceEditDTOValidator(placeRepository));
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
    public String createPlace(@Valid PlaceCreateDTO placeCreateDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "/PlaceCreateForm";
        }

        placeRepository.save(new Place(placeCreateDTO));
        redirectAttributes.addFlashAttribute("successAlert", "Local criado com sucesso!");
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
    public String updatePlace(@Valid PlaceEditDTO placeEditDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "/PlaceEditForm";
        }

        Place place = placeRepository.findById(placeEditDTO.id()).orElseThrow(NotFoundException::new);
        place.edit(placeEditDTO);

        redirectAttributes.addFlashAttribute("successAlert", "Local editado com sucesso!");
        return "redirect:/places";
    }

    @Transactional
    @PostMapping("/{id}/delete")
    public String deletePlace(@PathVariable Long id) {

        Place place = placeRepository.findById(id).orElseThrow(NotFoundException::new);
        placeRepository.delete(place);

        return "redirect:/places";
    }
}
