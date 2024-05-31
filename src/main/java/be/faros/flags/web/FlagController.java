package be.faros.flags.web;

import be.faros.flags.service.FlagService;
import be.faros.flags.web.dto.FlagDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.togglz.core.manager.FeatureManager;
import org.togglz.spring.web.FeaturesAreActive;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/flags")
public class FlagController {
    private final FlagService flagService;
    private final FlagValidator validator;
    private final FeatureManager featureManager;

    public FlagController(FlagService flagService, FlagValidator validator, FeatureManager featureManager) {
        this.flagService = flagService;
        this.validator = validator;
        this.featureManager = featureManager;
    }

    @GetMapping
    public List<FlagDTO> getFlags(@RequestParam(required = false) String user) {
        return flagService.getFlags(user);
    }

    @GetMapping("/{id}")
    public FlagDTO getFlag(@PathVariable UUID id) {
        return flagService.getFlag(id);
    }

    @FeaturesAreActive(features = "save_flag", errorResponseStatus = HttpStatus.NOT_IMPLEMENTED)
    @PostMapping
    public FlagDTO saveFlag(@RequestBody FlagDTO flag) {
        validator.validate(flag);
        return flagService.saveFlag(flag);
    }

    @FeaturesAreActive(features = {"update_flag"}, errorResponseStatus = HttpStatus.NOT_IMPLEMENTED)
    @PutMapping("/{id}")
    public FlagDTO updateFlag(@PathVariable UUID id, @RequestBody FlagDTO flag) {
        validator.validate(flag);
        return flagService.updateFlag(id, flag);
    }

    @FeaturesAreActive(features = {"update_flag"}, errorResponseStatus = HttpStatus.NOT_IMPLEMENTED)
    @DeleteMapping("/{id}")
    public void deleteFlag(@PathVariable UUID id) {
        flagService.deleteFlag(id);
    }
}
