package com.journaldev.jsf.helloworld;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class Controller {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Controller(){

    }

    public String getRandomGif(){
        API api = new API();
        GifDAO gif = api.getRandomGif();
        this.url = gif.getGifLink();
        return gif.getGifLink();
    }

}
