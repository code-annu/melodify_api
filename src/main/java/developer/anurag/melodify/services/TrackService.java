package developer.anurag.melodify.services;

import developer.anurag.melodify.entities.Track;
import developer.anurag.melodify.repositories.TrackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class TrackService {
    @Autowired
    private TrackRepo trackRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Track addTrack(Track track){
        return this.trackRepo.save(track);
    }

    public List<Track> addTracks(List<Track> tracks){
        return this.trackRepo.saveAll(tracks);
    }

    public List<Track> searchTracks(String query){
        return this.trackRepo.findAll().stream().filter(track -> track.getTitle().contains(query) || track.getArtist().contains(query) || track.getAlbum().contains(query)).collect(Collectors.toList());
    }

    public List<String> getAllTitles(){
        List<String> titles = new ArrayList<>();
        this.trackRepo.findAll().forEach(track -> titles.add(track.getTitle()));
        return titles;
    }

    public List<Track> getTracksByIds(List<String> ids){
        return this.trackRepo.findAllById(ids);
    }

    public List<Track> getShuffledTracks(int size){
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.sample(size));

        return mongoTemplate.aggregate(aggregation,"tracks", Track.class).getMappedResults();
    }

    public Track getTrackById(String id){
        return this.trackRepo.findById(id).orElse(null);
    }

    public List<Track> getAllTracks(){
        return this.trackRepo.findAll();
    }

}
