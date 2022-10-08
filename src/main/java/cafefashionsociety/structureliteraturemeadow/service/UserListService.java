package cafefashionsociety.structureliteraturemeadow.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.UserList;
import cafefashionsociety.structureliteraturemeadow.repository.UserListRepository;

@Service
public class UserListService {

    Logger logger = LoggerFactory.getLogger(UserListService.class);

    @Autowired
    UserListRepository userListsRepository;

    public void save(UserList userlist) {
        userListsRepository.save(userlist);
        UserList savedUserLists = userListsRepository.findById(userlist.getId()).get();
        logger.info("UserList " + savedUserLists.getId() + " saved");
    }

    public UserList findById(String id) {
        return userListsRepository.findById(id).get();
    }
}
