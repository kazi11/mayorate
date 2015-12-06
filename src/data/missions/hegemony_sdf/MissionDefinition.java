package data.missions.hegemony_sdf;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.BaseEveryFrameCombatPlugin;
import com.fs.starfarer.api.combat.CombatEngineAPI;
import com.fs.starfarer.api.fleet.FleetGoal;
import com.fs.starfarer.api.fleet.FleetMemberType;
import com.fs.starfarer.api.mission.FleetSide;
import com.fs.starfarer.api.mission.MissionDefinitionAPI;
import com.fs.starfarer.api.mission.MissionDefinitionPlugin;
import java.util.List;

public class MissionDefinition implements MissionDefinitionPlugin {

    private float interval;

    @Override
    public void defineMission(MissionDefinitionAPI api) {
        // Set up the fleets so we can add ships and fighter wings to them.
        // In this scenario, the fleets are attacking each other, but
        // in other scenarios, a fleet may be defending or trying to escape
        api.initFleet(FleetSide.PLAYER, "MNS", FleetGoal.ATTACK, false, 7);
        api.initFleet(FleetSide.ENEMY, "HSS", FleetGoal.ATTACK, true, 7);

        // Set a small blurb for each fleet that shows up on the mission detail and
        // mission results screens to identify each side.
        api.setFleetTagline(FleetSide.PLAYER, "Mayorate 1st Fleet");
        api.setFleetTagline(FleetSide.ENEMY, "Hegemony System Defense Fleet");

        // These show up as items in the bulleted list under 
        // "Tactical Objectives" on the mission detail screen
        api.addBriefingItem("Rout the enemy fleet and force a Hegemony surrender.");

        // Set up the player's fleet.  Variant names come from the
        // files in data/variants and data/variants/fighters
        api.addToFleet(FleetSide.PLAYER, "ilk_ravana_pursuit", FleetMemberType.SHIP, false);
        api.addToFleet(FleetSide.PLAYER, "ilk_ravana_pursuit", FleetMemberType.SHIP, false);
        api.addToFleet(FleetSide.PLAYER, "ilk_del_azarchel_artillery", FleetMemberType.SHIP, false);
        api.addToFleet(FleetSide.PLAYER, "ilk_del_azarchel_artillery", FleetMemberType.SHIP, false);
        api.addToFleet(FleetSide.PLAYER, "ilk_jamaran_support", FleetMemberType.SHIP, false);
        //api.addToFleet(FleetSide.PLAYER, "ilk_jamaran_support", FleetMemberType.SHIP, false);
        api.addToFleet(FleetSide.PLAYER, "ilk_cimeterre_strike", FleetMemberType.SHIP, "MNS Azure Dream", true);
        api.addToFleet(FleetSide.PLAYER, "ilk_cimeterre_strike", FleetMemberType.SHIP, false);
        //api.addToFleet(FleetSide.PLAYER, "ilk_cimeterre_strike", FleetMemberType.SHIP, false);
        api.addToFleet(FleetSide.PLAYER, "ilk_lilith_assault", FleetMemberType.SHIP, false);
        api.addToFleet(FleetSide.PLAYER, "ilk_lilith_assault", FleetMemberType.SHIP, false);
        api.addToFleet(FleetSide.PLAYER, "ilk_lilith_assault", FleetMemberType.SHIP, false);
        //api.addToFleet(FleetSide.PLAYER, "ilk_lilith_assault", FleetMemberType.SHIP, false);

        api.addToFleet(FleetSide.PLAYER, "ilk_raad_wing", FleetMemberType.FIGHTER_WING, false);
        api.addToFleet(FleetSide.PLAYER, "ilk_raad_wing", FleetMemberType.FIGHTER_WING, false);
        //api.addToFleet(FleetSide.PLAYER, "ilk_inanna_wing", FleetMemberType.FIGHTER_WING, false);
        api.addToFleet(FleetSide.PLAYER, "ilk_inanna_wing", FleetMemberType.FIGHTER_WING, false);
        api.addToFleet(FleetSide.PLAYER, "ilk_inanna_wing", FleetMemberType.FIGHTER_WING, false);
	//api.addToFleet(FleetSide.PLAYER, "broadsword_wing", FleetMemberType.FIGHTER_WING, false, CrewXPLevel.REGULAR);

        // Set up the enemy fleet.
        api.addToFleet(FleetSide.ENEMY, "onslaught_Standard", FleetMemberType.SHIP, false);
        api.addToFleet(FleetSide.ENEMY, "onslaught_Standard", FleetMemberType.SHIP, false);
        api.addToFleet(FleetSide.ENEMY, "onslaught_Standard", FleetMemberType.SHIP, false);

        api.addToFleet(FleetSide.ENEMY, "dominator_Support", FleetMemberType.SHIP, false);
        api.addToFleet(FleetSide.ENEMY, "enforcer_Assault", FleetMemberType.SHIP, false);
        api.addToFleet(FleetSide.ENEMY, "enforcer_Assault", FleetMemberType.SHIP, false);
        api.addToFleet(FleetSide.ENEMY, "enforcer_Assault", FleetMemberType.SHIP, false);
        api.addToFleet(FleetSide.ENEMY, "lasher_CS", FleetMemberType.SHIP, false);
        api.addToFleet(FleetSide.ENEMY, "condor_FS", FleetMemberType.SHIP, false);
        api.addToFleet(FleetSide.ENEMY, "condor_FS", FleetMemberType.SHIP, false);
        api.addToFleet(FleetSide.ENEMY, "condor_FS", FleetMemberType.SHIP, false);
        api.addToFleet(FleetSide.ENEMY, "piranha_wing", FleetMemberType.FIGHTER_WING, false);
        api.addToFleet(FleetSide.ENEMY, "piranha_wing", FleetMemberType.FIGHTER_WING, false);
        api.addToFleet(FleetSide.ENEMY, "piranha_wing", FleetMemberType.FIGHTER_WING, false);
        api.addToFleet(FleetSide.ENEMY, "broadsword_wing", FleetMemberType.FIGHTER_WING, false);
        api.addToFleet(FleetSide.ENEMY, "talon_wing", FleetMemberType.FIGHTER_WING, false);
        api.addToFleet(FleetSide.ENEMY, "talon_wing", FleetMemberType.FIGHTER_WING, false);
        api.addToFleet(FleetSide.ENEMY, "talon_wing", FleetMemberType.FIGHTER_WING, false);

        // Set up the map.
        float width = 24000f;
        float height = 18000f;
        api.initMap((float) -width / 2f, (float) width / 2f, (float) -height / 2f, (float) height / 2f);

        float minX = -width / 2;
        float minY = -height / 2;

        api.addPlanet(0, 0, 200f, "jungle", 350f, true);

        // Add an asteroid field
        api.addAsteroidField(minX + width / 2f, minY + height / 2f, 0, 8000f, 20f, 70f, 100);

        api.addPlugin(new BaseEveryFrameCombatPlugin()
        {
            @Override
            public void advance(float amount, List events) {
                interval += amount;
                if (interval > (163f)) {
                    Global.getSoundPlayer().playMusic(0, 0, "ilk_mission1_music");
                    interval = 0f;
                }
            }
            @Override
            public void init(CombatEngineAPI engine) {
                Global.getSoundPlayer().playMusic(0, 0, "ilk_mission1_music");
                engine.getContext().setStandoffRange(10000f);
                interval = 0f;
            }
        });
    }
}