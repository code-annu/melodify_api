package developer.anurag.melodify.controllers;

import developer.anurag.melodify.entities.Track;
import developer.anurag.melodify.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracks")
public class TrackController {
    @Autowired
    private TrackService trackService;

    @PostMapping("/add")
    String addTrack(@RequestParam(value = "api_key", required = false) String api_key,@RequestBody Track track){
        if(api_key == null || api_key.trim().isEmpty() || !api_key.equals("Anurag9696348678"))return "Invalid API Key.";
        if(trackService.addTrack(track)!=null)return "Track is added.";
        return "Failed to add track.";
    }

    @PostMapping("/add_all")
    String addTracks(@RequestParam(value = "api_key", required = false) String api_key,@RequestBody List<Track> tracks){
        if(api_key == null || api_key.trim().isEmpty() || !api_key.equals("Anurag9696348678"))return "Invalid API Key.";
        if(trackService.addTracks(tracks)!=null)return "Track is added.";
        return "Failed to add track.";
    }

    @GetMapping("/shuffle")
    List<Track> getShuffledTracks(@RequestParam(value = "size",defaultValue = "10") int size){
        return this.trackService.getShuffledTracks(size);
    }

    @GetMapping("/find_all")
    List<Track> findTracksById(@RequestBody List<String> ids){
        return this.trackService.getTracksByIds(ids);
    }

    @GetMapping("/search")
    List<Track> searchTracks(@RequestParam(value = "query",required = false) String query){
        return this.trackService.searchTracks(query);
    }

    @GetMapping("/find/{id}")
    Track getTrackById(@PathVariable String id){
        return this.trackService.getTrackById(id);
    }

    @GetMapping("/all")
    List<Track> getAllTracks(){
        return this.trackService.getAllTracks();
    }

}
