package serviceRest.dto;

import javax.validation.constraints.NotBlank;

public class QualifcationDto {

    @NotBlank(message = "Should not be blank.")
    private String qualifier;
    @NotBlank(message = "Should not be blank.")
    private String opinion;

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
