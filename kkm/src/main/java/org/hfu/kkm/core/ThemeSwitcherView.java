package org.hfu.kkm.core;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedProperty;
import org.hfu.kkm.core.Theme;
import org.hfu.kkm.core.ThemeService;
 
@Model
public class ThemeSwitcherView {
 
    private List<Theme> themes;
 
    @ManagedProperty("#{themeService}")
    private ThemeService service;
 
    @PostConstruct
    public void init() {
        themes = service.getThemes();
    }
 
    public List<Theme> getThemes() {
        return themes;
    }
 
    public void setService(ThemeService service) {
        this.service = service;
    }
}