package com.journaldev.jsf.helloworld;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class GifDAO {

    private Integer id;
    private String gifLink;

    public GifDAO(){

    }

    public GifDAO(String url){
        this.gifLink = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGifLink() {
        return gifLink;
    }

    public void setGifLink(String gifLink) {
        this.gifLink = gifLink;
    }


    public String showFavouriteGif(String url){
        this.gifLink = url;
        return "/singleFavouriteGif.xhtml?faces-redirect=true";
    }
}
