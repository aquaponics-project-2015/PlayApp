package controllers;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.JsonNode;
import models.Pump;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by Dennis on 3/11/2015.
 */
public class Pumps extends Controller{
    public static Result newPump() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return ResponseHelper.jsonResponse(ResponseHelper.BadRequest, Json.newObject(), "");
        }
        boolean status = json.findPath("status").asBoolean();
        long datetime = json.findPath("datetime").asLong();

        Pump pump = new Pump(status, datetime);
        Ebean.save(pump);
        return ResponseHelper.jsonResponse(ResponseHelper.OK,pump,"added");




    }

    public static Result listPumps(){
        List<Pump> pumps = Ebean.find(Pump.class).findList();
        List<Pump> filter = Ebean.filter(Pump.class).maxRows(50).filter(pumps);
        return ResponseHelper.jsonResponse(ResponseHelper.OK,filter,"Request executed successfully");
    }

}
