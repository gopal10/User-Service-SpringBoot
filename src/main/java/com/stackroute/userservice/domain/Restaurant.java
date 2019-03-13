package com.stackroute.userservice.domain;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int res_id;
    private String res_name;
    private String res_loc;
    private String image;
}

//    public Restaurant(String res_name, String res_loc, String image) {
//
//        this.res_name = res_name;
//        this.res_loc = res_loc;
//        this.image= image;
//
//    }


//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public Restaurant() {
//    }
//
//    public int getRes_id() {
//        return res_id;
//    }
//
//    public void setRes_id(int res_id) {
//        this.res_id = res_id;
//    }
//
//    public String getRes_name() {
//        return res_name;
//    }
//
//    public void setRes_name(String res_name) {
//        this.res_name = res_name;
//    }
//
//    public String getRes_loc() {
//        return res_loc;
//    }
//
//    public void setRes_loc(String res_loc) {
//        this.res_loc = res_loc;
//    }
//}
