/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import reporting.repository.CartRepository;

/**
 *
 * @author S3-Developer
 */
@javax.faces.bean.SessionScoped
@ManagedBean(name = "cartBean")
public class CartBean implements Serializable, CartRepository  {

    /**
     * Creates a new instance of CartBean
     */
    public CartBean() {
    }
    
}
