package projectfs44.gatedcommunity.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
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

    private List<PropositionServiceFileDTO> files;


    public PropositionServiceDTO() {

    }

    @Override
    public String toString() {
        return "PropositionServiceDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", files=" + files +
                '}';
    }

    public PropositionServiceDTO(Long id, String title, String description, String image, List<PropositionServiceFileDTO> files) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.files = files;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropositionServiceDTO that = (PropositionServiceDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(image, that.image) && Objects.equals(files, that.files);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(title);
        result = 31 * result + Objects.hashCode(description);
        result = 31 * result + Objects.hashCode(image);
        result = 31 * result + Objects.hashCode(files);
        return result;
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

    public List<PropositionServiceFileDTO> getFiles() {
        return files;
    }

    public void setFiles(List<PropositionServiceFileDTO> files) {
        this.files = files;
    }
}
