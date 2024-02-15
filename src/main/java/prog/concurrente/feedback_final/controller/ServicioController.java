package prog.concurrente.feedback_final.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import prog.concurrente.feedback_final.model.ServicioDTO;
import prog.concurrente.feedback_final.service.ServicioService;
import prog.concurrente.feedback_final.util.ReferencedWarning;
import prog.concurrente.feedback_final.util.WebUtils;


@Controller
@RequestMapping("/servicios")
public class ServicioController {

    private final ServicioService servicioService;

    public ServicioController(final ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping
    public String list(final Model model) {
        model.addAttribute("servicios", servicioService.findAll());
        return "servicio/list";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("servicio") final ServicioDTO servicioDTO) {
        return "servicio/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("servicio") @Valid final ServicioDTO servicioDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "servicio/add";
        }
        servicioService.create(servicioDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("servicio.create.success"));
        return "redirect:/servicios";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id, final Model model) {
        model.addAttribute("servicio", servicioService.get(id));
        return "servicio/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id,
            @ModelAttribute("servicio") @Valid final ServicioDTO servicioDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "servicio/edit";
        }
        servicioService.update(id, servicioDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("servicio.update.success"));
        return "redirect:/servicios";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") final Long id,
            final RedirectAttributes redirectAttributes) {
        final ReferencedWarning referencedWarning = servicioService.getReferencedWarning(id);
        if (referencedWarning != null) {
            redirectAttributes.addFlashAttribute(WebUtils.MSG_ERROR,
                    WebUtils.getMessage(referencedWarning.getKey(), referencedWarning.getParams().toArray()));
        } else {
            servicioService.delete(id);
            redirectAttributes.addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("servicio.delete.success"));
        }
        return "redirect:/servicios";
    }

}
