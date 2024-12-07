package developer.anurag.melodify.controllers;

import developer.anurag.melodify.entities.Playlist;
import developer.anurag.melodify.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @PostMapping("/add")
    String addPlaylist(@RequestParam(value = "api_key",required = false) String api_key, @RequestBody Playlist playlist){
        if(api_key == null || api_key.trim().isEmpty() || !api_key.equals("Anurag9696348678"))return "Invalid API Key.";
        if(playlistService.addPlaylist(playlist)!=null)return "Playlist is added.";
        return "Failed to add playlist.";
    }

    @GetMapping("/shuffle")
    List<Playlist> getShuffledPlaylist(@RequestParam(value = "size",defaultValue = "10") int size){
        return this.playlistService.getShuffledPlaylists(size);
    }


}
