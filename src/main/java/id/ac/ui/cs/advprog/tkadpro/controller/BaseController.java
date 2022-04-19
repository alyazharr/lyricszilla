package id.ac.ui.cs.advprog.tkadpro.controller;

import id.ac.ui.cs.advprog.tkadpro.service.SongRestService;
import id.ac.ui.cs.advprog.tkadpro.service.SongRestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(path = "/songDTO")
public class BaseController {
    @Autowired
    private SongRestService songRestService;
    @GetMapping({"", "/"})
    public String getCreatePage() {
        songRestService.retrieveListSong();
        return "home";
    }

}
