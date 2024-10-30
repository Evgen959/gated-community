package projectfs44.gatedcommunity.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import projectfs44.gatedcommunity.model.dto.PropositionServiceDTO;
import projectfs44.gatedcommunity.model.dto.PropositionServiceFileDTO;
import projectfs44.gatedcommunity.service.interfaces.PropositionServiceService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/offered-services")
@Tag(name = "PropositionService controller", description = "Controller for operations wis PropositionService")
public class PropositionServiceController {

    private final PropositionServiceService propositionServiceService;


    public PropositionServiceController(PropositionServiceService propositionServiceService) {
        this.propositionServiceService = propositionServiceService;
    }

    @Operation(summary = "Create propositionService", tags = { "PropositionService" }, description = "Add new propositionService.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PreparedStatement.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = PreparedStatement.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid username supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content) })

    @Transactional
    @PostMapping(consumes = "multipart/form-data")
    public PropositionServiceDTO savePropositionService(
            @RequestPart("propositionServiceDTO") @Valid PropositionServiceDTO propositionServiceDTO,
            @RequestPart(value = "files", required = false) List<MultipartFile> files) {

        return propositionServiceService.savePropositionService(propositionServiceDTO, files);
    }


    @Operation(summary = "Get propositionService by id", tags = { "PropositionService" }, description = "Find propositionService.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PreparedStatement.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = PreparedStatement.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid username supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content) })

    @Transactional
    @GetMapping("/{id}")
    public PropositionServiceDTO getPropositionServiceById(
            @Parameter(description = "The id that needs to de fetched", required = true) @PathVariable("id") long id){

        //  обращаемся к сервису для получения сервиса по id
        return propositionServiceService.getPropositionServiceById(id);
    }

    @Transactional
    @GetMapping()
    public List<PropositionServiceDTO> getPropositionServiceAllOrByTitle(@RequestParam(required = false) String title){
        if (title != null) {
            return propositionServiceService.getPropositionServiceByTitle(title);
        } else {
            return propositionServiceService.getAllPropositionService();
        }
    }

    @Transactional
    @PutMapping("/update/{id}")
    public PropositionServiceDTO updatePropositionService(@PathVariable("id") Long id, @RequestBody PropositionServiceDTO propositionServiceDTO){
        return propositionServiceService.updatePropositionService(id, propositionServiceDTO);
    }

    // DELETE /offered-services/2
    @DeleteMapping("/{id}")
    public PropositionServiceDTO deletePropositionServiceById(@PathVariable Long id){
        return propositionServiceService.deletePropositionServiceById(id);
    }


    // PUT /offered-services/restore/2
    @PutMapping("/restore/{id}")
    public PropositionServiceDTO restorePropositionServiceById(@PathVariable Long id) {
        return propositionServiceService.restorePropositionServiceById(id);
    }

    @PutMapping("/remove/{id}")
    public PropositionServiceDTO removePropositionServiceById(@PathVariable Long id) {
        return propositionServiceService.restorePropositionServiceById(id);
    }

}
