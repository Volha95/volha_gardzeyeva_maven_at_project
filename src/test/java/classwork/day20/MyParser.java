package classwork.day20;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyParser {
    public static void main(String[] args) throws IOException {
        MyParser myParser = new MyParser();
        myParser.parseGSON();
        myParser.fromGSON();
    }

    private static final String JSON = "src/test/resources/recipe.json";

    public void parseGSON() throws IOException {
        Gson gson = new Gson();
        Recipe recipe = gson.fromJson(new JsonReader(new FileReader(JSON)), Recipe.class);
        System.out.println(recipe.getIngredlist());
        System.out.println(recipe.getPreptime());
        System.out.println(recipe.getRecipename());
    }

    public void fromGSON() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Ingredient> ingredlist = new ArrayList<>();
        ingredlist.add(new Ingredient("beef", 5));
        ingredlist.add(new Ingredient("potato", 8));
        ingredlist.add(new Ingredient("beetroots", 4));
        Recipe recipe = new Recipe("Borsch", ingredlist, 150);
        System.out.println(gson.toJson(recipe));
    }

    public String fromGSON(Search search) {
        Gson gson = new Gson();
        return gson.toJson(search);
    }
}
