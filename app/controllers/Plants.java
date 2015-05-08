package controllers;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.JsonNode;
import models.Plant;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by Dennis on 10/04/2015.
 */
public class Plants extends Controller{

    public static Result newPlant() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return ResponseHelper.jsonResponse(ResponseHelper.BadRequest, Json.newObject(), "");
        }
        String name = json.findPath("name").asText();
        int type = json.findPath("type").asInt();
        long plantedTime = json.findPath("plantedTime").asLong();

        Plant plant = new Plant(name, type, plantedTime);
        Ebean.save(plant);
        return ResponseHelper.jsonResponse(ResponseHelper.OK,plant,"added");




    }

    public static Result listPlants(){
        List<Plant> plants = Ebean.find(Plant.class).findList();
        List<Plant> filter = Ebean.filter(Plant.class).maxRows(50).filter(plants);
        return ResponseHelper.jsonResponse(ResponseHelper.OK,filter,"Request executed successfully");
    }


}
