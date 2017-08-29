package api.repository.settings;

import api.model.settings.UsersEntity;
import api.repository.common.BaseRepository;

public interface UsersRepository extends BaseRepository<UsersEntity, Integer> {
    UsersEntity findOneByUserName(String userName);
}
