/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.*;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Amon.Sabul
 */
@WebService(serviceName = "insertRecord")
public class insertRecord {

    @PersistenceContext(unitName = "demoPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    Record record = new Record();

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "persistRecord")
    public String persistRecord(@WebParam(name = "name") String name, @WebParam(name = "age") int age, @WebParam(name = "gender") String gender, @WebParam(name = "county") String county) {

        try {

            record.setAge(age);
            record.setCounty(county);
            record.setGender(gender);
            record.setName(name);

            utx.begin();
            em.persist(record);
            utx.commit();
            return "000: Success";
        } catch (Exception ex) {
            return "091: " + ex.getMessage();
        }

    }
}
