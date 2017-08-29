package api.controller.settings;

/**
 * Created by khengny on 6/22/17.
 */
//import java.io.*;

import api.controller.common.BaseController;
import api.model.common.BaseEntity;
import api.model.settings.TodoEntity;
import api.repository.common.BaseRepository;
import api.repository.settings.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/todo")
public class TodoController extends BaseController {

    @Autowired
    public TodoRepository repository;

    @Override
    public BaseEntity getEntity(){
        return new TodoEntity();
    }

    @Override
    public BaseRepository getRepository(){
        return this.repository;
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public Object Create(HttpServletRequest request) throws IOException {
        TodoEntity p = new TodoEntity();
        p.setTitle(this.getParamRequest(request, "title", "").toString());
        p.setDescription(this.getParamRequest(request, "description", "").toString());
        this.repository.saveAndFlush(p);
        return "success!";
    }

    @Override
    @RequestMapping(value="/{id}", method = RequestMethod.POST)
    public Object Update(@PathVariable("id") int id, HttpServletRequest request) {
        TodoEntity p = this.repository.findOne(id);
        p.setTitle(this.getParamRequest(request, "title", "").toString());
        p.setDescription(this.getParamRequest(request, "discription", "").toString());
        this.repository.saveAndFlush(p);
        return "success!";
    }

//    @Override
//    public BaseEntity getNewEntity() { return new PermissionsEntity(); }

}