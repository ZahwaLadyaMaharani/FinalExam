/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalExam.FinalExam;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ASUS ROG
 */
public class tryController {
     Person mydata = new Person();
    JpaController ctrl = new JpaController();
    
    @GetMapping("/{id}")
    public String getNameById(@PathVariable("id") int id){
        try{
            mydata = ctrl.findPerson(id);
        } catch (Exception e){
            
        }
        return mydata.getNama();
    }
    
    @RequestMapping(value = "/GET",
            method = RequestMethod.GET,
            consumes = APPLICATION_JSON_VALUE)
    public List<Person> getAll(){
        List<Person> dummy = new ArrayList();
        try{
            dummy = ctrl.findPersonEntities();
        } catch (Exception e){
            dummy = List.of();
        }
        return dummy;
    }
    
    @RequestMapping(value = "/POST",
            method = RequestMethod.POST,
            consumes = APPLICATION_JSON_VALUE)
    public String createData(HttpEntity<String> paket){
        String message ="Data Saved";
        
        try{
            String json_receive  = paket.getBody();
                        
            ObjectMapper map = new ObjectMapper();
                    
            Person data = new Person);
            
            data = map.readValue( json_receive, Person.class);
            
            ctrl.create(data);
            message = data.getNama() + "Data Saved";
            
        }catch(Exception e) {message="Failed";}
        return message;
    }
    
    @RequestMapping(value = "/PUT",
            method = RequestMethod.PUT,
            consumes = APPLICATION_JSON_VALUE)
    public String editData(HttpEntity<String> kiriman) {
        String message = "no action";
        try {
            String json_receive = kiriman.getBody();
            ObjectMapper mapper = new ObjectMapper();

            
            
            ctrl.edit(newprsn);
            message = newprsn.getNama() + "Data Edit";
        } catch (Exception e) {message="Failed";}
        return message;
    }
    
    @RequestMapping(value = "/DELETE",
            method = RequestMethod.DELETE,
            consumes = APPLICATION_JSON_VALUE)
    public String deleteData(HttpEntity<String> kiriman) {
        String message = "no action";
        try {
            String json_receive = kiriman.getBody();
            ObjectMapper mapper = new ObjectMapper();
            
            Person newprsn = new Person();
            
            Person newbrgs = mapper.readValue(json_receive, Person.class);
            
            ctrl.destroy(newprsn.getId());
            message = newprsn.getNama() + "has been updated";
        } catch (Exception e) {
        }
        return message;
    }
}
