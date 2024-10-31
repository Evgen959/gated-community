package projectfs44.gatedcommunity.model.entity;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "proposition_service_files")
public class PropositionServiceFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob  //  (BLOB)
    @Column(name = "file_data", nullable = false)
    private byte[] fileData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proposition_service_id", nullable = false)
    private PropositionService propositionService;

    public PropositionServiceFile() {
    }

    @Override
    public String toString() {
        return "PropositionServiceFile{" +
                "id=" + id +
                ", fileData=" + Arrays.toString(fileData) +
                ", propositionService=" + propositionService +
                '}';
    }

    public PropositionServiceFile(Long id, byte[] fileData, PropositionService propositionService) {
        this.id = id;
        this.fileData = fileData;
        this.propositionService = propositionService;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public PropositionService getPropositionService() {
        return propositionService;
    }

    public void setPropositionService(PropositionService propositionService) {
        this.propositionService = propositionService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropositionServiceFile that = (PropositionServiceFile) o;
        return Objects.equals(id, that.id) && Arrays.equals(fileData, that.fileData) && Objects.equals(propositionService, that.propositionService);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Arrays.hashCode(fileData);
        result = 31 * result + Objects.hashCode(propositionService);
        return result;
    }
}