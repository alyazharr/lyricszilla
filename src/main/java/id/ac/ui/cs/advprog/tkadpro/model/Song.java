package id.ac.ui.cs.advprog.tkadpro.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "Song")
@Data
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "is_taken")
    private boolean isTaken;

    @Column(name = "judul_lagu")
    private String judulLagu;

    public Song(String judulLagu) {
        this.judulLagu = judulLagu;
        this.isTaken = false;
    }
}
