package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Dennis on 10/04/2015.
 */
@Entity
public class Plant extends Model {
    @Id
    public long id;

    public String name;
    public int type;
    @Constraints.Required
    public Date plantedTime;
    @Constraints.Required
    public Date expectedReapTime;

    public Plant(String name,int type,long plantedTime) {
        this.name = name;
        this.expectedReapTime = new Date(plantedTime+getReapTime(type));
        this.plantedTime = new Date(plantedTime);

    }

    public long getReapTime(int type){
        return 0;

    }

}
