package api.controller.common;

/**
 * Created by khengny on 6/22/17.
 */

import api.model.common.BaseEntity;
import api.repository.common.BaseRepository;
import api.utility.Tools;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public abstract class BaseController {

    public abstract BaseEntity getEntity();

    public abstract BaseRepository getRepository();

    @RequestMapping(method = RequestMethod.GET)
    public Page<Object> List(HttpServletRequest request) {
        int per_page = this.toInt(this.getParamRequest(request, "per_page", Tools.DEF_PER_PAGE));
        int page = this.toInt(this.getParamRequest(request, "page", Tools.DEF_PAGE));
        byte status = this.toByte(this.getParamRequest(request, "status", Tools.DEF_STATUS));
        return getRepository().findAllByStatus(status, new PageRequest(page, per_page));
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Object Get(@PathVariable("id") int id) {
        return getRepository().findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Object Create(HttpServletRequest request) throws IOException{
        BaseEntity m = getEntity();
        getRepository().save(m);
        return null;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.POST)
    public Object Update(@PathVariable("id") int id, HttpServletRequest request) {
        return getRepository().findOne(id);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public Object Delete(@PathVariable("id") int id) {
        return getRepository().findOne(id);
    }

    public Object ResultMessage(){
        return null;
    }

    public Object getParamRequest(HttpServletRequest request, String paramName, Object ifNullValue){
        if(request.getParameterMap().containsKey(paramName)){
            return request.getParameter(paramName);
        }
        return ifNullValue;
    }

    public int toInt(Object num){
        return Integer.parseInt(num.toString());
    }

    public byte toByte(Object a){
        return Byte.parseByte(a.toString());
    }

}
