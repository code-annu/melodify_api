package developer.anurag.melodify.repositories;

import developer.anurag.melodify.entities.Playlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepo extends MongoRepository<Playlist,String> {

}
