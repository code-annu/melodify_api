package developer.anurag.melodify.repositories;

import developer.anurag.melodify.entities.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepo extends MongoRepository<Track,String> {
}
