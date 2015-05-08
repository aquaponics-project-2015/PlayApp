package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Dennis on 3/11/2015.
 */
@Entity
public class Pump extends Model {
    @Id
    public long id;
    @Constraints.Required
    public boolean status;
    @Constraints.Required
    public Date datetime;

    public Pump(boolean status, long datetime) {
        this.status = status;
        this.datetime = new Date(datetime);
    }
}
