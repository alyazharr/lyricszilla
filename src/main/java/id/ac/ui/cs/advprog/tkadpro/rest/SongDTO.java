package id.ac.ui.cs.advprog.tkadpro.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class SongDTO {
    private String judul;
    private String penyanyi;
    private String album;
    private String lirik;

    public SongDTO(@JsonProperty("judul") String judul,
                   @JsonProperty("penyanyi") String penyanyi,
                   @JsonProperty("album") String album,
                   @JsonProperty("lirik") String lirik){
        this.judul = judul;
        this.penyanyi = penyanyi;
        this.album = album;
        this.lirik = lirik;
    }
}
