package org.hfu.kkm.test;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.primefaces.event.RowEditEvent;

@Named("viewUsers")
@ViewScoped
public class ViewUsers implements Serializable {
    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "SportBody")
    private EntityManager em;
    private List<User> userList;
    FacesMessage message;

    /**
     *
     * @return
     */
    protected EntityManager getEntityManager() {
        return em;
    }
    
    // User entries variable
    private String user_id;
    private String viewUserName;
    private String password;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String userType;

    // Get/Setter Methode
    /**
     *
     * @return
     */
    public String getUserType() {
        return userType;
    }

    /**
     *
     * @param userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     *
     * @return
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     *
     * @param user_id
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /**
     *
     * @return
     */
    public String getViewUserName() {
        return viewUserName;
    }

    /**
     *
     * @param userName
     */
    public void setViewUserName(String userName) {
        this.viewUserName = userName;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     *
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     *
     * @return
     */
    public List<User> getUserList() {
        return userList;
    }

    // Methode to Edit a Row and change Usersettings
    /**
     *
     * @param event
     */
    public void rowEditAction(RowEditEvent event) {
        message = new FacesMessage("Row successfully updated");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    // Methode to delete a Userprofile
    /**
     *
     * @param user
     */
    public void rowDeleteAction(User user) {
        User delUser = new User();
        delUser.setUserId(user.getUserId());
        message = new FacesMessage("Row successfully deleted");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    // Methode to check Userrole
    /**
     *
     * @return
     */
    public boolean checkUserRole() {
        return true;
    }

}
