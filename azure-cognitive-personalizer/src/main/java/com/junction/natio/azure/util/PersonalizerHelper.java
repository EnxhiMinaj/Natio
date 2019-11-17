package com.junction.natio.azure.util;

import com.junction.natio.azure.personalizer.models.RankableAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PersonalizerHelper {

    static Random rand = new Random();

    public static RankableAction getAction(String name){
        return new RankableAction()
                .withId(name)
                .withFeatures(Arrays.asList(
                    new Object() {
                        boolean hasLake = getRandomBoolean();
                        boolean hasWildAnimals = getRandomBoolean();
                        String treeType = getTreeType();
                        String hikeDifficulty = getHikingDifficulty();
                        String visitorsPerMonth = getVisitorsPerMonth();
                    }));
    }

    public static Object getFeature(String name){
        return new Object(){
            boolean hasLake = getRandomBoolean();
            boolean hasWildAnimals = getRandomBoolean();
            String treeType = getTreeType();
            String hikeDifficulty = getHikingDifficulty();
            String visitorsPerMonth = getVisitorsPerMonth();
        };

    }

    public static List<RankableAction> getActions(List<String> allTrails){
        List<RankableAction> rankableActions = new ArrayList<>();
        for(String trailName : allTrails){
            rankableActions.add(PersonalizerHelper.getAction(trailName));
        }
        return rankableActions;
    }

    public static List<Object> getFeatures(List<String> userTrailNames){
        List<Object> features = new ArrayList<>();
        for(String trailName : userTrailNames){
            features.add(PersonalizerHelper.getFeature(trailName));
        }
        return features;
    }

    private static boolean getRandomBoolean(){
        return rand.nextBoolean();
    }

    private static String getTreeType(){
        ArrayList<String> treeTypes = new ArrayList<>();
        treeTypes.add("Scots pine");
        treeTypes.add("Norway spruce");
        treeTypes.add("Common juniper");
        treeTypes.add("European yew");
        return treeTypes.get(rand.nextInt(4));
    }

    private static String getHikingDifficulty(){
        ArrayList<String> difficulties = new ArrayList<>();
        difficulties.add("Hard");
        difficulties.add("Medium");
        difficulties.add("Easy");
        return difficulties.get(rand.nextInt(3));
    }

    private static String getVisitorsPerMonth(){
        ArrayList<String> visitors = new ArrayList<>();
        visitors.add("0-250");
        visitors.add("250-500");
        visitors.add("500-750");
        visitors.add("750-1000");
        visitors.add("1000+");
        return visitors.get(rand.nextInt(5));
    }
}
