package api.controller.settings;

/**
 * Created by khengny on 6/22/17.
 */
//import java.io.*;

import api.controller.common.BaseController;
import api.model.common.BaseEntity;
import api.model.settings.PermissionsEntity;
import api.repository.common.BaseRepository;
import api.repository.settings.PermissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@RestController
@RequestMapping("/permissions")
public class PermissionsController extends BaseController {

    @Autowired
    public PermissionsRepository repository;

    @Override
    public BaseEntity getEntity(){
        return new PermissionsEntity();
    }

    @Override
    public BaseRepository getRepository(){
        return this.repository;
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public Object Create(HttpServletRequest request) throws IOException {
        PermissionsEntity p = new PermissionsEntity();
        p.setName(this.getParamRequest(request, "name", "").toString());
        p.setDisplayName(this.getParamRequest(request, "display_name", "").toString());
        p.setDescription(this.getParamRequest(request, "description", "").toString());
        this.repository.saveAndFlush(p);
        return "success!";
    }

//    @Override
//    public BaseEntity getNewEntity() { return new PermissionsEntity(); }

}