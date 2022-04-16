package id.ac.ui.cs.advprog.tkadpro.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class SongRestServiceImpl implements SongRestService{
    private static final String BASE_URL = "http://musixapi.herokuapp.com/lagu/find";
    private final RestTemplate restTemplate;
    private static final ObjectMapper mapper = new ObjectMapper();

    public SongRestServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    @Override
    public SongDTO[] retrieveListSong() {
        ResponseEntity<SongDTO[]> responseEntity = restTemplate.getForEntity(BASE_URL,SongDTO[].class);

        SongDTO[] songs = responseEntity.getBody();

//        for(SongDTO song:songs){
//            System.out.println(song.getPenyanyi() + ":" + song.getJudul());
//        }
        return songs;
    }
}
