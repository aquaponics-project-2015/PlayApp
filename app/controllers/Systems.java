package controllers;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import models.System;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by Dennis on 3/7/2015.
 */
public class Systems extends Controller {

    public static Result newSystemGet(double waterLevel, double ph, double temperature, long datetime) {
        if (waterLevel == 0.0 || ph == 0.0 || temperature == 0.0 || datetime == 0) {
            return ResponseHelper.jsonResponse(ResponseHelper.BadRequest, Json.newObject(), "");
        }
        System system = new System(waterLevel, ph, temperature, datetime);
        Ebean.save(system);
        return ResponseHelper.jsonResponse(ResponseHelper.OK,system,"added");
    }

    public static Result newSystem() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return ResponseHelper.jsonResponse(ResponseHelper.BadRequest, Json.newObject(), "");
        }
        double waterLevel = json.findPath("waterLevel").asDouble();
        double ph = json.findPath("ph").asDouble();
        double temperature = json.findPath("temperature").asDouble();
        long datetime = json.findPath("datetime").asLong();



        System system = new System(waterLevel, ph, temperature, datetime);
        Ebean.save(system);
        return ResponseHelper.jsonResponse(ResponseHelper.OK,system,"added");




    }

    public static Result listSystems(){
        List<System> systems = Ebean.find(System.class).findList();
        List<System> filter = Ebean.filter(System.class).maxRows(50).filter(systems);
        return ResponseHelper.jsonResponse(ResponseHelper.OK,filter,"Request executed successfully");
    }


}
