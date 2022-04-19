package id.ac.ui.cs.advprog.tkadpro.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "SongDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
public class SongDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "is_taken")
    private boolean isTaken;

    @Column(name = "judul_lagu")
    private String judul;

    @Column(name = "penyanyi")
    private String penyanyi;

    @Column(name = "album")
    private String album;

    @Column(name = "lirik", nullable = false, length = 10240)
    private String lirik;

    public SongDTO (@JsonProperty("judul") String judul,
                   @JsonProperty("penyanyi") String penyanyi,
                   @JsonProperty("album") String album,
                   @JsonProperty("lirik") String lirik) {
        this.judul = judul;
        this.penyanyi = penyanyi;
        this.album = album;
        this.lirik = lirik;
        this.isTaken = false;
    }
}