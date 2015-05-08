package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Dennis on 3/7/2015.
 */
@Entity
public class System extends Model {
    @Id
    public long id;
    @Constraints.Required
    public double waterLevel;
    @Constraints.Required
    public double ph;
    @Constraints.Required
    public double temperature;

    public Date datetime;

    public System(double waterLevel, double ph, double temperature, long datetime) {

        this.waterLevel = waterLevel;
        this.ph = ph;
        this.temperature = temperature;
        this.datetime = new Date(datetime);
    }
}
