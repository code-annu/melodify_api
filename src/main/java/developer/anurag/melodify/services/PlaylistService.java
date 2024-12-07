package developer.anurag.melodify.services;

import developer.anurag.melodify.entities.Playlist;
import developer.anurag.melodify.repositories.PlaylistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepo playlistRepo;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Playlist addPlaylist(Playlist playlist){
        return this.playlistRepo.save(playlist);
    }

    public List<Playlist> getShuffledPlaylists(int size){
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.sample(size));
        return mongoTemplate.aggregate(aggregation,"playlists", Playlist.class).getMappedResults();
    }


}
