package com.journaldev.jsf.helloworld;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class DatabaseAccess {

    private static final long serialVersionUID = 6081417964063918994L;

    public List<GifDAO> getGifs(){

        
        return null;
    }
}
