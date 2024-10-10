package projectfs44.gatedcommunity.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;


@Schema(description = "DTO for proposition_service")

public class PropositionServiceDTO {

    @Schema(description = "PropositionServiceDTO unique identifier", example = "777", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

     @Schema(description = "PropositionServiceDTO title", example = "Change lamp")
    private String title;

     @Schema(description = "PropositionServiceDTO description", example = "change old lamp nacho new")
    private String description;

    private String image;



    public PropositionServiceDTO() {

    }

    @Override
    public String toString() {
        return String.format("PropositionServiceDTO: id - %d, title - %s, description - %s",
                id, title, description);
    }

    public PropositionServiceDTO(Long id, String title, String description, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PropositionServiceDTO that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, image);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
