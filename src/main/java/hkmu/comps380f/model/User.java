//package hkmu.comps380f.model;
//
//import jakarta.persistence.*;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.Fetch;
//import org.hibernate.annotations.FetchMode;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Entity
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long userid;
//    @Column(name = "name", insertable = false, updatable = false)
//    private String userName;
//    @ManyToOne
//    @JoinColumn(name = "name")
//    private User username;
//    private String password;
//    private String confirmpassword;
//    private String fullname;
//    private String email;
//    private String delivery;
//    @CreationTimestamp
//    private Date createTime;
//    @UpdateTimestamp
//    private Date updateTime;
//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL, orphanRemoval = true)
//    @Fetch(FetchMode.SUBSELECT)
//    private List<Attachment> attachments = new ArrayList<>();
//
//    public long getId() {
//        return userid;
//    }
//
//    public void setId(long id) {
//        this.userid = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public AppUser getUsername() {
//        return username;
//    }
//
//    public void setUsername(User username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getConfirmpassword() {
//        return confirmpassword;
//    }
//
//    public void setConfirmpassword(String confirmpassword) {
//        this.confirmpassword = confirmpassword;
//    }
//
//    public String getFullname() {
//        return fullname;
//    }
//
//    public void setFullname(String fullname) {
//        this.fullname = fullname;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getDelivery() {
//        return delivery;
//    }
//
//    public void setDelivery(String delivery) {
//        this.delivery = delivery;
//    }
//
//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }
//
//    public List<Attachment> getAttachments() {
//        return attachments;
//    }
//
//    public void setAttachments(List<Attachment> attachments) {
//        this.attachments = attachments;
//    }
//}